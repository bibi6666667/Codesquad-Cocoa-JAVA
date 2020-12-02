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
                int viewInput = view.printWhat();
                printWhat(viewInput);
                break;
            case 2 :
                String baseInput = view.chooseBase();
                String toppingInput = view.chooseTopping();
                String syrupInput = view.chooseSyrup();
                String[] transferredBaseInput = transferBaseInput(baseInput);
                filterBase(transferredBaseInput);
                filterTopping(toppingInput);
                filterSyrup(syrupInput);
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

    String[] transferBaseInput(String baseInputNum){
        String[] baseInputNumArr = baseInputNum.split(",");
        String[] baseInputStrArr = new String[3]; // 3개까지 선택가능?
        for(int i = 0; i < baseInputNumArr.length; i++){ // 숫자배열의 0번째부터.
            int toTransfer = Integer.parseInt(baseInputNumArr[i]); // 0, 1, 2..번쨰 (Str->Int)
            String transfered = model.allBases[toTransfer - 1]; //
            System.out.println(transfered);
            baseInputStrArr[i] = transfered;
        }
        return baseInputStrArr;
    }

    void filterBase(String[] transferredBaseInput){// 선택한 베이스와 일치하는 플레이버 모두 찾기. 최대 2개 선택 가능
        int baseInputArrLength = transferredBaseInput.length;
        ArrayList allSignaturesNSeasons = model.allSignaturesNSeasons;
        int allSignaturesNSeasonsSize = allSignaturesNSeasons.size();
        ArrayList<String> filterdBaseResult; // 필터링 결과값 ) 플레이버 id값(String인 숫자)넣기
        for(int i = 0; i < baseInputArrLength; i++) { // 선택 베이스목록 각각과 일치하는 플레이버 찾기
            String aBaseInput = transferredBaseInput[i];
            System.out.println(aBaseInput + "를 찾습니다.");
            //String.contains("");
            //해쉬맵
            //value에 ArrayList 넣기?

            int indexOfBase;
            //System.out.println(allSignaturesNSeasons.get(indexOfBase));
        }
    }

    void filterTopping(String toppingInput){
        System.out.println(toppingInput);
    }

    void filterSyrup(String syrupInput){
        System.out.println(syrupInput);
    }

    void filterResult(){
        System.out.println("필터링 결과는..");
    }


}

