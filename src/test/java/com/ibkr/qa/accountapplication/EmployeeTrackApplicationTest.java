package com.ibkr.qa.accountapplication;

import com.ibkr.qa.base.PortalTestBase;
import com.ibkr.qa.enums.TestAuthor;
import com.ibkr.qa.enums.TestCategory;
import org.testng.annotations.Test;

public class EmployeeTrackApplicationTest extends PortalTestBase {

    @Test
    public void validateNewAccountApplication() {

        reporter.createTest("Employee Track Application Test")
                .withCategory(TestCategory.AccountApplication)
                .withAuthor(TestAuthor.EmployeeTrackApplicationLogin);

        employeeTrack()
                .loginComplianceOfficer();
//                .validateComplianceOfficer();

        softly.assertAll();
    }
}
