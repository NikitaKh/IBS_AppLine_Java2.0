import com.ibs.appline.task_5.Calculation;
import com.ibs.appline.task_5.InfixToPostfix;
import org.junit.Assert;
import org.junit.Test;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * UNIT Tests Calculator (task_5)
 *
 * @author Nikita Khvalin
 */

public class CalcTests {

    @Test
    public void infixToPostfixTest() {
        String[] input = {"1", "2", "5", "6", "*", "/", "+", "10", "-"};
        List<String> listForTest = new LinkedList<>();
        Collections.addAll(listForTest, input);
        Assert.assertEquals("Валидный результат: [1, 2, 5, 6, *, /, +, 10, -,]", listForTest,
                InfixToPostfix.convertToPostfix(InfixToPostfix.infixListToArray("1+2/(5*6)-10")));
    }

    @Test
    public void calculationTest() {
        String[] input = {"1", "20", "5", "2", "*", "/", "+", "10", "+"};
        List<String> listForTest = new LinkedList<>();
        Collections.addAll(listForTest, input);
        Assert.assertEquals("Ожидаемый результат 13.0", 13.0,
                Calculation.parsingPostfix(listForTest), 0);
    }

}
