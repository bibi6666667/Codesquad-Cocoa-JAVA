package projectMyPick31;

import java.util.Scanner;
import java.util.ArrayList;

// View : 화면 표시요소를 담당.
// View_console : GUI(AWT) 구현 전까지 콘솔창에서 View기능을 담당.
public class View_console {
    Scanner sc = new Scanner(System.in);
    // TODO : Model 객체 부르지 않고 처리해보기..
    Model model = new Model();

    void start() {
        System.out.println("=============🍧배스킨라빈스 아이스크림 필터링 서비스, MyPick31입니다.=============");
    }

    void returnHome() {
        System.out.println("[Home]으로 되돌아갑니다.");
    }

    int home() {

        System.out.println("[🏠 Home] 원하는 동작을 선택해 주세요.");
        System.out.println("1. 전체 플레이버 조회");
        System.out.println("2. 플레이버 검색");
        System.out.println("3. 종료");
        System.out.print("> ");
        int input = sc.nextInt();
        return input;
    }
    
    void inputAgain(){
        System.out.println("정의되지 않은 입력입니다. 다시 입력해 주세요");
    }

    void bye() {
        System.out.println("MyPick31을 종료합니다.");
    }

    int printWhat(){
        System.out.println("원하는 동작을 선택해 주세요.");
        System.out.println("1. 시그니처 플레이버 조회");
        System.out.println("2. 시즌 플레이버 조회");
        System.out.print("> ");
        int input = sc.nextInt();
        return input;
    }

    void printSignatures(){
        // 여기서 오류 발생.
        System.out.println("시그니처 플레이버를 조회합니다.");
        int allSignaturesSize = model.allSignatures.size();
        System.out.println(allSignaturesSize);
        for (int i = 0; i < allSignaturesSize; i++) {
            System.out.println(model.allSignatures.get(i));
        }
        System.out.println("전체 시그니처 플레이버 " + allSignaturesSize +  "개를 출력했습니다.");
    }

    void printSeasons(){
        System.out.println("시즌 플레이버를 조회합니다.");
        int allSeasonsSize = model.allSeasons.size();
        System.out.println(allSeasonsSize);
        for (int i = 0; i < allSeasonsSize; i++) {
            System.out.println(model.allSeasons.get(i));
        }
        System.out.println("전체 시즌 플레이버 " + allSeasonsSize +"개를 출력했습니다.");
    }
    
    String chooseBase(){ // Base Topping Syrup 선택
        sc.nextLine(); // 개행문자 제거
        System.out.println("------------베이스 목록입니다------------");
        int allBaseLength = model.allBases.length;
        for (int i = 0; i < allBaseLength; i++) {
            System.out.print((i+1) + "." + model.allBases[i] + " ");
            if ((i + 1) % 5 == 0)
                System.out.println("");
        }
        System.out.println("\n 베이스를 선택해 주세요. (필수 - 최소 1개, 최대 3개 선택. 여러 개 선택시 ,로 구분. ) \n >");
        String baseInput = sc.nextLine();
        return baseInput;
    }

    String chooseTopping(){
        System.out.println("------------토핑 목록입니다------------");
        int allToppingLength = model.allToppings.length;
        for (int i = 0; i < allToppingLength; i++) {
            System.out.print((i+1) + "." + model.allToppings[i] + " ");
            if ((i + 1) % 5 == 0)
                System.out.println("");
        }
        System.out.println("\n 토핑을 선택해 주세요. (최대 2개 선택. 여러 개 선택시 ,로 구분. 선택하지 않으려면 enter)\n >");
        String toppingInput = sc.nextLine();
        return toppingInput;
    }

    String chooseSyrup(){
        System.out.println("------------시럽 목록입니다------------");
        int allSyrupLength = model.allSyrups.length;
        for (int i = 0; i < allSyrupLength; i++) {
            System.out.print((i+1) + "." + model.allSyrups[i] + " ");
            if ((i + 1) % 5 == 0)
                System.out.println("");
        }
        System.out.println("\n 시럽을 선택해 주세요. (최대 1개 선택. 선택하지 않으려면 enter)\n >");
        String syrupInput = sc.nextLine();
        return syrupInput;
    }

}
