# BTL Web UI Automation

Selenium WebDriver test automation for the public website of Israel's National
Insurance Institute (Bituach Leumi). The project demonstrates a maintainable
Page Object Model, explicit waits, independent JUnit 5 tests, and headless CI
execution.

## Test coverage

- Navigation to the branches and service channels page
- Website search and results validation
- Branch lookup by city and validation of service details

## Technology

- Java 11
- Selenium WebDriver 4
- JUnit 5
- Maven
- GitHub Actions

ChromeDriver is resolved by Selenium Manager, so no driver executable needs to
be stored in the repository.

## Project structure

```text
src
├── main/java/org/example
│   ├── BasePage.java
│   ├── BranchesPage.java
│   ├── BtlHomePage.java
│   └── MenuItems.java
└── test/java/org/example
    └── BtlWebsiteTest.java
```

## Running the tests

Requirements: Java 11 or newer, Maven, and Google Chrome.

Run headlessly (the default):

```bash
mvn test
```

Run with a visible browser:

```bash
mvn test -Dbrowser.headless=false
```

Run against another environment:

```bash
mvn test -Dbase.url=https://www.btl.gov.il
```

## Design decisions

- Page objects own locators and browser interactions; tests express scenarios
  and assertions.
- Explicit waits are used instead of fixed sleeps.
- Each test creates and closes its own browser for isolation.
- Browser and base URL settings are externalized as system properties.

## Notes

These tests exercise a public third-party website. Changes to its content,
locators, availability, or bot-protection rules can affect results without a
change to this repository. The project is an independent educational portfolio
project and is not affiliated with Bituach Leumi.
