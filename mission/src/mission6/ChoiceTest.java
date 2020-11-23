package mission6;

import java.awt.*;

public class ChoiceTest {
    public static void main(String[] args) {
        Frame f = new Frame("Choice - Select");
        f.setSize(300, 200);
        f.setLayout(null);

        Choice day = new Choice(); // Choice 객체 생성
        day.add("SUN"); // .add()를 통해 Choice의 목록에 나타날 item들을 추가.
        day.add("MON");
        day.add("TUE");
        day.add("WED");
        day.add("THU");
        day.add("FRI");
        day.add("SAT");

        day.setSize(100,50);
        day.setLocation(100,70);

        f.add(day); //
        f.setVisible(true);
    }
}
