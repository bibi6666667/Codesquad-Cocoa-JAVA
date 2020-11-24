package mission6.awtcomponent;

import java.awt.*;

public class FontList {
    public static void main(String[] args) {
        GraphicsEnvironment ge = null; // GraphicsEnvironment객체생성
        ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        Font[] fonts = ge.getAllFonts(); // 시스템 내의 폰트 목록 가져오기

        for(int i=0; i < fonts.length; i++) {
            System.out.println(fonts[i].getFontName()); // 폰트 이름 하나씩 출력
        }
    }
}
