>>Features
>>>1. Cross Browser configuration using Maven profile. Simply select a profile and test would run in a different browser
>>>2. Advanced Reporting using Extent Reports. Categorized tests for easier reporting. Provides  different level of granularity
>>>3. Rerun failed tests automatically. Retries can be configured as needed
>>>4. Soft Assertions used to assert each test step and only throw exception after the test completed
>
>>>Libraries usage
>>> 1. Selenium - To interact with UI
>>> 2. TestNg - @Test, @BeforeMethod and @AfterMethod annotations are used to create tests. testng.xml is used to run the tests as a Test Suite
>>> 3. Extent Report - To create detailed Test Execution Reports
>>> 4. AssertJ - To perform assertions. 
>>Maven
>>> 1. Used to build the project 
>>> 2. Profiles - Created for each browser e.g. Chrome, Firefox etc. User can choose the profile to run and associated Browser will be invoked to run the tests
>>> 3. Maven Surefire plugin - Used to execute the tests by invoking a profile
>>> 4. Tests can be run from command line using "mvn test -PChrome"
>
>>Design
>>com.ibkr.qa.navigation
>>>1. WebOperation class - is base class for all pages classes 
>>>   and is used to defined different Web Elements and methods to capture them
>>>2. Each page classes should extend WebOperations directly or indirectly 
>>>
>
>>com.ibkr.qa.pages
>>> 1. Page classes are created for each Page. e.g. LoginPage - Used to Login to the portal
>>> 2. All locators available on the page are defined under respective class 
>>> 3. All pages object classes extends WebOperation class
>>modals
>>> 1. Modal classes are created for each modal that appears on the UI e.g. Workflow modal  
>
>>com.ibkr.qa.reporter
>>> 1. Used to create Extent Report
>>> 2. Create instance of TestReporter e.g. TestReporter com.ibkr.qa.reporter = new TestReporter();
>>> 3. createTest() - used to create the test
>>> 4. assertTest() - used to assert a test condition
>>> 5. testInfo() - used to print information at test level
>>> 6. createChild() - used to create test step within a test
>>> 7. assertChild() - used to assert a test step condition
>>> 8. childInfo() - used to print information at test step level
>>> 9. persist() - used to persist the report
