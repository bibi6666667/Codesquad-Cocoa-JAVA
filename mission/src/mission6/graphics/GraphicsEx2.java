package mission6.graphics;

import java.awt.*;
import java.awt.event.*;

public class GraphicsEx2 extends Frame implements MouseMotionListener {
 // Frame클래스 상속받고 MouseMotionListener구현.
    int x = 0;
    int y = 0;

    public static void main(String[] args) {
        new GraphicsEx2("GraphicsEx2");
    }

    public GraphicsEx2(String title) { // 생성자
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
    }

    public void paint(Graphics g) {
        g.drawString("마우스를 움직여보세요.", 10, 50);
        g.drawString("*", x, y);
    }


    public void mouseMoved(MouseEvent me) {
        // MouseMotionListener 이벤트처리 메서드
        x = me.getX(); // MouseEvent의 getX()메서드를 이용해 현재 마우스포인터의 x좌표를 얻어옴
        y = me.getY(); // MouseEvent의 getY()메서드를 이용해 현재 마우스포인터의 y좌표를 얻어옴
        repaint(); // 마우스 움직일 때마다 x,y좌표에 "*"가 있도록 새로 그리기.
    }
    public void mouseDragged(MouseEvent me){}

    /* 이 코드블럭을 추가하면 마우스포인터의 자취가 남게 된다.
    public void update(Graphics g){
        paint(g);
    }
    */
}
