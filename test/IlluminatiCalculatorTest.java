
import br.com.illuminati.calculator.IlluminatiCalculator;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class IlluminatiCalculatorTest {

    private IlluminatiCalculator illuminatiCalculator = new IlluminatiCalculator();
    private final static String SPACE = " ";

    @Test
    public void ifReceivesAnEmptyStringReturns0(){
        assertThat(illuminatiCalculator.add(""), equalTo(0));
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
        String firstNumber = "1", secondNumber = "2", thirdNumber = "100";
        assertThat(illuminatiCalculator.add(firstNumber + SPACE + secondNumber), equalTo(3));
        assertThat(illuminatiCalculator.add(firstNumber + SPACE + secondNumber + SPACE + thirdNumber), equalTo(103));
    }

    @Test
    public void ifIlluminatiSymbolIsPresentReturnsTheFinalResultMultipliedByIlluminatiOccurrenceNumber(){
        String firstNumber = "1", secondNumber = "2", thirdNumber = "3", illuminatiSymbol = "▲";
        assertThat(illuminatiCalculator.add(firstNumber + SPACE + secondNumber + SPACE + thirdNumber + illuminatiSymbol), equalTo(18));
    }
}