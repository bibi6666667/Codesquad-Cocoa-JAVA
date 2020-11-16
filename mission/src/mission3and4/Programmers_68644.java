package mission3and4;

public class Programmers_68644 {
    public static void main(String[] args) {
        Programmers_68644 p = new Programmers_68644();
        int[] sample = {2,1,3,4,1};
        p.solution(sample);
    }

    public int[] solution(int[] numbers) {
        int[] answer = {};
        // i랑 i+1랑 더하기
        for (int i = 0; i < numbers.length; i++) {
            int result = numbers[i] + numbers[i+1];
            //중복제거
            for(int j =0; j < answer.length; j++) {
                if (answer[i] == result) {

                }
            }
        }
        return answer;
    }
}
