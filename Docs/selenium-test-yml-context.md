# Selenium Test GitHub Actions Workflow

This document explains the purpose and functionality of the `selenium-test.yml` GitHub Actions workflow file used in this project.

## Overview
The `selenium-test.yml` file defines a GitHub Actions workflow that automates the execution of Selenium WebDriver tests in a continuous integration environment.
This workflow is triggered on every push or pull request to the `main` branch.

## Workflow Triggers
- **On Push**: Triggers when code is pushed to the `main` branch
- **On Pull Request**: Triggers when a pull request is opened or updated against the `main` branch

## Job Configuration

### Test Matrix Strategy
The workflow uses a matrix strategy to run tests across different Java versions:
- Java versions: 11 and 17
- Operating System: Windows latest

### Key Steps

1. **Checkout Code**
   - Checks out the repository code using `actions/checkout@v3`

2. **Java Setup**
   - Sets up the specified Java version using `actions/setup-java@v3`
   - Uses Temurin distribution for Java

3. **Maven Cache**
   - Caches Maven dependencies to speed up subsequent workflow runs
   - Uses the repository's `pom.xml` to determine cache key

4. **Test Execution**
   - Runs `mvn clean test` to execute all tests
   - Additionally runs tests using `testng.xml` configuration

5. **Test Results**
   - Uploads test results as artifacts (retained for 5 days)
   - Publishes a test report using the JUnit report action

## Artifacts
- Test results are uploaded as artifacts with names including the Java version
- Test reports are published in the GitHub Actions UI for easy review

## Benefits
- Ensures tests pass on multiple Java versions
- Provides immediate feedback on pull requests
- Maintains a history of test results
- Speeds up builds through dependency caching

## Dependencies
- Maven for build and test execution
- TestNG for test framework
- GitHub Actions for CI/CD pipeline
