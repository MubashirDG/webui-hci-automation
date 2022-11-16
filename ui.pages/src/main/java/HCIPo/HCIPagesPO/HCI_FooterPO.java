package HCIPo.HCIPagesPO;

import Base.BasePO;
import Base.SingletonBrowser;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

public class HCI_FooterPO extends BasePO {
    private static HCI_FooterPO hci_FooterPO;

    private SingletonBrowser singleton = SingletonBrowser.getInstance();
    private String cssStayConnectedJoinOurNewsLetterFontSizes18pxH2Footer = "//fontsninja-text[@id='fontsninja-text-787']";
    private String cssJoinOurNewsletterFontSizes18pxFooter = "";
    private HCI_FooterPO() {
        super();
    }

    public static final HCI_FooterPO getInstance() {
        if (hci_FooterPO == null) {
            hci_FooterPO = new HCI_FooterPO();
        }
        return hci_FooterPO;
    }

    public String getStayConnectedJoinOurNewsLetterFontSize_18pxH2Footer() throws Exception {
        try{
            String fontSizes18pxH2Footer = singleton.getDriver().findElement(By.xpath(cssStayConnectedJoinOurNewsLetterFontSizes18pxH2Footer)).getCssValue("font-size");
            System.out.println("StayConnectedJoinOurNewsLetterFontSizes_18pxFooter font-size :" + fontSizes18pxH2Footer);
            return fontSizes18pxH2Footer;
        } catch (NoSuchElementException e) {
            throw new Exception("Failed : getStayConnectedJoinOurNewsLetterFontSize_18pxH2Footer()" + e.getLocalizedMessage());
        }
    }

    public String getJoinOurNewsletterFontSize_18pxFooter() throws Exception {
        try{
            String fontSizes14pxNavBar = singleton.getDriver().findElement(By.xpath(cssJoinOurNewsletterFontSizes18pxFooter)).getCssValue("font-size");
            System.out.println("JoinOurNewsletterFontSize_18pxFooter font-size :" + fontSizes14pxNavBar);
            return fontSizes14pxNavBar;
        } catch (NoSuchElementException e) {
            throw new Exception("Failed : getStayConnectedFontSize_18pxFooter()" + e.getLocalizedMessage());
    }
    }
}
