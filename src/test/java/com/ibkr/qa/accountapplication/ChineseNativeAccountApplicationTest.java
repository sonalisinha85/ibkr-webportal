package com.ibkr.qa.accountapplication;

import com.ibkr.qa.base.PortalTestBase;
import com.ibkr.qa.enums.TestAuthor;
import com.ibkr.qa.enums.TestCategory;
import org.testng.annotations.Test;

public class ChineseNativeAccountApplicationTest extends PortalTestBase {

    @Test
    public void validateNewAccountApplication() {

        reporter.createTest("Chinese Native Account Application Test")
                .withCategory(TestCategory.ChineseNativeAccountApplication)
                .withAuthor(TestAuthor.ChineseNativeAccountApplication);

        accountApplication()
                .loginChineseNative()
                .fillAboutYou()
                .fillRegulatory()
                .fillAgreement()
                .fillAccountSetup();

        softly.assertAll();
    }
}
