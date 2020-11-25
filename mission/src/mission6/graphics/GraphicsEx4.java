package mission6.graphics;

import java.awt.*;
import java.awt.event.*;

public class GraphicsEx4 extends Frame implements MouseMotionListener{
    // Frame클래스 상속받고 MouseMotionListener구현.
    int x = 0;
    int y = 0;

    Image img = null; // Image객체 선언
    Graphics gImg = null; //

    public static void main(String[] args) {
        new GraphicsEx4("GraphicsEx4");
    }

    public GraphicsEx4(String title) { // 생성자
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

        img = createImage(500, 500); //createImage()로 Image객체를 생성
        gImg = img.getGraphics(); //getGraphics()를 통해 Image객체의 Graphics객체를 얻음
        gImg.drawString("왼쪽 버튼을 누른 채로 마우스를 움직여 보세요.", 10, 50);
        repaint();
    }

    public void paint(Graphics g) {
        if(img != null) {
            g.drawImage(img,0,0,this);
            // 가상화면에 그려진 그림을 Frame에 복사
        }
    }

    // MouseMotionListener 이벤트처리 메서드
    public void mouseMoved(MouseEvent me) {}
    // 마우스를 클릭해서 움직일(=드래그) 때만 그려지므로 mouseDragged()에 이벤트처리를 해 준다.
    public void mouseDragged(MouseEvent me){
        if (me.getModifiersEx() == MouseEvent.BUTTON1_DOWN_MASK) {
            // MouseEvent발생 시 누르고 있던 키 값 == 마우스 왼쪽 버튼 이면.
            x = me.getX();
            y = me.getY();
            gImg.drawString("*", x, y);
            repaint();
        }
    }
} // class GraphicsEx4
