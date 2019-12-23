import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the isValid function below.
    static String isValid(String s) {

        Map<Integer, Integer> map = new HashMap<>();

        for (char c : "abcdefghijklmnopqrstuvwxyz".toCharArray()) {
            int sumA = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == c) sumA++;
            }
            if (sumA != 0) {
                if (map.containsKey(Integer.valueOf(sumA))) {
                    Integer value = map.get(sumA);
                    value += 1;
                    map.put(Integer.valueOf(sumA), value);
                } else {
                    map.put(Integer.valueOf(sumA), 1);
                }
            }
        }

        if (map.size() > 2) {return "NO"; }
        if (map.size() == 1) {return "YES"; }

        String result = "NO";
        if (map.size() == 2) {
            for (Integer i: map.values()) {
                if (i == 1) {

                    int sum = 0;
                    for (Integer j: map.keySet()) {
                        if (j == 1 && map.get(j) == 1) {
                            result = "YES";
                            break;
                        }
                        if (sum == 0) {
                            sum = j;
                        } else {
                            sum = Math.abs(sum - j);
                        }
                    }
                    if (sum == 1) {
                        result = "YES";
                        break;
                    }
                }
            }
        }
        return result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

//        String s = scanner.nextLine();
//        String s = "aabbcd";
//        String s = "abcdefghhgfedecba";
//        String s = "aabbccddeefghi";
        String s = "aaaaabc";

        String result = isValid(s);
        System.out.println(result);

//        bufferedWriter.write(result);
//        bufferedWriter.newLine();

//        bufferedWriter.close();
//
//        scanner.close();
    }
}
