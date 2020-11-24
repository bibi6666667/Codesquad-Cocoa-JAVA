package mission6.menucomponent;

import java.awt.*;

public class MenuTest {
    public static void main(String[] args) {
        Frame f = new Frame("Frame with Menu");
        f.setSize(300, 200);

        MenuBar mb = new MenuBar(); // 메뉴바 선언
        Menu mFile = new Menu("File"); // 메뉴 선언

        MenuItem miNew = new MenuItem("New");
        MenuItem miOpen = new MenuItem("Open");
        Menu mOthers = new Menu("Others"); // MenuItme이 아닌 Menu.
        MenuItem miExit = new MenuItem("Exit");

        mFile.add(miNew);//Menu에 MenuItem들을 추가.
        mFile.add(miOpen);
        mFile.add(mOthers); // Menu에 Menu 추가.
        mFile.addSeparator(); // 메뉴 분리선 추가.
        mFile.add(miExit);

        MenuItem miPrint = new MenuItem("Print ...");
        MenuItem miPreview = new MenuItem("Print Preview");
        MenuItem miSetup = new MenuItem("Print Setup ...");
        mOthers.add(miPrint);
        mOthers.add(miPreview);
        mOthers.add(miSetup); // Others에 하위 메뉴들을 만들어 넣는다.

        Menu mEdit = new Menu("Edit");
        Menu mView = new Menu("View");
        Menu mHelp = new Menu("Help");
        CheckboxMenuItem miStatusBar = new CheckboxMenuItem("Statusbar");
        mView.add(miStatusBar); // View에 상태바 추가

        mb.add(mFile); // MenuBar에 Menu들을 추가한다.
        mb.add(mEdit);
        mb.add(mView);
        mb.setHelpMenu(mHelp); // mHelp를 HelpMenu로 지정.

        f.setMenuBar(mb); // Frame에 MenuBar를 포함시킨다.
        f.setVisible(true);

    }
}
