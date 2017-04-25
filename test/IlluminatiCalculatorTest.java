
import br.com.illuminati.calculator.IlluminatiCalculator;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class IlluminatiCalculatorTest {

    private IlluminatiCalculator illuminatiCalculator = new IlluminatiCalculator();
    private final static String SPACE = " ";
    private final static char ILLUMINATI_CHARACTER = '▲';
    //Fazer as variaveis de String e int que usamos embaixo(?)

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
        int firstResult = illuminatiCalculator.add(firstNumber + SPACE + secondNumber);
        assertThat(firstResult, equalTo(3));

        int secondResult = illuminatiCalculator.add(firstNumber + SPACE + secondNumber + SPACE + thirdNumber);
        assertThat(secondResult, equalTo(103));
    }

    @Test
    public void ifIlluminatiSymbolIsPresentReturnsTheFinalResultMultipliedByIlluminatiOccurrenceNumber(){
        String firstNumber = "1", secondNumber = "2", thirdNumber = "3";
        int firstResult = illuminatiCalculator.add(firstNumber + SPACE + secondNumber + SPACE + thirdNumber + ILLUMINATI_CHARACTER);
        assertThat(firstResult, equalTo(18));
        int secondResult = illuminatiCalculator.add(firstNumber + SPACE + secondNumber + SPACE + thirdNumber + ILLUMINATI_CHARACTER + ILLUMINATI_CHARACTER);
        assertThat(secondResult, equalTo(54));
    }

    @Test
    public void ifNegativeNumberIsPresentShowsAMessageAndTheNegativeNumbers(){
        String firstNumber = "1", secondNumber = "-2";
        int result = illuminatiCalculator.add(firstNumber + SPACE + secondNumber);
        assertThat(result, equalTo(-1));
    }
}