package com.ibkr.qa.portal;

import com.ibkr.qa.base.PortalTestBase;
import com.ibkr.qa.enums.PortalName;
import com.ibkr.qa.enums.TestAuthor;
import com.ibkr.qa.enums.TestCategory;
import org.testng.annotations.Test;

public class PortalDocumentUploadTest extends PortalTestBase {

    @Test(priority = 1)
    public void validateUploadDocument() {

        reporter.createTest("Advisor Portal Upload Document Test")
                .withCategory(TestCategory.AdvisorPortal)
                .withAuthor(TestAuthor.AdvisorPortalDashboard);

        loginAdvisor();
        portal()
                .withPortalName(PortalName.Advisor_Portal)
                .withDashboard()
                .withDocumentModal()
                .addDocument();
        portal().logout();

        softly.assertAll();
    }
}
