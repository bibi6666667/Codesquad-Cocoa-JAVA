package projectMyPick31;

import java.io.*;


// Model :  데이터를 다루는 객체 ) txt파일I/O, 카테고리 데이터 필터링 일부를 담당할 것이다.
public class Model {
    File signature = new File("C:\\Users\\rnala\\OneDrive\\바탕 화면\\bibi\\Codesquad-Cocoa-JAVA\\mission\\src\\projectMyPick31\\signature.txt");

    String[] allBases = {"바닐라", "초콜릿", "치즈", "민트", "녹차",
            "요거트", "견과류", "커피", "카라멜", "우유",
            "과일", "샤베트", "소르베", "과자", "곡류",
            "기타"};
    String[] allToppings = {"캔디", "과일", "견과류", "크런치", "쿠키",
            "초콜릿", "초콜릿 칩", "크런치 초콜릿", "초코볼",
            "과자", "케이크", "기타"};
    String[] allSyrups = {"초콜릿", "카라멜", "과일", "기타"};
    
    int allBaseLength = allBases.length;
    int allToppingLength = allToppings.length;
    int allSyrupLength = allSyrups.length;

    // Signature와 Seaosn을 담을 자료구조가 필요 - 배열 외에..
    String[] allSignatures;
    String[] allSeasons;


    void readSignatures(){
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(signature));
            while(true) {
                String line = bufferedReader.readLine();
                if (line == null) break;
                System.out.println(line);
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void readSeasons(){

    }

}
