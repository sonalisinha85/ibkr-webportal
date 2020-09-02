package com.ibkr.qa.portal;

import com.ibkr.qa.base.PortalTestBase;
import com.ibkr.qa.enums.PortalName;
import com.ibkr.qa.enums.TestAuthor;
import com.ibkr.qa.enums.TestCategory;
import org.testng.annotations.Test;

public class CompliancePortalTest extends PortalTestBase {

    @Test(priority = 1)
    public void validateEmployeeViewAndAddComment() {

        reporter.createTest("Compliance Portal View Employee & Add Comment Test")
                .withCategory(TestCategory.CompliancePortal)
                .withAuthor(TestAuthor.CompliancePortalEmployees);

        loginCompliance();
        portal()
                .withPortalName(PortalName.Compliance_Portal)
                .withEmployee()
                .validateEmployeeViewAndAddComment();
        portal().logout();

        softly.assertAll();
    }

    @Test(priority = 2)
    public void validateStatementAuditViewLog() {

        reporter.createTest("Compliance Portal Statement Audit View Log Test")
                .withCategory(TestCategory.CompliancePortal)
                .withAuthor(TestAuthor.CompliancePortalEmployees);

        loginCompliance();
        portal()
                .withPortalName(PortalName.Compliance_Portal)
                .withEmployee()
                .validateStatementViewLog();
        portal().logout();

        softly.assertAll();
    }

    @Test(priority = 3)
    public void validateSymbolReport() {

        reporter.createTest("Broker Portal Symbol Report Test")
                .withCategory(TestCategory.CompliancePortal)
                .withAuthor(TestAuthor.CompliancePortalTools);

        loginCompliance();
        portal()
                .withPortalName(PortalName.Compliance_Portal)
                .withDataQueries()
                .validateSymbolReport(PortalName.Compliance_Portal);
        portal().logout();

        softly.assertAll();
    }

    @Test(priority = 4)
    public void validateTransactionCountReport() {

        reporter.createTest("Broker Portal Transaction Count Report Test")
                .withCategory(TestCategory.CompliancePortal)
                .withAuthor(TestAuthor.CompliancePortalTools);

        loginCompliance();
        portal()
                .withPortalName(PortalName.Compliance_Portal)
                .withDataQueries()
                .validateTransactionCountReport(PortalName.Compliance_Portal);
        portal().logout();

        softly.assertAll();
    }

    @Test(priority = 5)
    public void validateNewRestriction() {

        reporter.createTest("Compliance Portal New Restriction Test")
                .withCategory(TestCategory.CompliancePortal)
                .withAuthor(TestAuthor.CompliancePortalPreTradeCompliance);

        loginCompliance();
        portal()
                .withPortalName(PortalName.Compliance_Portal)
                .withPreTradeCompliance()
                .validateNewRestriction();
        portal().logout();

        softly.assertAll();
    }

    @Test(priority = 6)
    public void validateCopyRestriction() {

        reporter.createTest("Compliance Portal Copy Restriction Test")
                .withCategory(TestCategory.CompliancePortal)
                .withAuthor(TestAuthor.CompliancePortalPreTradeCompliance);

        loginCompliance();
        portal()
                .withPortalName(PortalName.Compliance_Portal)
                .withPreTradeCompliance()
                .validateCopyRestriction();
        portal().logout();

        softly.assertAll();
    }

    @Test(priority = 7)
    public void validateDeleteRestriction() {

        reporter.createTest("Compliance Portal Delete Restriction Test")
                .withCategory(TestCategory.CompliancePortal)
                .withAuthor(TestAuthor.CompliancePortalPreTradeCompliance);

        loginCompliance();
        portal()
                .withPortalName(PortalName.Compliance_Portal)
                .withPreTradeCompliance()
                .validateDeleteRestriction();
        portal().logout();

        softly.assertAll();
    }

    @Test(priority = 8)
    public void validateViewRestriction() {

        reporter.createTest("Compliance Portal View Restriction Test")
                .withCategory(TestCategory.CompliancePortal)
                .withAuthor(TestAuthor.CompliancePortalPreTradeCompliance);

        loginCompliance();
        portal()
                .withPortalName(PortalName.Compliance_Portal)
                .withPreTradeCompliance()
                .validateViewRestriction();
        portal().logout();

        softly.assertAll();
    }

    @Test(priority = 9)
    public void validateCreateCustomStatements() {

        reporter.createTest("Compliance Portal Create Custom Statements Test")
                .withCategory(TestCategory.CompliancePortal)
                .withAuthor(TestAuthor.CompliancePortalReports);

        loginCompliance();
        portal()
                .withPortalName(PortalName.Compliance_Portal)
                .withReports()
                .withStatements()
                .navigateToReport()
                .validateStatementTab()
                .createCustomStatements();
        portal().logout();

        softly.assertAll();
    }

    @Test(priority = 10)
    public void validateEditCustomStatements() {

        reporter.createTest("Compliance Portal Edit Custom Statements Test")
                .withCategory(TestCategory.CompliancePortal)
                .withAuthor(TestAuthor.CompliancePortalReports);

        loginCompliance();
        portal()
                .withPortalName(PortalName.Compliance_Portal)
                .withReports()
                .withStatements()
                .navigateToReport()
                .validateStatementTab()
                .editCustomStatements();
        portal().logout();

        softly.assertAll();
    }

    @Test(priority = 11)
    public void validateRunCustomStatements() {

        reporter.createTest("Compliance Portal Run Custom Statements Test")
                .withCategory(TestCategory.CompliancePortal)
                .withAuthor(TestAuthor.CompliancePortalReports);

        loginCompliance();
        portal()
                .withPortalName(PortalName.Compliance_Portal)
                .withReports()
                .withStatements()
                .navigateToReport()
                .validateStatementTab()
                .runCustomStatements();
        portal().logout();

        softly.assertAll();
    }

    @Test(priority = 12)
    public void validateDeleteCustomStatements() {

        reporter.createTest("Compliance Portal Delete Custom Statements Test")
                .withCategory(TestCategory.CompliancePortal)
                .withAuthor(TestAuthor.CompliancePortalReports);

        loginCompliance();
        portal()
                .withPortalName(PortalName.Compliance_Portal)
                .withReports()
                .withStatements()
                .navigateToReport()
                .validateStatementTab()
                .deleteCustomStatements();
        portal().logout();

        softly.assertAll();
    }

    @Test(priority = 13)
    public void validateCreateActivityFlexQuery() {

        reporter.createTest("Compliance Portal Create Activity Flex Query Test")
                .withCategory(TestCategory.CompliancePortal)
                .withAuthor(TestAuthor.CompliancePortalReports);

        loginCompliance();
        portal()
                .withPortalName(PortalName.Compliance_Portal)
                .withReports()
                .withFlexQueries()
                .navigateToReport()
                .navigateToFlexQueries()
                .createActivityFlexQuery();
        portal().logout();

        softly.assertAll();
    }

    @Test(priority = 14)
    public void validateEditActivityFlexQuery() {

        reporter.createTest("Compliance Portal Edit Activity Flex Query Test")
                .withCategory(TestCategory.CompliancePortal)
                .withAuthor(TestAuthor.CompliancePortalReports);

        loginCompliance();
        portal()
                .withPortalName(PortalName.Compliance_Portal)
                .withReports()
                .withFlexQueries()
                .navigateToReport()
                .navigateToFlexQueries()
                .editActivityFlexQuery();
        portal().logout();

        softly.assertAll();
    }

    @Test(priority = 15)
    public void validateRunActivityFlexQuery() {

        reporter.createTest("Compliance Portal Run Activity Flex Query Test")
                .withCategory(TestCategory.CompliancePortal)
                .withAuthor(TestAuthor.CompliancePortalReports);

        loginCompliance();
        portal()
                .withPortalName(PortalName.Compliance_Portal)
                .withReports()
                .withFlexQueries()
                .navigateToReport()
                .navigateToFlexQueries()
                .runActivityFlexQuery();
        portal().logout();

        softly.assertAll();
    }

    @Test(priority = 16)
    public void validateDeleteActivityFlexQuery() {

        reporter.createTest("Compliance Portal Delete Activity Flex Query Test")
                .withCategory(TestCategory.CompliancePortal)
                .withAuthor(TestAuthor.CompliancePortalReports);

        loginCompliance();
        portal()
                .withPortalName(PortalName.Compliance_Portal)
                .withReports()
                .withFlexQueries()
                .navigateToReport()
                .navigateToFlexQueries()
                .deleteActivityFlexQuery();
        portal().logout();

        softly.assertAll();
    }
}
