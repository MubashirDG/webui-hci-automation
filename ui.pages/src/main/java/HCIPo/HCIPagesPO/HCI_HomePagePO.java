package HCIPo.HCIPagesPO;

import Base.BasePO;
import Base.Common;
import Base.Log;
import Base.SingletonBrowser;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

public class HCI_HomePagePO extends BasePO {
    private static HCI_HomePagePO hci_HomePagePO;

    private SingletonBrowser singleton = SingletonBrowser.getInstance();
    //private Common singletonClass = Common.getCssValue_H1FontSize();
    private HCI_HomePagePO() {
        super();
    }

    public static final HCI_HomePagePO getInstance() {
        if (hci_HomePagePO == null) {
            hci_HomePagePO = new HCI_HomePagePO();
        }
        return hci_HomePagePO;
    }


    public boolean isCustomerNameDisplayed() throws Exception {
        WebElement customerName = singleton.getDriver().findElement(By.xpath("//div[contains(text(),'Jack Gomez')]"));
        return customerName.isDisplayed();
    }



}
