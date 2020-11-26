package mission6;

import java.awt.*;
import java.awt.event.*;

public class Painter extends Frame implements MouseMotionListener {
    // 메뉴컴포넌트
    MenuBar menuBar;
    Menu mPainter, mTools, mColor;
    MenuItem miNew, miExit;
    MenuItem miPen, miCircle, miRectangle; //miRoundRectangle, miArc;  다각형까지?
    //MenuItem miBlack, miWhite, miRed, miBlue, miGreen, miYellow, miOrange, miPink;

    // x y 선언
    int x = 0;
    int y = 0;

    Object source;

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
        miPen = new MenuItem("Pencil");
        miCircle = new MenuItem("Circle");
        miRectangle = new MenuItem("Rectangle");
        mPainter.add(miNew);
        mPainter.addSeparator();
        mPainter.add(miExit);
        mTools.add(miPen);
        mTools.add(miCircle);
        mTools.add(miRectangle);

        menuBar.add(mPainter);
        menuBar.add(mTools);
        setMenuBar(menuBar);

        //메뉴 이벤트처리
        EventHandler eventHandler = new EventHandler();
        miNew.addActionListener(eventHandler);
        miExit.addActionListener(eventHandler);
        miPen.addActionListener(eventHandler);
        miCircle.addActionListener(eventHandler);
        miRectangle.addActionListener(eventHandler);
        //마우스포인터 이벤트처리
        addMouseMotionListener(this);
        //종료 이벤트처리
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
    // ↓ update()를 추가하면 이미지 깜빡거리지 않아요.
    public void update(Graphics g){
        paint(g);
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

    public void mouseClicked(MouseEvent e) {
        source = e.getSource();
        System.out.println(source);
        if (e.getModifiersEx() != MouseEvent.BUTTON1_DOWN_MASK) return;
        gImg.drawLine(x, y, e.getX(), e.getY());
        x = e.getX();
        y = e.getY();
        repaint();
    }

    // 메뉴 핸들러
   class EventHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();
            switch (command) {
                case "New" :
                    gImg.clearRect(0,0,640,480);
                    repaint();
                    break;
                case "Exit" :
                    System.exit(0);
                    break;
                case "Pencil" :
                    System.out.println("펜");
                    break;
                case "Circle" :
                    System.out.println("원");
                    break;
                case "Rectangle" :
                    System.out.println("사각형");
                    break;
            }
        }
    }

}
