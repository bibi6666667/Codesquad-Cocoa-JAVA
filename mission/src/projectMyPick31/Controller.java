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

    void ready() {
        model.readSignatures();
        model.readSeasons();
        model.makeAllSignaturesNSeasons();
        model.putAllBases();
        model.putAllTopping();
        model.putAllSyrup();
        System.out.println("전체 시그니처플레이버 " + model.allSignatures.size());
        System.out.println("전체 시즌 플레이버 " + model.allSeasons.size());
        System.out.println("전체 베이스 " + model.allBases.size());
        System.out.println("전체 토핑 " + model.allToppings.size());
        System.out.println("전체 시럽 " + model.allSyrups.size());
        System.out.println("준비 끝!");
        home();
    }

    void home() {
        view.start();
        int input = view.home();
        switch (input) {
            case 1:
                int viewInput = view.printWhat();
                printWhat(viewInput);
                break;
            case 2:
                String baseInput = view.chooseBase();
                String toppingInput = view.chooseTopping();
                String syrupInput = view.chooseSyrup();
                String[] transferredBaseInput = transferBaseInput(baseInput);
                ArrayList<String> filteredBaseResult = filterBase(transferredBaseInput);
                filterTopping(toppingInput);
                filterSyrup(syrupInput);
                filterResult(filteredBaseResult);
                view.returnHome();
                home();
                break;
            case 3:
                view.bye();
                break;
            default:
                view.inputAgain();
                home();
                break;
        }
    }

    void printWhat(int input) {
        switch (input) {
            case 1:
                view.printSignatures();
                view.returnHome();
                home();
                break;
            case 2:
                view.printSeasons();
                view.returnHome();
                home();
                break;
            default:
                view.inputAgain();
                view.printWhat();
                break;
        }
    }

    String[] transferBaseInput(String baseInputNum) {
        String[] baseInputNumArr = baseInputNum.split(",");
        String[] baseInputStrArr = new String[3]; // 3개까지 선택가능
        for (int i = 0; i < baseInputNumArr.length; i++) { // 숫자배열의 0번째부터.
            int toTransfer = Integer.parseInt(baseInputNumArr[i]); // 0, 1, 2..번쨰 (Str->Int)
            String transfered = model.bases[toTransfer - 1]; //
            baseInputStrArr[i] = transfered;
        }
        return baseInputStrArr;
    }

    ArrayList<String> filterBase(String[] transferredBaseInput) {// 최소 1개, 최대 3개 선택 가능
        int baseInputArrLength = transferredBaseInput.length;
        ArrayList<String> allSignaturesNSeasons = model.allSignaturesNSeasons;
        int allSignaturesNSeasonsSize = allSignaturesNSeasons.size();
        ArrayList<String> filteredBases = new ArrayList<>(); // 중간 결과값
        int filteredBasesSize = filteredBases.size();
        ArrayList<String> filteredResult = new ArrayList<>(); // 중복제거한 최종 결과값
        for (int i = 0; i < baseInputArrLength; i++) { // for1. 선택 베이스목록 각각에 대해..
            String aBaseInput = transferredBaseInput[i];
            if (aBaseInput == null) break;
            System.out.println(aBaseInput + "를/을 찾습니다.");
            for (int j = 0; j < allSignaturesNSeasonsSize; j++) { // for2. 시그니처/시즌에서 각 베이스와 일치하는 플레이버 찾기
                String aSignatureOrSeason = allSignaturesNSeasons.get(j);
                String comparedBase = aSignatureOrSeason.split("/")[3]; // 베이스는 인덱스3
                if (comparedBase.contains(aBaseInput)) {
                    String result = aSignatureOrSeason.split("/")[1]; // 플레이버명은 인덱스1
                    filteredBases.add(result);
                    // System.out.println(result);
                }
            }
        }
        // 중복제거
        for (int k = 0; k < filteredBases.size(); k++) {
            String filteredBase = filteredBases.get(k);
            if (!filteredResult.contains(filteredBase)) {
                filteredResult.add(filteredBase);
            }
        }
        return filteredResult;
    }

    void filterTopping(String toppingInput) { // 최대 2개
    }

    void filterSyrup(String syrupInput) { // 최대 1개
    }

    void filterResult(ArrayList<String> baseResult) { // filterBase, filterTopping, filterSyrup의 교집합 보여주기
        //// 기능구현 끝나면 아래 출력부분은 View로 옮기기
        int baseResultSize = baseResult.size();
        System.out.println("총 " + baseResultSize + "개의 플레이버가 검색되었습니다.");
        for (int i = 0; i < baseResultSize; i++) {
            System.out.print(baseResult.get(i));
            if (i == baseResultSize - 1) continue;
            System.out.print(",");
            if ((i + 1) % 5 == 0) System.out.println(""); // 5개씩 한 줄로 출력
        }
        System.out.println("\n검색이 완료되었습니다.");
    }
}

