package web.test.HCITests.HCIPages;

import Base.Common;
import HCIPo.HCIPagesPO.HCI_DiagnosisEarlyTreatmentPagePO;
import HCIPo.HCIPagesPO.HCI_HyperthermiaChemotherapyPagePO;
import lombok.extern.java.Log;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.annotations.Test;

@Log
public class HCI_HyperthermiaChemotherapyPageTests extends Common {

    @Test(testName = "verifyHyperthermiaPageFontSizes")
    public void verifyHyperthermiaChemotherapyPageFontSizes() throws Exception{
        try {
            HCI_HyperthermiaChemotherapyPagePO.getInstance().hciHyperthermiaChemotherapyPageLoad();
            System.out.println(getProperty("hyperthermiaChemotherapySubNavUrl"));
            pageScroll("window.scrollBy(0,200)");
            Assert.assertEquals(getCssValueFontSize_42pxH1(), "42px");
            Assert.assertEquals(getCssValueFontSizes_35pxH2(), "35px");
            pageScroll("window.scrollBy(0,1000)");
            Assert.assertEquals(getCssValueFontSize_20pxPG(), "20px");
            pageScroll("window.scrollBy(0,2000)");
            Thread.sleep(3000);
            backToTop();
        } catch (Exception e) {
            log.info("Failed : verifyHyperthermiaChemotherapyPageFontSizes");
            throw e;
        }
    }
    @Test(testName = "VerifyRedirectHyperthermiaRadiationTherapySubNav")
    public void verifyRedirectHyperthermiaRadiationTherapySubNav() throws Exception {
        try {
            HCI_HyperthermiaChemotherapyPagePO.getInstance().selectHyperthermiaRadiationTherapySubNav();
        } catch (NoSuchElementException e) {
            throw new Exception("Failed : verifyRedirectHyperthermiaRadiationTherapySubNav()" + e.getLocalizedMessage());
        }
    }
}
