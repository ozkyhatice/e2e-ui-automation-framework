# E2E UI Automation Framework

A Selenium-based test automation framework for testing web applications. This project uses TestNG and follows the Page Object Model pattern to keep tests clean, maintainable, and easy to scale.

## What's Inside

This framework tests DemoQA website features like buttons, checkboxes, radio buttons, text fields, and data tables. Here's what makes it useful:

- Page Object Model for cleaner, more maintainable code
- ThreadLocal WebDriver setup so you can run tests in parallel
- Smart waits and element interactions that handle flaky elements
- Data-driven tests with TestNG DataProviders
- Multiple assertions that won't stop at the first failure
- Headless mode for CI/CD pipelines

## Tech Stack

| Component | Version |
|-----------|---------|
| **Selenium WebDriver** | 4.11.0 |
| **TestNG** | 7.10.2 |
| **Java** | 17 |
| **Maven** | 3.6+ |
| **Log4j2** | Built-in |

## Project Structure

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

## How It Works

We use the Page Object Model pattern, which basically means each page has its own class that handles all interactions with that page. Tests then just call methods on the page object instead of dealing with selectors directly. This makes it super easy to update tests when the UI changes.

```
BasePage (reusable Selenium methods)
   ↓
Page Classes (ButtonsPage, CheckBoxPage, etc.)
   ↓
Test Classes (actual test logic)
```

For each test, we:
1. Set up the browser before the test runs
2. Run the test
3. Close the browser when done

## Getting Started

Make sure you have Java 17+, Maven 3.6+, and Chrome installed. Then:

```bash
git clone https://github.com/ozkyhatice/e2e-ui-automation-framework.git
cd e2e-ui-automation-framework
mvn clean install
```

## Run Your Tests

```bash
# Everything
mvn test

# Just one test class
mvn test -Dtest=ButtonsTest

# Headless mode (no browser window)
mvn test -Dheadless=true

# Run tests in parallel
mvn test -DparallelMethod=true
```

## Reports & Results

After running tests, check out your HTML report here: `target/surefire-reports/emailable-report.html`

## Common Methods You'll Use

BasePage has some useful methods for interacting with elements:

| Method | What it does |
|--------|---------|
| `click(By)` | Clicks an element (scrolls first, uses JS if needed) |
| `type(By, String)` | Types text into a field (clears first) |
| `getText(By)` | Gets text from an element (with wait) |
| `waitUntilElementVisible(By)` | Waits up to 10 seconds for an element to show |

For managing browsers:

- `initDriver()` - Start up the Chrome browser
- `getDriver()` - Get the current browser instance
- `quitDriver()` - Close the browser and clean up

## Example Test

Here's what a simple test looks like:

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

## What We've Built

- Page Object Model - keeps selectors out of your tests
- Thread-safe browser management - run tests in parallel
- Smart waits - handles elements that load slowly
- JavaScript fallback - clicks that work even when normal clicks fail
- Data-driven tests - test multiple scenarios easily
- Soft assertions - collect all failures instead of stopping at the first one
- Headless mode - great for CI/CD systems
- Retry logic - automatically reruns flaky tests
- Nice test reports - see what passed and what failed


---

**Repository:** [e2e-ui-automation-framework](https://github.com/ozkyhatice/e2e-ui-automation-framework)
