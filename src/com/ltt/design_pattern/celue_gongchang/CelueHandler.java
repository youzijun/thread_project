package com.ltt.design_pattern.celue_gongchang;

/**
 * Created by ZJX-BJ-01-00057 on 2019/5/9.
 */
public class CelueHandler {

    private DogInterface dogInterface;

    public CelueHandler(DogInterface dogInterface){
        this.dogInterface = dogInterface;
    }

    public void doRun(){
        dogInterface.execute();
    }

}
