package cn.edu.nju.checker;

import cn.edu.nju.context.Context;
import cn.edu.nju.node.CCTNode;
import cn.edu.nju.node.STNode;
import cn.edu.nju.pattern.Pattern;
import cn.edu.nju.util.LinkHelper;
import cn.edu.nju.util.LogFileHelper;

import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by njucjc on 2018/12/20.
 */
public class EccChecker extends Checker{

    public EccChecker(String name, STNode stRoot, Map<String, Pattern> patternMap, Map<String, STNode> stMap) {
        super(name, stRoot, patternMap, stMap);
    }

    public EccChecker(Checker checker) {
        super(checker);
    }

    protected EccChecker() {}
    /**
     *
     * @return violated link
     */
    @Override
    public synchronized boolean doCheck() {
        long start = System.nanoTime();

        checkTimes++;
        clearCCTMap();
        //removeCriticalNode(stRoot, cctRoot);
        cctRoot = new CCTNode(stRoot.getNodeName(), stRoot.getNodeType());
        buildCCT(stRoot, cctRoot);
        List<Context> param = new CopyOnWriteArrayList<>();
        evaluation(cctRoot, param);

        boolean value = true;
        if (!cctRoot.getNodeValue()) {
            String [] links = LinkHelper.splitLinks(cctRoot.getLink());
            for(String link : links) {
                if(addIncLink(link)) {
                    LogFileHelper.getLogger().info(getName() + " " + link);
                }
            }

            this.maxLinkSize = this.maxLinkSize > links.length ? this.maxLinkSize : links.length;
            value = false;
        }

        long end = System.nanoTime();
        timeCount = timeCount + (end - start);

        return value;

    }

}
