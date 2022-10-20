package com.example.firstjavadbproject.util;

import java.util.ResourceBundle;

public class AppUtility {

    public static String getResourceMessage(String key) {
        ResourceBundle resourceBundle = ResourceBundle.getBundle("messages");
        return resourceBundle.getString(key);
    }
}
