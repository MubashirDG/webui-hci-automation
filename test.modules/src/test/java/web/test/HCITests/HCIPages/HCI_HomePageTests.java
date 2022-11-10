package web.test.HCITests.HCIPages;

import Base.Common;
import Base.SingletonBrowser;
import HCIPo.HCIPagesPO.HCI_ContactUsPagePO;
import HCIPo.HCIPagesPO.HCI_HomePagePO;
import lombok.extern.java.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

@Log
public class HCI_HomePageTests extends Common {

    @Test(testName = "VerifyHomePageFontSizes")
    public void VerifyHomePageFontSizes() throws Exception{
        try {
            //SingletonBrowser.getInstance().getDriver().get(getProperty("homepageUrl"));
            Assert.assertEquals(getCssValueFontSize_45pxH2(), "45px");
            Assert.assertEquals(getCssValueFontSize_20pxPG(), "20px");
            Assert.assertEquals(getCssValueFontSize_20pxLinkButton(), "20px");
            Assert.assertEquals(getCssValueFontSize_14pxButton(), "14px");

            //SingletonBrowser.getInstance().getDriver().close();
        }catch (Exception e){
            log.info("Failed : VerifyHomePageFontSizes ");
            throw e;
        }
    }

    @Test(testName = "VerifyHomePageToContactUsPageNavigation")
    public void ContactUsPageNavigation() throws Exception{
        try {
            //HCI_HomePagePO.getInstance().ClickContactUsPageNavigation();
        } catch (NoSuchElementException e) {
            throw new Exception("Failed : clickContactUsPageNavigation()" + e.getLocalizedMessage());
        }
    }


}
