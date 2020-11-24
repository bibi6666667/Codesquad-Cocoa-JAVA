package mission6.awtcomponent;

import java.awt.*;

public class ScrollPaneTest {
    public static void main(String[] args) {
        Frame f = new Frame("ScrollPaneTest");
        f.setSize(300, 200);

        ScrollPane sp = new ScrollPane();
        Panel p = new Panel();
        p.setBackground(Color.green);
        p.add(new Button("첫번째")); // Button들을 Panel에 포함시킨다.
        p.add(new Button("두번째"));
        p.add(new Button("세번째"));
        p.add(new Button("네번쨰"));

        sp.add(p); // Panel을 ScrollPane에 포함시킨다
        f.add(sp); // ScrollPane을 Frame에 포함시킨다
        f.setVisible(true);
    }
}
