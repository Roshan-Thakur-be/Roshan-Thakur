import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }

        for (int i = 0; i < nums.length; i++) {
            int start = nums[i];

            // Expand the range as long as elements are consecutive
            while (i + 1 < nums.length && nums[i + 1] == nums[i] + 1) {
                i++;
            }

            // Format the output depending on whether it's a range or a single number
            if (start == nums[i]) {
                result.add(String.valueOf(start));
            } else {
                result.add(start + "->" + nums[i]);
            }
        }

        return result;
    }
}