public class rabinKarp {

    public static long generatehash(String str, int primenum) {

        int n = str.length();
        long hash = 0;
        for (int i = n - 1; i >= 0; i--) {
            hash += str.charAt(i) * Math.pow(primenum, n - 1 - i);
        }

        return hash;
    }

    public static long updatehash(long prevhash, char oldchar, char newchar, int primenum, int patternLength) {
        long newhash = (prevhash - oldchar * (long) Math.pow(primenum, patternLength - 1)) * primenum + newchar;
        return newhash;
    }

    public static void main(String[] args) {
        String text = "THIS IS A TEST TEXT";
        String pattern = "IS";
        int primenum = 10;

        long patternHash = generatehash(pattern, primenum);
        long textHash = generatehash(text.substring(0, pattern.length()), primenum);

        int flag = 0;
        for (int i = 0; i <= text.length() - pattern.length(); i++) {
            if (textHash == patternHash) {
                if (text.substring(i, i + pattern.length()).equals(pattern)) {
                    System.out.println("Pattern found at index " + i);
                    flag = 1;
                }
            }

            if (i < text.length() - pattern.length()) {
                textHash = updatehash(textHash, text.charAt(i),
                        text.charAt(i + pattern.length()), primenum, pattern.length());
            }
        }

        if (flag == 0) {
            System.out.println("not found");
        }
    }
}
