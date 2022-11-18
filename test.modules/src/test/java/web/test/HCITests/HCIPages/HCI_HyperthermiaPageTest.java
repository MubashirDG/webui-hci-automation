package web.test.HCITests.HCIPages;

import Base.Common;
import Base.SingletonBrowser;
import HCIPo.HCIPagesPO.HCI_HomePagePO;
import HCIPo.HCIPagesPO.HCI_HyperthermiaPagePO;
import lombok.extern.java.Log;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

@Log
public class HCI_HyperthermiaPageTest extends Common {

    @Test(testName = "verifyHyperthermiaPageFontSizes")
    public void verifyHyperthermiaPageFontSizes() throws Exception{
        try {
            HCI_HyperthermiaPagePO.getInstance().HyperthermiaPageLoad();
            System.out.println("hyperthermiaSubNavUrl");
            pageScroll("window.scrollBy(0,200)");
            Assert.assertEquals(getCssValueFontSize_42pxH1(), "42px");
            Assert.assertEquals(getCssValueFontSizes_35pxH2(), "35px");
            pageScroll("window.scrollBy(0,1200)");
            Assert.assertEquals(getCssValueFontSize_20pxPG(), "20px");
            //Assert.assertEquals(getCssValueFontSize_30pxH2(), "30px");
            pageScroll("window.scrollBy(0,2000)");
            Thread.sleep(3000);
            backToTop();
        } catch (Exception e) {
            log.info("Failed : verifyHyperthermiaPageFontSizes ");
            throw e;
        }
    }
    @Test(testName = "VerifyRedirectDiagnosisEarlyTreatmentSubNav")
    public void verifyRedirectDiagnosisEarlyTreatmentSubNav() throws Exception {
        try {
            HCI_HyperthermiaPagePO.getInstance().selectDiagnosisEarlyTreatmentSubNav();
        } catch (NoSuchElementException e) {
            throw new Exception("Failed : VerifyRedirectDiagnosisEarlyTreatmentSubNav()" + e.getLocalizedMessage());
        }
    }
}
