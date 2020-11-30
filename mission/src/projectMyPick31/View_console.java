package projectMyPick31;

import java.util.Scanner;

// View : 화면 표시요소를 담당.
// View_console : GUI(AWT) 구현 전까지 콘솔창에서 View기능을 담당.
public class View_console {
    Scanner sc = new Scanner(System.in);
    Model model = new Model();


    void start() {
        System.out.println("배스킨라빈스 아이스크림 필터링 서비스, MyPick31입니다.");
    }

    void returnHome(){
        System.out.println("[Home]으로 되돌아갑니다.");
    }

    int home(){
        System.out.println("[Home] 원하는 동작을 선택해 주세요.");
        System.out.println("1. 전체 플레이버 조회");
        System.out.println("2. 플레이버 검색"); // -> chooseBTS
        System.out.print("> ");
        int input = sc.nextInt();
        return input;
    }
    
    void inputAgain(){
        System.out.println("정의되지 않은 입력입니다. 다시 입력해 주세요");
    }

    void readWhat(){
        Controller controller = new Controller();
        System.out.println("원하는 동작을 선택해 주세요.");
        System.out.println("1. 시그니처 플레이버( 개) 조회");
        System.out.println("2. 시즌 플레이버( 개) 조회");
        System.out.print("> ");
        int input = sc.nextInt();
        controller.readWhat(input);
    }

    void readAllSignatures(){
        System.out.println("전체 시그니처 플레이버를 출력합니다.");
        model.readSignatures();
    }

    void readAllSeasons(){
        System.out.println("전체 시즌 플레이버를 출력합니다.");
        model.readSeasons();
    }
    
    void chooseBTS(){ // Base Topping Syrup 선택
        for (int i = 0; i < model.allBaseLength; i++) {
            System.out.print((i+1) + "." + model.allBases[i] + " ");
            if ((i + 1) % 5 == 0)
                System.out.println("");
        }
        System.out.println("\n 베이스를 선택해 주세요. (여러 개 선택시 ,로 구분, 최소 1개 선택) \n >");
        String baseInput = sc.nextLine();
        for (int i = 0; i < model.allToppingLength; i++) {
            System.out.print((i+1) + "." + model.allToppings[i] + " ");
            if ((i + 1) % 5 == 0)
                System.out.println("");
        }
        System.out.println("\n 토핑을 선택해 주세요. (여러 개 선택시 ,로 구분, 선택하지 않으려면 enter)\n >");
        String toppingInput = sc.nextLine();
        for (int i = 0; i < model.allSyrupLength; i++) {
            System.out.print((i+1) + "." + model.allSyrups[i] + " ");
            if ((i + 1) % 5 == 0)
                System.out.println("");
        }
        System.out.println("\n 시럽을 선택해 주세요. (여러 개 선택시 ,로 구분, 선택하지 않으려면 enter)\n >");
        String syrupInput = sc.nextLine();
    }

}
