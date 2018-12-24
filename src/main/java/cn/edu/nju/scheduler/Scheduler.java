package cn.edu.nju.scheduler;

/**
 * Created by njucjc on 2018/12/20.
 */
public interface Scheduler {
    void reset();
    void  update(String change);
    boolean schedule(String ruleName);
}
