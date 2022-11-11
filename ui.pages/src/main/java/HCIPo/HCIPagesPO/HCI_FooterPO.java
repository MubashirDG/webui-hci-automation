package HCIPo.HCIPagesPO;

import Base.BasePO;
import Base.SingletonBrowser;
import org.openqa.selenium.By;

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

    public String getstayConnectedFontSize_18pxFooter() throws Exception {
        //waitForLoad(15000);
        String fontSizes14pxNavBar = singleton.getDriver().findElement(By.xpath(cssStayConnectedFontSizes18pxFooter)).getCssValue("font-size");
        System.out.println("StayConnectedFontSize_18pxFooter font-size :" + fontSizes14pxNavBar);
        return fontSizes14pxNavBar;
    }

    public String getJoinOurNewsletterFontSize_18pxFooter() throws Exception {
        //waitForLoad(15000);
        String fontSizes14pxNavBar = SingletonBrowser.getInstance().getDriver().findElement(By.xpath(cssJoinOurNewsletterFontSizes18pxFooter)).getCssValue("font-size");
        System.out.println("JoinOurNewsletterFontSize_18pxFooter font-size :" + fontSizes14pxNavBar);
        return fontSizes14pxNavBar;
    }
}
