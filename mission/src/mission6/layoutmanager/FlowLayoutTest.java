package mission6.layoutmanager;

import java.awt.*;

public class FlowLayoutTest {
    public static void main(String[] args) {
        Frame f = new Frame("FlowLayoutTest");
        f.setSize(250, 100);
        f.setLayout(new FlowLayout(FlowLayout.LEFT)); // 왼쪽정렬의  FlowLayout 생성

        f.add(new Button("첫번째"));
        f.add(new Button("두번째"));
        f.add(new Button("세번째"));
        f.add(new Button("네번째"));
        f.add(new Button("다섯번째"));
        f.setVisible(true);
    }
}
