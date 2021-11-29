package com.codeeval.solutions;

import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapExample {
    
    public static void main(String[] args)
    {
        ConcurrentHashMap<String,String> premiumPhone = new ConcurrentHashMap<String,String>();
        premiumPhone.put("Apple", "iPhone6");
        premiumPhone.put("HTC", "HTC one");
        premiumPhone.put("Samsung","S6");
        
        Iterator iterator = premiumPhone.keySet().iterator();
        
        /*while (iterator.hasNext())
        {
            System.out.println(premiumPhone.get(iterator.next()));
            premiumPhone.put("Sony", "Xperia Z");
        }*/
        
        for(String str:premiumPhone.keySet()){
            System.out.println(premiumPhone.get(str));
            premiumPhone.put("Sony", "Xperia Z");
        }
        
        /*for(String str:premiumPhone.keySet()){
            System.out.println(premiumPhone.get(str));
            premiumPhone.put("Sony", "Xperia Z");
        }*/
    }

}
