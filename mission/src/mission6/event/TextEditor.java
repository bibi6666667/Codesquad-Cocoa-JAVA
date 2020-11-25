package mission6.event;

import java.awt.*;
import java.awt.event.*;
import java.io.*; // 파일IO 패키지?

public class TextEditor extends Frame { // Frame클래스 상속받아오기
    String fileName;
    TextArea content;
    MenuBar  mb;
    Menu     mFile;
    MenuItem miNew, miOpen, miSaveAs, miExit;

    TextEditor (String title) {
        super(title); // 부모클래스 Frame의 생성자 호출
        content = new TextArea();
        add(content);

        mb = new MenuBar();
        mFile = new Menu("File");
        miNew = new MenuItem("New");
        miOpen = new MenuItem("Open");
        miSaveAs = new MenuItem("Save As...");
        miExit = new MenuItem("Exit");
        
        mFile.add(miNew); // Menu에 MenuItem들 추가
        mFile.add(miOpen);
        mFile.add(miSaveAs);
        mFile.addSeparator(); // 메뉴 분리선(separator) 추가
        mFile.add(miExit);
        
        mb.add(mFile); // MenuBar에 Menu 추가
        setMenuBar(mb); // (setMenuBar메서드를 통해) Frame에 MenuBar 추가

        // 메뉴에 이벤트핸들러 등록
        MyHandler handler = new MyHandler();
        miNew.addActionListener(handler);
        miOpen.addActionListener(handler);
        miSaveAs.addActionListener(handler);
        miExit.addActionListener(handler);

        setSize(300,200);
        setVisible(true);
    }

    // 선택된 파일 내용을 읽어서 TextArea에 보여주는 메서드
    void fileOpen(String fileName) {
        // java.io.*;의 클래스들
        FileReader fr;
        BufferedReader br;
        StringWriter sw;

        try {
            fr = new FileReader(fileName);
            br = new BufferedReader(fr);
            sw = new StringWriter();

            int ch = 0;
            while ((ch=br.read()) != -1) {
                sw.write(ch);
            }

            br.close();
            content.setText(sw.toString()); // TextArea에 불러온 내용을 적어준다
        } catch (IOException e) {
            e.printStackTrace();
        }
    } // fileOpen()

    // TextArea의 내용을 지정된 파일에 저장하는 메서드
    void saveAs(String fileName) {
        FileWriter fw;
        BufferedWriter bw;
        try {
            fw = new FileWriter(fileName);
            bw= new BufferedWriter(fw);
            bw.write(content.getText()); // TextArea 의 내용을 파일에 저장한다.
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        } // try
    } // saveAs메서드의 끝

    public static void main(String args[]) {
        TextEditor mainWin = new TextEditor("Text Editor");
    } // main메서드의 끝

    // 이벤트 처리 : 메뉴 클릭했을 때 메뉴별 처리코드
    class MyHandler implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand(); // ActionEvent에서 발생한 명령 받아오기?

            if (command.equals("New")) {
                content.setText(""); // 공백 출력 (빈 페이지)
            } else if(command.equals("Open")) {
                FileDialog fileOpen =
                        new FileDialog(TextEditor.this, "파일열기");
                fileOpen.setVisible(true);
                fileName = fileOpen.getDirectory() + fileOpen.getFile();
                System.out.println(fileName);
                // fileOpen() 메서드 호출 - 선택된 파일의 내용을 TextArea에 보여준다
                fileOpen(fileName);
            } else if(command.equals("Save As...")) {
                FileDialog fileSave =
                        new FileDialog(TextEditor.this,"파일저장 ",FileDialog.SAVE);
                fileSave.setVisible(true);
                fileName = fileSave.getDirectory() + fileSave.getFile();
                System.out.println(fileName);
                // saveAs() 메서드 호출 - 현재 TextArea의 내용을 선택된 파일에 저장한다
                saveAs(fileName);
            } else if(command.equals("Exit")) {
                System.exit(0); // 프로그램 종료.
            }
        }
    } // class MyHandler
} // class TextEditor
