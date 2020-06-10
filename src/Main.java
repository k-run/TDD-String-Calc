public class Main {

    public static void main(String[] args) {
        System.out.println(Add("3,$"));
    }
    
    public static int Add(String numbers){
        // if input string is empty, return 0

        if (numbers.length() == 0) return 0;

        // if input string contains only 1 value
        if(numbers.split(",").length == 1) {
             try{
                 // if input string contains only 1 number, return that number
                 return Integer.parseInt(numbers.split(",")[0]);
             }
             catch (Exception e) {
                 // if input string contains 1 value other than a parsable int,return 0
                 return 0;
             }
        }

        // if input string contains of 2 numbers, add them and return the result

            int a = 0, b =0;
            try {
                a = Integer.parseInt(numbers.split(",")[0]);
                b = Integer.parseInt(numbers.split(",")[1]);
                return a + b;
            }
            catch (Exception e) {
                return ((Integer.class.isInstance(a)) ? a : b);
            }

    }
}
