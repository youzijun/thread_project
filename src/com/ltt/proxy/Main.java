package com.ltt.proxy;


/**
 * Created by ZJX-BJ-01-00057 on 2019/5/20.
 */
public class Main {


    public static void main(String[] args) {

        SubjectInterface subjectInterface = (SubjectInterface) new ProxyHandler(new SubjectInterfaceImpl()).getProxyObj();

        subjectInterface.doSomething();
    }

}
