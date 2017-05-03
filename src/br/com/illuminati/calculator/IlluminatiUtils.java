package br.com.illuminati.calculator;

public class IlluminatiUtils {

    public String writeNegativeNumberErrorMessage(String[] numbers){
        String errorMessage = "Números negativos não são illuminatis: ";

        for(String number: numbers){
            if(number.contains("-")){
                errorMessage += number;
            }
        }

        return errorMessage;
    }

}
