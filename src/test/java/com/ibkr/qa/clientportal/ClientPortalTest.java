package com.ibkr.qa.clientportal;

import com.ibkr.qa.base.TestBase;
import com.ibkr.qa.enums.TestAuthor;
import com.ibkr.qa.enums.TestCategory;
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

    @Test(priority = 19)
    public void validateCreateCustomBenchMarks() {

        reporter.createTest("Client Portal Create Custom Benchmarks Test")
                .withCategory(TestCategory.ClientPortal)
                .withAuthor(TestAuthor.ClientPortalReports);

        loginClient();
        clientPortal()
                .validateLogin()
                .withPortfolioAnalyst()
                .withReports()
                .createCustomBenchmarks();

        clientPortal()
                .logout();

        softly.assertAll();
    }

    @Test(priority = 20)
    public void validateEditCustomBenchMarks() {

        reporter.createTest("Client Portal Edit Custom Benchmarks Test")
                .withCategory(TestCategory.ClientPortal)
                .withAuthor(TestAuthor.ClientPortalReports);

        loginClient();
        clientPortal()
                .validateLogin()
                .withPortfolioAnalyst()
                .withReports()
                .editCustomBenchmarks();

        clientPortal()
                .logout();

        softly.assertAll();
    }

    @Test(priority = 21)
    public void validateDeleteCustomBenchMarks() {

        reporter.createTest("Client Portal Delete Custom Benchmarks Test")
                .withCategory(TestCategory.ClientPortal)
                .withAuthor(TestAuthor.ClientPortalReports);

        loginClient();
        clientPortal()
                .validateLogin()
                .withPortfolioAnalyst()
                .withReports()
                .deleteCustomBenchmarks();

        clientPortal()
                .logout();

        softly.assertAll();
    }

    @Test(priority = 22)
    public void validateCreateCustomReport() {

        reporter.createTest("Client Portal Create Custom Report Test")
                .withCategory(TestCategory.ClientPortal)
                .withAuthor(TestAuthor.ClientPortalReports);

        loginClient();
        clientPortal()
                .validateLogin()
                .withPortfolioAnalyst()
                .withReports()
                .createCustomReports();

        clientPortal()
                .logout();

        softly.assertAll();
    }

    @Test(priority = 23)
    public void validateEditCustomReport() {

        reporter.createTest("Client Portal Edit Custom Report Test")
                .withCategory(TestCategory.ClientPortal)
                .withAuthor(TestAuthor.ClientPortalReports);

        loginClient();
        clientPortal()
                .validateLogin()
                .withPortfolioAnalyst()
                .withReports()
                .editCustomReport();

        clientPortal()
                .logout();

        softly.assertAll();
    }

    @Test(priority = 24)
    public void validateDeleteCustomReport() {

        reporter.createTest("Client Portal Delete Custom Report Test")
                .withCategory(TestCategory.ClientPortal)
                .withAuthor(TestAuthor.ClientPortalReports);

        loginClient();
        clientPortal()
                .validateLogin()
                .withPortfolioAnalyst()
                .withReports()
                .deleteCustomReport();

        clientPortal()
                .logout();

        softly.assertAll();
    }

    @Test(priority = 25)
    public void validateRunCustomReport() {

        reporter.createTest("Client Portal Run Custom Report Test")
                .withCategory(TestCategory.ClientPortal)
                .withAuthor(TestAuthor.ClientPortalReports);

        loginClient();
        clientPortal()
                .validateLogin()
                .withPortfolioAnalyst()
                .withReports()
                .runCustomReport();

        clientPortal()
                .logout();

        softly.assertAll();
    }

    @Test(priority = 26)
    public void validateViewDefaultReport() {

        reporter.createTest("Client Portal View Default Report Test")
                .withCategory(TestCategory.ClientPortal)
                .withAuthor(TestAuthor.ClientPortalReports);

        loginClient();
        clientPortal()
                .validateLogin()
                .withPortfolioAnalyst()
                .withReports()
                .viewDefaultReport();

        clientPortal()
                .logout();

        softly.assertAll();
    }

    @Test(priority = 27)
    public void validateSnapshotDefaultReport() {

        reporter.createTest("Client Portal Snapshot Default Report Test")
                .withCategory(TestCategory.ClientPortal)
                .withAuthor(TestAuthor.ClientPortalReports);

        loginClient();
        clientPortal()
                .validateLogin()
                .withPortfolioAnalyst()
                .withReports()
                .runSnapshotDefaultReport();

        clientPortal()
                .logout();

        softly.assertAll();
    }

    @Test(priority = 28)
    public void validateDetailPDFDefaultReport() {

        reporter.createTest("Client Portal Detail PDF Default Report Test")
                .withCategory(TestCategory.ClientPortal)
                .withAuthor(TestAuthor.ClientPortalReports);

        loginClient();
        clientPortal()
                .validateLogin()
                .withPortfolioAnalyst()
                .withReports()
                .runDetailPdfDefaultReport();

        clientPortal()
                .logout();

        softly.assertAll();
    }

    @Test(priority = 29)
    public void validateDetailCSVDefaultReport() {

        reporter.createTest("Client Portal Detail CSV Default Report Test")
                .withCategory(TestCategory.ClientPortal)
                .withAuthor(TestAuthor.ClientPortalReports);

        loginClient();
        clientPortal()
                .validateLogin()
                .withPortfolioAnalyst()
                .withReports()
                .runDetailCsvDefaultReport();

        clientPortal()
                .logout();

        softly.assertAll();
    }

    @Test(priority = 30)
    public void validateViewTaxForms() {

        reporter.createTest("Client Portal Tax Form Test")
                .withCategory(TestCategory.ClientPortal)
                .withAuthor(TestAuthor.ClientPortalReports);

        loginClient();
        clientPortal()
                .validateLogin()
                .withClientPortalReports()
                .navigateToReports();
        portal()
                .withReports()
                .withTaxForms()
                .navigateToTax()
                .validateTaxForms();

        clientPortal()
                .logout();

        softly.assertAll();
    }

    @Test(priority = 31)
    public void validateCreateTradeConfirmationFlexQuery() {

        reporter.createTest("Client Portal Create Trade Confirmation Flex Query Test")
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
                .createTradeConfirmationFlexQuery();

        clientPortal()
                .logout();

        softly.assertAll();
    }

    @Test(priority = 32)
    public void validateEditTradeConfirmationFlexQuery() {

        reporter.createTest("Client Portal Edit Trade Confirmation Flex Query Test")
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
                .editTradeConfirmationFlexQuery();

        clientPortal()
                .logout();

        softly.assertAll();
    }

    @Test(priority = 33)
    public void validateRunTradeConfirmationFlexQuery() {

        reporter.createTest("Client Portal Run Trade Confirmation Flex Query Test")
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
                .runTradeConfirmationFlexQuery();

        clientPortal()
                .logout();

        softly.assertAll();
    }

    @Test(priority = 34)
    public void validateDeleteTradeConfirmationFlexQuery() {

        reporter.createTest("Client Portal Delete Trade Confirmation Flex Query Test")
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
                .deleteTradeConfirmationFlexQuery();

        clientPortal()
                .logout();

        softly.assertAll();
    }

    @Test(priority = 35)
    public void validateEducationCenter() {

        reporter.createTest("Client Portal Education Center Test")
                .withCategory(TestCategory.ClientPortal)
                .withAuthor(TestAuthor.ClientPortalPortfolioAnalyst);

        loginClient();
        clientPortal()
                .validateLogin()
                .withPortfolioAnalyst()
                .withEducationCenter()
                .validateEducationCenter();

        clientPortal()
                .logout();

        softly.assertAll();
    }
}