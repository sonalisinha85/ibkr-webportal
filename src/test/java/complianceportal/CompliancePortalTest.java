package complianceportal;

import base.TestBase;
import enums.PortalName;
import enums.TestCategory;
import org.testng.annotations.Test;

public class CompliancePortalTest extends TestBase {

    @Test (priority = 1)
    public void validateEmployeeViewAndAddComment() {

        reporter.createTest("Compliance Portal View Employee & Add Comment Test", TestCategory.CompliancePortalEmployees);

        loginCompliance();
        portal()
                .withPortalName(PortalName.Compliance_Portal)
                .withEmployee()
                .validateEmployeeViewAndAddComment();
        portal().logout();

        softly.assertAll();
    }

    @Test (priority = 2)
    public void validateStatementAuditViewLog() {

        reporter.createTest("Compliance Portal Statement Audit View Log Test", TestCategory.CompliancePortalEmployees);

        loginCompliance();
        portal()
                .withPortalName(PortalName.Compliance_Portal)
                .withEmployee()
                .validateStatementViewLog();
        portal().logout();

        softly.assertAll();
    }

    @Test (priority = 3)
    public void validateSymbolReport() {

        reporter.createTest("Broker Portal Symbol Report Test", TestCategory.CompliancePortalTools);

        loginCompliance();
        portal()
                .withPortalName(PortalName.Compliance_Portal)
                .withDataQueries()
                .validateSymbolReport(PortalName.Compliance_Portal);
        portal().logout();

        softly.assertAll();
    }

    @Test (priority = 4)
    public void validateTransactionCountReport() {

        reporter.createTest("Broker Portal Transaction Count Report Test", TestCategory.CompliancePortalTools);

        loginCompliance();
        portal()
                .withPortalName(PortalName.Compliance_Portal)
                .withDataQueries()
                .validateTransactionCountReport(PortalName.Compliance_Portal);
        portal().logout();

        softly.assertAll();
    }
}
