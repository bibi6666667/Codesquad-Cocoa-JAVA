package mission6.awtcomponent;

import java.awt.*;

public class DialogTest {
    public static void main(String[] args) {
        Frame f = new Frame("Parent");
        f.setSize(300, 200);

        // parent Frame을 f, modal을 true(필수응답 Dialog)
        Dialog info = new Dialog(f, "Information", true);
        info.setSize(140, 90);
        info.setLocation(50,50); // parent Frame이 아닌, 화면이 위치기준이 됨.
        info.setLayout(new FlowLayout());
        // Dialog의 기본 레아이웃 매니저는 BorderLayout이기 떄문에 FlowLayout로 변경.

        Label msg = new Label("This is modal Dialog", Label.CENTER);
        Button ok = new Button("ok");
        info.add(msg);
        info.add(ok);

        f.setVisible(true); // Frame을 보이게 한 다음,
        info.setVisible(true); // Dialog를 보이게 한다.
    }
}
