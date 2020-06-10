public class Main {

    public static void main(String[] args) {
        //System.out.println(Add("4,2,1"));
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
        if(numbers.split(",").length == 2) {
            int a = 0, b = 0;
            try {
                a = Integer.parseInt(numbers.split(",")[0]);
                b = Integer.parseInt(numbers.split(",")[1]);
                return a + b;
            } catch (Exception e) {
                return ((Integer.class.isInstance(a)) ? a : b);
            }
        }

        // allowing unknown number of numbers for add operation

            String[] str = numbers.split(",");
            int[] arr = new int[str.length];

            int sum = 0;
            for (int i = 0; i < arr.length; i++) {
                arr[i] = Integer.parseInt(str[i]);
                sum += arr[i];
            }

            return sum;
    }
}
