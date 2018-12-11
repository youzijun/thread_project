package com.ltt.design_pattern.zhuangshimoshi;

/**
 * Created by ZJX-BJ-01-00057 on 2018/11/21.
 */
public class Father {


    public static void main(String[] args) {
//        SchoolReport schoolReport = new SugarFouthGradeSchoolReport();
//
//        schoolReport.report();
//        schoolReport.sign("123");


        SchoolReport sr;
        sr = new FouthGradeSchoolReport();

        sr = new HighScoreDecorator(sr);

        sr = new SortDecorator(sr);

        sr.report();

        sr.sign("123");

    }


}
