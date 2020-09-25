package com.ibkr.qa.portal;

import com.ibkr.qa.base.PortalTestBase;
import com.ibkr.qa.enums.TestAuthor;
import com.ibkr.qa.enums.TestCategory;
import org.testng.annotations.Test;

public class ClientPortalTest extends PortalTestBase {

    @Test(priority = 1)
    public void validateFindServices() {

        reporter.createTest("Client Portal Find Services Test")
                .withCategory(TestCategory.ClientPortal)
                .withAuthor(TestAuthor.ClientPortalInvestorsMarketPlaceServices);

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

        reporter.createTest("Client Portal Add External Account Report Test")
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
    public void validateCustomStatementsNavigation() {

        reporter.createTest("Client Portal Custom Statements Navigation Test")
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
                .createCustomStatements()
                .editCustomStatements()
                .deleteCustomStatements()
                .runCustomStatements();

        clientPortal()
                .logout();

        softly.assertAll();
    }

    @Test(priority = 12)
    public void validateActivityFlexQueryNavigation() {

        reporter.createTest("Client Portal Activity Flex Query Navigation Test")
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
                .createActivityFlexQuery()
                .editActivityFlexQuery()
                .runActivityFlexQuery()
                .deleteActivityFlexQuery();

        clientPortal()
                .logout();

        softly.assertAll();
    }

    @Test(priority = 13)
    public void validateCustomBenchMarksNavigation() {

        reporter.createTest("Client Portal Custom Benchmarks Navigation Test")
                .withCategory(TestCategory.ClientPortal)
                .withAuthor(TestAuthor.ClientPortalReports);

        loginClient();
        clientPortal()
                .validateLogin()
                .withPortfolioAnalyst()
                .withReports()
                .createCustomBenchmarks()
                .editCustomBenchmarks()
                .deleteCustomBenchmarks();

        clientPortal()
                .logout();

        softly.assertAll();
    }

    @Test(priority = 14)
    public void validateCustomReportNavigation() {

        reporter.createTest("Client Portal Custom Report Navigation Test")
                .withCategory(TestCategory.ClientPortal)
                .withAuthor(TestAuthor.ClientPortalReports);

        loginClient();
        clientPortal()
                .validateLogin()
                .withPortfolioAnalyst()
                .withReports()
                .createCustomReports()
                .editCustomReport()
                .runCustomReport()
                .deleteCustomReport();

        clientPortal()
                .logout();

        softly.assertAll();
    }

    @Test(priority = 15)
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

    @Test(priority = 16)
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

    @Test(priority = 17)
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

    @Test(priority = 18)
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

    @Test(priority = 19)
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

    @Test(priority = 20)
    public void validateTradeConfirmationFlexQueryNavigation() {

        reporter.createTest("Client Portal Trade Confirmation Flex Query Navigation Test")
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
                .createTradeConfirmationFlexQuery()
                .editTradeConfirmationFlexQuery()
                .runTradeConfirmationFlexQuery()
                .deleteTradeConfirmationFlexQuery();

        clientPortal()
                .logout();

        softly.assertAll();
    }

    @Test(priority = 21)
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

    @Test(priority = 22)
    public void validateAdvertiseServices() {

        reporter.createTest("Client Portal Advertise Services Test")
                .withCategory(TestCategory.ClientPortal)
                .withAuthor(TestAuthor.ClientPortalInvestorsMarketPlaceServices);

        loginClient();
        clientPortal()
                .validateLogin()
                .withInvestorMarketplace()
                .validateAdvertiseServicesNavigation();
        clientPortal()
                .logout();

        softly.assertAll();
    }
}