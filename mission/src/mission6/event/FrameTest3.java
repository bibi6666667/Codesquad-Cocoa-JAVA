package mission6.event;

import java.awt.*;
import java.awt.event.*;

public class FrameTest3 {
    public static void main(String[] args) {
        Frame f = new Frame("Login"); // Frame객체를 생성한다
        f.setSize(300, 200); // Frame의 크기를 설정한다

        // EventHandler클래스의 객체를 생성해 Frame의 WindowListener로 등록한다
        f.addWindowListener(new EventHandler());
        f.setVisible(true); // Frame .
    }
}

// 클래스 EventHandler에서,
// 이미 만들어져 있는 WindowListener라는 인터페이스를 구현하게 함.
class EventHandler implements WindowListener
{
    public void windowOpened(WindowEvent e) {}
    // ↓ windowClosing메서드 : Frame의 닫기 버튼을 눌렀을 때 호출된다.
    // 따라서 해당 메서드에 어플리케이션을 종료하는 코드를 추가해야 한다.
    public void windowClosing(WindowEvent e) { // 사용자가 닫기 버튼을 누르는 이벤트
        e.getWindow().setVisible(false); // Frame을 화면에서 보이지 않도록 하고
        e.getWindow().dispose(); // 메모리에서 제거한다
        System.exit(0); // 프로그램을 종료한다
        // ※ 이 메서드 내에서는 이벤트 발생시 생성된 WindowEvent인스턴스의 참조를 사용할 수 있다.
        // 그래서 WindowEvent인스턴스의 메서드들을 사용할 수 있다.
    }
    public void windowClosed(WindowEvent e) {} // 아무내용도 없는 메서드들 구현
    public void windowIconified(WindowEvent e) {}
    public void windowDeiconified(WindowEvent e) {}
    public void windowActivated(WindowEvent e) {}
    public void windowDeactivated(WindowEvent e) {}
}
