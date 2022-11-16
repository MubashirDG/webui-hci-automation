package web.test.HCITests.HCIPages;

import Base.Common;
import HCIPo.HCIPagesPO.HCI_HomePagePO;
import lombok.extern.java.Log;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.annotations.Test;

@Log
public class HCI_HomePageTests extends Common {

    @Test(testName = "VerifyHomePageFontSizes")
    public void VerifyHomePageFontSizes() throws Exception{
        try {
            HCI_HomePagePO.getInstance().HomePageLoad();
            Assert.assertEquals(getCssValueFontSize_45pxH2(), "45px");
            Assert.assertEquals(getCssValueFontSize_20pxPG(), "20px");
            Assert.assertEquals(getCssValueFontSize_20pxLinkButton(), "20px");
            Assert.assertEquals(getCssValueFontSize_14pxButton(), "14px");
        } catch (Exception e) {
            log.info("Failed : VerifyHomePageFontSizes ");
            throw e;
        }
    }

    @Test(testName = "VerifyHomePagePlayVideo1")
    public void VerifyHomePagePlayVideo() throws Exception {
        try {
            HCI_HomePagePO.getInstance().PlayVideo1();
            backToTop();
        } catch (NoSuchElementException e) {
            throw new Exception("Failed : VerifyHomePagePlayVideo1()" + e.getLocalizedMessage());
        }
    }


}
