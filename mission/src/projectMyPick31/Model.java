package projectMyPick31;

import java.io.*;
import java.util.ArrayList;


// Model :  데이터를 다루는 객체 ) txt파일I/O, 카테고리 데이터 필터링 일부를 담당할 것이다.
public class Model {
    File signatures = new File("C:\\Users\\rnala\\OneDrive\\바탕 화면\\bibi\\Codesquad-Cocoa-JAVA\\mission\\src\\projectMyPick31\\signature.txt");
    File seasons = new File("C:\\Users\\rnala\\OneDrive\\바탕 화면\\bibi\\Codesquad-Cocoa-JAVA\\mission\\src\\projectMyPick31\\season.txt");

    String[] allBases = {"바닐라", "초콜릿", "치즈", "민트", "녹차",
            "요거트", "견과류", "커피", "카라멜", "우유",
            "과일", "샤베트", "소르베", "과자", "곡류",
            "기타"};
    String[] allToppings = {"캔디", "과일", "견과류", "크런치", "쿠키",
            "초콜릿", "초콜릿 칩", "크런치 초콜릿", "초코볼",
            "과자", "케이크", "기타"};
    String[] allSyrups = {"초콜릿", "카라멜", "과일", "기타"};


    ArrayList<String> allSignatures = new ArrayList<>(20);
    ArrayList<String> allSeasons = new ArrayList<>(200);
    static ArrayList<String> allSignaturesNSeasons = new ArrayList<>(220);

    ArrayList<String> baseFilteredFlavor = new ArrayList<>();
    ArrayList<String> toppingFilteredFlavor = new ArrayList<>();
    ArrayList<String> syrupFilteredFlavor = new ArrayList<>();

    void makeAllSignaturesNSeasons() {
        allSignaturesNSeasons.addAll(allSignatures);
        allSignaturesNSeasons.addAll(allSeasons);
    }

    void readSignatures() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(signatures));
            while (true) {
                String line = bufferedReader.readLine();
                if (line == null) break;
                allSignatures.add(line);
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void readSeasons() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(seasons));
            while (true) {
                String line = bufferedReader.readLine();
                if (line == null) break;
                allSeasons.add(line);
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
