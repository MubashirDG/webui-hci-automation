package web.test.HCITests.HCIPages;

import Base.Common;
import Base.SingletonBrowser;
import HCIPo.HCIPagesPO.HCI_ContactUsPagePO;
import HCIPo.HCIPagesPO.HCI_FooterPO;
import lombok.extern.java.Log;
import org.testng.Assert;
import org.testng.annotations.Test;

@Log
public class HCI_FooterTests extends Common {
    @Test(testName = "VerifyFooterFontSizes")
    public void VerifyFooterFontSizes() throws Exception{
        try {
            //SingletonBrowser.getInstance().getDriver().get(getProperty("homepageUrl"));
            Assert.assertEquals(HCI_FooterPO.getInstance().getstayConnectedFontSize_18pxFooter(), "18px");
            Assert.assertEquals(HCI_FooterPO.getInstance().getJoinOurNewsletterFontSize_18pxFooter(), "18px");
            //SingletonBrowser.getInstance().getDriver().close();
        }catch (Exception e){
            log.info("Failed : VerifyFooterFontSizes ");
            throw e;
        }
    }
}
