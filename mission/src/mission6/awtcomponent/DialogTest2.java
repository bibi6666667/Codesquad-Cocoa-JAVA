package mission6.awtcomponent;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DialogTest2 {
    public static void main(String[] args) {
        Frame f = new Frame("Parent");
        f.setSize(300, 200);

        // parent Frame을 f, modal을 true(필수응답 Dialog)
        Dialog info = new Dialog(f, "Information", true);
        info.setSize(140, 90);
        info.setLocation(50,50); // parent Frame이 아닌, 화면이 위치기준이 됨.
        info.setLayout(new FlowLayout());

        Label msg = new Label("This is modal Dialog", Label.CENTER);
        Button ok = new Button("ok");

        ok.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //ok버튼을 누르면 수행될 메서드 : Dialog 없애기.
                info.setVisible(false); // Dialog를 안 보이게 한다.(숨김)
                info.dispose(); // Dialog를 메모리에서 없앤다.(삭제)
                // 둘 중 어느 방법을 사용해도 Dialog는 보이지 않게 되며, 부모Frame은 사용가능해진다.
            }
        });

        info.add(msg);
        info.add(ok);

        f.setVisible(true); // Frame을 보이게 한 다음,
        info.setVisible(true); // Dialog를 보이게 한다.
    }
}
