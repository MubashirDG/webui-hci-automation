package HCIPo.HCIPagesPO;

import Base.BasePO;
import Base.Common;
import Base.SingletonBrowser;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

public class HCI_DiagnosisEarlyTreatmentPagePO extends BasePO {

    private static HCI_DiagnosisEarlyTreatmentPagePO hciDiagnosisEarlyTreatmentPagePO;
    private SingletonBrowser singleton = SingletonBrowser.getInstance();
    private By hyperthermiaMainNav = By.xpath("//span[text()='HYPERTHERMIA']");
    private By hyperthermiaChemotherapySubNav = By.xpath("//span[text()='Hyperthermia & Chemotherapy']");
    private HCI_DiagnosisEarlyTreatmentPagePO() {
        super();
    }

    public static final HCI_DiagnosisEarlyTreatmentPagePO getInstance() {
        if (hciDiagnosisEarlyTreatmentPagePO == null) {
            hciDiagnosisEarlyTreatmentPagePO = new HCI_DiagnosisEarlyTreatmentPagePO();
        }
        return hciDiagnosisEarlyTreatmentPagePO;
    }
    public void diagnosisEarlyTreatmentPageLoad()throws Exception{
        try {
            Common.implicitlyWait(70);
        } catch (NoSuchElementException e) {
            throw new Exception("Failed : DiagnosisEarlyTreatmentPageLoad()" + e.getLocalizedMessage());
        }
    }
    public void selectHyperthermiaChemotherapySubNav() throws Exception {
        try {
            hoverOverElement(hyperthermiaMainNav);
            WebElement subNav = singleton.getDriver().findElement(hyperthermiaChemotherapySubNav);
            Common.waitForElementToBeClickable(singleton.getDriver(),subNav ,10);
            subNav.click();
        } catch (NoSuchElementException e) {
            throw new Exception("Failed : selectHyperthermiaChemotherapySubNav()" + e.getLocalizedMessage());
        }
    }
}
