package com.ltt.design_pattern.zhuangshimoshi;

/**
 * Created by ZJX-BJ-01-00057 on 2018/11/21.
 */
public class SugarFouthGradeSchoolReport extends FouthGradeSchoolReport{


    //美化1
    private void sugarMethod1(){
        System.out.println("美化1");
    }

    //美化2
    private void sugarMethod2(){
        System.out.println("美化2");
    }

    @Override
    public void report(){
        this.sugarMethod1();
        this.sugarMethod2();
        super.report();
    }

}
