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
    public void verifyHomePageFontSizes() throws Exception{
        try {
            HCI_HomePagePO.getInstance().homePageLoad();
            pageScroll("window.scrollBy(0,200)");
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
    public void verifyHomePagePlayVideo() throws Exception {
        try {
            HCI_HomePagePO.getInstance().playVideo1();
            backToTop();
            Thread.sleep(4000);
        } catch (NoSuchElementException e) {
            throw new Exception("Failed : VerifyHomePagePlayVideo1()" + e.getLocalizedMessage());
        }
    }


    @Test(testName = "verifyRedirectHyperthermiaSubNav")
    public void verifyRedirectHyperthermiaSubNav() throws Exception {
        try {
            HCI_HomePagePO.getInstance().selectHyperthermiaNavBarHyperthermiaSubNav();
        } catch (NoSuchElementException e) {
            throw new Exception("Failed : verifyRedirectHyperthermiaSubNav()" + e.getLocalizedMessage());
        }
    }


}
