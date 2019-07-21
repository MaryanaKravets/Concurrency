package main.java.service;

import java.util.Random;

class Service {
    static String start() {
        String bodeRequest = "This is body request";
        String result = "";
        int r = new Random().nextInt(HttpMethods.values().length);
        HttpMethods cases = HttpMethods.values()[r];
        System.out.println("Httpmethods is: " + cases);
        switch (cases) {
            case GET:
                result = bodeRequest;
                break;
            case PUT:
                result = bodeRequest.toUpperCase();
                break;
            case POST:
                result = "new " + bodeRequest;
                break;
            case DELETE:
                break;
        }
        return result;
    }
}


    

