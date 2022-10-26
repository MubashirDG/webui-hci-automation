package HCIPo.HCIHomePage;

import Base.BasePO;
import Base.SingletonBrowser;

public class HCIHomePagePo extends BasePO {
    private static HCIHomePagePo abcHomePagePo;
    private SingletonBrowser singleton = SingletonBrowser.getInstance();

    private HCIHomePagePo() {
        super();
    }

    public static final HCIHomePagePo getInstance() {
        if (abcHomePagePo == null) {
            abcHomePagePo = new HCIHomePagePo();
        }
        return abcHomePagePo;
    }

}
