package com.ibkr.qa.portal;

import com.ibkr.qa.base.PortalTestBase;
import com.ibkr.qa.enums.PortalName;
import com.ibkr.qa.enums.TestAuthor;
import com.ibkr.qa.enums.TestCategory;
import com.ibkr.qa.pages.Portal;
import com.ibkr.qa.pages.tabs.contacts.Contacts;
import org.testng.annotations.Test;

public class BrokerPortalTest extends PortalTestBase {

    @Test(priority = 1)
    public void validateWorkflowNavigation() {

        reporter.createTest("Broker Portal Workflow Navigation Test")
                .withCategory(TestCategory.BrokerPortal)
                .withAuthor(TestAuthor.BrokerPortalDashboard);

        loginBroker();
        portal()
                .withPortalName(PortalName.Broker_Portal)
                .withDashboard()
                .withWorkflowModal()
                .addWorkflow()
                .editWorkflow()
                .viewWorkflow()
                .deleteWorkflow()
                .viewMoreWorkflows();
        portal().logout();

        softly.assertAll();
    }

    @Test(priority = 2)
    public void validateNotesNavigation() {

        reporter.createTest("Broker Portal Notes Navigation Test")
                .withCategory(TestCategory.BrokerPortal)
                .withAuthor(TestAuthor.BrokerPortalDashboard);

        loginBroker();
        portal()
                .withPortalName(PortalName.Broker_Portal)
                .withDashboard()
                .withNotesModal()
                .addNotes()
                .editNotes()
                .viewNotes()
                .deleteNotes()
                .viewMoreNotes();
        portal().logout();

        softly.assertAll();
    }

    @Test(priority = 3)
    public void validateEventNavigation() {

        reporter.createTest("Broker Portal Event Navigation Test")
                .withCategory(TestCategory.BrokerPortal)
                .withAuthor(TestAuthor.BrokerPortalCalendar);

        loginBroker();
        portal()
                .withPortalName(PortalName.Broker_Portal)
                .withDashboard()
                .withEventModal()
                .addEvent()
                .editEvent();
        portal().logout();

        softly.assertAll();
    }

    @Test(priority = 4)
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

    @Test(priority = 5)
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

    @Test(priority = 6)
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

    @Test(priority = 7)
    public void validateTransactionCountReport() {

        reporter.createTest("Broker Portal Transaction Count Report Test")
                .withCategory(TestCategory.BrokerPortal)
                .withAuthor(TestAuthor.BrokerPortalTools);

        loginBrokerNonDisclosed();
        portal()
                .withPortalName(PortalName.Broker_Portal)
                .withDataQueries()
                .validateTransactionCountReport(PortalName.Broker_Portal);
        portal().logout();

        softly.assertAll();
    }

    @Test(priority = 8)
    public void validateRiskMarginReport() {

        reporter.createTest("Broker Portal Risk Margin Report Test")
                .withCategory(TestCategory.BrokerPortal)
                .withAuthor(TestAuthor.BrokerPortalReports);

        loginBrokerNonDisclosed();
        portal()
                .withPortalName(PortalName.Broker_Portal)
                .withReports()
                .withOtherReports()
                .validateRiskMarginReport();
        portal().logout();

        softly.assertAll();
    }

    @Test(priority = 9)
    public void validateStressTestReport() {

        reporter.createTest("Broker Portal Stress Test Report Test")
                .withCategory(TestCategory.BrokerPortal)
                .withAuthor(TestAuthor.BrokerPortalReports);

        loginBrokerNonDisclosed();
        portal()
                .withPortalName(PortalName.Broker_Portal)
                .withReports()
                .withOtherReports()
                .validateStressTestReport();
        portal().logout();

        softly.assertAll();
    }

    @Test(priority = 10)
    public void validateValueAtRiskReport() {

        reporter.createTest("Broker Portal Value At Risk Report Test")
                .withCategory(TestCategory.BrokerPortal)
                .withAuthor(TestAuthor.BrokerPortalReports);

        loginBrokerNonDisclosed();
        portal()
                .withPortalName(PortalName.Broker_Portal)
                .withReports()
                .withOtherReports()
                .validateValueAtRiskReport();
        portal().logout();

        softly.assertAll();
    }

    @Test(priority = 11)
    public void validateTransactionCostAnalysisReport() {

        reporter.createTest("Broker Portal Transaction Cost Analysis Report Test")
                .withCategory(TestCategory.BrokerPortal)
                .withAuthor(TestAuthor.BrokerPortalReports);

        loginBrokerNonDisclosed();
        portal()
                .withPortalName(PortalName.Broker_Portal)
                .withReports()
                .withOtherReports()
                .validateTransactionCostAnalysisReport();
        portal().logout();

        softly.assertAll();
    }

    @Test(priority = 12)
    public void validateTaxLotHoldingPeriodChangeReport() {

        reporter.createTest("Broker Portal Tax Lot Holding Period Change Test")
                .withCategory(TestCategory.BrokerPortal)
                .withAuthor(TestAuthor.BrokerPortalReports);

        loginBrokerNonDisclosed();
        portal()
                .withPortalName(PortalName.Broker_Portal)
                .withReports()
                .withOtherReports()
                .validateTaxLotHoldingPeriodChangeReport();
        portal().logout();

        softly.assertAll();
    }

    @Test(priority = 13)
    public void validateAccountConfirmationLetterReport() {

        reporter.createTest("Broker Portal Account Confirmation Letter Test")
                .withCategory(TestCategory.BrokerPortal)
                .withAuthor(TestAuthor.BrokerPortalReports);

        loginBrokerNonDisclosed();
        portal()
                .withPortalName(PortalName.Broker_Portal)
                .withReports()
                .withOtherReports()
                .validateTaxLotHoldingPeriodChangeReport();
        portal().logout();

        softly.assertAll();
    }

    @Test(priority = 14)
    public void validateBrokerFindServices() {

        reporter.createTest("Broker Portal Find Services Test")
                .withCategory(TestCategory.BrokerPortal)
                .withAuthor(TestAuthor.BrokerPortalInvestorsMarketPlaceServices);

        loginBroker();
        portal()
                .withPortalName(PortalName.Broker_Portal)
                .withInvestorMarketPlace()
                .validateBrokerFindServicesNavigation();
        portal().logout();

        softly.assertAll();
    }

    @Test(priority = 15)
    public void validateBrokerAdvertiseServices() {

        reporter.createTest("Broker Portal Find Services Test")
                .withCategory(TestCategory.BrokerPortal)
                .withAuthor(TestAuthor.BrokerPortalInvestorsMarketPlaceServices);

        loginBroker();
        portal()
                .withPortalName(PortalName.Broker_Portal)
                .withInvestorMarketPlace()
                .validateBrokerAdvertiseServicesNavigation();
        portal().logout();

        softly.assertAll();
    }

    @Test(priority = 16)
    public void validateActivityFlexQueryNavigation() {

        reporter.createTest("Broker Portal Activity Flex Query Navigation Test")
                .withCategory(TestCategory.BrokerPortal)
                .withAuthor(TestAuthor.BrokerPortalReports);

        loginBrokerNonDisclosed();
        portal()
                .withPortalName(PortalName.Broker_Portal)
                .withReports()
                .navigateToReports()
                .withFlexQueries()
                .navigateToFlexQueries()
                .createActivityFlexQuery()
                .editActivityFlexQuery()
                .runActivityFlexQuery()
                .deleteActivityFlexQuery();

        portal().logout();

        softly.assertAll();
    }

    @Test(priority = 17)
    public void validateTradeConfirmationFlexQueryNavigation() {

        reporter.createTest("Broker Portal Trade Confirmation Flex Query Navigation Test")
                .withCategory(TestCategory.BrokerPortal)
                .withAuthor(TestAuthor.BrokerPortalReports);

        loginBrokerNonDisclosed();
        portal()
                .withPortalName(PortalName.Broker_Portal)
                .withReports()
                .navigateToReports()
                .withFlexQueries()
                .navigateToFlexQueries()
                .createTradeConfirmationFlexQuery()
                .editTradeConfirmationFlexQuery()
                .runTradeConfirmationFlexQuery()
                .deleteTradeConfirmationFlexQuery();
        portal().logout();

        softly.assertAll();
    }

    @Test(priority = 18)
    public void validateActivityFlexQueryDelivery() {

        reporter.createTest("Broker Portal Activity Flex Query Delivery Test")
                .withCategory(TestCategory.BrokerPortal)
                .withAuthor(TestAuthor.BrokerPortalReports);

        loginBrokerNonDisclosed();
        portal()
                .withPortalName(PortalName.Broker_Portal)
                .withReports()
                .navigateToReports()
                .withFlexQueries()
                .navigateToFlexQueries()
                .withFlexQueryDelivery()
                .flexQueryDeliveryConfiguration("Activity Flex Queries Delivery");

        portal().logout();

        softly.assertAll();
    }

    @Test(priority = 19)
    public void validateTradeConfirmationFlexQueryDelivery() {

        reporter.createTest("Broker Portal Trade Confirmation Flex Query Delivery Test")
                .withCategory(TestCategory.BrokerPortal)
                .withAuthor(TestAuthor.BrokerPortalReports);

        loginBrokerNonDisclosed();
        portal()
                .withPortalName(PortalName.Broker_Portal)
                .withReports()
                .navigateToReports()
                .withFlexQueries()
                .navigateToFlexQueries()
                .withFlexQueryDelivery()
                .flexQueryDeliveryConfiguration("Trade Confirmation Flex Queries Delivery");

        portal().logout();

        softly.assertAll();
    }

    @Test(priority = 20)
    public void validateCustomStatementsNavigation() {

        reporter.createTest("Broker Portal Custom Statements Navigation Test")
                .withCategory(TestCategory.BrokerPortal)
                .withAuthor(TestAuthor.BrokerPortalReports);

        loginBrokerNonDisclosed();
        portal()
                .withPortalName(PortalName.Broker_Portal)
                .withReports()
                .navigateToReports()
                .withStatements()
                .validateStatementTab()
                .createCustomStatements()
                .editCustomStatements()
                .deleteCustomStatements()
                .runCustomStatements();
        portal().logout();

        softly.assertAll();
    }

    @Test(priority = 21)
    public void validateDefaultStatementsNavigation() {

        reporter.createTest("Broker Portal Default Statements Navigation Test")
                .withCategory(TestCategory.BrokerPortal)
                .withAuthor(TestAuthor.BrokerPortalReports);

        loginBrokerNonDisclosed();
        portal()
                .withPortalName(PortalName.Broker_Portal)
                .withReports()
                .navigateToReports()
                .withStatements()
                .validateStatementTab()
                .viewDefaultStatements()
                .runDefaultStatements();
        portal().logout();

        softly.assertAll();
    }

    @Test(priority = 22)
    public void validateDailyCustomStatementsDelivery() {

        reporter.createTest("Broker Daily Custom Statements Delivery Test")
                .withCategory(TestCategory.BrokerPortal)
                .withAuthor(TestAuthor.BrokerPortalReports);

        loginBrokerNonDisclosed();
        portal()
                .withPortalName(PortalName.Broker_Portal)
                .withReports()
                .navigateToReports()
                .withStatements()
                .validateStatementTab()
                .withStatementDelivery()
                .statementDeliveryConfiguration("Daily Custom Statements Delivery");

        portal().logout();

        softly.assertAll();
    }

    @Test(priority = 23)
    public void validateMonthlyCustomStatementsDelivery() {

        reporter.createTest("Broker Monthly Custom Statements Delivery Test")
                .withCategory(TestCategory.BrokerPortal)
                .withAuthor(TestAuthor.BrokerPortalReports);

        loginBrokerNonDisclosed();
        portal()
                .withPortalName(PortalName.Broker_Portal)
                .withReports()
                .navigateToReports()
                .withStatements()
                .validateStatementTab()
                .withStatementDelivery()
                .statementDeliveryConfiguration("Monthly Custom Statements Delivery");

        portal().logout();

        softly.assertAll();
    }

    @Test(priority = 24)
    public void validateWorkflowInAgendaTab() {

        reporter.createTest("Broker Portal Check Workflow in Agenda Tab Test")
                .withCategory(TestCategory.BrokerPortal)
                .withAuthor(TestAuthor.BrokerPortalContacts);

        loginBroker();
        Portal portal = portal()
                .withPortalName(PortalName.Broker_Portal);
        Contacts contacts = portal
                .withContacts()
                .navigateToContacts()
                .addContact();
        portal.withDashboard()
                .navigateToDashboard()
                .withWorkflowModal()
                .addWorkflow(contacts.getFirstName());
        contacts.searchAndViewContactsByAssociatedName()
                .withContactInformation()
                .validateWorkflow(contacts.getFirstName());

        portal().logout();

        softly.assertAll();
    }

    @Test(priority = 25)
    public void validateNoteInAgendaTab() {

        reporter.createTest("Broker Portal Check Note in Agenda Tab Test")
                .withCategory(TestCategory.BrokerPortal)
                .withAuthor(TestAuthor.BrokerPortalContacts);

        loginBroker();
        Portal portal = portal()
                .withPortalName(PortalName.Broker_Portal);
        Contacts contacts = portal
                .withContacts()
                .navigateToContacts()
                .addContact();
        portal.withDashboard()
                .navigateToDashboard()
                .withNotesModal()
                .addNotes(contacts.getFirstName());
        contacts.searchAndViewContactsByAssociatedName()
                .withContactInformation()
                .validateNote(contacts.getFirstName());

        portal().logout();

        softly.assertAll();
    }

    @Test(priority = 26)
    public void validateEventInAgendaTab() {

        reporter.createTest("Broker Portal Check Event in Agenda Tab Test")
                .withCategory(TestCategory.BrokerPortal)
                .withAuthor(TestAuthor.BrokerPortalContacts);

        loginBroker();
        Portal portal = portal()
                .withPortalName(PortalName.Broker_Portal);
        Contacts contacts = portal
                .withContacts()
                .navigateToContacts()
                .addContact();
        portal.withDashboard()
                .navigateToDashboard()
                .withEventModal()
                .addEvent(contacts.getFirstName());
        contacts.searchAndViewContactsByAssociatedName()
                .withContactInformation()
                .validateEvent(contacts.getFirstName());

        portal().logout();

        softly.assertAll();
    }

    @Test(priority = 27)
    public void validateThirdPartyDownloads() {

        reporter.createTest("Broker Portal Third Party Downloads Test")
                .withCategory(TestCategory.BrokerPortal)
                .withAuthor(TestAuthor.BrokerPortalReports);

        loginBrokerNonDisclosed();
        portal()
                .withPortalName(PortalName.Broker_Portal)
                .withReports()
                .navigateToReportsWithSingleAccount()
                .withStatements()
                .validateThirdPartyDownloads()
                .runThirdPartyDownloads();
        portal().logout();

        softly.assertAll();
    }
}