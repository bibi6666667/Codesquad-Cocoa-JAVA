package mission6.awtcomponent;

import java.awt.*;

public class ButtonTest2 {
    public static void main(String[] args) {
        Frame f = new Frame("Login");
        f.setSize(300, 200);
        f.setLayout(null); // 레이아웃매니저의 설정을 해제한다.

        Button b = new Button("확 인");
        b.setSize(100,50);
        b.setLocation(100,75); // Frame내에서 Button의 위치 설정

        f.add(b);
        f.setVisible(true);
    }
}
