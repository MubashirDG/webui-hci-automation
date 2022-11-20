package web.test.HCITests.HCIPages;

import Base.Common;
import HCIPo.HCIPagesPO.HCI_BreastCancerPagePO;
import HCIPo.HCIPagesPO.HCI_DiagnosisEarlyTreatmentPagePO;
import HCIPo.HCIPagesPO.HCI_HyperthermiaChemotherapyPagePO;
import HCIPo.HCIPagesPO.HCI_WhatToExpectPagePO;
import lombok.extern.java.Log;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.annotations.Test;

@Log
public class HCI_BreastCancerPageTests extends Common {

    @Test(testName = "verifyBreastCancerPageFontSizes")
    public void verifyBreastCancerPageFontSizes() throws Exception{
        try {
            HCI_BreastCancerPagePO.getInstance().hciBreastCancerPageLoad();
            System.out.println(getProperty("cancerWeTreatBreastCancerSubNavUrl"));
            pageScroll("window.scrollBy(0,200)");
            Assert.assertEquals(getCssValueFontSize_42pxH1(), "42px");
            Assert.assertEquals(getCssValueFontSizes_35pxH2(), "35px");
            pageScroll("window.scrollBy(0,1950)");
            Assert.assertEquals(getCssValueFontSize_20pxPG(), "20px");
            Thread.sleep(3000);
        } catch (Exception e) {
            log.info("Failed : verifyBreastCancerPageFontSizes");
            throw e;
        }
    }

    @Test(testName = "verifyBreastCancerPlayVideo")
    public void verifyBreastCancerPlayVideo() throws Exception {
        try {
            HCI_BreastCancerPagePO.getInstance().playVideoBreastCancer();
            Common.pageScroll("window.scrollBy(0,3000)");
            Thread.sleep(1500);
            backToTop();
        } catch (NoSuchElementException e) {
            throw new Exception("Failed : verifyBreastCancerPlayVideo()" + e.getLocalizedMessage());
        }
    }

    @Test(testName = "verifyRedirectCancersWeTreatColonRectalSubNav")
    public void verifyRedirectCancersWeTreatColonRectalSubNav() throws Exception {
        try {
            HCI_BreastCancerPagePO.getInstance().selectCancersWeTreatColonRectalSubNav();
        } catch (NoSuchElementException e) {
            throw new Exception("Failed : verifyRedirectCancersWeTreatColonRectalSubNav()" + e.getLocalizedMessage());
        }
    }
}