package datetime;

import java.util.Calendar;

public class Ex05 {
    public static void main(String[] args) {
        int month = Calendar.JUNE;
        int year = 2021;

        Calendar c = Calendar.getInstance();
        c.set(year, month, 1);

        int daysInMonth = c.getActualMaximum(Calendar.DAY_OF_MONTH);
        int weekday = Calendar.TUESDAY;
        int[] fiveDays = null;

        switch (daysInMonth) {
            case 31:
                fiveDays = new int[3];
                for (int i = 0; i < fiveDays.length; i++) {
                    fiveDays[i] = c.get(Calendar.DAY_OF_WEEK);
                    c.add(Calendar.DAY_OF_MONTH, 1);
                }
                break;
            case 30:
                fiveDays = new int[2];
                for (int i = 0; i < fiveDays.length; i++) {
                    fiveDays[i] = c.get(Calendar.DAY_OF_WEEK);
                    c.add(Calendar.DAY_OF_MONTH, 1);
                }
                break;
            case 29:
                fiveDays = new int[1];
                for (int i = 0; i < fiveDays.length; i++) {
                    fiveDays[i] = c.get(Calendar.DAY_OF_WEEK);
                    c.add(Calendar.DAY_OF_MONTH, 1);
                }
                break;
            default:
                break;
        }
        System.out.println("Number of weekday: " + nofWeekday(weekday, fiveDays));
    }

    private static int nofWeekday(int weekday, int[] fiveDays) {
        for (int i : fiveDays) {
            if (i == weekday) {
                return 5;
            }
        }
        return 4;
    }
}