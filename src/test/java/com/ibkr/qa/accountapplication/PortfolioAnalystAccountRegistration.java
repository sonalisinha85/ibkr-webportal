package com.ibkr.qa.accountapplication;

import com.ibkr.qa.base.AccountRegistrationTestBase;
import org.testng.annotations.Test;

public class PortfolioAnalystAccountRegistration extends AccountRegistrationTestBase {

    @Test
    public void registerAccount() {

        portfolioAnalystAccountRegistration()
                .fillForm();
    }
}
