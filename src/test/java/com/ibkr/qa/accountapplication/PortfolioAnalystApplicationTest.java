package com.ibkr.qa.accountapplication;

import com.ibkr.qa.base.PortalTestBase;
import com.ibkr.qa.enums.TestAuthor;
import com.ibkr.qa.enums.TestCategory;
import org.testng.annotations.Test;

public class PortfolioAnalystApplicationTest extends PortalTestBase {

    @Test
    public void validateNewAccountApplication() {

        reporter.createTest("Portfolio Analyst Application Test")
                .withCategory(TestCategory.AccountApplication)
                .withAuthor(TestAuthor.PortfolioAnalystApplicationLogin);

        portfolioAnalyst()
                .loginPortfolioAnalyst()
                .validatePortfolioAnalyst();

        softly.assertAll();
    }
}
