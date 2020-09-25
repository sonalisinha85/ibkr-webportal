package com.ibkr.qa.portal;

import com.ibkr.qa.base.PortalTestBase;
import com.ibkr.qa.enums.PortalName;
import com.ibkr.qa.enums.TestAuthor;
import com.ibkr.qa.enums.TestCategory;
import org.testng.annotations.Test;

public class HedgeFundAdvisorPortal extends PortalTestBase {

    @Test(priority = 1)
    public void validateFindServices() {

        reporter.createTest("Advisor Portal Find Services Test")
                .withCategory(TestCategory.HedgeFundAdvisorPortal)
                .withAuthor(TestAuthor.HedgeFundAdvisorPortalInvestorsMarketPlaceServices);

        loginHedgeFundAdvisor();
        portal()
                .withPortalName(PortalName.Institutions_Portal)
                .withInvestorMarketPlace()
                .validateHedgeFundFindServicesNavigation();
        portal().logout();

        softly.assertAll();
    }

    @Test(priority = 2)
    public void validateAdvertiseServices() {

        reporter.createTest("Hedge Fund Advisor Portal Advertise Services Test")
                .withCategory(TestCategory.HedgeFundAdvisorPortal)
                .withAuthor(TestAuthor.HedgeFundAdvisorPortalInvestorsMarketPlaceServices);

        loginHedgeFundAdvisor();
        portal()
                .withPortalName(PortalName.Institutions_Portal)
                .withInvestorMarketPlace()
                .validateHedgeFundAdvisorAdvertiseServicesNavigation();
        portal().logout();

        softly.assertAll();
    }
}
