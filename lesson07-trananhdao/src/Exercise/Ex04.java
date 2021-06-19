package Exercise;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.time.Period;

public class Ex04 {
	public static void main(String[] args) {
        System.out.println("NEW YORK:" + now());
        currentmMonth(2, 2020);
        lastdayofmonth();
        firstAndLastDay();
        dateOfWeek();
        add8hours();
        Period();
        add20days();
    }
    //==============4a======================

    private static String now() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyy HH:mm:ss");
        LocalDateTime dtNY = LocalDateTime.now(ZoneId.of("America/New_York"));
        return dtf.format(dtNY);
    }
    //==============4b====================
    private static final String[] Months = {"January", "February", "March", "April", "May", "June",
        "July", "August", "September", "October", "November", "December"};

    public static String getMonth(int month) {
        return Months[month - 1];
    }

    private static void currentmMonth(int month, int year) {

        switch (month) {
            case 1,3,5,7,8,10,12:
                System.out.println(getMonth(month) + ": " + "31 days");
            case 4,6,9,11:
                System.out.println(getMonth(month) + ": " + "30 days");
            case 2:
                if (year % 4 == 0) {
                    System.out.println(getMonth(month) + ": " + "29 days");
                } else {
                    System.out.println(getMonth(month) + ": " + "28 days");
                }
        }

    }

    //==============4c==============================
    private static void lastdayofmonth() {
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");

        Calendar cal = Calendar.getInstance();
        cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.getActualMaximum(Calendar.DATE));

        System.out.println("last day of " + df.format(cal.getTime()));
    }

    //===============4d=================================
    private static void firstAndLastDay() {
        Calendar cal = Calendar.getInstance();

        cal.set(Calendar.DAY_OF_WEEK, cal.getFirstDayOfWeek());
        System.out.println("Start of this week: " + cal.get(Calendar.DATE));
        cal.add(Calendar.DAY_OF_WEEK, 6);
        System.out.println("End of this week: " + cal.get(Calendar.DATE));
        System.out.println("");

    }

    //================4e===============================
    private static void dateOfWeek() {
        int count = 0;
        Calendar now = Calendar.getInstance();
        int n = now.get(Calendar.DATE);

        Calendar startOfMonth = Calendar.getInstance();
        int s = startOfMonth.getMinimum(Calendar.DATE);

        while (s<=n) {
            count++;
             s= s+7;
        }

        System.out.println("week is " + count);
    }
    //====================4f===========================
    private static void  add8hours(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy - HH:mm:ss");
        LocalDateTime dateTime=LocalDateTime.now();
        
        System.out.println("add 8 hours: " + dtf.format(dateTime.plusHours(8)));
    }
    //===========================4g==================================
    private static void Period (){
       
        LocalDate dateTime1 = LocalDate.now();
        LocalDate dateTime2 = LocalDate.of(2001, 4, 2);
        Period period = Period.between(dateTime2, dateTime1);
        System.out.println("period: " + period);

    }
    private static void add20days(){
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        LocalDate now = LocalDate.now();
        LocalDate date = now.plusDays(20);
        int day = date.getDayOfMonth();
        int month = date.getMonthValue();
        int year = date.getYear();
        DayOfWeek dayofweek = date.getDayOfWeek();
        
        System.out.println("add20days: "+ day + "/" + month +"/" + year);
        System.out.println("dayofweek: "+dayofweek);
    }
}
