package mission6.awtcomponent;

import java.awt.*;

public class CanvasTest {
    public static void main(String[] args) {
        Frame f = new Frame("CanvasTest");
        f.setSize(300, 200);
        f.setLayout(null); // Frame의 LayoutManager 설정 해제

        Canvas c = new Canvas();
        c.setBackground(Color.pink); // 캔버스 배경 = 분홍색
        c.setBounds(50, 50, 150, 100); // 위치(x축/y축), 너비, 높이

        f.add(c);
        f.setVisible(true);
    }
}
