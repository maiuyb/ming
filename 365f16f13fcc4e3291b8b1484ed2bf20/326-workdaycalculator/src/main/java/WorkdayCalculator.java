import java.util.*;
import java.text.SimpleDateFormat;
public class WorkdayCalculator {
    // 示例数据：节假日和调休日（格式：yyyy-MM-dd）
    private static final Set<String> HOLIDAYS = new HashSet<>(Arrays.asList(
            // 元旦
            "2025-01-01",

            // 春节
            "2025-01-28", "2025-01-29", "2025-01-30",
            "2025-01-31", "2025-02-01", "2025-02-02", "2025-02-03",

            // 清明节
            "2025-04-04", "2025-04-05", "2025-04-06",

            // 劳动节
            "2025-05-01", "2025-05-02", "2025-05-03",

            // 端午节
            "2025-05-30", "2025-05-31", "2025-06-01",

            // 中秋节
            "2025-09-06", "2025-09-07", "2025-09-08",

            // 国庆节
            "2025-10-01", "2025-10-02", "2025-10-03",
            "2025-10-04", "2025-10-05", "2025-10-06", "2025-10-07"
            ));
    private static final Set<String> WORK_WEEKENDS = new HashSet<>(Arrays.asList(
            // 春节调休
            "2025-01-25", // 原周六上班
            "2025-02-08", // 原周六上班

            // 国庆节调休
            "2025-09-27", // 原周六上班
            "2025-10-11"  // 原周六上班
    ));

    public static int calculateWorkdays(Calendar start, Calendar end) {
// 日期有效性验证
        if (start.after(end)) {
            throw new IllegalArgumentException();
        }

        int workdays = 0;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar current = (Calendar) start.clone();

        while (!current.after(end)) {
            int dayOfWeek = current.get(Calendar.DAY_OF_WEEK);
            String dateStr = sdf.format(current.getTime());

            // 判断是否为工作日
            if (!HOLIDAYS.contains(dateStr)){
                if (WORK_WEEKENDS.contains(dateStr)){
                    workdays++;
                }
            else{
                if((dayOfWeek != Calendar.SATURDAY && dayOfWeek != Calendar.SUNDAY) ){
                    workdays++;
                }
            }
            }


           // if ((dayOfWeek != Calendar.SATURDAY && dayOfWeek != Calendar.SUNDAY) || WORK_WEEKENDS.contains(dateStr)) {
             //   if (!HOLIDAYS.contains(dateStr)) {
               //     workdays++;
                //}
            //}
            current.add(Calendar.DAY_OF_YEAR, 1);
        }

        return workdays;
    }

}