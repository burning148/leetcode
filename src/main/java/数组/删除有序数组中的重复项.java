package 数组;

public class 删除有序数组中的重复项 {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int slow = 0, fast = 0;
        while (fast < nums.length) {
            if (nums[slow] != nums[fast]) {
                slow++;
                // 维护[0, slow]无重复
                nums[slow] = nums[fast];
            }
            fast++;
        }
        // 长度等于索引 + 1
        return slow + 1;
    }


    public int removeDuplicates2(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int slow = 0;
        for (int fast = 0; fast < nums.length; fast++) {
            if (nums[slow] != nums[fast]) {
                slow++;
                nums[slow] = nums[fast];
            }
        }

        // 长度等于索引 + 1
        return slow + 1;
    }
}
