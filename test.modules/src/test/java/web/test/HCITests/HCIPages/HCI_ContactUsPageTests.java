package web.test.HCITests.HCIPages;

import Base.Common;
import Base.SingletonBrowser;
import HCIPo.HCIPagesPO.HCI_ContactUsPagePO;
import lombok.extern.java.Log;
import org.testng.Assert;
import org.testng.annotations.Test;

@Log
public class HCI_ContactUsPageTests extends Common {

    @Test(testName = "VerifyContactus")
    public void VerifyContactUs() throws Exception{
        try {
            SingletonBrowser.getInstance().getDriver().get(getProperty("contactusUrl"));
            HCI_ContactUsPagePO.getInstance().enterFirstName(getProperty("firstname"));
            HCI_ContactUsPagePO.getInstance().enterLastName(getProperty("lastname"));
            HCI_ContactUsPagePO.getInstance().enterEmail(getProperty("email"));
            HCI_ContactUsPagePO.getInstance().enterPhoneNumber(getProperty("phoneNumber"));
            HCI_ContactUsPagePO.getInstance().enterRandomDrpDwnImA();
            HCI_ContactUsPagePO.getInstance().enterInsuranceProvider(getProperty("insuranceProvider"));
            HCI_ContactUsPagePO.getInstance().enterQuestionMessage(getProperty("questionMessage"));
            Common.pageScroll();
            HCI_ContactUsPagePO.getInstance().enterHearAboutUs(getProperty("hearAboutUs"));
           // HCI_ContactUsPagePO.getInstance().clickSubmit();
            //Assert.assertEquals(HCI_ContactUsPagePO.getInstance().successfullMsgDisplayed(), "Thank you for your message. It has been sent.");
           SingletonBrowser.getInstance().getDriver().close();

        }catch (Exception e){
            log.info("Failed : VerifyContactus ");
            throw e;
        }
    }
}
