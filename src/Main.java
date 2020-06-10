public class Main {

    public static void main(String[] args) {

        System.out.println(Add("1002"));
    }
    
    public static int Add(String numbers){
        // if input string is empty, return 0
        if (numbers.length() == 0) return 0;

        // if input string contains only 1 value
        if (numbers.split("\n|,").length == 1) {
             try{
                 // if input string contains only 1 number, return that number
                  int n = Integer.parseInt(numbers.split("\n|,")[0]);
                  if(n < 0) throw new Exception("Negatives not allowed: " + n);

                  if(n >= 1000) n = 0;
                  return n;
             }
             catch (Exception e) {
                 // if input string contains 1 value other than a parsable int,return 0
                 e.printStackTrace();
                 return 0;
             }
        }

        // if input string contains of 2 numbers, add them and return the result
        if(numbers.split("\n|,").length == 2) {
            int a = 0, b = 0;
            try {
                a = Integer.parseInt(numbers.split("\n|,")[0]);
                if(a < 0) throw new Exception("Negatives not allowed: " + a);

                b = Integer.parseInt(numbers.split("\n|,")[1]);
                if(b < 0) throw new Exception("Negatives not allowed: " + b);

                if(a >= 1000) a = 0;
                if(b >= 1000) b = 0;
                return a + b;
            }
            catch (NumberFormatException e) {
                return ((Integer.class.isInstance(a)) ? a : b);
            }
            catch (Exception e) {
                e.printStackTrace();
                return 0;
            }
        }

        // allowing unknown number of numbers for add operation

            String[] str = numbers.split("\n|,");
            int[] arr = new int[str.length];

            int sum = 0;
            for (int i = 0; i < arr.length; i++) {
                arr[i] = Integer.parseInt(str[i]);
                if(arr[i] < 0){
                    try {
                        throw new Exception("Negatives not allowed: " + arr[i]);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

                if(arr[i] >= 1000) arr[i] = 0;
                sum += arr[i];
            }

            return sum;
    }
}
