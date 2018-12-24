package cn.edu.nju.builder;

import cn.edu.nju.checker.Checker;
import cn.edu.nju.util.LogFileHelper;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by njucjc on 2018/12/20.
 */
public class CheckerBuilder  extends AbstractCheckerBuilder implements Runnable{

    public CheckerBuilder(String configFilePath) {
        super(configFilePath);
    }

//    @Override
    public void run() {
        List<String> contextList = fileReader(this.dataFilePath);

        int count = 0;
        long startTime = System.nanoTime();
        for(String change : contextList) {
            changeHandler.doContextChange(count, change);
            count++;
        }
        scheduler.reset();
        changeHandler.doCheck();
        long endTime = System.nanoTime(); //获取结束时间
        int incCount = 0;
        int checkTimes = 0;
        long timeCount = 0L;
        for(Checker checker : checkerList) {
            incCount += checker.getInc();
            checkTimes += checker.getCheckTimes();
            timeCount = timeCount + checker.getTimeCount();
            LogFileHelper.getLogger().info(checker.getName() + ": INC = " + checker.getInc() + " times, Max Link Size = "  + checker.getMaxLinkSize());
        }
        LogFileHelper.getLogger().info("Total INC: " + incCount + " times");
        LogFileHelper.getLogger().info("Total check: " + checkTimes + " times");
        LogFileHelper.getLogger().info("check time: " + timeCount / 1000000 + " ms");
        LogFileHelper.getLogger().info("run time: " + (endTime - startTime) / 1000000 + " ms");
        shutdown();
    }

    public static void main(String[] args) {
        CheckerBuilder checkerBuilder = new CheckerBuilder("config.properties");
    }


}
