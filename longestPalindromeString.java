import java.util.*;

public class longestPalindromeString {

    // Function to print the longest palindrome substring
    public static void print(StringBuilder str, int start, int end) {
        for (int i = start; i <= end; i++) { // Use <= to include the last character
            System.out.print(str.charAt(i)); // Changed to print on the same line
        }
        System.out.println(); // Print a new line after the palindrome
    }

    // Function to find the longest palindrome substring
    public static void longestPalindrome(StringBuilder str) {
        int start = 0; // Start index of the longest palindrome
        int end = 0; // End index of the longest palindrome

        int low, high;

        for (int i = 0; i < str.length(); i++) { // Start from the first character

            // Odd length palindromes
            // low = i;
            // high = i;
            // while (low >= 0 && high < str.length() && str.charAt(low) == str.charAt(high)) {
            //     if (high - low > end - start) {
            //         start = low;
            //         end = high;
            //     }
            //     low--;
            //     high++;
            // }

            // Even length palindromes
            low = i;
            high = i + 1;
            while (low >= 0 && high < str.length() && str.charAt(low) == str.charAt(high)) {
                if (high - low > end - start) {
                    start = low;
                    end = high;
                }
                low--;
                high++;
            }
        }

        print(str, start, end); // Print the longest palindrome substring
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter string: ");
        String input = sc.nextLine();
        StringBuilder sb = new StringBuilder(input);

        longestPalindrome(sb);
    }
}
