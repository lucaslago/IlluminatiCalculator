package br.com.illuminati.calculator;

public class IlluminatiCalculator {

    private final static char ILLUMINATI_CHARACTER = '▲';
    private final static int ILLUMINATI_MULTIPLIER = 3;

    public int add(String input) {
        if(input.isEmpty() || (input.trim()).isEmpty()){//Mesmo resultado se n tiver espaços(?) - deixar só com trim()
            return 0;
        } else {

            int illuminatiOccurrences = countIlluminatiOccurrences(input);
            input = input.replaceAll((String.valueOf(ILLUMINATI_CHARACTER)), "");

            String numbers[] = input.split(" ");
            int result = parseInput(numbers);

            if(illuminatiOccurrences > 0){
                result = multiplyTotalResultByIlluminatiOccurrenceNumber(illuminatiOccurrences, result);
            }
            return result;
        }
    }

    private int parseInput(String[] numbers) {
        int result = 0;
        for (String number: numbers){
            result += Integer.parseInt(number);
        }
        return result;
    }

    private boolean isANegativeNumber(int number){
        return number > 0;
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
