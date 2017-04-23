package br.com.illuminati.calculator;

public class IlluminatiCalculator {

    public int add(String input) {
        if(input.isEmpty() || (input.trim()).isEmpty()){
            return 0;
        } else {
            String numbers[] = input.split("( )|(▲)");
            int result = parseInput(numbers);
            int illuminatiOccurrences = countIlluminatiOccurrences(input);
            if(illuminatiOccurrences > 0){
                result = multiplyResultByIlluminatiOccurrenceNumber(illuminatiOccurrences, result);
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

    private int countIlluminatiOccurrences(String input){
        int illuminatiOccurrences = 0;

        for(int cont = 0; cont < input.length(); cont++){
            if((input.charAt(cont)) == '▲'){
                illuminatiOccurrences ++;
            }
        }
        return illuminatiOccurrences;
    }

    private int multiplyResultByIlluminatiOccurrenceNumber(int illuminatiOccurrences, int result){
        for(int cont = 0; cont<illuminatiOccurrences; cont++){
            result = result*3;
        }
        return result;
    }

}
