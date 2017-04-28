package br.com.illuminati.calculator;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class InputTransformer {

    private final static char ILLUMINATI_CHARACTER = '▲';

    public String removeIlluminatiSymbol(String input){
        return input.replaceAll((String.valueOf(ILLUMINATI_CHARACTER)), "");
    }

    public String[] splitByWhitespace(String input){
        return input.split(" ");
    }

    public String[] transformInput(String input) {
        String inputWithoutIlluminatiSymbol = removeIlluminatiSymbol(input);

        return splitByWhitespace(inputWithoutIlluminatiSymbol);
    }

}
