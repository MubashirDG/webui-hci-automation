package HCIPo.HCIPagesPO;

import Base.BasePO;
import Base.SingletonBrowser;

public class HCI_NavigationBarPO extends BasePO {
    private static HCI_NavigationBarPO hci_NavigationBarPO;

    private SingletonBrowser singleton = SingletonBrowser.getInstance();
    private HCI_NavigationBarPO() {
        super();
    }

    public static final HCI_NavigationBarPO getInstance() {
        if (hci_NavigationBarPO == null) {
            hci_NavigationBarPO = new HCI_NavigationBarPO();
        }
        return hci_NavigationBarPO;
    }
}
