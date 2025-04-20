import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FindMinDifference {
    public static int findMinDifference(List<String> timePoints) {
        List<Integer> minutesList = new ArrayList<>();
        // 将时间字符串转换为分钟数
        for (String time : timePoints) {
            String[] parts = time.split(":");
            int hours = Integer.parseInt(parts[0]);
            int minutes = Integer.parseInt(parts[1]);
            minutesList.add(hours * 60 + minutes);
        }
        // 排序分钟数列表
        Collections.sort(minutesList);
        int minDiff = Integer.MAX_VALUE;
        // 计算相邻时间差
        for (int i = 1; i < minutesList.size(); i++) {
            int diff = minutesList.get(i) - minutesList.get(i - 1);
            minDiff = Math.min(minDiff, diff);
        }
        // 考虑循环时间差
        int circularDiff = 1440 + minutesList.get(0) - minutesList.get(minutesList.size() - 1);
        minDiff = Math.min(minDiff, circularDiff);
        return minDiff;
    }
}