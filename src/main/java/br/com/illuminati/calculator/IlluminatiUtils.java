package main.java.br.com.illuminati.calculator;

import java.util.List;

public class IlluminatiUtils {

    public String writeNegativeNumberErrorMessage(List<String> negativeNumbers){
        String errorMessage = "Números negativos não são illuminatis: " + String.join(",", negativeNumbers);
        return errorMessage;
    }

}
