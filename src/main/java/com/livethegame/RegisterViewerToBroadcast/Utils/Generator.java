package com.livethegame.RegisterViewerToBroadcast.Utils;

public  class Generator {
    public static String generateCode(){
        double code = 100000 + Math.random() * 900000;
        return String.valueOf(code).substring(0,6);
    };
}
