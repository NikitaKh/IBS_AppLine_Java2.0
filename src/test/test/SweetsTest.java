import com.ibs.appline.task_4.gift_box.Gift;
import org.junit.Assert;
import org.junit.Test;

/**
 * UNIT Tests Gift Project (task_4)
 *
 * @author Nikita Khvalin
 */

public class SweetsTest {

    @Test
    public void test1() {
        Gift present = new Gift();
        Assert.assertEquals("Вес коробки должен быть равен 0", 0.0,
                present.getTotalWeight(), 0);
    }
}
