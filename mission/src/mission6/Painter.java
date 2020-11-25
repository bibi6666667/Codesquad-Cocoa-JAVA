package mission6;

import java.awt.*;
import java.awt.event.*;
import java.beans.EventHandler;

public class Painter extends Frame implements MouseMotionListener {
    // 메뉴컴포넌트
    MenuBar menuBar;
    Menu mPainter, mTools, mColor;
    MenuItem miNew, miExit;
    MenuItem miPencil, miCircle, miRectangle; //miRoundRectangle, miArc;  다각형까지?
    //MenuItem miBlack, miWhite, miRed, miBlue, miGreen, miYellow, miOrange, miPink;

    // x y 선언
    int x = 0;
    int y = 0;
    // 가상화면 - Image, Graphics
    Image img = null;
    Graphics gImg = null;

    public static void main(String[] args) {
        new Painter("Painter");
    }

    // 생성자 만들고 부모클래스 생성자 호출
    public Painter(String text) {
        super(text);

        //메뉴
        menuBar = new MenuBar();
        mPainter = new Menu("Painter");
        mTools = new Menu("Tools");
        mColor = new Menu("Color");
        miNew = new MenuItem("New");
        miExit = new MenuItem("Exit");
        miPencil = new MenuItem("Pencil");
        miCircle = new MenuItem("Circle");
        miRectangle = new MenuItem("Rectangle");
        mPainter.add(miNew);
        mPainter.addSeparator();
        mPainter.add(miExit);
        mTools.add(miPencil);
        mTools.add(miCircle);
        mTools.add(miRectangle);

        menuBar.add(mPainter);
        menuBar.add(mTools);
        setMenuBar(menuBar);

        EventHandler eventHandler = new EventHandler();
        miNew.addActionListener(eventHandler);
        miExit.addActionListener(eventHandler);
        miPencil.addActionListener(eventHandler);
        miCircle.addActionListener(eventHandler);
        miRectangle.addActionListener(eventHandler);

        //종료버튼
        addMouseMotionListener(this);
        addWindowListener(new WindowAdapter() {// 종료버튼 눌렀을 때.
            public void windowClosing(WindowEvent e) {
                System.exit(0); // 시스템 종료
            }
        });

        setBounds(400, 300, 640, 480);
        setVisible(true);

        //가상화면
        img = createImage(640, 480);
        gImg = img.getGraphics();
        repaint();
    }

    //paint()메서드
    public void paint(Graphics g) {
        if (img == null) return;
        g.drawImage(img, 0, 0, this); // img(가상화면)에 그려진 그림을 Frame에 복사
    }

    //이벤트처리
    @Override
    public void mouseMoved(MouseEvent e) {
        x = e.getX();
        y = e.getY();
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        if (e.getModifiersEx() != MouseEvent.BUTTON1_DOWN_MASK) return;

        gImg.drawLine(x, y, e.getX(), e.getY());
        x = e.getX();
        y = e.getY();
        repaint();
    }

    class EventHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();
            if (command.equals("New")){
                gImg.clearRect(0,0,640,480);
                repaint();
            } else if (command.equals("Exit")) {
                System.exit(0);
            }
            // TODO : mTools 이벤트처리하기
        }
    }

}
