package projectMyPick31;


// Controller : Model-View를 연결하고 프로그램의 로직을 담당. Model에서 데이터를 받고 View를 제어함. 또, 사용자의 조작을 입력받음.
public class Controller {
    View_console view = new View_console();
    Model model = new Model();

    public static void main(String[] args) {
        Controller controller = new Controller();
        controller.home();
    }

    void home(){
        view.start();
        int input = view.home();
        switch (input) {
            case 1 :
                view.readWhat();
                break;
            case 2 :
                view.chooseBTS();
                break;
            default :
                view.inputAgain();
                home();
                break;
        }
    }

    void readWhat(int input) {
        switch (input) {
            case 1 :
                view.readAllSignatures();
                view.returnHome();
                break;
            case 2 :
                view.readAllSeasons();
                view.returnHome();
                break;
            default :
                view.inputAgain();
                view.readWhat();
                break;
        }
    }

}

