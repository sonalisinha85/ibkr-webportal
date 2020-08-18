package clientportal;

import base.TestBase;
import enums.TestCategory;
import org.testng.annotations.Test;

public class ClientPortalTest extends TestBase {

    @Test(priority = 1)
    public void validateFindServices() {

        reporter.createTest("Client Portal Find Services Test", TestCategory.ClientPortalFindServices);

        loginClient();
        portal()
                .withClientPortal()
                .validateLogin()
                .withInvestorMarketplace()
                .validateFindServicesNavigation();
        portal()
                .withClientPortal()
                .logout();

        softly.assertAll();
    }
}