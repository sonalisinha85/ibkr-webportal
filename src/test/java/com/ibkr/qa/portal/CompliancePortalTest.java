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

//    @Test(priority = 2)
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
    public void validateRestrictionNavigation() {

        reporter.createTest("Compliance Portal Restriction Navigation Test")
                .withCategory(TestCategory.CompliancePortal)
                .withAuthor(TestAuthor.CompliancePortalPreTradeCompliance);

        loginCompliance();
        portal()
                .withPortalName(PortalName.Compliance_Portal)
                .withPreTradeCompliance()
                .newRestriction()
                .viewRestriction()
                .copyRestriction()
                .deleteRestriction();
        portal().logout();

        softly.assertAll();
    }

    @Test(priority = 6)
    public void validateCustomStatementsNavigation() {

        reporter.createTest("Compliance Portal Custom Statements Navigation Test")
                .withCategory(TestCategory.CompliancePortal)
                .withAuthor(TestAuthor.CompliancePortalReports);

        loginCompliance();
        portal()
                .withPortalName(PortalName.Compliance_Portal)
                .withReports()
                .withStatements()
                .navigateToReport()
                .validateStatementTab()
                .createCustomStatements()
                .editCustomStatements()
                .runCustomStatements()
                .deleteCustomStatements();
        portal().logout();

        softly.assertAll();
    }

    @Test(priority = 7)
    public void validateActivityFlexQueryNavigation() {

        reporter.createTest("Compliance Portal Activity Flex Query Navigation Test")
                .withCategory(TestCategory.CompliancePortal)
                .withAuthor(TestAuthor.CompliancePortalReports);

        loginCompliance();
        portal()
                .withPortalName(PortalName.Compliance_Portal)
                .withReports()
                .withFlexQueries()
                .navigateToReport()
                .navigateToFlexQueries()
                .createActivityFlexQuery()
                .editActivityFlexQuery()
                .runActivityFlexQuery()
                .deleteActivityFlexQuery();
        portal().logout();

        softly.assertAll();
    }
}
