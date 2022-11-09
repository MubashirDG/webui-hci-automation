package web.test.HCITests.HCIPages;

import Base.Common;
import Base.SingletonBrowser;
import lombok.extern.java.Log;
import org.testng.Assert;
import org.testng.annotations.Test;

@Log
public class HCI_HomePageTests extends Common {

    @Test(testName = "VerifyHomePageFontSizes")
    public void VerifyHomePageFontSizes() throws Exception{
        try {
            SingletonBrowser.getInstance().getDriver().get(getProperty("homepageUrl"));
            Assert.assertEquals(Common.getCssValueFontSize_45pxH2(), "45px");
            Assert.assertEquals(Common.getCssValueFontSize_20pxPG(), "20px");
            Assert.assertEquals(Common.getCssValueFontSize_20pxLinkButton(), "20px");
            Assert.assertEquals(Common.getCssValueFontSize_14pxNavBar(), "14px");
            Assert.assertEquals(Common.getCssValueFontSize_14pxButton(), "14px");

            SingletonBrowser.getInstance().getDriver().close();
        }catch (Exception e){
            log.info("Failed : VerifyHomePageFontSizes ");
            throw e;
        }
    }

    @Test(testName = "VerifyHomePageToContactUsPageNavigation")
    public void contactUsPageNavigation() throws Exception{
        try {
            pageNavigation("contactusUrl");
            //pageNavigation("https://hcioncology.com/contact-us/");
        }catch (Exception e){
            log.info("Failed : VerifyHomePageToContactUsPageNavigation");
            throw e;
        }
    }

    @Test(testName = "VerifyHomePageVideo1")
    public void VerifyHomePageVideo1() throws Exception{

    }


}
