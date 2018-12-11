package com.ltt.design_pattern.zhuangshimoshi;

/**
 * Created by ZJX-BJ-01-00057 on 2018/11/21.
 */
public class FouthGradeSchoolReport extends SchoolReport{


    @Override
    public void report() {
        System.out.println("打印成绩。。。");
    }

    @Override
    public void sign(String name) {
        System.out.println("签字。。。" + name);
    }
}
