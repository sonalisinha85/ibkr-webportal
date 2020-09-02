package com.ibkr.qa.portal;

import com.ibkr.qa.base.PortalTestBase;
import com.ibkr.qa.enums.PortalName;
import com.ibkr.qa.enums.TestAuthor;
import com.ibkr.qa.enums.TestCategory;
import org.testng.annotations.Test;

public class AdvisorPortalTest extends PortalTestBase {

    @Test(priority = 1)
    public void validateAddWorkflow() {

        reporter.createTest("Advisor Portal Add Workflow Test")
                .withCategory(TestCategory.AdvisorPortal)
                .withAuthor(TestAuthor.AdvisorPortalDashboard);

        loginAdvisor();
        portal()
                .withPortalName(PortalName.Advisor_Portal)
                .withDashboard()
                .withWorkflowModal()
                .addWorkflow();
        portal().logout();

        softly.assertAll();
    }

    @Test(priority = 2)
    public void validateEditWorkflow() {

        reporter.createTest("Advisor Portal Edit Workflow Test")
                .withCategory(TestCategory.AdvisorPortal)
                .withAuthor(TestAuthor.AdvisorPortalDashboard);

        loginAdvisor();
        portal()
                .withPortalName(PortalName.Advisor_Portal)
                .withDashboard()
                .withWorkflowModal()
                .editWorkflow();
        portal().logout();

        softly.assertAll();
    }

    @Test(priority = 3)
    public void validateDeleteWorkflow() {

        reporter.createTest("Advisor Portal Delete Workflow Test")
                .withCategory(TestCategory.AdvisorPortal)
                .withAuthor(TestAuthor.AdvisorPortalDashboard);

        loginAdvisor();
        portal()
                .withPortalName(PortalName.Advisor_Portal)
                .withDashboard()
                .withWorkflowModal()
                .deleteWorkflow();
        portal().logout();

        softly.assertAll();
    }

    @Test(priority = 4)
    public void validateViewWorkflow() {

        reporter.createTest("Advisor Portal View Workflow Test")
                .withCategory(TestCategory.AdvisorPortal)
                .withAuthor(TestAuthor.AdvisorPortalDashboard);

        loginAdvisor();
        portal()
                .withPortalName(PortalName.Advisor_Portal)
                .withDashboard()
                .withWorkflowModal()
                .viewWorkflow()
                .viewMoreWorkflows();
        portal().logout();

        softly.assertAll();
    }

    @Test(priority = 5)
    public void validateAddNotes() {

        reporter.createTest("Advisor Portal Add Notes Test")
                .withCategory(TestCategory.AdvisorPortal)
                .withAuthor(TestAuthor.AdvisorPortalDashboard);

        loginAdvisor();
        portal()
                .withPortalName(PortalName.Advisor_Portal)
                .withDashboard()
                .withNotesModal()
                .addNotes();
        portal().logout();

        softly.assertAll();
    }

    @Test(priority = 6)
    public void validateEditNotes() {

        reporter.createTest("Advisor Portal Edit Notes Test")
                .withCategory(TestCategory.AdvisorPortal)
                .withAuthor(TestAuthor.AdvisorPortalDashboard);

        loginAdvisor();
        portal()
                .withPortalName(PortalName.Advisor_Portal)
                .withDashboard()
                .withNotesModal()
                .editNotes();
        portal().logout();

        softly.assertAll();
    }

    @Test(priority = 7)
    public void validateDeleteNotes() {

        reporter.createTest("Advisor Portal Delete Notes Test")
                .withCategory(TestCategory.AdvisorPortal)
                .withAuthor(TestAuthor.AdvisorPortalDashboard);

        loginAdvisor();
        portal()
                .withPortalName(PortalName.Advisor_Portal)
                .withDashboard()
                .withNotesModal()
                .deleteNotes();
        portal().logout();

        softly.assertAll();
    }

    @Test(priority = 8)
    public void validateViewNotes() {

        reporter.createTest("Advisor Portal View Notes Test")
                .withCategory(TestCategory.AdvisorPortal)
                .withAuthor(TestAuthor.AdvisorPortalDashboard);

        loginAdvisor();
        portal()
                .withPortalName(PortalName.Advisor_Portal)
                .withDashboard()
                .withNotesModal()
                .viewNotes()
                .viewMoreNotes();
        portal().logout();

        softly.assertAll();
    }

    @Test(priority = 9)
    public void validateSearchContacts() {

        reporter.createTest("Advisor Portal Search Contacts Test")
                .withCategory(TestCategory.AdvisorPortal)
                .withAuthor(TestAuthor.AdvisorPortalContacts);

        loginAdvisor();
        portal()
                .withPortalName(PortalName.Advisor_Portal)
                .withContacts()
                .searchContacts();
        portal().logout();

        softly.assertAll();
    }

    @Test(priority = 10)
    public void validateAddContacts() {

        reporter.createTest("Advisor Portal Add Contacts Test")
                .withCategory(TestCategory.AdvisorPortal)
                .withAuthor(TestAuthor.AdvisorPortalContacts);

        loginAdvisor();
        portal()
                .withPortalName(PortalName.Advisor_Portal)
                .withContacts()
                .addContact();
        portal().logout();

        softly.assertAll();
    }

    @Test(priority = 11)
    public void validateFilterContacts() {

        reporter.createTest("Advisor Portal Filter Contacts Test")
                .withCategory(TestCategory.AdvisorPortal)
                .withAuthor(TestAuthor.AdvisorPortalContacts);

        loginAdvisor();
        portal()
                .withPortalName(PortalName.Advisor_Portal)
                .withContacts()
                .filterContacts();
        portal().logout();

        softly.assertAll();
    }

    @Test(priority = 12)
    public void validateSettingsContacts() {

        reporter.createTest("Advisor Portal Filter Contacts Test")
                .withCategory(TestCategory.AdvisorPortal)
                .withAuthor(TestAuthor.AdvisorPortalContacts);

        loginAdvisor();
        portal()
                .withPortalName(PortalName.Advisor_Portal)
                .withContacts()
                .contactSettings();
        portal().logout();

        softly.assertAll();
    }

    @Test(priority = 13)
    public void validateViewContacts() {

        reporter.createTest("Advisor Portal View Contacts Test")
                .withCategory(TestCategory.AdvisorPortal)
                .withAuthor(TestAuthor.AdvisorPortalContacts);

        loginAdvisor();
        portal()
                .withPortalName(PortalName.Advisor_Portal)
                .withContacts()
                .viewContact();
        portal().logout();

        softly.assertAll();
    }

    @Test(priority = 14)
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

    @Test(priority = 15)
    public void validateAddGroup() {

        reporter.createTest("Advisor Portal Add Group Test")
                .withCategory(TestCategory.AdvisorPortal)
                .withAuthor(TestAuthor.AdvisorPortalGroup);

        loginAdvisor();
        portal()
                .withPortalName(PortalName.Advisor_Portal)
                .withGroups()
                .validateAddGroup();
        portal().logout();

        softly.assertAll();
    }

    @Test(priority = 16)
    public void validateDeleteGroup() {

        reporter.createTest("Advisor Portal Delete Group Test")
                .withCategory(TestCategory.AdvisorPortal)
                .withAuthor(TestAuthor.AdvisorPortalGroup);

        loginAdvisor();
        portal()
                .withPortalName(PortalName.Advisor_Portal)
                .withGroups()
                .validateDeleteGroup();
        portal().logout();

        softly.assertAll();
    }

    @Test(priority = 17)
    public void validateEditGroup() {

        reporter.createTest("Advisor Portal Edit Group Test")
                .withCategory(TestCategory.AdvisorPortal)
                .withAuthor(TestAuthor.AdvisorPortalGroup);

        loginAdvisor();
        portal()
                .withPortalName(PortalName.Advisor_Portal)
                .withGroups()
                .validateEditGroup();
        portal().logout();

        softly.assertAll();
    }

    @Test(priority = 18)
    public void validateViewGroup() {

        reporter.createTest("Advisor Portal View Group Test")
                .withCategory(TestCategory.AdvisorPortal)
                .withAuthor(TestAuthor.AdvisorPortalGroup);

        loginAdvisor();
        portal()
                .withPortalName(PortalName.Advisor_Portal)
                .withGroups()
                .validateViewGroup();
        portal().logout();

        softly.assertAll();
    }

    @Test(priority = 19)
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

    @Test(priority = 20)
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

    @Test(priority = 21)
    public void validateAddAndDeleteClientFeeTemplates() {

        reporter.createTest("Advisor Portal Add & Delete Client Fee Template Test")
                .withCategory(TestCategory.AdvisorPortal)
                .withAuthor(TestAuthor.AdvisorPortalFeeAdmin);

        loginAdvisor();
        portal()
                .withPortalName(PortalName.Advisor_Portal)
                .withFeeAdmin()
                .configureClientFeeTemplateNavigation()
                .addAndDeleteClientFeeTemplate();
        portal().logout();

        softly.assertAll();
    }

    @Test(priority = 22)
    public void validateApplyClientFeeTemplates() {

        reporter.createTest("Advisor Portal Apply Client Fee Template Test")
                .withCategory(TestCategory.AdvisorPortal)
                .withAuthor(TestAuthor.AdvisorPortalFeeAdmin);

        loginAdvisor();
        portal()
                .withPortalName(PortalName.Advisor_Portal)
                .withFeeAdmin()
                .configureClientFeeTemplateNavigation()
                .applyClientFeeTemplate();
        portal().logout();

        softly.assertAll();
    }

    @Test(priority = 23)
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

    @Test(priority = 24)
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

    @Test(priority = 25)
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

    @Test(priority = 26)
    public void validateCreateSynopses() {

        reporter.createTest("Advisor Portal Create Synopses Test")
                .withCategory(TestCategory.AdvisorPortal)
                .withAuthor(TestAuthor.AdvisorPortalPortfolioAnalyst);

        loginAdvisor();
        portal()
                .withPortalName(PortalName.Advisor_Portal)
                .withPortfolioAnalyst()
                .navigateToReports()
                .withSynopsesModal()
                .createSynopses();
        portal().logout();

        softly.assertAll();
    }

    @Test(priority = 27)
    public void validateUpdateSynopses() {

        reporter.createTest("Advisor Portal Update Synopses Test")
                .withCategory(TestCategory.AdvisorPortal)
                .withAuthor(TestAuthor.AdvisorPortalPortfolioAnalyst);

        loginAdvisor();
        portal()
                .withPortalName(PortalName.Advisor_Portal)
                .withPortfolioAnalyst()
                .navigateToReports()
                .withSynopsesModal()
                .editSynopses();
        portal().logout();

        softly.assertAll();
    }

    @Test(priority = 28)
    public void validateDeleteSynopses() {

        reporter.createTest("Advisor Portal Delete Synopses Test")
                .withCategory(TestCategory.AdvisorPortal)
                .withAuthor(TestAuthor.AdvisorPortalPortfolioAnalyst);

        loginAdvisor();
        portal()
                .withPortalName(PortalName.Advisor_Portal)
                .withPortfolioAnalyst()
                .navigateToReports()
                .withSynopsesModal()
                .deleteSynopses();
        portal().logout();

        softly.assertAll();
    }

    @Test(priority = 29)
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

    @Test(priority = 30)
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

    @Test(priority = 31)
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

    @Test(priority = 32)
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

    @Test(priority = 33)
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

    @Test(priority = 34)
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

    @Test(priority = 35)
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

    @Test(priority = 36)
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

    @Test(priority = 37)
    public void validateRiskScoresReport() {

        reporter.createTest("Advisor Portal Account Confirmation Letter Test")
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
}