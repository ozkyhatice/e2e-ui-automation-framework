package com.example.data;


import org.testng.annotations.DataProvider;

public class TextBoxDataProvider {

    @DataProvider(name = "textboxData")
    public static Object[][] getData() {
        return new Object[][]{
            {"Hatice", "hatice@test.com", "Istanbul", "Turkey"},
            {"QA User", "qa@test.com", "Berlin", "Germany"}
        };
    }
}