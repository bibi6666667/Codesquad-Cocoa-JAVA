package mission6;

import java.awt.*;

public class ButtonTest {
    public static void main(String[] args) {
        Frame f = new Frame("Login");
        f.setSize(300,200);

        Button b = new Button("확 인");// "확 인"이라는 글자가 있는 Button 생성
        b.setSize(100,50); // Button의 크기 설정

        f.add(b); // 생성된 Button을 Frame에 포함시킨다.
        f.setVisible(true);
    }
}
