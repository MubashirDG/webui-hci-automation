package web.test.HCITests.HCIPages;

import Base.Common;
import HCIPo.HCIPagesPO.HCI_HyperthermiaChemotherapyPagePO;
import HCIPo.HCIPagesPO.HCI_HyperthermiaRadiationTherapyPagePO;
import lombok.extern.java.Log;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.annotations.Test;

@Log
public class HCI_HyperthermiaRadiationTherapyPageTests extends Common {

    @Test(testName = "VerifyHyperthermiaRadiationTherapyPageFontSizes")
    public void verifyHyperthermiaRadiationTherapyPageFontSizes() throws Exception{
        try {
            HCI_HyperthermiaRadiationTherapyPagePO.getInstance().hciHyperthermiaRadiationTherapyPageLoad();
            System.out.println(getProperty("hyperthermiaRadiationTherapySubNavUrl"));
            pageScroll("window.scrollBy(0,200)");
            Assert.assertEquals(getCssValueFontSize_42pxH1(), "42px");
            Assert.assertEquals(getCssValueFontSizes_35pxH2(), "35px");
            pageScroll("window.scrollBy(0,1000)");
            Assert.assertEquals(getCssValueFontSize_20pxPG(), "20px");
            pageScroll("window.scrollBy(0,2000)");
            Thread.sleep(1500);
            backToTop();
        } catch (Exception e) {
            log.info("Failed : VerifyHyperthermiaRadiationTherapyPageFontSizes");
            throw e;
        }
    }
    @Test(testName = "VerifyRedirectCancersWeTreatBreastSubNav")
    public void verifyRedirectCancersWeTreatBreastSubNav() throws Exception {
        try {
            HCI_HyperthermiaRadiationTherapyPagePO.getInstance().selectCancersWeTreatBreastSubNav();
        } catch (NoSuchElementException e) {
            throw new Exception("Failed : verifyRedirectCancersWeTreatBreastSubNav()" + e.getLocalizedMessage());
        }
    }
}
