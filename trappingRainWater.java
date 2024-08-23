public class trappingRainWater {

    public static int trappingRainWater(int heights[]) {
        int left = 0;
        int right = heights.length - 1;
        int maxl = 0;
        int maxr = 0;
        int ans = 0;

        while (left < right) {

            if (heights[left] < heights[right]) {
                if (heights[left] > maxl) {
                    maxl = heights[left];
                } else {
                    ans += maxl - heights[left];
                }
                left++;
            } else {
                if (heights[right] > maxr) {
                    maxr = heights[right];
                } else {
                    ans += maxr - heights[right];
                }
                right--;
            }
        }
        return ans;
    }

    public static void main(String args[]) {
        int heights[] = { 4, 2, 0, 3, 2, 5 };
        int ans = trappingRainWater(heights);
        System.out.println(ans);
    }
}
