package projectMyPick31;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;


// Model :  데이터를 다루는 객체 ) txt파일I/O, 카테고리 데이터 필터링 일부를 담당할 것이다.
public class Model {
    File signatures = new File("C:\\Users\\rnala\\OneDrive\\바탕 화면\\bibi\\Codesquad-Cocoa-JAVA\\mission\\src\\projectMyPick31\\signature.txt");
    File seasons = new File("C:\\Users\\rnala\\OneDrive\\바탕 화면\\bibi\\Codesquad-Cocoa-JAVA\\mission\\src\\projectMyPick31\\season.txt");

    String[] bases = {"바닐라", "초콜릿", "치즈", "민트", "녹차",
            "요거트", "견과류", "커피", "카라멜", "우유",
            "과일", "샤베트", "소르베", "과자", "곡류",
            "기타"};
    String[] toppings = {"캔디", "과일", "견과류", "크런치", "쿠키",
            "초콜릿", "초콜릿 칩", "크런치 초콜릿", "초코볼",
            "과자", "케이크", "기타"};
    String[] syrups = {"초콜릿", "카라멜", "과일", "기타"};

    HashMap<String,String> allBases = new HashMap<String, String>(16);
    HashMap<String,String> allToppings = new HashMap<String, String>(13);
    HashMap<String,String> allSyrups = new HashMap<String, String>(4);

    ArrayList<String> allSignatures = new ArrayList<>(20);
    ArrayList<String> allSeasons = new ArrayList<>(200);
    static ArrayList<String> allSignaturesNSeasons = new ArrayList<>(220);

    void putAllBases(){ // 16개
        allBases.put("바닐라","");        allBases.put("초콜릿","");        allBases.put("치즈","");
        allBases.put("민트","");        allBases.put("녹차","");        allBases.put("요거트","");
        allBases.put("견과류","호두, 피스타치오, 아몬드");        allBases.put("커피","자모카, 에스프레소");
        allBases.put("카라멜","");        allBases.put("우유","크림, 연유");
        allBases.put("과일","딸기, 체리, 망고, 바나나, 블루베리, 블랙베리, 파인애플, 석류, 멜론, 오렌지, 사과, 라즈베리, 코코넛, 아보카도, 카시스");
        allBases.put("샤베트","");        allBases.put("소르베","");
        allBases.put("과자","쿠키, 콘푸로스트, 첵스 초코, 바나나킥, 로투스, 죠리퐁, 카라멜콘땅콩");
        allBases.put("곡류","흑임자, 쌀, 옥수수, 인절미, 팥");
        allBases.put("기타","밤, 고구마, 감자, 커스터드, 마시멜로, 누가, 시리얼, 솜사탕");
    }

    void putAllTopping(){ // 12개
        allToppings.put("캔디","스프링클, 젤리, 토피, 달고나, 브리틀");
        allToppings.put("과일","딸기, 체리, 바나나칩, 블루베리, 망고, 사과, 파인애플");
        allToppings.put("견과류","호두, 아몬드, 초코 코팅 아몬드, 마카다미아, 캐슈넛, 땅콩, 피칸");
        allToppings.put("크런치","");        allToppings.put("쿠키","비스코티, 크래커");
        allToppings.put("초콜릿","");        allToppings.put("초콜릿 칩","");
        allToppings.put("크런치 초콜릿","");        allToppings.put("초코볼","프레첼볼, 다이제볼");
        allToppings.put("과자","초코파이, 킷캣, 후루트링, 미니바나나킥, 로투스, 죠리퐁, 프레첼, 첵스초코, 시리얼");
        allToppings.put("케이크","");        allToppings.put("기타","마카롱, 고구마, 팥, 그래놀라, 감자볼");
    }

    void putAllSyrup(){ // 4개
        allSyrups.put("초콜릿","");        allSyrups.put("카라멜","");
        allSyrups.put("과일","딸기, 블루베리, 체리, 망고, 블랙베리, 라즈베리, 크랜베리, 카시스");
        allSyrups.put("기타","떡, 꿀, 연유, 슈크림, 쿠키, 시리얼, 조청쌀엿, 로투스");
    }


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
