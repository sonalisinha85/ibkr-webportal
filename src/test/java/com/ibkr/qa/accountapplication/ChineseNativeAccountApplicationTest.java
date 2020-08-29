package com.ibkr.qa.accountapplication;

import com.ibkr.qa.base.TestBase;
import com.ibkr.qa.enums.TestAuthor;
import com.ibkr.qa.enums.TestCategory;

public class ChineseNativeAccountApplicationTest extends TestBase {

    //    @Test
    public void validateNewAccountApplication() {

        reporter.createTest("Chinese Native Account Application Test")
                .withCategory(TestCategory.ChineseNativeAccountApplication)
                .withAuthor(TestAuthor.ChineseNativeAccountApplication);

        loginChineseNative();
        accountApplication()
                .withAboutYou()
                .fillForm();

        softly.assertAll();
    }
}
