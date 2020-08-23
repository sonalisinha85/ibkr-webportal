package brokerportal;

import base.TestBase;
import enums.PortalName;
import enums.TestAuthor;
import enums.TestCategory;
import org.testng.annotations.Test;

public class BrokerPortalTest extends TestBase {

    @Test(priority = 1)
    public void validateAddWorkflow() {

        reporter.createTest("Broker Portal Add Workflow Test")
                .withCategory(TestCategory.BrokerPortal)
                .withAuthor(TestAuthor.BrokerPortalDashboard);

        loginBroker();
        portal()
                .withPortalName(PortalName.Broker_Portal)
                .withDashboard()
                .withWorkflowModal()
                .addWorkflow();
        portal().logout();

        softly.assertAll();
    }

    @Test(priority = 2)
    public void validateEditWorkflow() {

        reporter.createTest("Broker Portal Edit Workflow Test")
                .withCategory(TestCategory.BrokerPortal)
                .withAuthor(TestAuthor.BrokerPortalDashboard);

        loginBroker();
        portal()
                .withPortalName(PortalName.Broker_Portal)
                .withDashboard()
                .withWorkflowModal()
                .editWorkflow();
        portal().logout();

        softly.assertAll();
    }

    @Test(priority = 3)
    public void validateDeleteWorkflow() {

        reporter.createTest("Broker Portal Delete Workflow Test")
                .withCategory(TestCategory.BrokerPortal)
                .withAuthor(TestAuthor.BrokerPortalDashboard);

        loginBroker();
        portal()
                .withPortalName(PortalName.Broker_Portal)
                .withDashboard()
                .withWorkflowModal()
                .deleteWorkflow();
        portal().logout();

        softly.assertAll();
    }

    @Test(priority = 4)
    public void validateViewWorkflow() {

        reporter.createTest("Broker Portal View Workflow Test")
                .withCategory(TestCategory.BrokerPortal)
                .withAuthor(TestAuthor.BrokerPortalDashboard);

        loginBroker();
        portal()
                .withPortalName(PortalName.Broker_Portal)
                .withDashboard()
                .withWorkflowModal()
                .viewWorkflow()
                .viewMoreWorkflows();
        portal().logout();

        softly.assertAll();
    }

    @Test(priority = 5)
    public void validateAddNotes() {

        reporter.createTest("Broker Portal Add Notes Test")
                .withCategory(TestCategory.BrokerPortal)
                .withAuthor(TestAuthor.BrokerPortalDashboard);

        loginBroker();
        portal()
                .withPortalName(PortalName.Broker_Portal)
                .withDashboard()
                .withNotesModal()
                .addNotes();
        portal().logout();

        softly.assertAll();
    }

    @Test(priority = 6)
    public void validateEditNotes() {

        reporter.createTest("Broker Portal Edit Notes Test")
                .withCategory(TestCategory.BrokerPortal)
                .withAuthor(TestAuthor.BrokerPortalDashboard);

        loginBroker();
        portal()
                .withPortalName(PortalName.Broker_Portal)
                .withDashboard()
                .withNotesModal()
                .editNotes();
        portal().logout();

        softly.assertAll();
    }

    @Test(priority = 7)
    public void validateDeleteNotes() {

        reporter.createTest("Broker Portal Delete Notes Test")
                .withCategory(TestCategory.BrokerPortal)
                .withAuthor(TestAuthor.BrokerPortalDashboard);

        loginBroker();
        portal()
                .withPortalName(PortalName.Broker_Portal)
                .withDashboard()
                .withNotesModal()
                .deleteNotes();
        portal().logout();

        softly.assertAll();
    }

    @Test(priority = 8)
    public void validateViewNotes() {

        reporter.createTest("Broker Portal View Notes Test")
                .withCategory(TestCategory.BrokerPortal)
                .withAuthor(TestAuthor.BrokerPortalDashboard);

        loginBroker();
        portal()
                .withPortalName(PortalName.Broker_Portal)
                .withDashboard()
                .withNotesModal()
                .viewNotes()
                .viewMoreNotes();
        portal().logout();

        softly.assertAll();
    }

    @Test(priority = 9)
    public void validateAddEvent() {

        reporter.createTest("Broker Portal Add Event Test")
                .withCategory(TestCategory.BrokerPortal)
                .withAuthor(TestAuthor.BrokerPortalCalendar);

        loginBroker();
        portal()
                .withPortalName(PortalName.Broker_Portal)
                .withDashboard()
                .withEventModal()
                .addEvent();
        portal().logout();

        softly.assertAll();
    }

    @Test(priority = 10)
    public void validateEditEvent() {

        reporter.createTest("Broker Portal Edit Event Test")
                .withCategory(TestCategory.BrokerPortal)
                .withAuthor(TestAuthor.BrokerPortalCalendar);

        loginBroker();
        portal()
                .withPortalName(PortalName.Broker_Portal)
                .withDashboard()
                .withEventModal()
                .editEvent();
        portal().logout();

        softly.assertAll();
    }

    @Test(priority = 11)
    public void validateViewFullCalendar() {

        reporter.createTest("Broker Portal View Full Calendar Test")
                .withCategory(TestCategory.BrokerPortal)
                .withAuthor(TestAuthor.BrokerPortalCalendar);

        loginBroker();
        portal()
                .withPortalName(PortalName.Broker_Portal)
                .withDashboard()
                .viewFullCalendar();
        portal().logout();

        softly.assertAll();
    }

    @Test(priority = 12)
    public void validatePerformanceReport() {

        reporter.createTest("Broker Portal Performance Report Test")
                .withCategory(TestCategory.BrokerPortal)
                .withAuthor(TestAuthor.BrokerPortalTools);

        loginBroker();
        portal()
                .withPortalName(PortalName.Broker_Portal)
                .withDataQueries()
                .validatePerformanceReport();
        portal().logout();

        softly.assertAll();
    }

    @Test(priority = 13)
    public void validateSymbolReport() {

        reporter.createTest("Broker Portal Symbol Report Test")
                .withCategory(TestCategory.BrokerPortal)
                .withAuthor(TestAuthor.BrokerPortalTools);

        loginBroker();
        portal()
                .withPortalName(PortalName.Broker_Portal)
                .withDataQueries()
                .validateSymbolReport(PortalName.Broker_Portal);
        portal().logout();

        softly.assertAll();
    }

    @Test(priority = 14)
    public void validateTransactionCountReport() {

        reporter.createTest("Broker Portal Transaction Count Report Test")
                .withCategory(TestCategory.BrokerPortal)
                .withAuthor(TestAuthor.BrokerPortalTools);

        loginBroker();
        portal()
                .withPortalName(PortalName.Broker_Portal)
                .withDataQueries()
                .validateTransactionCountReport(PortalName.Broker_Portal);
        portal().logout();

        softly.assertAll();
    }

    @Test(priority = 15)
    public void validateRiskMarginReport() {

        reporter.createTest("Broker Portal Risk Margin Report Test")
                .withCategory(TestCategory.BrokerPortal)
                .withAuthor(TestAuthor.BrokerPortalReports);

        loginBroker();
        portal()
                .withPortalName(PortalName.Broker_Portal)
                .withReports()
                .validateRiskMarginReport();
        portal().logout();

        softly.assertAll();
    }

    @Test(priority = 16)
    public void validateStressTestReport() {

        reporter.createTest("Broker Portal Stress Test Report Test")
                .withCategory(TestCategory.BrokerPortal)
                .withAuthor(TestAuthor.BrokerPortalReports);

        loginBroker();
        portal()
                .withPortalName(PortalName.Broker_Portal)
                .withReports()
                .validateStressTestReport();
        portal().logout();

        softly.assertAll();
    }

    @Test(priority = 17)
    public void validateValueAtRiskReport() {

        reporter.createTest("Broker Portal Value At Risk Report Test")
                .withCategory(TestCategory.BrokerPortal)
                .withAuthor(TestAuthor.BrokerPortalReports);

        loginBroker();
        portal()
                .withPortalName(PortalName.Broker_Portal)
                .withReports()
                .validateValueAtRiskReport();
        portal().logout();

        softly.assertAll();
    }

    @Test(priority = 18)
    public void validateTransactionCostAnalysisReport() {

        reporter.createTest("Broker Portal Transaction Cost Analysis Report Test")
                .withCategory(TestCategory.BrokerPortal)
                .withAuthor(TestAuthor.BrokerPortalReports);

        loginBroker();
        portal()
                .withPortalName(PortalName.Broker_Portal)
                .withReports()
                .validateTransactionCostAnalysisReport();
        portal().logout();

        softly.assertAll();
    }

    @Test(priority = 19)
    public void validateTaxLotHoldingPeriodChangeReport() {

        reporter.createTest("Broker Portal Tax Lot Holding Period Change Test")
                .withCategory(TestCategory.BrokerPortal)
                .withAuthor(TestAuthor.BrokerPortalReports);

        loginBroker();
        portal()
                .withPortalName(PortalName.Broker_Portal)
                .withReports()
                .validateTaxLotHoldingPeriodChangeReport();
        portal().logout();

        softly.assertAll();
    }

    @Test(priority = 20)
    public void validateAccountConfirmationLetterReport() {

        reporter.createTest("Broker Portal Account Confirmation Letter Test")
                .withCategory(TestCategory.BrokerPortal)
                .withAuthor(TestAuthor.BrokerPortalReports);

        loginBroker();
        portal()
                .withPortalName(PortalName.Broker_Portal)
                .withReports()
                .validateTaxLotHoldingPeriodChangeReport();
        portal().logout();

        softly.assertAll();
    }
}