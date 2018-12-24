package cn.edu.nju.context;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by njucjc on 2018/12/20. */
public class ContextStaticRepo implements ContextRepoService{
    private BufferedReader bufferedReader;
    private ContextParser contextParser;
    private int count = 0;

    public ContextStaticRepo(String changeFilePath) {
        try {
            FileReader fr = new FileReader(changeFilePath);
            this.bufferedReader = new BufferedReader(fr);
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        this.contextParser = new ContextParser();
    }

    @Override
    public Context getContext() throws IOException{
        String pattern = bufferedReader.readLine();
        if(pattern == null) {
            return null;
        }
        else {
            Context context =  contextParser.parseContext(count++, pattern);
            return context;
        }
    }
}
