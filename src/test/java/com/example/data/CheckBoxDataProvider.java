package com.example.data;

import org.testng.annotations.DataProvider;

public class CheckBoxDataProvider {
    @DataProvider(name = "checkboxData")
    public static Object[][] checkboxData() {
        return new Object[][]{
                {"Home", false},
                {"Desktop", true},
                {"Documents", true}
                {"Downloads", true}
        };
    }
}
