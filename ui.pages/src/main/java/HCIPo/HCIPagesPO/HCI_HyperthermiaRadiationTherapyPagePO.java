package HCIPo.HCIPagesPO;

import Base.BasePO;
import Base.Common;
import Base.SingletonBrowser;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

public class HCI_HyperthermiaRadiationTherapyPagePO extends BasePO {

    private static HCI_HyperthermiaRadiationTherapyPagePO hciHyperthermiaRadiationTherapyPagePO;
    private SingletonBrowser singleton = SingletonBrowser.getInstance();
    private By cancersWeTreatMainNav = By.xpath("//span[text()='CANCERS WE TREAT']");
    private By breastSubNav = By.xpath("//span[text()='Breast']");
    private HCI_HyperthermiaRadiationTherapyPagePO() {
        super();
    }

    public static final HCI_HyperthermiaRadiationTherapyPagePO getInstance() {
        if (hciHyperthermiaRadiationTherapyPagePO == null) {
            hciHyperthermiaRadiationTherapyPagePO = new HCI_HyperthermiaRadiationTherapyPagePO();
        }
        return hciHyperthermiaRadiationTherapyPagePO;
    }

    public void hciHyperthermiaRadiationTherapyPageLoad()throws Exception{
        try {
            Common.implicitlyWait(70);
        } catch (NoSuchElementException e) {
            throw new Exception("Failed : hciHyperthermiaChemotherapyPageLoad()" + e.getLocalizedMessage());
        }
    }
    public void selectCancersWeTreatBreastSubNav() throws Exception {
        try {
            hoverOverElement(cancersWeTreatMainNav);
            WebElement subNav = singleton.getDriver().findElement(breastSubNav);
            Common.waitForElementToBeClickable(singleton.getDriver(),subNav ,10);
            subNav.click();
        } catch (NoSuchElementException e) {
            throw new Exception("Failed : selectHyperthermiaRadiationTherapySubNav()" + e.getLocalizedMessage());
        }
    }
}
