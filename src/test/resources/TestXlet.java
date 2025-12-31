
import xjavax.tv.xlet.Xlet;
import xjavax.tv.xlet.XletContext;
import xjavax.tv.xlet.XletStateChangeException;
import java.io.File;

public class TestXlet implements Xlet {
    public File file;
    public File[] files;
    public void initXlet(XletContext ctx) throws XletStateChangeException {
        file = new File("test");
        files = new File[] { new File("test1"), new File("test2") };
    }
    public void startXlet() throws XletStateChangeException {
    }
    public void pauseXlet() {
    }
    public void destroyXlet(boolean unconditional) throws XletStateChangeException {
    }
}
