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
}