package mission6.awtcomponent;

import java.awt.*;

public class TextFieldTest {
    public static void main(String[] args) {
        Frame f = new Frame("Login");
        f.setSize(400,65);
        // 레이아웃매니저를 FlowLayout로 한다.
        f.setLayout(new FlowLayout());

        Label lid = new Label("ID : ", Label.RIGHT); // 오른쪽 정렬
        Label lpwd = new Label("Password : ", Label.RIGHT);

        TextField id = new TextField(10); // 10글자를 입력할 수 이는 크기로 생성
        TextField pwd = new TextField(10); // 10글자를 입력할 수 이는 크기로 생성
        pwd.setEchoChar('*'); // 입력한 값 대신 *가 보이게 한다.
        // 한 글자이므로 홑따옴표를 사용해야 한다.

        f.add(lid);
        f.add(id);
        f.add(lpwd);
        f.add(pwd);
        f.setVisible(true);

    }
}
