# E2E UI Automation Framework

A test automation framework using Selenium WebDriver and TestNG for UI testing. Built with Page Object Model (POM) architecture for maintainability and scalability.

## 🎯 Overview

Tests DemoQA website components: buttons, checkboxes, radio buttons, text input, and web tables.

**Key Features:**
- Page Object Model (POM) design pattern
- ThreadLocal WebDriver for parallel execution
- Explicit waits with smart element interaction
- Data-driven testing with @DataProvider
- Soft assertions for multiple validations
- Headless browser support

## 🛠️ Tech Stack

| Component | Version |
|-----------|---------|
| **Selenium WebDriver** | 4.11.0 |
| **TestNG** | 7.10.2 |
| **Java** | 17 |
| **Maven** | 3.6+ |
| **Log4j2** | Built-in |

## 📁 Project Structure

```
src/
├── main/java/com/example/
│   ├── base/BasePage.java          # Base class with common methods
│   ├── driver/DriverFactory.java   # ThreadLocal WebDriver management
│   ├── config/ConfigReader.java    # Configuration management
│   └── pages/                      # Page Objects (ButtonsPage, etc.)
│
└── test/java/com/example/
    ├── tests/                      # Test classes (ButtonsTest, etc.)
    ├── data/                       # DataProviders for test data
    ├── utils/                      # Utilities (RetryAnalyzer, WaitUtils)
    └── listeners/                  # TestNG listeners
```

## 🔧 Architecture

**Page Object Model Flow:**
```
BasePage (Selenium actions)
   ↓
Page Classes (ButtonsPage, CheckBoxPage, etc.)
   ↓
Test Classes (Extends BaseTest)
```

**Test Execution:**
```
@BeforeMethod → Initialize WebDriver
    ↓
@Test → Execute test method
    ↓
@AfterMethod → Close WebDriver
```

## 🚀 Quick Start

**Prerequisites:** Java 17+, Maven 3.6+, Chrome browser

**Installation:**
```bash
git clone https://github.com/ozkyhatice/e2e-ui-automation-framework.git
cd e2e-ui-automation-framework
mvn clean install
```

## ▶️ Running Tests

```bash
# Run all tests
mvn test

# Run specific test
mvn test -Dtest=ButtonsTest

# Run with headless mode
mvn test -Dheadless=true

# Run in parallel
mvn test -DparallelMethod=true
```

## 📊 Reports

Test reports generated in: `target/surefire-reports/emailable-report.html`

## ✨ Key Methods (BasePage)

| Method | Purpose |
|--------|---------|
| `click(By)` | Click with scrolling & JS fallback |
| `type(By, String)` | Type text with clear & JS fallback |
| `getText(By)` | Get element text with wait |
| `waitUntilElementVisible(By)` | Explicit 10-second wait |

**DriverFactory Methods:**
- `initDriver()` - Initialize Chrome WebDriver
- `getDriver()` - Get current thread's driver
- `quitDriver()` - Close browser & cleanup

## 📝 Test Example

```java
public class ButtonsTest extends BaseTest {
    @Test
    public void testButtons() {
        ButtonsPage page = new ButtonsPage(driver);
        page.openPage();
        page.clickDoubleClickButton();
        
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(message.isDisplayed());
        softAssert.assertAll();
    }
}
```

## ✅ Implemented Features

- Page Object Model with BasePage abstraction
- ThreadLocal WebDriver for thread safety
- Explicit waits (10-second WebDriverWait)
- Smart click/type with JavaScript fallback
- Data-driven testing with DataProviders
- Soft assertions for multiple validations
- Headless browser execution
- Test retry mechanism (RetryAnalyzer)
- Comprehensive test reporting


---

**Repository:** [e2e-ui-automation-framework](https://github.com/ozkyhatice/e2e-ui-automation-framework)
