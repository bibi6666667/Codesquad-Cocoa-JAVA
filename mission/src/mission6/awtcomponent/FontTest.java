package mission6.awtcomponent;

import java.awt.*;

public class FontTest {
    public static void main(String[] args) {
        Frame f = new Frame("Font Test");
        String abc = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        Label abc1 = new Label(abc);
        Label abc2 = new Label(abc);
        Label abc3 = new Label(abc);
        Label abc4 = new Label(abc);
        Label abc5 = new Label(abc);

        // Font를 설정
        Font f1 = new Font("Serif", Font.PLAIN, 20); // 보통체
        Font f2 = new Font("Serif", Font.ITALIC, 20); // 기울임체
        Font f3 = new Font("Serif", Font.BOLD, 20); // 굵은체
        Font f4 = new Font("Serif", Font.BOLD+Font.ITALIC, 20); // 굵은 기울임체

        // 설정한 Font를 Label에 적용
        abc1.setFont(f1);
        abc2.setFont(f2);
        abc3.setFont(f3);
        abc4.setFont(f4);

        f.setLayout(new FlowLayout());
        f.add(abc1);
        f.add(abc2);
        f.add(abc3);
        f.add(abc4);
        f.add(abc5); // 폰트를 지정해 주지 않으면, 자신이 포함된 컨테이너의 기본설정을 따른다.

        f.setSize(400, 200);
        f.setVisible(true);
    }
}
