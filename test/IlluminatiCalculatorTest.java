
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class IlluminatiCalculatorTest {

    IlluminatiCalculator illuminatiCalculator = new IlluminatiCalculator();

    @Test
    public void ifReceivesAnEmptyStringReturns0(){
        assertThat(illuminatiCalculator.add(""), equalTo(0));
    }
}