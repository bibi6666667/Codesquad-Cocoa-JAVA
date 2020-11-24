package mission6.menucomponent;

import java.awt.*;
import java.awt.event.*; // 이벤트 처리를 위해 추가.

public class PopupMenuTest {
    public static void main(String[] args) {
        final Frame f = new Frame("PopupMenu Test");
        f.setSize(300, 200);

        final PopupMenu pMenu = new PopupMenu("Edit");

        // final ? 메서드 내에 정의된 클래스에서는,
        // 같은 메서드 내의 지역변수들 중 final키워드가 붙언 것들만 참조할 수 있다.
        // 익명클래스를 main메서드 내에 정의했기 때문에 사용.

        MenuItem miCut = new MenuItem("Cut");
        MenuItem miCopy = new MenuItem("Copy");
        MenuItem miPaste = new MenuItem("Paste");
        pMenu.add(miCut); // PopupMenu에 MenuItem들을 추가한다.
        pMenu.add(miCopy);
        pMenu.add(miPaste);

        f.add(pMenu); // PopupMenu를 Frame에 추가한다.
        f.addMouseListener(new MouseAdapter() { // 익명클래스
            public void mousePressed(MouseEvent me) {
                // 오른쪽 마우스버튼을 누르면 PopupMenu를 화면에 보여준다
                if (me.getModifiers() == me.BUTTON3_MASK)
                    pMenu.show(f, me.getX(), me.getY()); // Frame내에서 마우스포인터의 x,y좌표 얻기
            }
        });
        f.setVisible(true);
    }
}
