package mission6.awtcomponent;

import java.awt.*;

public class FileDialogTest {
    public static void main(String[] args) {
        Frame f = new Frame("Parent");
        f.setSize(300, 200);

        FileDialog fileOpen = new FileDialog(f, "파일열기", FileDialog.LOAD);

        f.setVisible(true); // Frame을 표시하고
        fileOpen.setDirectory("c:\\"); // c 디렉토리 내의 파일들이 보이게 열기
        fileOpen.setVisible(true); // FileDialog를 표시.

        // FileDialog에서 파일을 선택한 다음 '열기'버튼을 누르면,
        // getFile()과 getDirectory()를 이용해 선택된 파일의 이름과 디렉토리 위치를 얻을 수 있다.
        // 아무것도 선택하지 않을 시, null을 반환.
        System.out.println(fileOpen.getDirectory() + fileOpen.getFile());
    }
}
