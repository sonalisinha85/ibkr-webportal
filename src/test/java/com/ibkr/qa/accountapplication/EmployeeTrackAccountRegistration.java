package com.ibkr.qa.accountapplication;

import com.ibkr.qa.base.AccountRegistrationTestBase;
import org.testng.annotations.Test;

public class EmployeeTrackAccountRegistration extends AccountRegistrationTestBase {

    @Test
    public void registerAccount() {

        employeeTrackAccountRegistration()
                .fillForm1()
//                wait after this step and enter verification manually
                .fillForm2();
    }
}
