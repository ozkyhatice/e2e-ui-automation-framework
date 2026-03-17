package com.example.data;

import org.testng.annotations.DataProvider;

public class CheckBoxDataProvider {
    @DataProvider(name = "checkboxData")
    public static Object[][] checkboxData() {
        return new Object[][]{
                {"Home", false},
                {"Desktop", true},
                {"Documents", true},
                {"Downloads", true}
        };
    }

    @DataProvider(name = "childCheckboxData")
    public Object[][] childCheckboxData() {
        return new Object[][]{
                {"Desktop", "Notes"},
                {"Desktop", "Commands"},
                {"Documents", "WorkSpace"},
                {"Documents", "React"},
                {"Documents", "Angular"},
                {"Documents", "Veu"},
                {"Documents", "Office"},
                {"Documents", "Public"},
                {"Documents", "Private"},
                {"Documents", "Classified"},
                {"Documents", "General"},
                {"Downloads", "Word File.doc"},
                {"Downloads", "Excel File.doc"}
        };
    }
}
