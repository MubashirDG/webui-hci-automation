package HCIPo.HCIPagesPO;

import Base.Common;
import Base.SingletonBrowser;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

public class HCI_HyperthermiaPagePO {

    private static HCI_HyperthermiaPagePO hciHyperthermiaPO;
    private SingletonBrowser singleton = SingletonBrowser.getInstance();


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
}
