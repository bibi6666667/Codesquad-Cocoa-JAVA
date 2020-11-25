package mission6.event;

import java.awt.*;
import java.awt.event.*;


public class MouseEventTest extends Frame{ // Frame클래스 상속받기
    Label location;

    MouseEventTest (String title) { // 생성자
        super(title); // 부모 클래스인 Frame(String title)의 생성자 호출
        location = new Label("Mouse Pointer Location : ");
        location.setSize(195,15);
        location.setLocation(5,30);
        location.setBackground(Color.yellow);
        add(location);

        //EventHandler의 인스턴스를 Frame의 Listener로 등록.
        // 마우스 모션 이벤트 발생시 addMouseMotionListener가 감지하고, EventHandler가 이벤트 처리.
        addMouseMotionListener(new EventHandler());

        setSize(300,200);
        setLayout(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        MouseEventTest mainWin = new MouseEventTest("MouseEventTest");
    }

    class EventHandler implements MouseMotionListener {
        public void mouseDragged(MouseEvent e) {}
        public void mouseMoved(MouseEvent e) {
            // .setText() Label 내 텍스트를 ()로 바꾸기
            location.setText("Mouse Pointer Location : (" + e.getX()
                                                    + "," + e.getY() + ")");
        }
    } // EventHandler
}
