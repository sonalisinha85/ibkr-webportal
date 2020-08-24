package clientportal;

import base.TestBase;
import enums.TestAuthor;
import enums.TestCategory;
import org.testng.annotations.Test;

public class ClientPortalTest extends TestBase {

    @Test(priority = 1)
    public void validateFindServices() {

        reporter.createTest("Client Portal Find Services Test")
                .withCategory(TestCategory.ClientPortal)
                .withAuthor(TestAuthor.ClientPortalFindServices);

        loginClient();
        clientPortal()
                .validateLogin()
                .withInvestorMarketplace()
                .validateFindServicesNavigation();
        clientPortal()
                .logout();

        softly.assertAll();
    }

    @Test(priority = 2)
    public void validateConcentrationReport() {

        reporter.createTest("Client Portal Concentration Report Test")
                .withCategory(TestCategory.ClientPortal)
                .withAuthor(TestAuthor.ClientPortalPortfolioAnalyst);

        loginClient();
        clientPortal()
                .validateLogin()
                .withPortfolioAnalyst()
                .withFundParser()
                .validateConcentrationReport();
        clientPortal()
                .logout();

        softly.assertAll();
    }

    @Test(priority = 3)
    public void validateSearchHome() {

        reporter.createTest("Client Portal Home Search Test")
                .withCategory(TestCategory.ClientPortal)
                .withAuthor(TestAuthor.ClientPortalPortfolioAnalyst);

        loginClient();
        clientPortal()
                .validateLogin()
                .withPortfolioAnalyst()
                .withHome()
                .validateSearch();
        clientPortal()
                .logout();

        softly.assertAll();
    }

    @Test(priority = 4)
    public void validatePortfolioCheckup() {

        reporter.createTest("Client Portal Portfolio Checkup Test")
                .withCategory(TestCategory.ClientPortal)
                .withAuthor(TestAuthor.ClientPortalPortfolioAnalyst);

        loginClient();
        clientPortal()
                .validateLogin()
                .withPortfolioAnalyst()
                .withPortfolioCheckup()
                .validatePortfolioCheckup();
        clientPortal()
                .logout();

        softly.assertAll();
    }

    @Test(priority = 5)
    public void validateTwrMwrToggle() {

        reporter.createTest("Client Portal Twr Mwr Toggle Test")
                .withCategory(TestCategory.ClientPortal)
                .withAuthor(TestAuthor.ClientPortalPortfolioAnalyst);

        loginClient();
        clientPortal()
                .validateLogin()
                .withPortfolioAnalyst()
                .withHome()
                .validateTwrMwrToggle();
        clientPortal()
                .logout();

        softly.assertAll();
    }

    @Test(priority = 6)
    public void validateViewByDropdown() {

        reporter.createTest("Client Portal View By Drop down Test")
                .withCategory(TestCategory.ClientPortal)
                .withAuthor(TestAuthor.ClientPortalPortfolioAnalyst);

        loginClient();
        clientPortal()
                .validateLogin()
                .withPortfolioAnalyst()
                .withHome()
                .validateViewByDropDown();
        clientPortal()
                .logout();

        softly.assertAll();
    }

    @Test(priority = 7)
    public void validateFundSearchETF() {

        reporter.createTest("Client Portal Fund Search ETF Test")
                .withCategory(TestCategory.ClientPortal)
                .withAuthor(TestAuthor.ClientPortalPortfolioAnalyst);

        loginClient();
        clientPortal()
                .validateLogin()
                .withPortfolioAnalyst()
                .withFundParser()
                .validateExchangeTradedFundSearch();
        clientPortal()
                .logout();

        softly.assertAll();
    }

    @Test(priority = 8)
    public void validateFundSearchMutualFund() {

        reporter.createTest("Client Portal Fund Search Mutual Fund Test")
                .withCategory(TestCategory.ClientPortal)
                .withAuthor(TestAuthor.ClientPortalPortfolioAnalyst);

        loginClient();
        clientPortal()
                .validateLogin()
                .withPortfolioAnalyst()
                .withFundParser()
                .validateMutualFundSearch();
        clientPortal()
                .logout();

        softly.assertAll();
    }

    @Test(priority = 9)
    public void validateAddExternalAccount() {

        reporter.createTest("Client Portal Add External Account Test")
                .withCategory(TestCategory.ClientPortal)
                .withAuthor(TestAuthor.ClientPortalPortfolioAnalyst);

        loginClient();
        clientPortal()
                .validateLogin()
                .withPortfolioAnalyst()
                .withExternalAccount()
                .addExternalAccount();
        clientPortal()
                .logout();

        softly.assertAll();
    }

    @Test(priority = 10)
    public void validateReportDelivery() {

        reporter.createTest("Client Portal Edit Report Delivery Test")
                .withCategory(TestCategory.ClientPortal)
                .withAuthor(TestAuthor.ClientPortalPortfolioAnalyst);

        loginClient();
        clientPortal()
                .validateLogin()
                .withPortfolioAnalyst()
                .withReports()
                .validateReportDelivery();
        clientPortal()
                .logout();

        softly.assertAll();
    }

    @Test(priority = 11)
    public void validateCreateCustomStatements() {

        reporter.createTest("Client Portal Create Custom Statements Test")
                .withCategory(TestCategory.ClientPortal)
                .withAuthor(TestAuthor.ClientPortalReports);

        loginClient();
        clientPortal()
                .validateLogin()
                .withClientPortalReports()
                .navigateToReports();
        portal()
                .withReports()
                .withStatements()
                .validateStatementTab()
                .createCustomStatements();

        clientPortal()
                .logout();

        softly.assertAll();
    }

    @Test(priority = 12)
    public void validateEditCustomStatements() {

        reporter.createTest("Client Portal Edit Custom Statements Test")
                .withCategory(TestCategory.ClientPortal)
                .withAuthor(TestAuthor.ClientPortalReports);

        loginClient();
        clientPortal()
                .validateLogin()
                .withClientPortalReports()
                .navigateToReports();
        portal()
                .withReports()
                .withStatements()
                .validateStatementTab()
                .editCustomStatements();

        clientPortal()
                .logout();

        softly.assertAll();
    }

    @Test(priority = 13)
    public void validateRunCustomStatements() {

        reporter.createTest("Client Portal Run Custom Statements Test")
                .withCategory(TestCategory.ClientPortal)
                .withAuthor(TestAuthor.ClientPortalReports);

        loginClient();
        clientPortal()
                .validateLogin()
                .withClientPortalReports()
                .navigateToReports();
        portal()
                .withReports()
                .withStatements()
                .validateStatementTab()
                .runCustomStatements();

        clientPortal()
                .logout();

        softly.assertAll();
    }

    @Test(priority = 14)
    public void validateDeleteCustomStatements() {

        reporter.createTest("Client Portal Delete Custom Statements Test")
                .withCategory(TestCategory.ClientPortal)
                .withAuthor(TestAuthor.ClientPortalReports);

        loginClient();
        clientPortal()
                .validateLogin()
                .withClientPortalReports()
                .navigateToReports();
        portal()
                .withReports()
                .withStatements()
                .validateStatementTab()
                .deleteCustomStatements();

        clientPortal()
                .logout();

        softly.assertAll();
    }

    @Test(priority = 15)
    public void validateCreateActivityFlexQuery() {

        reporter.createTest("Client Portal Create Activity Flex Query Test")
                .withCategory(TestCategory.ClientPortal)
                .withAuthor(TestAuthor.ClientPortalReports);

        loginClient();
        clientPortal()
                .validateLogin()
                .withClientPortalReports()
                .navigateToReports();
        portal()
                .withReports()
                .withFlexQueries()
                .navigateToFlexQueries()
                .createActivityFlexQuery();

        clientPortal()
                .logout();

        softly.assertAll();
    }

    @Test(priority = 16)
    public void validateEditActivityFlexQuery() {

        reporter.createTest("Client Portal Edit Activity Flex Query Test")
                .withCategory(TestCategory.ClientPortal)
                .withAuthor(TestAuthor.ClientPortalReports);

        loginClient();
        clientPortal()
                .validateLogin()
                .withClientPortalReports()
                .navigateToReports();
        portal()
                .withReports()
                .withFlexQueries()
                .navigateToFlexQueries()
                .editActivityFlexQuery();

        clientPortal()
                .logout();

        softly.assertAll();
    }

    @Test(priority = 17)
    public void validateRunActivityFlexQuery() {

        reporter.createTest("Client Portal Run Activity Flex Query Test")
                .withCategory(TestCategory.ClientPortal)
                .withAuthor(TestAuthor.ClientPortalReports);

        loginClient();
        clientPortal()
                .validateLogin()
                .withClientPortalReports()
                .navigateToReports();
        portal()
                .withReports()
                .withFlexQueries()
                .navigateToFlexQueries()
                .runActivityFlexQuery();

        clientPortal()
                .logout();

        softly.assertAll();
    }

    @Test(priority = 18)
    public void validateDeleteActivityFlexQuery() {

        reporter.createTest("Client Portal Delete Activity Flex Query Test")
                .withCategory(TestCategory.ClientPortal)
                .withAuthor(TestAuthor.ClientPortalReports);

        loginClient();
        clientPortal()
                .validateLogin()
                .withClientPortalReports()
                .navigateToReports();
        portal()
                .withReports()
                .withFlexQueries()
                .navigateToFlexQueries()
                .deleteActivityFlexQuery();

        clientPortal()
                .logout();

        softly.assertAll();
    }
}