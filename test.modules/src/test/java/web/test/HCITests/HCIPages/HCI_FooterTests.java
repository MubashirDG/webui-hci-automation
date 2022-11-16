package web.test.HCITests.HCIPages;

import Base.Common;
import HCIPo.HCIPagesPO.HCI_FooterPO;
import lombok.extern.java.Log;
import org.testng.Assert;
import org.testng.annotations.Test;

@Log
public class HCI_FooterTests extends Common {
    @Test(testName = "VerifyFooterFontSizes")
    public void VerifyFooterFontSizes() throws Exception{
        try {
            Assert.assertEquals(HCI_FooterPO.getInstance().getStayConnectedJoinOurNewsLetterFontSize_18pxH2Footer(), "18px");
        } catch (Exception e){
            log.info("Failed : VerifyFooterFontSizes ");
            throw e;
        }
    }
}
