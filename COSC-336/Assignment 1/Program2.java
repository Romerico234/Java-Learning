public class Program2 {
    public static void main(String[] args) {
        int[] list1 = { 4, 9, 2, 5, 3, 101, 7, 18, 2, 1 };
        int[] list2 = { 186, 359, 274, 927, 890, 520, 571, 310, 916, 798, 732, 23, 196, 579,
                426, 188, 524, 991, 91, 150, 117, 565, 993, 615, 48, 811, 594, 303, 191,
                505, 724, 818, 536, 416, 179, 485, 334, 74, 998, 100, 197, 768, 421,
                114, 739, 636, 356, 908, 477, 656 };
        int[] list3 = { 318, 536, 390, 598, 602, 408, 254, 868, 379, 565, 206, 619, 936, 195,
                123, 314, 729, 608, 148, 540, 256, 768, 404, 190, 559, 1000, 482, 141, 26,
                230, 550, 881, 759, 122, 878, 350, 756, 82, 562, 897, 508, 853, 317,
                380, 807, 23, 506, 98, 757, 247 };

        System.out.println(longestDecreasingSub(list1));
        System.out.println(longestDecreasingSub(list2));
        System.out.println(longestDecreasingSub(list3));
    }

    public static int longestDecreasingSub(int[] nums) {
        if (nums.length == 0)
            return 0;
        else if (nums.length == 1)
            return 1;

        int n = nums.length;
        int[] d = new int[n];
        for (int i = 0; i < n; i++)
            d[i] = 1;

        for (int i = n; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                if (nums[i] > nums[j])
                    d[i] = Math.max(d[i], 1 + d[j]);
            }
        }

        int max = d[0];
        for (int i = 1; i < n; i++)
            if (d[i] > max)
                max = d[i];

        return max;
    }
}