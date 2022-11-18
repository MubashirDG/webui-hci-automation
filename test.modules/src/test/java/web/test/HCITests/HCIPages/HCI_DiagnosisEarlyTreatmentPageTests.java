package web.test.HCITests.HCIPages;

import Base.Common;
import Base.SingletonBrowser;
import HCIPo.HCIPagesPO.HCI_DiagnosisEarlyTreatmentPagePO;
import HCIPo.HCIPagesPO.HCI_HyperthermiaPagePO;
import lombok.extern.java.Log;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.annotations.Test;

@Log
public class HCI_DiagnosisEarlyTreatmentPageTests extends Common {

    @Test(testName = "verifyHyperthermiaPageFontSizes")
    public void verifyDiagnosisEarlyTreatmentPageFontSizes() throws Exception{
        try {
            HCI_DiagnosisEarlyTreatmentPagePO.getInstance().DiagnosisEarlyTreatmentPageLoad();
            System.out.println(getProperty("diagnosisEarlyTreatmentSubNavUrl"));
            pageScroll("window.scrollBy(0,200)");
            Assert.assertEquals(getCssValueFontSize_42pxH1(), "42px");
            Assert.assertEquals(getCssValueFontSizes_35pxH2(), "35px");
            pageScroll("window.scrollBy(0,500)");
            Assert.assertEquals(getCssValueFontSize_20pxPG(), "20px");
            // Assert.assertEquals(getCssValueFontSize_30pxH2(), "30px");
            pageScroll("window.scrollBy(0,1000)");
            Thread.sleep(3000);
            backToTop();
        } catch (Exception e) {
            log.info("Failed : verifyHyperthermiaPageFontSizes ");
            throw e;
        }
    }
    @Test(testName = "VerifyRedirectHyperthermiaChemotherapySubNav")
    public void verifyRedirectHyperthermiaChemotherapySubNav() throws Exception {
        try {
            HCI_DiagnosisEarlyTreatmentPagePO.getInstance().selectHyperthermiaChemotherapySubNav();
        } catch (NoSuchElementException e) {
            throw new Exception("Failed : verifyRedirectHyperthermiaChemotherapySubNav()" + e.getLocalizedMessage());
        }
    }
}
