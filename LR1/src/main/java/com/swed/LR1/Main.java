package com.swed.LR1;

public class Main {
    public static void main(String[] args) {
        // 1.1
        long l = 123456;
        double d1,d2;
        float f = 14.75f;
        char c1 = '0';
        // 1.2
        l = (long)f;
        d1 = 100.0 + Math.random() * (1000.0 - 100.0); // [100,1000]
        d2 =  1.0 + Math.random() * (99.0 - 1.0); // [1,99]
        System.out.printf("Змінні l = %d , d1 = %.1f , d2 = %.1f\n",l,d1,d2);
        // 1.3
        double y = Math.sin(d1) * Math.cos(d2) - (Math.atan(d1) / Math.atan(d2));
        System.out.printf("Змінна y = %.1f\n",y);
        // 2.1
        // U+1F61C U+1F61D U+1F621 https://nowsms.com/download/emoticons.htm
        System.out.print("\uD83D\uDE1C \uD83D\uDE1D \uD83D\uDE21\n");
        // 2.2
        String text = "LoReM IpSuM DoLOR sit AmeT, ConSEctetur ADipiscing ELIT. MORbi BIbendum CONGUE faucibus.";
        System.out.println(text.substring(0,1).toUpperCase() + text.substring(1,text.length()-1).toLowerCase());
    }
}