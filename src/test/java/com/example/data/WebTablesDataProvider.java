package com.example.data;
import org.testng.annotations.DataProvider;
public class WebTablesDataProvider {
    @DataProvider(name = "trueCondition")
    public static Object[][] trueCondition() {
        return new Object[][]{
            {"Test User", "Test LastName", "test@email.com", "25", "50000", "Test Department"}
        };
    }
}
