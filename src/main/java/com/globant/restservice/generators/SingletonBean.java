package com.globant.restservice.generators;

public class SingletonBean {
    
    private static volatile SingletonBean INSTANCE = null;

    // dummy object variable for synchronization
    private static Object mutex = new Object();
    
    private SingletonBean() {}

    public static SingletonBean getInstance() {
        if (INSTANCE == null) {
            //synchronized (SingletonBean.class) {
            synchronized (mutex) {
                if (INSTANCE == null) {
                    INSTANCE = new SingletonBean();
                }
            }
        }
        
        return INSTANCE;
    }
}
