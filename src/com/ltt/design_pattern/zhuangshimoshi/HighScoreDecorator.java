package com.ltt.design_pattern.zhuangshimoshi;

/**
 * Created by ZJX-BJ-01-00057 on 2018/11/21.
 */
public class HighScoreDecorator extends Decorator{


    public HighScoreDecorator(SchoolReport sr) {
        super(sr);
    }


    private void reportHighScore(){
        System.out.println("最高成绩是。。。");
    }

    @Override
    public void report(){
        this.reportHighScore();
        super.report();
    }

}
