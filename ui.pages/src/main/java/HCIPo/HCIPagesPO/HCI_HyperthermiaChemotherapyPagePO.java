package HCIPo.HCIPagesPO;

import Base.BasePO;
import Base.Common;
import Base.SingletonBrowser;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

public class HCI_HyperthermiaChemotherapyPagePO extends BasePO {
    private static HCI_HyperthermiaChemotherapyPagePO hciHyperthermiaChemotherapyPagePO;
    private SingletonBrowser singleton = SingletonBrowser.getInstance();
    private By hyperthermiaMainNav = By.xpath("//span[text()='HYPERTHERMIA']");
    private By hyperthermiaRadiationTherapySubNav = By.xpath("//span[text()='Hyperthermia & Radiation Therapy']");
    private HCI_HyperthermiaChemotherapyPagePO() {
        super();
    }

    public static final HCI_HyperthermiaChemotherapyPagePO getInstance() {
        if (hciHyperthermiaChemotherapyPagePO == null) {
            hciHyperthermiaChemotherapyPagePO = new HCI_HyperthermiaChemotherapyPagePO();
        }
        return hciHyperthermiaChemotherapyPagePO;
    }

    public void hciHyperthermiaChemotherapyPageLoad()throws Exception{
        try {
            Common.implicitlyWait(70);
        } catch (NoSuchElementException e) {
            throw new Exception("Failed : hciHyperthermiaChemotherapyPageLoad()" + e.getLocalizedMessage());
        }
    }
    public void selectHyperthermiaRadiationTherapySubNav() throws Exception {
        try {
            hoverOverElement(hyperthermiaMainNav);
            WebElement subNav = singleton.getDriver().findElement(hyperthermiaRadiationTherapySubNav);
            Common.waitForElementToBeClickable(singleton.getDriver(),subNav ,10);
            subNav.click();
        } catch (NoSuchElementException e) {
            throw new Exception("Failed : selectHyperthermiaRadiationTherapySubNav()" + e.getLocalizedMessage());
        }
    }
}
