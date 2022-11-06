package web.test.HCITests.HCIPages;

import Base.Common;
import Base.SingletonBrowser;
import HCIPo.HCIPagesPO.HCIContactUsPO;
import lombok.extern.java.Log;
import org.testng.annotations.Test;

@Log
public class HCI_ContactUsTests extends Common {

    @Test(testName = "VerifyContactus")
    public void VerifyContactUs() throws Exception{
        try {
            SingletonBrowser.getInstance().getDriver().get(getProperty("url"));
            HCIContactUsPO.getInstance().enterFirstName(getProperty("firstname"));
            HCIContactUsPO.getInstance().enterLastName(getProperty("lastname"));
            HCIContactUsPO.getInstance().enterEmail(getProperty("email"));
            HCIContactUsPO.getInstance().enterPhoneNumber(getProperty("phoneNumber"));
            HCIContactUsPO.getInstance().enterRandomDrpDwnImA(getProperty("imA"));
            HCIContactUsPO.getInstance().enterInsuranceProvider(getProperty("insuranceProvider"));
            HCIContactUsPO.getInstance().enterQuestionMessage(getProperty("questionMessage"));
            Common.pageScroll();
            HCIContactUsPO.getInstance().enterHearAboutUs(getProperty("hearAboutUs"));
           // HCIContactUsPO.getInstance().clickSubmit();
           // Assert.assertEquals(HCIContactUsPO.getInstance().successfullMsgDisplayed(), "Thank you for your message. It has been sent.");
           // SingletonBrowser.getInstance().getDriver().close();

        }catch (Exception e){
            log.info("Failed : VerifyContactus ");
            throw e;
        }
    }
}
