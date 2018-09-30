package com.ltt.threadPool;

/**
 * Created by ZJX-BJ-01-00057 on 2018/7/3.
 */
public class MySingleton {


    //1\========================================================================

//    private static MySingleton singleton = new MySingleton();
//
//    private MySingleton(){
//
//    }
//
//    public static MySingleton getSingleton(){
//        return singleton;
//    }




    //2\========================================================================

//    private static MySingleton singleton = null;
//
//    private MySingleton(){
//
//    }
//
//    public static MySingleton getSingleton(){
//        if(singleton == null){
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            singleton = new MySingleton();
//        }
//
//        return singleton;
//    }


    //3\========================================================================

//    private static MySingleton singleton = null;
//
//    private MySingleton(){
//
//    }
//
//    public synchronized static MySingleton getSingleton(){
//        if(singleton == null){
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            singleton = new MySingleton();
//        }
//
//        return singleton;
//    }


    //4\========================================================================

//    private static MySingleton singleton = null;
//
//    private MySingleton(){
//
//    }
//
//    public static MySingleton getSingleton(){
//        if(singleton == null){
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//
//            synchronized (MySingleton.class){
//                if(singleton == null){
//                    singleton = new MySingleton();
//                }
//            }
//        }
//
//        return singleton;
//    }



    //5\========================================================================

     private static MySingleton singleton = null;

    private MySingleton(){

    }

    public static MySingleton getSingleton(){
        if(singleton == null){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            synchronized (MySingleton.class){
                if(singleton == null){
                    singleton = new MySingleton();
                }
            }
        }

        return singleton;
    }





}
