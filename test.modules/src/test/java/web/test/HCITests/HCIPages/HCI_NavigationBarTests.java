package web.test.HCITests.HCIPages;

import Base.Common;
import Base.SingletonBrowser;
import lombok.extern.java.Log;
import org.testng.Assert;
import org.testng.annotations.Test;

@Log
public class HCI_NavigationBarTests extends Common {

    @Test(testName = "VerifyNavigationBarFontSizes")
    public void VerifyNavigationBarFontSizes() throws Exception{
        try {
            SingletonBrowser.getInstance().getDriver().get(getProperty("homepageUrl"));
            implicitlyWait(2700);
            Assert.assertEquals(getCssValueFontSize_14pxNavBar(), "14px");
            pageScroll("window.scrollBy(0,3200)");

        } catch (Exception e){
            log.info("Failed : VerifyNavigationBarFontSizes ");
            throw e;
        }
    }
}
