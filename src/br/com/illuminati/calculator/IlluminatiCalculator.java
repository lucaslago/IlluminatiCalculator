package br.com.illuminati.calculator;

import org.apache.commons.lang3.StringUtils;

public class IlluminatiCalculator {

    private final static char ILLUMINATI_CHARACTER = '▲';
    private final static int ILLUMINATI_MULTIPLIER = 3;

    private InputTransformer inputTransformer;

    public IlluminatiCalculator(InputTransformer inputTransformer){
        this.inputTransformer = inputTransformer;
    }

    public int add(String input) {
        if(StringUtils.isBlank(input)){
            return 0;

        } else {
            int illuminatiOccurrences = countIlluminatiOccurrences(input);

            String inputWithoutIlluminatiSymbol = inputTransformer.removeIlluminatiSymbol(input);

            String numbers[] = inputWithoutIlluminatiSymbol.split(" ");
            int result = 0;

            try {
                result = parseInput(numbers);

            } catch (NegativeNumberException e){
                System.out.println(e.getMessage());
            }

            if(illuminatiOccurrences > 0){
                result = multiplyTotalResultByIlluminatiOccurrenceNumber(illuminatiOccurrences, result);
            }

            return result;
        }
    }

    private int parseInput(String[] numbers) throws NegativeNumberException {
        int result = 0;

        for (String number: numbers){
            int parsedNumber = Integer.parseInt(number);

            if(isANegativeNumber(parsedNumber)){
                throw new NegativeNumberException(writeNegativeNumberErrorMessage(numbers));
            }

            result += parsedNumber;
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
        for(int cont = 0; cont < illuminatiOccurrences; cont++){
            totalResult = totalResult * ILLUMINATI_MULTIPLIER;
        }
        return totalResult;
    }


}
