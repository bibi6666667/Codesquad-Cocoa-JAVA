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
                ArrayList<String> managedBaseInput = manageBaseInput(baseInput);
                ArrayList<String> filteredBaseResult = filterBase(managedBaseInput);
                ArrayList<String> managedToppingInput = manageToppingInput(toppingInput);
                ArrayList<String> filteredToppingResult = filterTopping(managedToppingInput);
                ArrayList<String> managedSyrupInput = manageSyrupInput(syrupInput);
                ArrayList<String> filteredSyrupResult = filterSyrup(managedSyrupInput);
                filterResult(filteredBaseResult, filteredToppingResult ,filteredSyrupResult);
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

    ArrayList<String> manageBaseInput(String baseInputNum) {
        String[] baseInputNumArr = baseInputNum.split(",");
        ArrayList<String> managedBaseInput = new ArrayList<>(); // 최종결과값(선택값+선택하위값)
        if (baseInputNumArr[0].equals("")) { // 입력 없으면 값 없이 반환
            System.out.println("베이스 입력 없음");
            return managedBaseInput;
        }
        for (int i = 0; i < baseInputNumArr.length; i++) { // 숫자배열의 0번째부터.
            int toTransfer = Integer.parseInt(baseInputNumArr[i]); // 0, 1, 2..번쨰 (Str->Int)
            String transfered = model.bases[toTransfer - 1]; //
            managedBaseInput.add(transfered);
            // 하위카테고리
            String base2Str = model.allBases.get(transfered); // 선택한베이스1개가 키인 값(하위카테고리)
            if (base2Str == "") continue; // 하위카테고리 없으면 스킵
            System.out.println(transfered + "의 하위카테고리는 " + base2Str);
            String[] base2Arr = base2Str.split(",");
            for(int j = 0; j < base2Arr.length; j++) {
                managedBaseInput.add(base2Arr[j]);
            }
        }
        return managedBaseInput;
    }

    ArrayList<String> filterBase(ArrayList<String> managedBaseInput) {// 최대 3개 선택 가능
        int baseInputSize = managedBaseInput.size();
        ArrayList<String> filteredBases = new ArrayList<>(); // 중간 결과값
        ArrayList<String> filteredResult = new ArrayList<>(); // 중복제거한 최종 결과값
        if (baseInputSize == 0) {
            return filteredResult;
        }
        ArrayList<String> allSignaturesNSeasons = model.allSignaturesNSeasons;
        int allSignaturesNSeasonsSize = allSignaturesNSeasons.size();
        for (int i = 0; i < baseInputSize; i++) { // for1. 선택 베이스목록 각각에 대해..
            String aBaseInput = managedBaseInput.get(i);
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
        for (int k = 0; k < filteredBases.size(); k++) { // 중복제거
            String filteredBase = filteredBases.get(k);
            if (!filteredResult.contains(filteredBase)) {
                filteredResult.add(filteredBase);
            }
        }
        return filteredResult;
    }

    ArrayList<String> manageToppingInput(String toppingInputNum){
        String[] toppingInputNumArr = toppingInputNum.split(",");
        ArrayList<String> managedToppingInput = new ArrayList<>(); // 최종 결과값(선택+하위값)
        if (toppingInputNumArr[0].equals("")) { // 입력 없으면 값 없이 반환
            System.out.println("토핑 입력 없음");
            return managedToppingInput;
        }
        for (int i = 0; i < toppingInputNumArr.length; i++) { // 숫자배열의 0번째부터.
            int toTransfer = Integer.parseInt(toppingInputNumArr[i]); // 0, 1, 2..번쨰 (Str->Int)
            String transfered = model.toppings[toTransfer - 1]; //
            managedToppingInput.add(transfered);
            // 하위카테고리
            String topping2Str = model.allToppings.get(transfered); // 선택한토핑 1개가 키인 값(하위카테고리)
            if (topping2Str == "") continue; // 하위카테고리 없으면 스킵
            System.out.println(transfered + "의 하위카테고리는 " + topping2Str);
            String[] topping2Arr = topping2Str.split(",");
            for(int j = 0; j < topping2Arr.length; j++) {
                managedToppingInput.add(topping2Arr[j]);
            }
        }
        return managedToppingInput;
    }

    ArrayList<String> filterTopping(ArrayList<String> managedToppingInput) { // 최대 2개
        int toppingInputSize = managedToppingInput.size();
        ArrayList<String> filteredToppings = new ArrayList<>(); // 중간 결과값
        ArrayList<String> filteredResult = new ArrayList<>(); // 중복제거한 최종 결과값
        if (toppingInputSize == 0) {
            return filteredResult;
        }
        ArrayList<String> allSignaturesNSeasons = model.allSignaturesNSeasons;
        int allSignaturesNSeasonsSize = allSignaturesNSeasons.size();
        for (int i = 0; i < toppingInputSize; i++) { // for1. 선택 토핑목록 각각에 대해..
            String aToppingInput = managedToppingInput.get(i);
            // if (aToppingInput == null) break;
            for (int j = 0; j < allSignaturesNSeasonsSize; j++) { // for2. 시그니처/시즌에서 각 토핑과 일치하는 플레이버 찾기
                String aSignatureOrSeason = allSignaturesNSeasons.get(j);
                String comparedTopping = aSignatureOrSeason.split("/")[4]; // 토핑은 인덱스4
                if (comparedTopping.contains(aToppingInput)) {
                    String result = aSignatureOrSeason.split("/")[1]; // 플레이버명은 인덱스1
                    filteredToppings.add(result);
                    // System.out.println(result);
                }
            }
        }
        for (int k = 0; k < filteredToppings.size(); k++) { // 중복제거
            String filteredTopping = filteredToppings.get(k);
            if (!filteredResult.contains(filteredTopping)) {
                filteredResult.add(filteredTopping);
            }
        }
        return filteredResult;
    }

    ArrayList<String> manageSyrupInput(String syrupInputNum){
        String[] syrupInputNumArr = syrupInputNum.split(",");
        ArrayList<String> managedSyrupInput = new ArrayList<>(); // 최종 결과값(선택+하위값)
        if (syrupInputNumArr[0].equals("")) { // 입력 없으면 값 없이 반환
            System.out.println("시럽 입력 없음");
            return managedSyrupInput;
        }
        for (int i = 0; i < syrupInputNumArr.length; i++) { // 숫자배열의 0번째부터.
            int toTransfer = Integer.parseInt(syrupInputNumArr[i]); // 0, 1, 2..번쨰 (Str->Int)
            String transfered = model.syrups[toTransfer - 1]; //
            managedSyrupInput.add(transfered);
            // 하위카테고리
            String syrup2Str = model.allSyrups.get(transfered); // 선택한토핑 1개가 키인 값(하위카테고리)
            if (syrup2Str == "") continue; // 하위카테고리 없으면 스킵
            System.out.println(transfered + "의 하위카테고리는 " + syrup2Str);
            String[] syrup2Arr = syrup2Str.split(",");
            for(int j = 0; j < syrup2Arr.length; j++) {
                managedSyrupInput.add(syrup2Arr[j]);
            }
        }
        return managedSyrupInput;
    }

    ArrayList<String> filterSyrup(ArrayList<String> managedSyrupInput) { // 최대 1개
        int syrupInputSize = managedSyrupInput.size();
        ArrayList<String> filteredSyrups = new ArrayList<>(); // 중간 결과값
        ArrayList<String> filteredResult = new ArrayList<>(); // 중복제거한 최종 결과값
        if (syrupInputSize == 0) {
            return filteredResult;
        }
        ArrayList<String> allSignaturesNSeasons = model.allSignaturesNSeasons;
        int allSignaturesNSeasonsSize = allSignaturesNSeasons.size();
        for (int i = 0; i < syrupInputSize; i++) { // for1. 선택 시럽목록 각각에 대해..
            String aSyrupInput = managedSyrupInput.get(i);
            // if (aSyrupInput == null) break;
            for (int j = 0; j < allSignaturesNSeasonsSize; j++) { // for2. 시그니처/시즌에서 각 시럽과 일치하는 플레이버 찾기
                String aSignatureOrSeason = allSignaturesNSeasons.get(j);
                String comparedSyrup = aSignatureOrSeason.split("/")[5]; // 시럽은 인덱스5
                if (comparedSyrup.contains(aSyrupInput)) {
                    String result = aSignatureOrSeason.split("/")[1]; // 플레이버명은 인덱스1
                    filteredSyrups.add(result);
                    // System.out.println(result);
                }
            }
        }
        for (int k = 0; k < filteredSyrups.size(); k++) { // 중복제거
            String filteredSyrup = filteredSyrups.get(k);
            if (!filteredResult.contains(filteredSyrup)) {
                filteredResult.add(filteredSyrup);
            }
        }
        return filteredResult;
    }

    void filterResult(ArrayList<String> baseResult, ArrayList<String> toppingResult, ArrayList<String> syrupResult) { // filterBase, filterTopping, filterSyrup의 교집합 보여주기
        ArrayList<String> filteredBaseToppingSyrup = new ArrayList<>();
        System.out.println("베이스필터링결과 " + baseResult.size());
        System.out.println("토핑필터링결과 " + toppingResult.size());
        System.out.println("시럽필터링결과 " + syrupResult.size());
        filteredBaseToppingSyrup.addAll(baseResult);
        filteredBaseToppingSyrup.addAll(toppingResult);
        filteredBaseToppingSyrup.addAll(syrupResult);
        System.out.println("filteredBaseToppingSyrup 갯수 " + filteredBaseToppingSyrup.size());
        ArrayList<String> matchedAll = new ArrayList<>(); // 베이스,토핑,시럽 교집합인 결과값
        ArrayList<String> finalResult = new ArrayList<>(); // 중복제거된 최종 결과값
        for (int i = 0; i < filteredBaseToppingSyrup.size(); i++) { // 교집합 추출
            String isMatched = filteredBaseToppingSyrup.get(i);
            if (baseResult.contains(isMatched) && toppingResult.contains(isMatched) && syrupResult.contains(isMatched)) { // 베이스 토핑 시럽 결과값에 모두 존재하면
                matchedAll.add(isMatched);
            }
        }
        System.out.println("matchedAll 갯수 " + matchedAll.size());
        for (int i = 0; i < matchedAll.size(); i++) {
            String isDuplicated = matchedAll.get(i);
            if (! finalResult.contains(isDuplicated)) {
                finalResult.add(isDuplicated);
            }
        }
        System.out.println("finalResult 갯수 " + finalResult.size());
        //// 최종출력 ) 출력부분은 View로 옮기기
        int finalResultSize = finalResult.size();
        System.out.println("총 " + finalResultSize + "개의 플레이버가 검색되었습니다.");
        for (int i = 0; i < finalResultSize; i++) {
            System.out.print(finalResult.get(i));
            if (i == finalResultSize - 1) continue; // 맨 끝에는 쉼표 생략
            System.out.print(",");
            if ((i + 1) % 5 == 0) System.out.println(""); // 5항목 출력 후 개행
        }

        System.out.println("\n검색이 완료되었습니다.");
    }
}

