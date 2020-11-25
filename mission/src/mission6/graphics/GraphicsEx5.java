package mission6.graphics;

import java.awt.*;
import java.awt.event.*;

public class GraphicsEx5 extends Frame implements MouseMotionListener {
    // Frame클래스 상속받고 MouseMotionListener구현.
    int x = 0;
    int y = 0;

    Image img = null; // Image객체 선언(가상화면)
    Graphics gImg = null; // img의 Graphics객체를 담을 변수 선언 

    public static void main(String[] args) {
        new GraphicsEx5("GraphicsEx5");
    }

    public GraphicsEx5(String title) { // 생성자
        super(title); // 부모클래스 Frame의 생성자 호출
        addMouseMotionListener(this);//GraphicsEx2 객체에 MouseMotionListener 연결
        addWindowListener(new WindowAdapter() { // 종료기능 - Adapter클래스 활용
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        setBounds(100, 100, 500, 500);
        setVisible(true);

        img = createImage(500, 500); // (가상화면) createImage()로 Image객체 생성
        gImg = img.getGraphics(); //getGraphics()를 통해 Image객체의 Graphics객체를 얻음
        gImg.drawString("왼쪽 버튼을 누른 채로 마우스를 움직여 보세요.", 10, 50);
        repaint();
    }

    public void paint(Graphics g) {
        if (img == null) return; // 가상화면에 그려진 게 없으면 paint() 종료
        g.drawImage(img, 0, 0, this);
        // 가상화면에 그려진 그림을 Frame에 복사

    }

    // MouseMotionListener 이벤트처리 메서드
    public void mouseMoved(MouseEvent me) {
        x = me.getX(); //MouseEvent 발생했을 때, 마우스포인터의 x좌표
        y = me.getY();
    }

    public void mouseDragged(MouseEvent me) {
        if (me.getModifiersEx() != MouseEvent.BUTTON1_DOWN_MASK) return;
        // MouseEvent발생했을 때 누르고 있던 키 값이 마우스 왼쪽 버튼이 아니면 종료.
        gImg.drawLine(x, y, me.getX(), me.getY());
        x = me.getX();
        y = me.getY();

        repaint();
    }
} // class GraphicsEx5