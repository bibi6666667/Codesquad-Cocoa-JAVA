package mission6;

import java.awt.*;

public class FrameTest2 {
    public static void main(String[] args) {
        Frame f = new Frame("Login");
        f.setSize(300,200);

        Toolkit toolkit = Toolkit.getDefaultToolkit(); // 구현된 Toolkit객체를 얻는다
        Dimension screenSize = toolkit.getScreenSize(); // 화면의 크기를 구한다.

        // Frame을 화면 가운데 위치하게 하기
        // : Frame의 위치를 화면크기의 절반값에서 Frame크기의 절반값을 뺀 위치로 한다.
        // x축 위치 : 화면 너비 / 2 - Frame 너비 / 2
        // y축 위치 : 화면 높이 / 2 - Frame 높이 / 2
        f.setLocation(screenSize.width/2 - 150, screenSize.height/2 - 100);
        f.setVisible(true); // 마지막으로 생성된 Frame을 나타나게 한다.
    }
}
