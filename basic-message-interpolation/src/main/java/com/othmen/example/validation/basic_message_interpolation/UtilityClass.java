package com.othmen.example.validation.basic_message_interpolation;

import java.util.Arrays;
import java.util.stream.Stream;

public class UtilityClass {

    public static String toUnderscoreCase(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.toUpperCase(c) == c) {
                sb.append("_").append(Character.toLowerCase(c));
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
