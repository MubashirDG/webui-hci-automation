package web.test.ABCTests.ABCHomePage;

import Base.Common;
import Base.SingletonBrowser;
import ABCPo.ABCHomePage.ABCLoginPo;
import lombok.extern.java.Log;
import org.testng.Assert;
import org.testng.annotations.Test;

@Log
public class ABCLoginTest extends Common {

    @Test(testName = "VerifyValidLogin")
    public void VerifyUserLogin() throws Exception {
        try {
            SingletonBrowser.getInstance().getDriver().get(getProperty("url"));
            ABCLoginPo.getInstance().enterUserName(getProperty("username"));
            ABCLoginPo.getInstance().enterPassword(getProperty("password"));
            ABCLoginPo.getInstance().clickSignIn();
            Assert.assertTrue(ABCLoginPo.getInstance().isCustomerNameDisplayed(), "Jack Gomez");
            SingletonBrowser.getInstance().getDriver().close();
        } catch (Exception e) {
            log.info("Failed : userLogin ");
            throw e;
        }
    }


}
