package mission6.awtcomponent;

import java.awt.*;

public class PanelTest {
    public static void main(String[] args) {
        Frame f = new Frame("Panel");
        f.setSize(300,200);
        f.setLayout(null); // Frame이 LayoutManager를 사용하지 않게 한다.

        Panel p = new Panel(); // Panel은 LayoutManager를 사용 - Panel안의 버튼 위치,크기는 자동배치.
        p.setBackground(Color.green);
        p.setSize(100, 100);
        p.setLocation(50, 50);

        Button ok = new Button("OK");

        p.add(ok); // Button은 Panel에 포함시킨다.
        f.add(p); // Panel은 Frame에 포함시킨다.
        f.setVisible(true);

    }
}
