package br.com.illuminati.calculator;

public class InputTransformer {

    private final static char ILLUMINATI_CHARACTER = '▲';

    public String removeIlluminatiSymbol(String input){
        return input.replaceAll((String.valueOf(ILLUMINATI_CHARACTER)), "");
    }

}
