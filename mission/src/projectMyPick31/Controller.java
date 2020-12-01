package projectMyPick31;


import java.util.ArrayList;

// Controller : Model-View를 연결하고 프로그램의 로직을 담당. Model에서 데이터를 받고 View를 제어함. 또, 사용자의 조작을 입력받음.
public class Controller {
    View_console view = new View_console();
    Model model = new Model();

    public static void main(String[] args) {
        Controller controller = new Controller();
        controller.ready();
    }

    void ready(){
        model.readSignatures();
        model.readSeasons();
        model.makeAllSignaturesNSeasons();
        System.out.println(model.allSignatures.size());
        System.out.println(model.allSeasons.size());
        System.out.println("준비 끝!");
        home();
    }

    void home(){
        view.start();
        int input = view.home();
        switch (input) {
            case 1 :
                System.out.println(model.allSignatures.size());
                System.out.println(model.allSeasons.size());
                int viewInput = view.printWhat();
                printWhat(viewInput);
                break;
            case 2 :
                String baseInput = view.chooseBase();
                String toppingInput = view.chooseTopping();
                String syrupInput = view.chooseSyrup();
                model.filterBase(baseInput);
                model.filterTopping(toppingInput);
                model.filterSyrup(syrupInput);
                filterResult();
                view.returnHome();
                home();
                break;
            case 3 :
                view.bye();
                break;
            default :
                view.inputAgain();
                home();
                break;
        }
    }

    void printWhat(int input) {
        switch (input) {
            case 1 :
                view.printSignatures();
                view.returnHome();
                home();
                break;
            case 2 :

                System.out.println(model.allSignatures.size());
                System.out.println(model.allSeasons.size());
                view.printSeasons();
                view.returnHome();
                home();
                break;
            default :
                view.inputAgain();
                view.printWhat();
                break;
        }
    }



    void filterResult(){
        System.out.println("필터링 결과는..");
    }


}

