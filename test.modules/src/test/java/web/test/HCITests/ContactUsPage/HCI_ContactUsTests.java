package web.test.HCITests.ContactUsPage;

import Base.SingletonBrowser;
import HCIPo.HCIContactUsPage.HCIContactUsPO;
import lombok.extern.java.Log;
import org.testng.annotations.Test;
import Base.Common;

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
            HCIContactUsPO.getInstance().enterDrpDwnImA("imA");
            HCIContactUsPO.getInstance().enterInsuranceProvider(getProperty("insuranceProvider"));
            HCIContactUsPO.getInstance().enterQuestionMessage(getProperty("questionMessage"));
            HCIContactUsPO.getInstance().enterHearAboutUs(getProperty("hearAboutUs"));
            //HCIContactUsPO.getInstance().clickSubmit();
            //Assert.assertTrue(HCIContactUsPO.getInstance().isSuccessfullMsgDisplayed(), "Thank you for your message. It has been sent.");
            //SingletonBrowser.getInstance().getDriver().close();

        }catch (Exception e){
            log.info("Failed : VerifyContactus ");
            throw e;
        }
    }

}
