package mission3and4;
// 'txt 파일 출력(데이터 읽어오기)' 테스트용 파일입니다.

import java.io.BufferedReader;
import java.io.FileReader;
// BufferedReader와 FileReader를 조합해 사용하면 txt파일을 한 줄씩 읽을 수 있다.
import java.io.IOException;


public class FileRead {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("c:/out.txt"));
        while (true) { // .txt 파일을 라인 단위로 읽어와서, 라인 단위로 출력.
            String line = bufferedReader.readLine(); // .readline()메소드 : 더 이상 읽을 라인이 없으면 null을 리턴함.
            if (line == null) break; // 더 이상 읽을 라인이 없으면 while문을 빠져나감.
            System.out.println(line);
        }
        bufferedReader.close();
    }
}
