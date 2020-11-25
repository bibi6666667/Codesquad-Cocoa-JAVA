package mission6.event;

import java.awt.*;
import java.awt.event.*;

public class CheckboxEventTest2 extends Frame { // Frame클래스 상속받아오기
    CheckboxGroup group;
    Checkbox cb1;
    Checkbox cb2;
    Checkbox cb3;

    CheckboxEventTest2 (String title) { // 생성자
        super(title); // 부모 클래스인 Frame의 생성자 호출
        group = new CheckboxGroup();
        cb1 = new Checkbox("red", group, true); // 기본 체크 상태
        cb2 = new Checkbox("green", group, false);
        cb3 = new Checkbox("blue", group, false);

        cb1.addItemListener(new EventHandler());
        cb2.addItemListener(new EventHandler());
        cb3.addItemListener(new EventHandler());

        setLayout(new FlowLayout());
        add(cb1);
        add(cb2);
        add(cb3);
        setBackground(Color.red);
        setSize(300,200);
        setVisible(true);
    }

    public static void main(String[] args) {
        CheckboxEventTest2 mainWin = new CheckboxEventTest2("CheckboxEventTest2");
    }

    class EventHandler implements ItemListener {
        public void itemStateChanged(ItemEvent e) {
            Checkbox cb = (Checkbox)e.getSource();
            String color = cb.getLabel();
            System.out.println(color); // 잘 찍히는지 확인용.
            if(color.equals("red")) {
                setBackground(Color.red);
            } else if (color.equals("green")) {
                setBackground(Color.green);
            } else {
                setBackground(Color.blue);
            }
        }
    }
}
