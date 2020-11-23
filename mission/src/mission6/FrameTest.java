package mission6;

import java.awt.*;

public class FrameTest {
    public static void main(String[] args) {
        Frame f = new Frame("Login"); // Frame 객체 생성.
        f.setSize(300, 200) ; // Frame의 크기를 설정.
        f.setVisible(true); // 프레임을 화면에 보이게 한다.
        // Frame객체를 생성했다고 화면에 보이는 것이 아니다. 반드시 이 옵션을 추가해주어야 한다.
    }
}
