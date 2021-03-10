package com.ibkr.qa.portal;

import com.ibkr.qa.base.PortalTestBase;
import com.ibkr.qa.enums.PortalName;
import com.ibkr.qa.enums.TestAuthor;
import com.ibkr.qa.enums.TestCategory;
import com.ibkr.qa.pages.Portal;
import com.ibkr.qa.pages.tabs.contacts.Contacts;
import org.testng.annotations.Test;

public class AdvisorPortalTest extends PortalTestBase {

    @Test(priority = 1)
    public void validateWorkflowNavigation() {

        reporter.createTest("Advisor Portal Workflow Navigation Test")
                .withCategory(TestCategory.AdvisorPortal)
                .withAuthor(TestAuthor.AdvisorPortalDashboard);

        loginAdvisor();
        portal()
                .withPortalName(PortalName.Advisor_Portal)
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

        reporter.createTest("Advisor Portal Notes Navigation Test")
                .withCategory(TestCategory.AdvisorPortal)
                .withAuthor(TestAuthor.AdvisorPortalDashboard);

        loginAdvisor();
        portal()
                .withPortalName(PortalName.Advisor_Portal)
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
    public void validateContactsNavigation() {

        reporter.createTest("Advisor Portal Contacts Navigation Test")
                .withCategory(TestCategory.AdvisorPortal)
                .withAuthor(TestAuthor.AdvisorPortalContacts);

        loginAdvisor();
        portal()
                .withPortalName(PortalName.Advisor_Portal)
                .withContacts()
                .contactSettings()
                .addContact()
//                .searchContacts()
//                .filterContacts()
                .viewContact();
        portal().logout();

        softly.assertAll();
    }

    @Test(priority = 4)
    public void validateAumAndMasterAccountBalance() {

        reporter.createTest("Advisor Portal Aum and Master Account Balance Test")
                .withCategory(TestCategory.AdvisorPortal)
                .withAuthor(TestAuthor.AdvisorPortalDashboard);

        loginAdvisor();
        portal()
                .withPortalName(PortalName.Advisor_Portal)
                .withDashboard()
                .validateAum()
                .validateMasterAccountBalance();
        portal().logout();

        softly.assertAll();
    }

    @Test(priority = 5)
    public void validateGroupNavigation() {

        reporter.createTest("Advisor Portal Group Navigation Test")
                .withCategory(TestCategory.AdvisorPortal)
                .withAuthor(TestAuthor.AdvisorPortalGroup);

        loginAdvisor();
        portal()
                .withPortalName(PortalName.Advisor_Portal)
                .withGroups()
                .addGroup()
                .editGroup()
                .deleteGroup()
                .viewGroup();
        portal().logout();

        softly.assertAll();
    }

    @Test(priority = 6)
    public void validateViewDocument() {

        reporter.createTest("Advisor Portal View Document Test")
                .withCategory(TestCategory.AdvisorPortal)
                .withAuthor(TestAuthor.AdvisorPortalDashboard);

        loginAdvisor();
        portal()
                .withPortalName(PortalName.Advisor_Portal)
                .withDashboard()
                .withDocumentModal()
                .viewDocument();
        portal().logout();

        softly.assertAll();
    }

    @Test(priority = 7)
    public void validateWhiteBrandingConfiguration() {

        reporter.createTest("Advisor Portal configure White Branding Test")
                .withCategory(TestCategory.AdvisorPortal)
                .withAuthor(TestAuthor.AdvisorPortalSettings);

        loginAdvisor();
        portal()
                .withPortalName(PortalName.Advisor_Portal)
                .withAccountSettings()
                .configureWhiteBranding();
        portal().logout();

        softly.assertAll();
    }

    @Test(priority = 8)
    public void validateClientFeeTemplatesNavigation() {

        reporter.createTest("Advisor Portal Client Fee Templates Navigation Test")
                .withCategory(TestCategory.AdvisorPortal)
                .withAuthor(TestAuthor.AdvisorPortalFeeAdmin);

        loginAdvisor();
        portal()
                .withPortalName(PortalName.Advisor_Portal)
                .withFeeAdmin()
                .configureClientFeeTemplateNavigation()
                .addAndDeleteClientFeeTemplate()
                .applyClientFeeTemplate();
        portal().logout();

        softly.assertAll();
    }

    @Test(priority = 9)
    public void validateConfigureClientFee() {

        reporter.createTest("Advisor Portal Configure Client Fee Test")
                .withCategory(TestCategory.AdvisorPortal)
                .withAuthor(TestAuthor.AdvisorPortalFeeAdmin);

        loginAdvisor();
        portal()
                .withPortalName(PortalName.Advisor_Portal)
                .withFeeAdmin()
                .configureClientFee();
        portal().logout();

        softly.assertAll();
    }

    @Test(priority = 10)
    public void validatePortfolioAnalystAccountSelector() {

        reporter.createTest("Advisor Portfolio Analyst Account Selector Test")
                .withCategory(TestCategory.AdvisorPortal)
                .withAuthor(TestAuthor.AdvisorPortalPortfolioAnalyst);

        loginAdvisor();
        portal()
                .withPortalName(PortalName.Advisor_Portal)
                .withPortfolioAnalyst()
                .validatePortfolioAnalystAccountSelector();
        portal().logout();

        softly.assertAll();
    }

    @Test(priority = 11)
    public void validateTransactionHistory() {

        reporter.createTest("Advisor Portfolio Analyst Account Selector Test")
                .withCategory(TestCategory.AdvisorPortal)
                .withAuthor(TestAuthor.AdvisorPortalTransferAndPay);

        loginAdvisor();
        portal()
                .withPortalName(PortalName.Advisor_Portal)
                .withTransactionStatusAndHistory()
                .validateTransactionHistory();
        portal().logout();

        softly.assertAll();
    }

    @Test(priority = 12)
    public void validateSynopsesNavigation() {

        reporter.createTest("Advisor Portal Create Synopses Test")
                .withCategory(TestCategory.AdvisorPortal)
                .withAuthor(TestAuthor.AdvisorPortalPortfolioAnalyst);

        loginAdvisor();
        portal()
                .withPortalName(PortalName.Advisor_Portal)
                .withPortfolioAnalyst()
                .navigateToReports()
                .withSynopsesModal()
                .createSynopses()
                .editSynopses()
                .deleteSynopses();
        portal().logout();

        softly.assertAll();
    }

    @Test(priority = 13)
    public void validateRiskMarginReport() {

        reporter.createTest("Advisor Portal Risk Margin Report Test")
                .withCategory(TestCategory.AdvisorPortal)
                .withAuthor(TestAuthor.AdvisorPortalReports);

        loginAdvisor();
        portal()
                .withPortalName(PortalName.Advisor_Portal)
                .withReports()
                .withOtherReports()
                .validateRiskMarginReport();
        portal().logout();

        softly.assertAll();
    }

    @Test(priority = 14)
    public void validateStressTestReport() {

        reporter.createTest("Advisor Portal Stress Test Report Test")
                .withCategory(TestCategory.AdvisorPortal)
                .withAuthor(TestAuthor.AdvisorPortalReports);

        loginAdvisor();
        portal()
                .withPortalName(PortalName.Advisor_Portal)
                .withReports()
                .withOtherReports()
                .validateStressTestReport();
        portal().logout();

        softly.assertAll();
    }

    @Test(priority = 15)
    public void validateValueAtRiskReport() {

        reporter.createTest("Advisor Portal Value At Risk Report Test")
                .withCategory(TestCategory.AdvisorPortal)
                .withAuthor(TestAuthor.AdvisorPortalReports);

        loginAdvisor();
        portal()
                .withPortalName(PortalName.Advisor_Portal)
                .withReports()
                .withOtherReports()
                .validateValueAtRiskReport();
        portal().logout();

        softly.assertAll();
    }

    @Test(priority = 16)
    public void validateTransactionCostAnalysisReport() {

        reporter.createTest("Advisor Portal Transaction Cost Analysis Report Test")
                .withCategory(TestCategory.AdvisorPortal)
                .withAuthor(TestAuthor.AdvisorPortalReports);

        loginAdvisor();
        portal()
                .withPortalName(PortalName.Advisor_Portal)
                .withReports()
                .withOtherReports()
                .validateTransactionCostAnalysisReport();
        portal().logout();

        softly.assertAll();
    }

    @Test(priority = 17)
    public void validatePnLMarkupReport() {

        reporter.createTest("Advisor Portal P/L Markup Report Test")
                .withCategory(TestCategory.AdvisorPortal)
                .withAuthor(TestAuthor.AdvisorPortalReports);

        loginAdvisor();
        portal()
                .withPortalName(PortalName.Advisor_Portal)
                .withReports()
                .withOtherReports()
                .validatePnLMarkupReport();
        portal().logout();

        softly.assertAll();
    }

    @Test(priority = 18)
    public void validateAdvisoryFeeInvoiceReport() {

        reporter.createTest("Advisor Portal Advisory Fee Invoice Report Test")
                .withCategory(TestCategory.AdvisorPortal)
                .withAuthor(TestAuthor.AdvisorPortalReports);

        loginAdvisor();
        portal()
                .withPortalName(PortalName.Advisor_Portal)
                .withReports()
                .withOtherReports()
                .validateAdvisoryFeeInvoiceReport();
        portal().logout();

        softly.assertAll();
    }

    @Test(priority = 19)
    public void validateTaxLotHoldingPeriodChangeReport() {

        reporter.createTest("Advisor Portal Tax Lot Holding Period Change Test")
                .withCategory(TestCategory.AdvisorPortal)
                .withAuthor(TestAuthor.AdvisorPortalReports);

        loginAdvisor();
        portal()
                .withPortalName(PortalName.Advisor_Portal)
                .withReports()
                .withOtherReports()
                .validateTaxLotHoldingPeriodChangeReport();
        portal().logout();

        softly.assertAll();
    }

    @Test(priority = 20)
    public void validateAccountConfirmationLetterReport() {

        reporter.createTest("Advisor Portal Account Confirmation Letter Test")
                .withCategory(TestCategory.AdvisorPortal)
                .withAuthor(TestAuthor.AdvisorPortalReports);

        loginAdvisor();
        portal()
                .withPortalName(PortalName.Advisor_Portal)
                .withReports()
                .withOtherReports()
                .validateTaxLotHoldingPeriodChangeReport();
        portal().logout();

        softly.assertAll();
    }

    @Test(priority = 21)
    public void validateRiskScoresReport() {

        reporter.createTest("Advisor Portal Risk Scores Report Test")
                .withCategory(TestCategory.AdvisorPortal)
                .withAuthor(TestAuthor.AdvisorPortalTools);

        loginAdvisor();
        portal()
                .withPortalName(PortalName.Advisor_Portal)
                .withRiskScores()
                .validateRiskScores();
        portal().logout();

        softly.assertAll();
    }

    @Test(priority = 22)
    public void validateFindServices() {

        reporter.createTest("Advisor Portal Find Services Test")
                .withCategory(TestCategory.AdvisorPortal)
                .withAuthor(TestAuthor.AdvisorPortalInvestorsMarketPlaceServices);

        loginAdvisor();
        portal()
                .withPortalName(PortalName.Advisor_Portal)
                .withInvestorMarketPlace()
                .validateAdvisorFindServicesNavigation();
        portal().logout();

        softly.assertAll();
    }

    @Test(priority = 23)
    public void validateAdvertiseServices() {

        reporter.createTest("Advisor Portal Advertise Services Test")
                .withCategory(TestCategory.AdvisorPortal)
                .withAuthor(TestAuthor.AdvisorPortalInvestorsMarketPlaceServices);

        loginAdvisor();
        portal()
                .withPortalName(PortalName.Advisor_Portal)
                .withInvestorMarketPlace()
                .validateAdvisorAdvertiseServicesNavigation();
        portal().logout();

        softly.assertAll();
    }

    @Test(priority = 24)
    public void validateActivityFlexQueryNavigation() {

        reporter.createTest("Advisor Portal Activity Flex Query Navigation Test")
                .withCategory(TestCategory.AdvisorPortal)
                .withAuthor(TestAuthor.AdvisorPortalReports);

        loginAdvisor();
        portal()
                .withPortalName(PortalName.Advisor_Portal)
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

    @Test(priority = 25)
    public void validateTradeConfirmationFlexQueryNavigation() {

        reporter.createTest("Advisor Portal Trade Confirmation Flex Query Navigation Test")
                .withCategory(TestCategory.AdvisorPortal)
                .withAuthor(TestAuthor.AdvisorPortalReports);

        loginAdvisor();
        portal()
                .withPortalName(PortalName.Advisor_Portal)
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

    @Test(priority = 26)
    public void validateActivityFlexQueryDelivery() {

        reporter.createTest("Advisor Portal Activity Flex Query Delivery Test")
                .withCategory(TestCategory.AdvisorPortal)
                .withAuthor(TestAuthor.AdvisorPortalReports);

        loginAdvisor();
        portal()
                .withPortalName(PortalName.Advisor_Portal)
                .withReports()
                .navigateToReports()
                .withFlexQueries()
                .navigateToFlexQueries()
                .withFlexQueryDelivery()
                .flexQueryDeliveryConfiguration("Activity Flex Queries Delivery");

        portal().logout();

        softly.assertAll();
    }

    @Test(priority = 27)
    public void validateTradeConfirmationFlexQueryDelivery() {

        reporter.createTest("Advisor Portal Trade Confirmation Flex Query Delivery Test")
                .withCategory(TestCategory.AdvisorPortal)
                .withAuthor(TestAuthor.AdvisorPortalReports);

        loginAdvisor();
        portal()
                .withPortalName(PortalName.Advisor_Portal)
                .withReports()
                .navigateToReports()
                .withFlexQueries()
                .navigateToFlexQueries()
                .withFlexQueryDelivery()
                .flexQueryDeliveryConfiguration("Trade Confirmation Flex Queries Delivery");

        portal().logout();

        softly.assertAll();
    }

    @Test(priority = 28)
    public void validateCustomStatementsNavigation() {

        reporter.createTest("Advisor Portal Custom Statements Navigation Test")
                .withCategory(TestCategory.AdvisorPortal)
                .withAuthor(TestAuthor.AdvisorPortalReports);

        loginAdvisor();
        portal()
                .withPortalName(PortalName.Advisor_Portal)
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

    @Test(priority = 29)
    public void validateDefaultStatementsNavigation() {

        reporter.createTest("Advisor Portal Default Statements Navigation Test")
                .withCategory(TestCategory.AdvisorPortal)
                .withAuthor(TestAuthor.AdvisorPortalReports);

        loginAdvisor();
        portal()
                .withPortalName(PortalName.Advisor_Portal)
                .withReports()
                .navigateToReports()
                .withStatements()
                .validateStatementTab()
                .viewDefaultStatements()
                .runDefaultStatements();
        portal().logout();

        softly.assertAll();
    }

    @Test(priority = 30)
    public void validateDailyCustomStatementsDelivery() {

        reporter.createTest("Advisor Daily Custom Statements Delivery Test")
                .withCategory(TestCategory.AdvisorPortal)
                .withAuthor(TestAuthor.AdvisorPortalReports);

        loginAdvisor();
        portal()
                .withPortalName(PortalName.Advisor_Portal)
                .withReports()
                .navigateToReports()
                .withStatements()
                .validateStatementTab()
                .withStatementDelivery()
                .statementDeliveryConfiguration("Daily Custom Statements Delivery");

        portal().logout();

        softly.assertAll();
    }

    @Test(priority = 31)
    public void validateMonthlyCustomStatementsDelivery() {

        reporter.createTest("Advisor Monthly Custom Statements Delivery Test")
                .withCategory(TestCategory.AdvisorPortal)
                .withAuthor(TestAuthor.AdvisorPortalReports);

        loginAdvisor();
        portal()
                .withPortalName(PortalName.Advisor_Portal)
                .withReports()
                .navigateToReports()
                .withStatements()
                .validateStatementTab()
                .withStatementDelivery()
                .statementDeliveryConfiguration("Monthly Custom Statements Delivery");

        portal().logout();

        softly.assertAll();
    }

    @Test(priority = 32)
    public void validateWorkflowInAgendaTab() {

        reporter.createTest("Advisor Portal Check Workflow in Agenda Tab Test")
                .withCategory(TestCategory.AdvisorPortal)
                .withAuthor(TestAuthor.AdvisorPortalContacts);

        loginAdvisor();
        Portal portal = portal()
                .withPortalName(PortalName.Advisor_Portal);
        Contacts contacts = portal
                .withContacts()
                .navigateToContacts()
                .addContact();
        portal.withDashboard()
                .navigateToDashboard()
                .withWorkflowModal()
                .addWorkflow(contacts.getFirstName());
        contacts.searchAndViewContactsByAssociatedName(contacts.getFirstName())
                .withContactInformation()
                .validateWorkflow(contacts.getFirstName())
                .deleteContact();

        portal().logout();

        softly.assertAll();
    }

    @Test(priority = 33)
    public void validateNoteInAgendaTab() {

        reporter.createTest("Advisor Portal Check Note in Agenda Tab Test")
                .withCategory(TestCategory.AdvisorPortal)
                .withAuthor(TestAuthor.AdvisorPortalContacts);

        loginAdvisor();
        Portal portal = portal()
                .withPortalName(PortalName.Advisor_Portal);
        Contacts contacts = portal
                .withContacts()
                .navigateToContacts()
                .addContact();
        portal.withDashboard()
                .navigateToDashboard()
                .withNotesModal()
                .addNotes(contacts.getFirstName());
        contacts.searchAndViewContactsByAssociatedName(contacts.getFirstName())
                .withContactInformation()
                .validateNote(contacts.getFirstName())
                .deleteContact();

        portal().logout();

        softly.assertAll();
    }

    @Test(priority = 34)
    public void validateEventInAgendaTab() {

        reporter.createTest("Advisor Portal Check Event in Agenda Tab Test")
                .withCategory(TestCategory.AdvisorPortal)
                .withAuthor(TestAuthor.AdvisorPortalContacts);

        loginAdvisor();
        Portal portal = portal()
                .withPortalName(PortalName.Advisor_Portal);
        Contacts contacts = portal
                .withContacts()
                .navigateToContacts()
                .addContact();
        portal.withDashboard()
                .navigateToDashboard()
                .withEventModal()
                .addEvent(contacts.getFirstName());
        contacts.searchAndViewContactsByAssociatedName(contacts.getFirstName())
                .withContactInformation()
                .validateEvent(contacts.getFirstName())
                .deleteContact();

        portal().logout();

        softly.assertAll();
    }

    @Test(priority = 35)
    public void validateThirdPartyDownloads() {

        reporter.createTest("Advisor Portal Third Party Downloads Test")
                .withCategory(TestCategory.AdvisorPortal)
                .withAuthor(TestAuthor.AdvisorPortalReports);

        loginAdvisor();
        portal()
                .withPortalName(PortalName.Advisor_Portal)
                .withReports()
                .navigateToReportsWithSingleAccount()
                .withStatements()
                .validateThirdPartyDownloads()
                .runThirdPartyDownloads();
        portal().logout();

        softly.assertAll();
    }
}