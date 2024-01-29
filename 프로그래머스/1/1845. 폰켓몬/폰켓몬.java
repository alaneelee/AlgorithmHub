import java.util.HashSet;
import java.util.Set;

class Solution {
    public int solution(int[] nums) {
        int count = nums.length / 2;
        Set<Integer> setNums = new HashSet<>();

        for(int num : nums) {
            setNums.add(num);
        }
        
        return Math.min(setNums.size(), count);
    }
}