package complianceportal;

import base.TestBase;
import enums.PortalName;
import enums.TestAuthor;
import enums.TestCategory;
import org.testng.annotations.Test;

public class CompliancePortalTest extends TestBase {

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
    public void validateCreateCustomReport() {

        reporter.createTest("Compliance Portal Create Custom Report Test")
                .withCategory(TestCategory.CompliancePortal)
                .withAuthor(TestAuthor.CompliancePortalReports);

        loginCompliance();
        portal()
                .withPortalName(PortalName.Compliance_Portal)
                .withReports()
                .createCustomReport();
        portal().logout();

        softly.assertAll();
    }

    @Test(priority = 10)
    public void validateEditCustomReport() {

        reporter.createTest("Compliance Portal Edit Custom Report Test")
                .withCategory(TestCategory.CompliancePortal)
                .withAuthor(TestAuthor.CompliancePortalReports);

        loginCompliance();
        portal()
                .withPortalName(PortalName.Compliance_Portal)
                .withReports()
                .editCustomReport();
        portal().logout();

        softly.assertAll();
    }

    @Test(priority = 11)
    public void validateRunCustomReport() {

        reporter.createTest("Compliance Portal Run Custom Report Test")
                .withCategory(TestCategory.CompliancePortal)
                .withAuthor(TestAuthor.CompliancePortalReports);

        loginCompliance();
        portal()
                .withPortalName(PortalName.Compliance_Portal)
                .withReports()
                .runCustomReport();
        portal().logout();

        softly.assertAll();
    }

    @Test(priority = 12)
    public void validateDeleteCustomReport() {

        reporter.createTest("Compliance Portal Delete Custom Report Test")
                .withCategory(TestCategory.CompliancePortal)
                .withAuthor(TestAuthor.CompliancePortalReports);

        loginCompliance();
        portal()
                .withPortalName(PortalName.Compliance_Portal)
                .withReports()
                .deleteCustomReport();
        portal().logout();

        softly.assertAll();
    }
}
