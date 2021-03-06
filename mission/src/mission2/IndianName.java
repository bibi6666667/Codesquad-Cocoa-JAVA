package mission2;
// day 3 미션2-1 : 인디언 이름 짓기.
import java.util.Scanner;

public class IndianName { // 클래스
    // 입력값을 받는다 - getBirth() -> 생년끝자리, 생월, 생일
    // 인디언이름 배열에서 입력값에 해당하는 번째 수의 정보를 가져온다 - makeIndianName()
    // 인디언이름을 받아서 콘솔에 출력한다 - printIndianName()

    public int[] getBirth(){
        System.out.println("생년, 월, 일을 입력해 주세요 >");
        Scanner s = new Scanner(System.in);
        int year = s.nextInt();
        int month = s.nextInt();
        int day = s.nextInt();
        int yearLastNum = year % 10; // 생년 끝자리
        //s.close();
        int YMD[] = {yearLastNum, month, day};
        return YMD;
    }

    public String[] makeIndianNames() {

        String[] indianYearNames = {"시끄러운", "푸른", "붉은", "조용한", "웅크린", "백색",
                "지혜로운", "용감한", "날카로운", "욕심많은" };
        String[] indianMonthNames = {"늑대", "태양", "양", "매", "황소", "불꽃",
                "나무", "달빛", "말", "돼지", "하늘", "바람"};
        String[] indianDayNames = {"와(과) 함께 춤을", "의 기상", "은(는) 그림자 속에",
                "","","","의 환생","의 죽음"," 아래에서", "를(을) 보라",
                "이(가) 노래하다", "의 그림자", "의 일격", "에게 쫓기는 남자", "의 행진",
                "의 왕", "의 유령", "을(를) 죽인 자", "은(는) 맨날 잠잔다", "처럼",
                "의 고향", "의 전사", "은(는) 나의 친구", "의 노래", "의 정령",
                "의 파수꾼", "의 악마", "와(과) 같은 사나이", "를(을) 쓰러트린 자", "의 혼",
                "은(는) 말이 없다"};


        // 생년 끝자리, 월, 일을 가지고 인디언이름 배열의 n번쨰 항목 가져와 인디언이름 배열에 넣기
        String[] yourIndianName = new String[3];

        //IndianName name = new IndianName();
        int YMD[] = this.getBirth();
        yourIndianName[0] = indianYearNames[YMD[0]];
        yourIndianName[1] = indianMonthNames[YMD[1] - 1];
        yourIndianName[2] = indianDayNames[YMD[2] - 1];

        return yourIndianName;
    }

    public void printIndianName(){
        String[] result = this.makeIndianNames();
        System.out.println("당신의 이름은 " + String.join(" ", result) + " 입니다.");
    }

    public static void main(String[] args) { // 메소드
        IndianName name = new IndianName();
        name.getBirth();
        name.makeIndianNames();
        name.printIndianName();
    }
}
