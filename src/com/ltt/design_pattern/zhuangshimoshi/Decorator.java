package com.ltt.design_pattern.zhuangshimoshi;

/**
 * Created by ZJX-BJ-01-00057 on 2018/11/21.
 */
public abstract class Decorator extends SchoolReport{

    private SchoolReport sr;

    public Decorator(SchoolReport sr) {
        this.sr = sr;
    }

    public void report() {
        this.sr.report();
    }

    public void sign(String name) {
        this.sr.sign(name);
    }
}
