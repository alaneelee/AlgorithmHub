import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Solution {
    public int[] solution(String s) {
        char c;
        int num;
        HashMap<Character, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();

        for(int i = 0; i < s.length(); i++) {
            c = s.charAt(i);

            num = map.getOrDefault(c, -1);

            if (num == -1) {
                list.add(num);
            } else {
                list.add(i-num);
            }
            map.put(c, i);
        }
        
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}