package com.iskhak.romanToInt;

import java.util.HashMap;
import java.util.Map;

public class RomanToInt {


    public static void main(String[] args) {
        romanToInt("XLVI");//40+5+1
    }

    public static int romanToInt(String s) {
        HashMap<String, Integer> romInt = new HashMap();
        romInt.put("I", 1);
        romInt.put("V", 5);
        romInt.put("X", 10);
        romInt.put("L", 50);
        romInt.put("C", 100);
        romInt.put("D", 500);
        romInt.put("M", 1000);


        String[] s1 = s.split("");
        int r = 0;
        String current = null;
        int temp = 0;
        int last = 0;
        for (int i = 0; i < s1.length; i++) {
            String newValue = s1[i];
            for (Map.Entry<String, Integer> entry : romInt.entrySet()) {
                String key = entry.getKey();
                int value = entry.getValue();
                if (key.startsWith(s1[i])) {
                    temp = value;
                    if(last>temp)
                        r += value;
                    else
                        r+= - last + (temp-last);
                }
            }
            last = temp;
        }
        System.out.println(r);
        return r;
    }


}
