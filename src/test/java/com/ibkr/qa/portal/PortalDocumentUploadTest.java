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

    @Test(priority = 2)
    public void validateUploadEmployeesByCsv() {

        reporter.createTest("Compliance Portal Upload Employees By CSV Test")
                .withCategory(TestCategory.CompliancePortal)
                .withAuthor(TestAuthor.CompliancePortalEmployees);

        loginCompliance();
        portal()
                .withPortalName(PortalName.Compliance_Portal)
                .withEmployee()
                .validateUploadEmployeesByCsv();
        portal().logout();

        softly.assertAll();
    }
}
