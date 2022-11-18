package HCIPo.HCIPagesPO;

import Base.BasePO;
import Base.Common;
import Base.SingletonBrowser;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

public class HCI_HyperthermiaPagePO extends BasePO {

    private static HCI_HyperthermiaPagePO hciHyperthermiaPO;
    private SingletonBrowser singleton = SingletonBrowser.getInstance();

    private By hyperthermiaMainNav = By.xpath("//span[text()='HYPERTHERMIA']");
    private By diagnosisEarlyTreatmentSubNav = By.xpath("//span[text()='Diagnosis & Early Treatment']");
    private HCI_HyperthermiaPagePO() {
        super();
    }

    public static final HCI_HyperthermiaPagePO getInstance() {
        if (hciHyperthermiaPO == null) {
            hciHyperthermiaPO = new HCI_HyperthermiaPagePO();
        }
        return hciHyperthermiaPO;
    }

    public void HyperthermiaPageLoad()throws Exception{
        try {
            Common.implicitlyWait(70);
        } catch (NoSuchElementException e) {
            throw new Exception("Failed : HyperthermiaPageLoad()" + e.getLocalizedMessage());
        }
    }

    public void selectDiagnosisEarlyTreatmentSubNav() throws Exception {
        try {
            hoverOverElement(hyperthermiaMainNav);
            WebElement subNav = singleton.getDriver().findElement(diagnosisEarlyTreatmentSubNav);
            Common.waitForElementToBeClickable(singleton.getDriver(),subNav ,10);
            subNav.click();
        } catch (NoSuchElementException e) {
            throw new Exception("Failed : selectHyperthermiaNavBarHyperthermiaSubNav()" + e.getLocalizedMessage());
        }
    }

}
