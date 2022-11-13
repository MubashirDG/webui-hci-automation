package HCIPo.HCIPagesPO;

import Base.BasePO;
import Base.SingletonBrowser;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

public class HCI_FooterPO extends BasePO {
    private static HCI_FooterPO hci_FooterPO;

    private SingletonBrowser singleton = SingletonBrowser.getInstance();
    private String cssStayConnectedFontSizes18pxFooter = "//fontsninja-text[@id='fontsninja-text-381']";
    private String cssJoinOurNewsletterFontSizes18pxFooter = "//fontsninja-text[@id='fontsninja-text-417']";
    private HCI_FooterPO() {
        super();
    }

    public static final HCI_FooterPO getInstance() {
        if (hci_FooterPO == null) {
            hci_FooterPO = new HCI_FooterPO();
        }
        return hci_FooterPO;
    }

    public String getStayConnectedFontSize_18pxFooter() throws Exception {
        try{
            String fontSizes14pxNavBar = singleton.getDriver().findElement(By.xpath(cssStayConnectedFontSizes18pxFooter)).getCssValue("font-size");
            System.out.println("StayConnectedFontSize_18pxFooter font-size :" + fontSizes14pxNavBar);
            return fontSizes14pxNavBar;
        } catch (NoSuchElementException e) {
            throw new Exception("Failed : clickSubmit()" + e.getLocalizedMessage());
        }
    }

    public String getJoinOurNewsletterFontSize_18pxFooter() throws Exception {
        try{
            String fontSizes14pxNavBar = singleton.getDriver().findElement(By.xpath(cssJoinOurNewsletterFontSizes18pxFooter)).getCssValue("font-size");
            System.out.println("JoinOurNewsletterFontSize_18pxFooter font-size :" + fontSizes14pxNavBar);
            return fontSizes14pxNavBar;
        } catch (NoSuchElementException e) {
            throw new Exception("Failed : clickSubmit()" + e.getLocalizedMessage());
    }
    }
}
