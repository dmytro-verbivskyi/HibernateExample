import junit.framework.Assert;
import org.junit.Test;

public class HelloTest {

    @Test
    public void HelloTest() {
        Hello h = new Hello();
        Assert.assertNotNull(h.toString());
        Assert.assertEquals(h.toString(), new Hello().toString());
    }
}
