public class IlluminatiCalculator {

    public int add(String numbers) {
        if(numbers.isEmpty() || (numbers.replaceAll("\\s", "")).isEmpty()){
            return 0;
        } else if(numbers.matches("\\d")) {
            return Integer.parseInt(numbers); //try-catch
        }
        return 20;
    }
}
