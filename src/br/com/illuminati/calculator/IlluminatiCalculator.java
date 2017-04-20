package br.com.illuminati.calculator;

public class IlluminatiCalculator {

    public int add(String input) {
        if(input.isEmpty() || (input.trim()).isEmpty()){
            return 0;
        } else {
            //▲
//            input.su
            String numbers[] = input.split(" ");
            return parseInput(numbers);
        }
    }

    private int parseInput(String[] numbers) {
        int result = 0;
        for (String number: numbers){
            result += Integer.parseInt(number);
        }
        return result;
    }
}
