package mission6.graphics;

import java.awt.*;
import java.awt.event.*;

public class GraphicsEx1 extends Frame{ // Frame클래스를 상속받음
    public static void main(String[] args) {
        new GraphicsEx1("GraphicsEx1");
    }

    public GraphicsEx1 (String title) { // 생성자
        super(title); // Frame의 생성자 호출
        addWindowListener(new WindowAdapter() {
            // 창닫기 버튼 구현
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        setBounds(100, 100, 400, 300);
        setVisible(true);
    }

    public void paint (Graphics g) {
        g.setFont(new Font("Serif", Font.PLAIN, 15));
        g.drawString("Graphics를 이용해 그림을 그립니다.", 10, 50);

        // 원 그리기
        g.drawOval(50,100, 50,50); // 일반 원
        // 파란색 원 그리기
        g.setColor(Color.BLUE);//( 색 설정 -> 그리기 : 그 색깔로 그려짐 )
        g.fillOval(100,100, 50,50); // 파란색 원

        // 선 그리기
        g.setColor(Color.red);
        g.drawLine(100,100, 150,150);

        // 둥근 사각형 그리기
        g.fillRoundRect(200, 100, 120, 80, 30, 30);
        // 다각형 그리기
        g.setColor(Color.orange);
        g.fillPolygon(new int[]{50, 100, 150, 200}, new int[]{250, 200, 200, 250}, 4);

        // 호 그리기
        g.setColor(Color.cyan);
        g.fillArc(250, 200, 100, 100, 0, 120);
        // startAngle : 부채꼴을 그리기 시작하는 각도
        // arcAngle : 부채꼴을 표현할 각도
    }
}
