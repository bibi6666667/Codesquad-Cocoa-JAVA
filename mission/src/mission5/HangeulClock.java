package mission5;

import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Timer;
import java.util.TimerTask;

public class HangeulClock {
    static HangeulClock hangeulClock = new HangeulClock();

    public void runHanguelClock() {
        Timer scheduler = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                // hangeulClock.clearScreen(); 동작하지 않음..ㅜ
                String[][] clockResult = hangeulClock.showHourMinute();
                hangeulClock.printHangeulClock(clockResult);
            }
        };
        scheduler.scheduleAtFixedRate(task, 1000, 60000); // 1초 뒤 1분마다 반복실행
        System.out.println("한글시계는 1분마다 자동 업데이트됩니다. 아무 키나 입력하면 업데이트가 멈춥니다.");
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        switch (input) {
            default :
                scheduler.cancel();
                System.out.println("자동 업데이트를 종료합니다.");
                break;
        }
    }


    public static String[][] showBackground() {
        String[][] background = new String[6][6];
        background[0] = new String[]{"✨", "✨", "✨", "✨", "✨", "✨"};
        background[1] = new String[]{"✨", "✨", "✨", "✨", "✨", "✨"};
        background[2] = new String[]{"✨", "✨", "✨", "✨", "✨", "✨"};
        background[3] = new String[]{"✨", "✨", "✨", "✨", "✨", "✨"};
        background[4] = new String[]{"✨", "✨", "✨", "✨", "✨", "✨"};
        background[5] = new String[]{"✨", "✨", "✨", "✨", "✨", "✨"};
        return background;
    }

    public static String[][] takeHangeul() {
        String[][] HangeulTime = new String[6][6];
        HangeulTime[0] = new String[]{"한", "두", "세", "네", "다", "섯"};
        HangeulTime[1] = new String[]{"여", "섯", "일", "곱", "여", "덟"};
        HangeulTime[2] = new String[]{"아", "홉", "열", "한", "두", "시"};
        HangeulTime[3] = new String[]{"자", "이", "삼", "사", "오", "십"};
        HangeulTime[4] = new String[]{"정", "일", "이", "삼", "사", "육"};
        HangeulTime[5] = new String[]{"오", "오", "칠", "팔", "구", "분"};
        return HangeulTime;
    }

    public void printHangeulClock(String[][] clockFormat) {
        String[][] HangeulClock = clockFormat;
        System.out.println("💫한글시계 따라 만들기💫");
        for (int i = 0; i < 6; i++) {
            System.out.print(" " + HangeulClock[i][0] + " ");
            System.out.print(" " + HangeulClock[i][1] + " ");
            System.out.print(" " + HangeulClock[i][2] + " ");
            System.out.print(" " + HangeulClock[i][3] + " ");
            System.out.print(" " + HangeulClock[i][4] + " ");
            System.out.println(" " + HangeulClock[i][5] + " ");
        }
    }

    public String getCurrentTime() {
        LocalDateTime dateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ISO_TIME;
        String currentTime = dateTime.format(formatter);
        // System.out.println(currentTime); 시간출력
        String[] timeArr = currentTime.split(":");
        String hourMinute = String.join(":", timeArr[0], timeArr[1]);
        return hourMinute;
    }

    public String[][] showHourMinute() {
        String hourMinute = getCurrentTime();
        String[][] HangeulData = takeHangeul();
        String[][] clockFormat = showBackground();
        String hour = hourMinute.split(":")[0]; // 시
        String minute = hourMinute.split(":")[1]; // 분
        switch (hourMinute) {
            case "00:00":
                clockFormat[3][0] = HangeulData[3][0];//자
                clockFormat[4][0] = HangeulData[4][0];//정
                break;
            case "12:00":
                clockFormat[4][0] = HangeulData[4][0];//정
                clockFormat[5][0] = HangeulData[5][0];//오
                break;
            default:
                putHangeulHours(clockFormat, HangeulData, hour);
                putHangeulMinutes(clockFormat, HangeulData, minute);
                break;
        }
        return clockFormat;
    }

    public void putHangeulHours(String[][] clockFormat, String[][] HangeulData, String hour) {
        ///// 시
        switch (hour) {
            case "01":
            case "13":
                clockFormat[0][0] = HangeulData[0][0];//한
                break;
            case "02":
            case "14":
                clockFormat[0][1] = HangeulData[0][1];//두
                break;
            case "03":
            case "15":
                clockFormat[0][2] = HangeulData[0][2];//세
                break;
            case "04":
            case "16":
                clockFormat[0][3] = HangeulData[0][3];//네
                break;
            case "05":
            case "17":
                clockFormat[0][4] = HangeulData[0][4];//다
                clockFormat[0][5] = HangeulData[0][5];//섯
                break;
            case "06":
            case "18":
                clockFormat[1][0] = HangeulData[1][0];//여
                clockFormat[1][1] = HangeulData[1][1];//섯
                break;
            case "07":
            case "19":
                clockFormat[1][2] = HangeulData[1][2];//일
                clockFormat[1][3] = HangeulData[1][3];//곱
                break;
            case "08":
            case "20":
                clockFormat[1][4] = HangeulData[1][4];//여
                clockFormat[1][5] = HangeulData[1][5];//덟
                break;
            case "09":
            case "21":
                clockFormat[2][0] = HangeulData[2][0];//아
                clockFormat[2][1] = HangeulData[2][1];//홉
                break;
            case "10":
            case "22":
                clockFormat[2][2] = HangeulData[2][2];//열
                break;
            case "11":
            case "23":
                clockFormat[2][2] = HangeulData[2][2];//열
                clockFormat[2][3] = HangeulData[2][3];//한
                break;
            case "12":
            case "0":
                clockFormat[2][2] = HangeulData[2][2];//열
                clockFormat[2][4] = HangeulData[2][4];//두
                break;
        }
        clockFormat[2][5] = HangeulData[2][5];//시
    }

    public void putHangeulMinutes(String[][] clockFormat, String[][] HangeulData, String minute) {
        /////// 분
        String minuteTen = minute.split("")[0];  // 분의 십의 자리
        String minuteOne = minute.split("")[1];  // 분의 일의 자리
        // 분 - 십의 자리
        switch (minuteTen) {
            case "1":
                clockFormat[3][5] = HangeulData[3][5];//십
                break;
            case "2":
                clockFormat[3][1] = HangeulData[3][1];//이
                clockFormat[3][5] = HangeulData[3][5];//십
                break;
            case "3":
                clockFormat[3][2] = HangeulData[3][2];//삼
                clockFormat[3][5] = HangeulData[3][5];//십
                break;
            case "4":
                clockFormat[3][3] = HangeulData[3][3];//사
                clockFormat[3][5] = HangeulData[3][5];//십
                break;
            case "5":
                clockFormat[3][4] = HangeulData[3][4];//오
                clockFormat[3][5] = HangeulData[3][5];//십
                break;
            case "0":
                break;
        }
        // 분 - 일의 자리
        switch (minuteOne) {
            case "1":
                clockFormat[4][1] = HangeulData[4][1];//일
                break;
            case "2":
                clockFormat[4][2] = HangeulData[4][2];//이
                break;
            case "3":
                clockFormat[4][3] = HangeulData[4][3];//삼
                break;
            case "4":
                clockFormat[4][4] = HangeulData[4][4];//사
                break;
            case "5":
                clockFormat[5][1] = HangeulData[5][1];//오
                break;
            case "6":
                clockFormat[4][5] = HangeulData[4][5];//육
                break;
            case "7":
                clockFormat[5][2] = HangeulData[5][2];//칠
                break;
            case "8":
                clockFormat[5][3] = HangeulData[5][3];//팔
                break;
            case "9":
                clockFormat[5][4] = HangeulData[5][4];//구
                break;
            case "0":
                break;
        }
        if (minuteTen.equals("0") && minuteOne.equals("0")) {
            return;
        } else {
            clockFormat[5][5] = HangeulData[5][5];//분
        }
    }
}
