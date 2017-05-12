import main.java.br.com.illuminati.calculator.IlluminatiCalculator;
import main.java.br.com.illuminati.calculator.IlluminatiUtils;
import main.java.br.com.illuminati.calculator.InputTransformer;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class IlluminatiCalculatorTest {

    private InputTransformer inputTransformer = new InputTransformer();
    private IlluminatiUtils illuminatiUtils = new IlluminatiUtils();

    private IlluminatiCalculator illuminatiCalculator = new IlluminatiCalculator(inputTransformer, illuminatiUtils);

    private final static String SPACE = " ";
    private final static char ILLUMINATI_CHARACTER = '▲';

    //Fazer as variaveis de String e int que usamos embaixo(?)
    private String firstNumber = "1", secondNumber = "2", thirdNumber = "100";
    private String positiveNumber = "10", negativeNumber = "-1";
    private int result;

    @Test
    public void ifReceivesAnEmptyStringReturns0(){
        assertThat(illuminatiCalculator.add(""), equalTo(0));
    }

    @Test
    public void ifNullStringReturns0(){
        assertThat(illuminatiCalculator.add(null), equalTo(0));
    }

    @Test
    public void ifReceivesAStringWithSpacesOnlyReturns0(){
        assertThat(illuminatiCalculator.add("    "), equalTo(0));
    }

    @Test
    public void ifReceivesOneNumberReturnsIt(){
        assertThat(illuminatiCalculator.add("2"), equalTo(2));
    }

    @Test
    public void ifNumbersSeparatedBySpaceAreGivenItReturnsTheCorrectSum() {
        result = illuminatiCalculator.add(positiveNumber + SPACE + negativeNumber);
        assertThat(result, equalTo(9));
    }

    //Exemplo de como testar se deu throw na exception
    @Test(expected=IndexOutOfBoundsException.class)
    public void testIndexOutOfBoundsException() {
        ArrayList emptyList = new ArrayList();
        Object o = emptyList.get(0);
    }

    @Test
    public void ifIlluminatiSymbolIsPresentReturnsTheFinalResultMultipliedByIlluminatiOccurrenceNumber(){
        thirdNumber = "3";
        result = illuminatiCalculator.add(firstNumber + SPACE + secondNumber + SPACE + thirdNumber + ILLUMINATI_CHARACTER + ILLUMINATI_CHARACTER);
        assertThat(result, equalTo(36));
    }

    @Test
    public void ifNegativeNumberIsPresentShowsAMessageAndTheNegativeNumbers(){
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        secondNumber = "-2";
        illuminatiCalculator.add(firstNumber + SPACE + secondNumber);
        String expectedOutput  = "Números negativos não são illuminatis: -2\n";

        assertThat(outContent.toString(), equalTo(expectedOutput));

    }

    @Test
    public void ifNumberGreaterThanIlluminatiCreationYearIsPresentIgnoreIt(){
        thirdNumber = "1777";
        result = illuminatiCalculator.add(firstNumber + SPACE + secondNumber + SPACE + thirdNumber);
        assertThat(result, equalTo(3));
    }

}
