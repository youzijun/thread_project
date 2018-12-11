package com.ltt.design_pattern.zhuangshimoshi;

/**
 * Created by ZJX-BJ-01-00057 on 2018/11/21.
 */
public class SortDecorator extends Decorator{


    public SortDecorator(SchoolReport sr) {
        super(sr);
    }


    private void reportSortScore(){
        System.out.println("成绩排名。。。");
    }

    @Override
    public void report(){
        this.reportSortScore();
        super.report();
    }


}
