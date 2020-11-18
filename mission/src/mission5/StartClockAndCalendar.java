package mission5;

import java.util.Scanner;

public class StartClockAndCalendar {
    static Scanner sc = new Scanner(System.in);
    static StartClockAndCalendar starter = new StartClockAndCalendar();
    HangeulClock clock = new HangeulClock();
    MyCalendar calendar = new MyCalendar();
    public static void main(String[] args) {
        System.out.println("== 한글시계와 달력입니다. == \n👉 원하는 명령어를 입력하세요 ");
        starter.home();
    }

    private void home() {
        System.out.println("⏲ 한글시계 : clock , 📅 달력 : cal , ⛔ 종료 : q");
        System.out.print("> ");
        String input = sc.next();
        switch(input) {
            case "clock" :
                System.out.println("⏲ 한글시계를 실행합니다.");
                starter.runHangeulClock();
                starter.goTo();
                break;
            case "cal" :
                System.out.println("📅 달력을 실행합니다.");
                starter.runMyCalendar();
                starter.goTo();
                break;
            case "q" :
                System.out.println("⛔ 종료합니다.");
                break;
            default:
                System.out.println("❓ 잘못된 명령어입니다. 다시 입력하세요.");
                starter.home();
                break;
        }
    }

    public void goTo(){
        System.out.println("\n👉 원하는 명령어를 입력하세요.");
        System.out.println("🏠 처음으로 : h , ⛔ 종료 : q");
        System.out.print("> ");

        String input = sc.next();
        switch (input) {
            case "h" :
                System.out.println("🏠 처음으로 돌아갑니다.");
                starter.home();
                break;
            case "q" :
                System.out.println("⛔ 종료합니다.");
                break;
            default :
                System.out.println("❓ 잘못된 명령어입니다. 다시 입력하세요.");
                starter.goTo();
                break;
        }
    }

    public void runHangeulClock() {
        clock.runHanguelClock();
    }

    public void runMyCalendar() {
        System.out.println("\n👉  원하는 명령어를 입력하세요.");
        System.out.println("📆 현재 달력 : a , 📅 지난 달력 : z , 🏠 처음으로 : h");
        System.out.print("> ");
        String input = sc.next();
        switch (input) {
            case "a" :
                System.out.println("📆 현재 날짜의 달력을 출력합니다.");
                calendar.buildCurrentCalendar();
                break;
            case "z" :
                System.out.println("📅 지난 날짜의 달력을 출력합니다.");
                int year = calendar.getYear();
                int month = calendar.getMonth();
                calendar.buildPastCalendar(year, month);
                break;
            case "h" :
                break;
            default:
                System.out.println("❓ 잘못된 명령어입니다. 다시 입력하세요.");
                starter.runMyCalendar();
                break;
        }

    }
}
