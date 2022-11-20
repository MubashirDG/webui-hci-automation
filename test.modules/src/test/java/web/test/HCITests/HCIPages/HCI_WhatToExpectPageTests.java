package web.test.HCITests.HCIPages;

import Base.Common;
import HCIPo.HCIPagesPO.HCI_HomePagePO;
import HCIPo.HCIPagesPO.HCI_HyperthermiaRadiationTherapyPagePO;
import HCIPo.HCIPagesPO.HCI_WhatToExpectPagePO;
import lombok.extern.java.Log;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.annotations.Test;

@Log
public class HCI_WhatToExpectPageTests extends Common {

    @Test(testName = "verifyWhatToExpectPageFontSizes")
    public void verifyWhatToExpectPageFontSizes() throws Exception{
        try {
            HCI_WhatToExpectPagePO.getInstance().hciWhatToExpectPagePageLoad();
            //System.out.println(getProperty("hyperthermiaRadiationTherapySubNavUrl"));
            pageScroll("window.scrollBy(0,200)");
            Assert.assertEquals(getCssValueFontSize_42pxH1(), "42px");
            Assert.assertEquals(getCssValueFontSizes_35pxH2(), "35px");
            pageScroll("window.scrollBy(0,1000)");
            Assert.assertEquals(getCssValueFontSize_20pxPG(), "20px");
            Thread.sleep(3000);
        } catch (Exception e) {
            log.info("Failed : VerifyHyperthermiaRadiationTherapyPageFontSizes");
            throw e;
        }
    }
    @Test(testName = "verifyWhatToExpectPlayVideo")
    public void verifyWhatToExpectPlayVideo() throws Exception {
        try {
            HCI_WhatToExpectPagePO.getInstance().playVideo2();
            Thread.sleep(1500);
            backToTop();
        } catch (NoSuchElementException e) {
            throw new Exception("Failed : verifyWhatToExpectPlayVideo()" + e.getLocalizedMessage());
        }
    }
    @Test(testName = "verifyRedirectPlanYourVisitSubNav")
    public void verifyRedirectPlanYourVisitSubNav() throws Exception {
        try {
            HCI_WhatToExpectPagePO.getInstance().selectPlanYourVisitSubNav();
        } catch (NoSuchElementException e) {
            throw new Exception("Failed : verifyRedirectPlanYourVisitSubNav()" + e.getLocalizedMessage());
        }
    }
}
