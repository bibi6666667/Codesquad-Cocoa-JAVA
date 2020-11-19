package mission5;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class MyCalendar {
    static MyCalendar myCalendar = new MyCalendar();

    public void starter(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("현재 달력 출력 : a , 과거 달력 출력 : z");
        String input = scanner.next();
        switch (input) {
            case "a" :
                buildCurrentCalendar();
                break;
            case "z" :
                int year = getYear();
                int month = getMonth();
                buildPastCalendar(year, month);
                break;
            default:
                System.out.println("잘못된 명령어입니다. 다시 입력하세요");
                starter();
                break;
        }
    }

    public int getYear() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n👉 출력을 원하는 연도를 숫자로 입력하세요.");
        int yearInput = scanner.nextInt();
        if (yearInput <= 0) {
            System.out.println("❗ 연도는 자연수로 입력해 주세요.");
            yearInput = scanner.nextInt();
        }
        return yearInput;
    }

    public int getMonth() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n👉 출력을 원하는 월을 숫자로 입력하세요.");
        int monthInput = scanner.nextInt();
        if (monthInput <= 0 || monthInput > 12) {
            System.out.println("❗ 월은 1이상 12이하의 자연수로 입력해 주세요.");
            monthInput = scanner.nextInt();
        }
        return monthInput;
    }

    public int[] getCurrent() {
        Calendar calendar = Calendar.getInstance();
        int currentYear = calendar.get(Calendar.YEAR);
        int currentMonth = calendar.get(Calendar.MONTH) + 1;
        int[] currentYearMonth = {currentYear, currentMonth};
        return currentYearMonth;
    }

    public boolean isLeapYear(int year) {
        if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0)
            return true;
        else
            return false;
    }

    public int calMonth1stDayWeek(int year, int month) {
        Calendar calendar = Calendar.getInstance();
        Date currentTime = new Date();
        String YMD = year + "-" + month + "-01";
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String today = formatter.format(currentTime);
        System.out.println("<오늘 날짜는 " + today + "입니다>");
        try {
            calendar.setTime(formatter.parse(YMD));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        int dayNum = calendar.get(Calendar.DAY_OF_WEEK);
        // 1(일) 2(월) 3(화) 4(수) 5(목) 6(금) 7(토)
        return dayNum;
    }

    public void buildCurrentCalendar() {
        //(기본값으로는 현재날짜의 달력을 출력)
        // 1. 연, 월 결정
        int year = myCalendar.getCurrent()[0];
        int month = myCalendar.getCurrent()[1];
        // 2. 월 가지고 최대일 결정 (2월이면 윤년 test, 윤년이면 최대일배열=dayDataLeapYear)
        int dayMax = 0;
        int[] dayData = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int[] dayDataLeapYear = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        boolean leapTest = isLeapYear(year);
        if (month == 2 && leapTest == true) { //2월이고 윤년
            dayMax = dayDataLeapYear[month - 1];
        }
        if (month == 2 && leapTest == false) { //2월이지만 윤년X
            dayMax = dayData[month - 1];
        }
        if (month != 2) { // 2월 아님
            dayMax = dayData[month - 1];
        }
        // 3. 월의 1일의 요일 계산
        int dayWeek1 = calMonth1stDayWeek(year, month); // 현재 월의 1일의 요일
        // 4. 달력 형태로 출력 - printCalendar
        printCalendar(year, month, dayMax, dayWeek1);
    }

    public void buildPastCalendar(int year, int month){
        // (연, 월을 입력받으면 그 연, 월의 달력을 출력.)
        // 1. 연, 월 결정 = 파라미터로 받아옴
        // 2. 월 가지고 최대일 결정 (2월이면 윤년 test, 윤년이면 최대일배열=dayDataLeapYear)
        int dayMax = 0;
        int[] dayData = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int[] dayDataLeapYear = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        boolean leapTest = isLeapYear(year);
        if (month == 2 && leapTest == true) { //2월이고 윤년
            dayMax = dayDataLeapYear[month - 1];
        }
        if (month == 2 && leapTest == false) { //2월이지만 윤년X
            dayMax = dayData[month - 1];
        }
        if (month != 2) { // 2월 아님
            dayMax = dayData[month - 1];
        }
        // 3. 월의 1일의 요일 계산
        int dayWeek1 = calMonth1stDayWeek(year, month); // 기준 월의 1일의 요일
        // 4. 달력 형태로 출력 - printCalendar
        printCalendar(year, month, dayMax, dayWeek1);
    }

    public void printCalendar(int year, int month, int dayMax, int dayWeek1) {
        // 월의 1일의 요일부터(dayWeek1) 1~최대일 출력.
        System.out.println("======== " + year + "년 " + month + "월 ========");
        System.out.printf("%4s%4s%4s%4s%4s%4s%4s%n","SUN","MON","TUE","WED","THU","FRI","SAT");
        //System.out.println("  일  월  화  수  목  금  토  ");
        for (int j = 1; j < dayWeek1; j++) {
            System.out.printf("%4s"," ");
        }
        for (int i = 1; i <= dayMax; i++) {
                System.out.printf("%4d", i);
            // 줄바꿈
            if ((dayWeek1 - 1 + i ) % 7 == 0) { // 공백 = (dayWeek1 - 1) + i 가 일주일 한 줄.
                System.out.println();//줄바꿈
            }
        }
    }
}
