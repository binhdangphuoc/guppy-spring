package com.example.guppy.helper;


import java.util.List;
import java.util.stream.Collectors;

public class Helper {
    public static String IntToString(List<Integer> listInput) {
        String listString = listInput.stream().map(Object::toString)
                .collect(Collectors.joining(","));
        System.out.println("convert: " + listString);
        return listString;
    }
    public static String StrToString(List<String> listInput) {
        String listString = listInput.stream().map(Object::toString)
                .collect(Collectors.joining(","));
        System.out.println("convert: " + listString);
        return listString;
    }
    public static String FloToString(List<Float> listInput) {
        String listString = listInput.stream().map(Object::toString)
                .collect(Collectors.joining(","));
        System.out.println("convert: " + listString);
        return listString;
    }
}
