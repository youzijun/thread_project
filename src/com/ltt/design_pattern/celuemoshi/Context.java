package com.ltt.design_pattern.celuemoshi;

/**
 * Created by ZJX-BJ-01-00057 on 2018/9/30.
 */
public class Context {

    private CeLueInterface ceLueInterface;

    public Context(CeLueInterface ceLueInterface){
        this.ceLueInterface = ceLueInterface;
    }

    public void operate(){
        this.ceLueInterface.operate();
    }

}
