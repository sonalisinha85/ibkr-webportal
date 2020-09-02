package com.ibkr.qa.accountapplication;

import com.ibkr.qa.base.AccountRegistrationTestBase;
import org.testng.annotations.Test;

public class ChineseNativeAccountRegistration extends AccountRegistrationTestBase {

    @Test
    public void registerAccount() {

        accountApplication()
                .withAccountRegistration()
                .fillForm();
    }
}
