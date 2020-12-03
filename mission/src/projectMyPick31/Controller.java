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
                String[] managedBaseInput = manageBaseInput(baseInput);
                ArrayList<String> filteredBaseResult = filterBase(managedBaseInput);
                String[] managedToppingInput = manageToppingInput(toppingInput);
                ArrayList<String> filteredToppingResult = filterTopping(managedToppingInput);
                String[] managedSyrupInput = manageSyrupInput(syrupInput);
                ArrayList<String> filteredSyrupResult = filterSyrup(managedSyrupInput);
                filterResult(filteredBaseResult, filteredToppingResult, filteredSyrupResult);
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
                view.printSignatures(model.allSignatures);
                view.returnHome();
                home();
                break;
            case 2:
                view.printSeasons(model.allSeasons);
                view.returnHome();
                home();
                break;
            default:
                view.inputAgain();
                view.printWhat();
                break;
        }
    }

    String[] manageBaseInput(String baseInputNum) {
        String[] baseInputNumArr = baseInputNum.split(",");
        String[] managedBaseInputAB = new String[2]; // 최종결과값(선택A값+선택A하위값+선택B값+선택B하위값)
        String managedBaseInputA = "";
        String managedBaseInputB = "";
        if (baseInputNumArr[0].equals("")) { // 입력 없으면 값 없이 반환
            return managedBaseInputAB;
        }
        for (int i = 0; i < baseInputNumArr.length; i++) { // 숫자배열의 0번째부터.
            int toTransfer = Integer.parseInt(baseInputNumArr[i]); // 0, 1, 2..번쨰 (Str->Int)
            String transfered = model.bases[toTransfer - 1]; //
            if (i == 0) {
                managedBaseInputA += transfered; // 첫번쨰 상위 베이스를 A에 넣기.
            } else {
                managedBaseInputB += transfered; // 나머지 상위베이스는 B에 넣기.
            }
            // 하위카테고리
            String subBaseStr = model.allBases.get(transfered); // 선택한베이스1개가 키인 값(하위카테고리)
            if (subBaseStr == "") continue; // 하위카테고리 없으면 다음 베이스로.
            String[] subBaseArr = subBaseStr.split(",");
            for (int j = 0; j < subBaseArr.length; j++) {
                if (i == 0) {
                    managedBaseInputA += ("," + subBaseArr[j]); // 첫 번째의 하위베이스를 A에 함께 이어붙이기.
                } else {
                    managedBaseInputB += ("," + subBaseArr[j]); // 나머지 하위베이스는 B에 함께 이어붙이기.
                }
            }
        }
        managedBaseInputAB[0] = managedBaseInputA;
        managedBaseInputAB[1] = managedBaseInputB;
        return managedBaseInputAB;
    }

    ArrayList<String> filterBase(String[] managedBaseInput) {// 베이스와 그 하위카테고리들.
        ArrayList<String> filteredFlavors = new ArrayList<>(); // 중간 결과값 (베이스A,B,A하위,B하위 전체)
        ArrayList<String> matchedFlavor = new ArrayList<>(); // 교집합 결과값 (베이스A,A하위와  베이스B,B하위의 교집합)
        ArrayList<String> finalResult = new ArrayList<>(); // 중복제거한 최종 결과값
        if (managedBaseInput[0] == null) { // 값 없으면 종료
            return finalResult;
        }
        ArrayList<String> allSignaturesNSeasons = model.allSignaturesNSeasons;
        int allSignaturesNSeasonsSize = allSignaturesNSeasons.size();
        String baseNSubBaseA = managedBaseInput[0]; //
        String[] baseNSubBaseAArr = baseNSubBaseA.split(",");
        String baseNSubBaseB = managedBaseInput[1];
        String[] baseNSubBaseBArr = baseNSubBaseB.split(",");
        String[] allBaseNSubBase = new String[baseNSubBaseAArr.length + baseNSubBaseBArr.length];
        System.arraycopy(baseNSubBaseAArr, 0, allBaseNSubBase, 0, baseNSubBaseAArr.length);
        System.arraycopy(baseNSubBaseBArr, 0, allBaseNSubBase, baseNSubBaseAArr.length, baseNSubBaseBArr.length);
        // 중간결과값 필터링
        for (int i = 0; i < allBaseNSubBase.length; i++) { // for1. 선택 베이스&하위베이스 목록 각각에 대해..
            String aBaseNSubBase = allBaseNSubBase[i];
            for (int j = 0; j < allSignaturesNSeasonsSize; j++) { // for2. 시그니처/시즌에서 각 베이스가 들어있는 플레이버 찾기
                String aSignatureNSeason = allSignaturesNSeasons.get(j);
                String comparedBase = aSignatureNSeason.split("/")[3]; // 베이스는 인덱스3
                if (comparedBase.contains(aBaseNSubBase)) {
                    filteredFlavors.add(aSignatureNSeason);
                }
            }
        }
        // 교집합 찾기 : 베이스 A,B 선택했으면 A,B 모두 들어있는 플레이버 가져와야.
        // if filteredBases의 항목 하나가 베이스A또는베이스A하위와, 베이스B또는베이스B하위를 포함하고 있을 때만 filteredResult에 넣는다.
        ArrayList<String> tempMatched = new ArrayList<>(); // A나A하위만 포함하는 임시컬렉션
        for (int i = 0; i < filteredFlavors.size(); i++) {
            String aFilteredFlavor = filteredFlavors.get(i);
            String comparedBase = aFilteredFlavor.split("/")[3]; // 베이스는 인덱스3
            for (int j = 0; j < baseNSubBaseAArr.length; j++) { // baseNSubBaseA 다 돌 때까지
                if (comparedBase.contains(baseNSubBaseAArr[j])) { // A나A하위 포함하면 전체 정보를 temp에 담기
                    tempMatched.add(aFilteredFlavor);
                }
            }
        }
        for (int i = 0; i < tempMatched.size(); i++) {
            String tempFlavor = tempMatched.get(i);
            String tempBase = tempFlavor.split("/")[3]; // 베이스는 인덱스3
            for (int j = 0; j < baseNSubBaseBArr.length; j++) {
                if (tempBase.contains(baseNSubBaseBArr[j])) { // temp가 B나B하위도 포함하면 플레이버명을 matchedName에 담기
                    String matchedName = tempFlavor.split("/")[1]; // 플레이버명은 인덱스1
                    matchedFlavor.add(matchedName);
                }
            }
        }
        // 교집합 후 중복제거
        for (int i = 0; i < matchedFlavor.size(); i++) {
            String aMatchedFlavor = matchedFlavor.get(i);
            if (!finalResult.contains(aMatchedFlavor)) {
                finalResult.add(aMatchedFlavor);
            }
        }
        return finalResult;
    }

    String[] manageToppingInput(String toppingInputNum) {
        String[] toppingInputNumArr = toppingInputNum.split(",");
        String[] managedToppingInputAB = new String[2]; // 최종결과값(선택A값+선택A하위값+선택B값+선택B하위값)
        String managedToppingInputA = "";
        String managedToppingInputB = "";
        if (toppingInputNumArr[0].equals("")) { // 입력 없으면 값 없이 반환
            return managedToppingInputAB;
        }
        for (int i = 0; i < toppingInputNumArr.length; i++) { // 숫자배열의 0번째부터.
            int toTransfer = Integer.parseInt(toppingInputNumArr[i]); // 0, 1, 2..번쨰 (Str->Int)
            String transfered = model.toppings[toTransfer - 1]; //
            if (i == 0) {
                managedToppingInputA += transfered; // 첫번쨰 상위 토핑을 A에 넣기.
            } else {
                managedToppingInputB += transfered; // 나머지 상위토핑은 B에 넣기.
            }
            // 하위카테고리
            String subToppingStr = model.allToppings.get(transfered); // 선택한베이스1개가 키인 값(하위카테고리)
            if (subToppingStr == "") continue; // 하위카테고리 없으면 다음 베이스로.
            String[] subToppingArr = subToppingStr.split(",");
            for (int j = 0; j < subToppingArr.length; j++) {
                if (i == 0) {
                    managedToppingInputA += ("," + subToppingArr[j]); // 첫 번째의 하위베이스를 A에 함께 이어붙이기.
                } else {
                    managedToppingInputB += ("," + subToppingArr[j]); // 나머지 하위베이스는 B에 함께 이어붙이기.
                }
            }
        }
        managedToppingInputAB[0] = managedToppingInputA;
        managedToppingInputAB[1] = managedToppingInputB;
        return managedToppingInputAB;
    }

    ArrayList<String> filterTopping(String[] managedToppingInput) { // 최대 2개
        ArrayList<String> filteredFlavors = new ArrayList<>(); // 중간 결과값 (베이스A,B,A하위,B하위 전체)
        ArrayList<String> matchedFlavor = new ArrayList<>(); // 교집합 결과값 (베이스A,A하위와  베이스B,B하위의 교집합)
        ArrayList<String> finalResult = new ArrayList<>(); // 중복제거한 최종 결과값
        if (managedToppingInput[0] == null) { // 값 없으면 종료
            return finalResult;
        }
        ArrayList<String> allSignaturesNSeasons = model.allSignaturesNSeasons;
        int allSignaturesNSeasonsSize = allSignaturesNSeasons.size();
        String toppingNSubToppingA = managedToppingInput[0]; //
        String[] toppingNSubToppingAArr = toppingNSubToppingA.split(",");
        String toppingNSubToppingB = managedToppingInput[1];
        String[] toppingNSubToppingBArr = toppingNSubToppingB.split(",");
        String[] allToppingNSubTopping = new String[toppingNSubToppingAArr.length + toppingNSubToppingBArr.length];
        System.arraycopy(toppingNSubToppingAArr, 0, allToppingNSubTopping, 0, toppingNSubToppingAArr.length);
        System.arraycopy(toppingNSubToppingBArr, 0, allToppingNSubTopping, toppingNSubToppingAArr.length, toppingNSubToppingBArr.length);
        // 중간결과값 필터링
        for (int i = 0; i < allToppingNSubTopping.length; i++) { // for1. 선택 토핑&하위토핑 목록 각각에 대해..
            String aToppingNSubTopping = allToppingNSubTopping[i];
            for (int j = 0; j < allSignaturesNSeasonsSize; j++) { // for2. 시그니처/시즌에서 각 토핑이 들어있는 플레이버 찾기
                String aSignatureNSeason = allSignaturesNSeasons.get(j);
                String comparedTopping = aSignatureNSeason.split("/")[4]; // 토핑은 인덱스4
                if (comparedTopping.contains(aToppingNSubTopping)) {
                    filteredFlavors.add(aSignatureNSeason);
                }
            }
        }
        // 교집합 찾기 : 토핑 A,B 선택했으면 A,B 모두 들어있는 플레이버 가져와야.
        // if filteredBases의 항목 하나가 토핑A또는토핑A하위와, 토핑B또는토핑B하위를 포함하고 있을 때만 filteredResult에 넣는다.
        ArrayList<String> tempMatched = new ArrayList<>(); // A나A하위만 포함하는 임시컬렉션
        for (int i = 0; i < filteredFlavors.size(); i++) {
            String aFilteredFlavor = filteredFlavors.get(i);
            String comparedTopping = aFilteredFlavor.split("/")[4]; // 토핑은 인덱스4
            for (int j = 0; j < toppingNSubToppingAArr.length; j++) { // toppingNSubToppingA 다 돌 때까지
                if (comparedTopping.contains(toppingNSubToppingAArr[j])) { // A나A하위 포함하면 전체 정보를 temp에 담기
                    tempMatched.add(aFilteredFlavor);
                }
            }
        }
        for (int i = 0; i < tempMatched.size(); i++) {
            String tempFlavor = tempMatched.get(i);
            String tempTopping = tempFlavor.split("/")[4]; // 토핑은 인덱스4
            for (int j = 0; j < toppingNSubToppingBArr.length; j++) {
                if (tempTopping.contains(toppingNSubToppingBArr[j])) { // temp가 B나B하위도 포함하면 플레이버명을 matchedName에 담기
                    String matchedName = tempFlavor.split("/")[1]; // 플레이버명은 인덱스1
                    matchedFlavor.add(matchedName);
                }
            }
        }
        // 교집합 후 중복제거
        for (int i = 0; i < matchedFlavor.size(); i++) {
            String aMatchedFlavor = matchedFlavor.get(i);
            if (!finalResult.contains(aMatchedFlavor)) {
                finalResult.add(aMatchedFlavor);
            }
        }
        return finalResult;
    }

    String[] manageSyrupInput(String syrupInputNum) {
        String[] syrupInputNumArr = syrupInputNum.split(",");
        String[] managedSyrupInputAB = new String[2]; // 최종결과값(선택A값+선택A하위값+선택B값+선택B하위값)
        String managedSyrupInputA = "";
        String managedSyrupInputB = "";
        if (syrupInputNumArr[0].equals("")) { // 입력 없으면 값 없이 반환
            return managedSyrupInputAB;
        }
        for (int i = 0; i < syrupInputNumArr.length; i++) { // 숫자배열의 0번째부터.
            int toTransfer = Integer.parseInt(syrupInputNumArr[i]); // 0, 1, 2..번쨰 (Str->Int)
            String transfered = model.syrups[toTransfer - 1]; //
            if (i == 0) {
                managedSyrupInputA += transfered; // 첫번쨰 상위 시럽을 A에 넣기.
            } else {
                managedSyrupInputB += transfered; // 나머지 상위시럽은 B에 넣기.
            }
            // 하위카테고리
            String subSyrupStr = model.allSyrups.get(transfered); // 선택한시럽1개가 키인 값(하위카테고리)
            if (subSyrupStr == "") continue; // 하위카테고리 없으면 다음 시럽으로.
            String[] subSyrupArr = subSyrupStr.split(",");
            for (int j = 0; j < subSyrupArr.length; j++) {
                if (i == 0) {
                    managedSyrupInputA += ("," + subSyrupArr[j]); // 첫 번째의 하위시럽을 A에 함께 이어붙이기.
                } else {
                    managedSyrupInputB += ("," + subSyrupArr[j]); // 나머지 하위시럽은 B에 함께 이어붙이기.
                }
            }
        }
        managedSyrupInputAB[0] = managedSyrupInputA;
        managedSyrupInputAB[1] = managedSyrupInputB;
        return managedSyrupInputAB;
    }

    ArrayList<String> filterSyrup(String[] managedSyrupInput) { // 최대 1개
        ArrayList<String> filteredFlavors = new ArrayList<>(); // 중간 결과값 (시럽A,B,A하위,B하위 전체)
        ArrayList<String> matchedFlavor = new ArrayList<>(); // 교집합 결과값 (시럽A,A하위와  시럽B,B하위의 교집합)
        ArrayList<String> finalResult = new ArrayList<>(); // 중복제거한 최종 결과값
        if (managedSyrupInput[0] == null) { // 값 없으면 종료
            return finalResult;
        }
        ArrayList<String> allSignaturesNSeasons = model.allSignaturesNSeasons;
        int allSignaturesNSeasonsSize = allSignaturesNSeasons.size();
        String syrupNSubSyrupA = managedSyrupInput[0]; //
        String[] syrupNSubSyrupAArr = syrupNSubSyrupA.split(",");
        String syrupNSubSyrupB = managedSyrupInput[1];
        String[] syrupNSubSyrupBArr = syrupNSubSyrupB.split(",");
        String[] allSyrupNSubSyrup = new String[syrupNSubSyrupAArr.length + syrupNSubSyrupBArr.length];
        System.arraycopy(syrupNSubSyrupAArr, 0, allSyrupNSubSyrup, 0, syrupNSubSyrupAArr.length);
        System.arraycopy(syrupNSubSyrupBArr, 0, allSyrupNSubSyrup, syrupNSubSyrupAArr.length, syrupNSubSyrupBArr.length);
        // 중간결과값 필터링
        for (int i = 0; i < allSyrupNSubSyrup.length; i++) { // for1. 선택 시럽&하위시럽 목록 각각에 대해..
            String aSyrupNSubSyrup = allSyrupNSubSyrup[i];
            for (int j = 0; j < allSignaturesNSeasonsSize; j++) { // for2. 시그니처/시즌에서 각 시럽이 들어있는 플레이버 찾기
                String aSignatureNSeason = allSignaturesNSeasons.get(j);
                String comparedSyrup = aSignatureNSeason.split("/")[5]; // 시럽은 인덱스5
                if (comparedSyrup.contains(aSyrupNSubSyrup)) {
                    filteredFlavors.add(aSignatureNSeason);
                }
            }
        }
        // 교집합 찾기 : 시럽 A,B 선택했으면 A,B 모두 들어있는 플레이버 가져와야.
        // if filteredBases의 항목 하나가 시럽A또는시럽A하위와, 시럽B또는시럽B하위를 포함하고 있을 때만 filteredResult에 넣는다.
        ArrayList<String> tempMatched = new ArrayList<>(); // A나A하위만 포함하는 임시컬렉션
        for (int i = 0; i < filteredFlavors.size(); i++) {
            String aFilteredFlavor = filteredFlavors.get(i);
            String comparedSyrup = aFilteredFlavor.split("/")[5]; // 시럽은 인덱스5
            for (int j = 0; j < syrupNSubSyrupAArr.length; j++) { // syrupNSubSyrupA 다 돌 때까지
                if (comparedSyrup.contains(syrupNSubSyrupAArr[j])) { // A나A하위 포함하면 전체 정보를 temp에 담기
                    tempMatched.add(aFilteredFlavor);
                }
            }
        }
        for (int i = 0; i < tempMatched.size(); i++) {
            String tempFlavor = tempMatched.get(i);
            String tempSyrup = tempFlavor.split("/")[5]; // 시럽은 인덱스 5
            for (int j = 0; j < syrupNSubSyrupBArr.length; j++) {
                if (tempSyrup.contains(syrupNSubSyrupBArr[j])) { // temp가 B나B하위도 포함하면 플레이버명을 matchedName에 담기
                    String matchedName = tempFlavor.split("/")[1]; // 플레이버명은 인덱스1
                    matchedFlavor.add(matchedName);
                }
            }
        }
        // 교집합 후 중복제거
        for (int i = 0; i < matchedFlavor.size(); i++) {
            String aMatchedFlavor = matchedFlavor.get(i);
            if (!finalResult.contains(aMatchedFlavor)) {
                finalResult.add(aMatchedFlavor);
            }
        }
        return finalResult;
    }

    void filterResult
            (ArrayList<String> baseResult, ArrayList<String> toppingResult, ArrayList<String> syrupResult) { // filterBase, filterTopping, filterSyrup의 교집합 보여주기
        ArrayList<String> filteredBaseToppingSyrup = new ArrayList<>();
        System.out.println("베이스필터링결과 " + baseResult.size());
        System.out.println("토핑필터링결과 " + toppingResult.size());
        System.out.println("시럽필터링결과 " + syrupResult.size());
        filteredBaseToppingSyrup.addAll(baseResult);
        filteredBaseToppingSyrup.addAll(toppingResult);
        filteredBaseToppingSyrup.addAll(syrupResult);
        ArrayList<String> matchedAll = new ArrayList<>(); // 베이스,토핑,시럽 교집합인 결과값
        ArrayList<String> finalResult = new ArrayList<>(); // 중복제거된 최종 결과값
        int baseResultSize = baseResult.size();
        int toppingResultSize = toppingResult.size();
        int syrupResultSize = syrupResult.size();
        // 교집합) 베이스,토핑,시럽 중 몇개 선택했는지 판단
        int choosedNum = 0;
        if (baseResultSize != 0 && toppingResultSize != 0 && syrupResultSize != 0) {
            choosedNum = 3; // 베이스, 토핑, 시럽 모두 선택
        } else if (baseResultSize != 0 && toppingResultSize != 0
                || toppingResultSize != 0 && syrupResultSize != 0
                || baseResultSize != 0 && syrupResultSize != 0) {
            choosedNum = 2; // 베이스,토핑,시럽 중 2개 선택
        } else if (baseResultSize != 0 && toppingResultSize == 0 && syrupResultSize == 0
                || baseResultSize == 0 && toppingResultSize != 0 && syrupResultSize == 0
                || baseResultSize == 0 && toppingResultSize == 0 && syrupResultSize != 0) {
            choosedNum = 1;
        }
        switch (choosedNum) {
            case 1:
                for (int i = 0; i < filteredBaseToppingSyrup.size(); i++) { // 교집합 추출
                    String isMatched = filteredBaseToppingSyrup.get(i);
                    matchedAll.add(isMatched); // 1개만 선택했다면 그 결과가 최종결과와 같다.
                }
                break;
            case 2:
                for (int i = 0; i < filteredBaseToppingSyrup.size(); i++) { // 교집합 추출
                    String isMatched = filteredBaseToppingSyrup.get(i);
                    if (baseResult.contains(isMatched) && toppingResult.contains(isMatched)
                            || toppingResult.contains(isMatched) && syrupResult.contains(isMatched)
                            || baseResult.contains(isMatched) && syrupResult.contains(isMatched)) { // 베이스 토핑 시럽 결과값에 모두 존재하면
                        matchedAll.add(isMatched);
                    }
                }
                break;
            case 3:
                for (int i = 0; i < filteredBaseToppingSyrup.size(); i++) { // 교집합 추출
                    String isMatched = filteredBaseToppingSyrup.get(i);
                    if (baseResult.contains(isMatched) && toppingResult.contains(isMatched) && syrupResult.contains(isMatched)) { // 베이스 토핑 시럽 결과값에 모두 존재하면
                        matchedAll.add(isMatched);
                    }
                }
                break;
            default:
                System.out.println("선택 오류");
                break;
        }

        // 중복제거
        for (int i = 0; i < matchedAll.size(); i++) {
            String isDuplicated = matchedAll.get(i);
            if (!finalResult.contains(isDuplicated)) {
                finalResult.add(isDuplicated);
            }
        }
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

