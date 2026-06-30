package com.assignment.server;
import java.util.HashMap;
import java.util.Map;

public class DataStore {

	private static final Map<String, Map<String, Integer>> data = new HashMap<>();

    static {

        Map<String,Integer> setA = new HashMap<>();
        setA.put("One",1);
        setA.put("Two",2);

        Map<String,Integer> setB = new HashMap<>();
        setB.put("Three",3);
        setB.put("Four",4);

        Map<String,Integer> setC = new HashMap<>();
        setC.put("Five",5);
        setC.put("Six",6);

        Map<String,Integer> setD = new HashMap<>();
        setD.put("Seven",7);
        setD.put("Eight",8);

        Map<String,Integer> setE = new HashMap<>();
        setE.put("Nine",9);
        setE.put("Ten",10);

        data.put("SetA",setA);
        data.put("SetB",setB);
        data.put("SetC",setC);
        data.put("SetD",setD);
        data.put("SetE",setE);
    }

    public static Map<String, Map<String, Integer>> getData() {
        return data;
    }
}
