package mission6;

import java.awt.*;

public class LabelTest {
    public static void main(String[] args) {
        Frame f = new Frame("Login");
        f.setSize(300, 200);
        f.setLayout(null);

        // Label을 생성하고, 크기와 위치 지정.
        Label id = new Label("ID :");
        id.setBounds(50,50, 30,10);
        // 50,50 위치에 가로길이 30, 세로길이 10

        Label pwd = new Label("Password : ");
        pwd.setBounds(50,65, 100,10);

        f.add(id);
        f.add(pwd);
        f.setVisible(true);
    }
}
