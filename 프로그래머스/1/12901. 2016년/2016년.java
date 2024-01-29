import java.util.ArrayList;
import java.util.List;

class Solution {
    public String solution(int a, int b) {
        int day = 0;
        String result = "";

        List<Integer> month = new ArrayList<>();

        month.add(31);
        month.add(29);
        month.add(31);
        month.add(30);
        month.add(31);
        month.add(30);
        month.add(31);
        month.add(31);
        month.add(30);
        month.add(31);
        month.add(30);
        month.add(31);

        for (int i = 0; i < a-1; i++) {
            day += month.get(i);
        }

        day += b;

        result = switch (day % 7) {
            case 0 -> "THU";
            case 1 -> "FRI";
            case 2 -> "SAT";
            case 3 -> "SUN";
            case 4 -> "MON";
            case 5 -> "TUE";
            case 6 -> "WED";
            default -> result;
        };
        return(result);
    }
}