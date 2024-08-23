public class numericKeypad {

    public static String convert(String input) {
        StringBuilder output = new StringBuilder("");
        int arr[] = { 2, 22, 222, 3, 33, 333, 4, 44, 444, 5, 55, 555, 6, 66, 666, 7, 77, 777, 7777, 8, 88, 888, 9, 99,
                999, 9999 };

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (ch == ' ') {
                output.append(0);
            } else {
                output.append(arr[ch - 65]);
            }
        }
        return output.toString();
    }

    public static void main(String[] args) {
        String input = "ABC ABC";
        System.out.println(convert(input));
    }

}
