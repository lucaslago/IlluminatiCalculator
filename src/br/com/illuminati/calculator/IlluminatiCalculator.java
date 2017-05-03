package br.com.illuminati.calculator;

import org.apache.commons.lang3.StringUtils;

public class IlluminatiCalculator {

    private final static char ILLUMINATI_CHARACTER = '▲';
    private final static int ILLUMINATI_MULTIPLIER = 3;
    private final static int ILLUMINATI_CREATION_YEAR = 1776;

    private InputTransformer inputTransformer;
    private IlluminatiUtils illuminatiUtils;

    public IlluminatiCalculator(InputTransformer inputTransformer, IlluminatiUtils illuminatiUtils){
        this.inputTransformer = inputTransformer;
        this.illuminatiUtils = illuminatiUtils;
    }

    public int add(String input) {
        if(StringUtils.isBlank(input)){
            return 0;

        } else {
            int illuminatiOccurrences = countIlluminatiOccurrences(input);
            String numbers[] = inputTransformer.transformInput(input);
            //Fazer um objeto que contenha esses dois parâmetros como atributos?

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
                String errorMessage = illuminatiUtils.writeNegativeNumberErrorMessage(numbers);
                throw new NegativeNumberException(errorMessage);
            }

            if(!isGreaterThanIlluminatiCreationYear(parsedNumber)){
                result += parsedNumber;
            }
        }
        //Tem um for aqui e um no countIlluminatiOccurrences, como eliminar isso?

        if(illuminatiOccurrences > 0){
            result = multiplyTotalResultByIlluminatiOccurrenceNumber(illuminatiOccurrences, result);
        }

        return result;
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
