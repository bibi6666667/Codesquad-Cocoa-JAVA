package mission3and4;

public class Programmers_12928 {
    public static void main (String[] args) {
        Programmers_12928 p = new Programmers_12928();
        p.solution(12); // n = 12일 때 answer = 28
    }

    public int solution(int n) {
        int answer = 0;
        for (int i = 1; i <= n ; i++) {
            if (n % i == 0) {
                answer += i;
                System.out.println(answer);
            }
        }
        return answer;
    }

}



