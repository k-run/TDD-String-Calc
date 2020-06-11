import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {

   //     System.out.println(Add("//[*][%]\\n1*2%3"));
    }
    
    public static int Add(String numbers){
        String delimiterList = getDelimiter(numbers);

        String numberWithoutDelimiterFormat = getNumberWithoutDelimiterFormat(numbers);

        // if input string is empty, return 0
        if (numberWithoutDelimiterFormat.length() == 0) return 0;

        // if input string contains only 1 value
        if (numberWithoutDelimiterFormat.split(delimiterList).length == 1) {
             try{
                 // if input string contains only 1 number, return that number
                  int n = Integer.parseInt(numberWithoutDelimiterFormat.split(delimiterList)[0]);
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
        if(numberWithoutDelimiterFormat.split(delimiterList).length == 2) {
            int a = 0, b = 0;

            try {
                a = Integer.parseInt(numberWithoutDelimiterFormat.split(delimiterList)[0]);
                if(a < 0) throw new Exception("Negatives not allowed: " + a);

                b = Integer.parseInt(numberWithoutDelimiterFormat.split(delimiterList)[1]);
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

            String[] str = numberWithoutDelimiterFormat.split(delimiterList);
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

    public static String getDelimiter(String numbers){
        StringBuilder delimitersList = new StringBuilder();

        String[] delimiterArray = numbers.substring(2, numbers.indexOf("\\n"))
                .replaceAll("]", ",")
                .replaceAll(" ", "")
                .replaceAll("\\[", "")
                .split(",");

        for (int i = 0; i < delimiterArray.length; i++) {
            StringBuilder delimiter = new StringBuilder();

            if(delimiterArray[i].length() > 1) {
                int len = delimiterArray[i].length();
                int count = 0;
                while(count < len) {
                    delimiter.append("\\").append(delimiterArray[i].charAt(count));
                    count++;
                }
            }

            else delimiter.append("\\").append(delimiterArray[i]);

            delimiter.append("|");

            delimitersList.append(delimiter);
        }

        delimitersList.deleteCharAt(delimitersList.length()-1);
        return delimitersList.toString();
    }

    public static String getNumberWithoutDelimiterFormat(String numbers){
        numbers = numbers.substring(numbers.indexOf("\\n") + 2).replaceAll(" ", "");
        return numbers;
    }
}
