package com.example.data;

import org.testng.annotations.DataProvider;

public class CheckBoxDataProvider {
    @DataProvider(name = "childCheckboxData")
    public Object[][] childCheckboxData() {
        return new Object[][]{
            { new String[]{"Home", "Desktop"}, "Notes" },
            { new String[]{"Home", "Desktop"}, "Commands" },
            { new String[]{"Home", "Documents"}, "WorkSpace" },
            { new String[]{"Home", "Documents", "WorkSpace"}, "React" }, 
            { new String[]{"Home", "Documents", "WorkSpace"}, "Angular" },
            { new String[]{"Home", "Documents", "WorkSpace"}, "Veu" }
        };
    }         
    @DataProvider(name = "checkboxData")
    public static Object[][] checkboxData() {
        return new Object[][]{
                {"Home", false},
                {"Desktop", true},
                {"Documents", true},
                {"Downloads", true}
        };
    }

}
