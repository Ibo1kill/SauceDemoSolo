SauceDemo Solo - Test Automation

Automated UI tests for the demo website https://www.saucedemo.com, written in Java with Selenium, TestNG and Maven, using the Page Object Model.


Workflows

- Workflow 1 - Purchase: login, add to cart, checkout, finish, back home (PurchaseFlowTest)

- Workflow 2 - Remove: login, add products, remove them, logout (RemoveFlowTest)

Both workflows include happy, negative and edge cases. Total: 25 test runs, all passing.


Project structure

- WorkflowBasepage: wait, click and type helpers for all pages

- PurchaseFlowPage: page for Workflow 1

- RemoveFlowPage: page for Workflow 2

- WorkflowBaseTest: opens and closes Chrome

- TestData: reads the test data from testdata.csv

- testdata.csv: the test data file (login and checkout data)

- PurchaseFlowTest: Workflow 1 tests

- RemoveFlowTest: Workflow 2 tests

- testng.xml: runs both workflows


How to run

1. Import the project in Eclipse as a Maven project.

2. Right-click testng.xml and choose Run As, then TestNG Suite.

Requirements: Java 17, Maven, Google Chrome.


Author

Ibrahim
