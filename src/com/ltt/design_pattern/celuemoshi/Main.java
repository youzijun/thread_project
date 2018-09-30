package com.ltt.design_pattern.celuemoshi;

/**
 * Created by ZJX-BJ-01-00057 on 2018/9/30.
 */
public class Main {

    public static void main(String[] args) {
        Context context;

        context = new Context(new AClassImpl());
        context.operate();

        context = new Context(new BClassImpl());
        context.operate();

        context = new Context(new CClassImpl());
        context.operate();
    }

}
