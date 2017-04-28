package br.com.illuminati.calculator;

import org.apache.commons.lang3.StringUtils;

public class IlluminatiCalculator {

    private final static char ILLUMINATI_CHARACTER = '▲';
    private final static int ILLUMINATI_MULTIPLIER = 3;
    private final static int ILLUMINATI_CREATION_YEAR = 1776;

    private InputTransformer inputTransformer;

    public IlluminatiCalculator(InputTransformer inputTransformer){
        this.inputTransformer = inputTransformer;
    }

    public int add(String input) {
        if(StringUtils.isBlank(input)){
            return 0;

        } else {
            int illuminatiOccurrences = countIlluminatiOccurrences(input);

            String numbers[] = inputTransformer.transformInput(input);

            int result = 0;

            try {
                result = calculateResult(numbers, illuminatiOccurrences);

            } catch (NegativeNumberException e){
                System.out.println(e.getMessage());

            }

            return result;
        }
    }

    private int calculateResult(String[] numbers, int illuminatiOccurrences) throws NegativeNumberException {
        int result = 0;

        for (String number: numbers){
            int parsedNumber = Integer.parseInt(number);

            if(isANegativeNumber(parsedNumber)) {
                throw new NegativeNumberException(writeNegativeNumberErrorMessage(numbers));
            }

            if(!isGreaterThanIlluminatiCreationYear(parsedNumber)){
                result += parsedNumber;
            }
        }

        if(illuminatiOccurrences > 0){
            result = multiplyTotalResultByIlluminatiOccurrenceNumber(illuminatiOccurrences, result);
        }

        return result;
    }

    private String writeNegativeNumberErrorMessage(String[] numbers){
        String errorMessage = "Números negativos não são illuminatis: ";

        for(String number: numbers){
            if(number.contains("-")){
                errorMessage += number;
            }
        }

        return errorMessage;
    }


    private boolean isANegativeNumber(int number){
        return number < 0;
    }

    private boolean isGreaterThanIlluminatiCreationYear(int number){
        return number > ILLUMINATI_CREATION_YEAR;
    }


    private int countIlluminatiOccurrences(String input){
        int illuminatiOccurrences = 0;

        for(int cont = 0; cont < input.length(); cont++){
            if((input.charAt(cont)) == ILLUMINATI_CHARACTER){
                illuminatiOccurrences ++;
            }
        }
        return illuminatiOccurrences;
    }

    private int multiplyTotalResultByIlluminatiOccurrenceNumber(int illuminatiOccurrences, int totalResult){
        return totalResult * (illuminatiOccurrences * ILLUMINATI_MULTIPLIER);
    }


}
