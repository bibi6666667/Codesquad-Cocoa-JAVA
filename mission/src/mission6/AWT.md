# AWT

* AWT란?
 * AWT = Abstract Window Toolkit로, 자바의 Window GUI 프로그래밍 도구이다.
* GUI = Graphical User Interface. 그래픽 기반의 사용자 인터페이스. 사용자가 그래픽을 통해 하드웨어와 상호작용하는 환경. (마우스 등을 통해). 
 * GUI의 요소 : 윈도우, 스크롤바, 아이콘 이미지, 버튼 등이 있다.
* GUI는 CUI (Character User Interface, 텍스트 기반의 사용자 인터페이스) 와 대조적인 개념이다.
* AWT는 OS의 컴포넌트들을 그대로 사용한다. 따라서 AWT응용프로그램의 외형은 실행되는 OS(윈도우/iOS..)에 따라 다르게 나타난다.

## Swing

* Swing은 AWT를 확장한 것이지만 AWT보다 다양, 풍부한 컴포넌트를 제공. - 최근은 **JavaFX**가 더 좋다고.
* Swing과 AWT의 사용법은 거의 비슷하므로 AWT프로그래밍을 먼저 익히면 된다.

- - -

# AWT의 구성

## AWT 패키지
* (`import java.awt.*;`로도 선언할 수 있다)
* 패키지명이 `java.awt`로 시작하면 모두 AWT관련 패키지이다.
 * `java.awt` : AWT를 이용한 GUI어플리케이션 작성에 필요한 기본적 클래스와 컴포넌트 제공.
 * `java.awt.event` : GUI어플리케이션에서 발생하는 이벤트를 처리하는데 필요한 클래스,인터페이스 제공.
 * `java.awt.datatransfer` : 어플리케이션 내/어플리케이션 간 데이터 전송 구현에 필요한 클래스, 인터페이스 제공.
 * `java.awt.dnd` : 끌어놓기=드래그 앤 드롭(Drag and Drop) 구현에 필요한 클래스 제공.
 * `java.awt.font` : 폰트와 관련된 클래스,인터페이스를 제공.
 * `java.awt.image` : 이미지 생성, 변경에 사용되는 클래스 제공.
 * `java.awt.print` : 출력에 관련된 클래스와 인터페이스 제공.
 
 - - -

## 컴포넌트 Component
* 모든 컴포넌트의 조상은 Component클래스. (※예외 : 메뉴 관련 컴포넌트)
* Component클래스의 조상은 Object클래스.
* 컴포넌트(AWT컴포넌트) : GUI응용프로그램의 화면을 구성하는 데 사용되는, Component클래스와 그 자손 클래스들.
 * 윈도우, 스크롤바, 버튼, 체크박스, 리스트 .. 등이 있다.
1. 일반 컴포넌트 : (최상위조상 : Component). 
 * Button, Label, Checkbox, List, Choice, Scrollbar, Dialog(대화상자요소), Frame, TextArea/TextField, FileDialog(파일열기)..
2. 메뉴 컴포넌트 : (최상위조상 : MenuComponent)
 * MenuBar, MenuItem(Menu-PopupMenu, CheckboxMenuItem) ..
 
#### 컴포넌트의 주요 메서드
* `Color getBackground()` : 컴포넌트의 배경색을 얻는다
* `void setBackground(Color c)` : 컴포넌트의 배경색을 지정된 색으로 변경한다.
* `Cursor getCursor()` : 컴포넌트에 지정된 커서를 얻는다.
* `void setCursor(Cursor c)` : 컴포넌트의 커서(마우스포인터) 를 지정한다.
* `Font getFont()` : 컴포넌트에 지정되어 있는 Font를 얻는다.
* `void setFont(Font f)` : 컴포넌트의 Font를 지정한다.
* `Color getForeground()` : 컴포넌트의 전경색을 얻는다.
* `void setForeground(Color c)` : 컴포넌트의 전경색을 지정한다.
* `int getHeight()` : 컴포넌트의 높이를 얻는다.
* `int getWidth()` : 컴포넌트의 폭을 얻는다.
* `void setBounds(int x, int y, int witdh, int height)` : 컴포넌트의 위치(x,y)와 크기(width, height)를 지정한다.
* `Rectangle getBounds()` : 컴포넌트의 위치와 크기(Rectangle 객체)를 얻는다.
* `Point getLocation()` : 컴포넌트의 위치를 얻는다.
* `void setLocation(int x, int y)` : 컴포넌트의 위치를 지정한다.
* `Dimension getSize()` : 컴포넌트의 크기를 얻는다.
* `void setSize(int width, int height)` : 컴포넌트의 크기를 지정한다.
* `boolean hasFocus()` : 컴포넌트가 현재 focus를 갖고 있는지 알려준다.
* `void requestFocus()` : 컴포넌트가 focus를 갖도록 한다.
* `void paint(Graphics g)` : 컴포넌트를 화면에 그린다.
* `void repaint()` : 컴포넌트를 화면에 다시 그린다.
* `void setEnabled(boolean b)` : 컴포넌트를 사용가능(true)/불가능(false)하게 한다.
* `Container getParent()` : 컴포넌트가 포함되어져 있는 컨테이너(parent)를 얻는다.
* `void setVisible(boolean b)` : 컴포넌트가 화면에 보이게(true)/보이지 않게(false)한다.

- - -

## 컨테이너 Container
* 컨테이너 : Component의 자손인 Container 또는 Container의 자손들.
* 컨테이너는 다른 컴포넌트 또는 컨테이너를 포함할 수 있다.

1. 독립적 컨테이너 : 독립적으로 사용될 수 있음 & 다른 컴포넌트 또는 종속적 컨테이너를 포함할 수 있다.
 * `Frame`
  * 가장 일반적 컨테이너. `Window`와 모양이 같다.
  * titlebar와 크기조절버튼, 닫기버튼이 있다.
  * 메뉴를 추가할 수 있다.
 * `Window`
  * `Frame`의 조상이다.
  * 컴포넌트를 담을 수 있는 평면공간만을 갖는다.
  * 경계선, titlebar, 크기조절버튼, 닫기버튼 없고 메뉴 추가도 불가능.
 * `Dialog`(대화상자요소)
  * titlebar와 닫기버튼은 있지만, 메뉴는 없다.
  * 기본적으로 크기를 변경할 수 없다.
  * 주로 사용자에게 메시지를 보여주거나 응답을 받는 데 사용한다.
  
2. 종속적 컨테이너 : 독립적으로 사용될 수 없음 & 다른 컨테이너에 포함되어야만 한다.
 * `Panel`
  * 평면공간. `Frame`처럼 여러 컴포넌트를 담을 수 있으나 단독 사용은 불가능.
 * `ScrollPane`(스크롤페인)
  * `Panel`과 같은 평면공간이나 단 **하나**의 컴포넌트만 포함할 수 있음.
  * 자신보다 큰 컴포넌트가 포함되면 스크롤바가 자동으로 나타남.
  
#### 컨테이너의 주요 메서드
* 컨테이너에는 여러 개의 오버로딩된 add메서드들이 있다. 
 * 따라서 컨테이너에 add메서드를 사용하는 것 만으로도 다른 컴포넌트들을 포함시킬 수 있다.
* 컨테이너에 포함된 컴포넌트들은 기본적으로 컨테이너의 배경색&전경색, 폰트 등의 설정을 따른다.

* `Component[] getComponents()` : 컨테이너에 포함되어 있는 <U>모든</U> 컴포넌트를 얻는다.
* `Component getComponent(int n)` : 컨테이너에 n번쨰로 추가된 컴포넌트를 얻는다.
* `Component getComponentAt(int x, int y)` : 컨테이너의 지정 위치(x, y)에 있는 컴포넌트를 얻는다.
* `Component add(Component comp)` : 컨테이너에 컴포넌트를 추가한다.
* `void remove(Component comp)` : 컨테이너에서 지정된 컴포넌트를 제거한다.
* `Insets getInsets()` : 컨테이너의 경계의 크기를 알 수 있는 Inset객체를 얻는다.
* `LayoutManager getLayout()` : 컨테이너에 설정되어 있는 LayoutManager를 얻는다.
* `void setLayout(LayoutManager mgr)` : 컨테이너에 LayoutManager를 설정한다.

- - -
- - -

# AWT의 주요 컴포넌트
이제 AWT를 이용한 GUI프로그래밍에 사용되는 컴포넌트의 종류 및 기본적 기능을 실습으로 알아본다.
✅ AWT를 시작하는 데 별도의 설치는 필요없으며, `import java.awt.*;` 로 임포트만 해 주면 된다.

- - -

### Frame 프레임
* Frame은 GUI프로그래밍의 가장 대표적 컴포넌트이자, 다른 컴포넌트들을 포함할 수 있는 **컨테이너**이다.
* titlebar, 최대화버튼, 최소화버튼, 닫기버튼을 가진다.
* 크기 조절이 가능하다.
* 단, 닫기 버튼은 눌러도 작동하지 않는다. 이벤트처리를 통해 기능을 따로 추가해주어야 동작한다.
 * 실행을 멈추려면 콘솔창에서 정지를 누르거나 작업관리자에서 종료해야 한다.

##### Frame의 메서드
* `Frame(String title)` : Frame을 생성한다.
 * `title`은 Frame의 titlebar에 보여질 text를 말한다(필수)
* `String getTitle()` : titlebar에 있는 text를 얻는다.
* `void setTitle(String title)` : titlebar의 text를 변경한다.
* `void setState(int state)` : Frame의 상태를 변경할 수 있다. 
 * `state`에는 두 가지 값 중 하나를 사용할 수 있다.
  1. `Frame.ICONIFIED` : Frame을 최소화 상태가 되게 한다.
  2. `Frame.NORMAL` : Frame을 정상상태(최소화 이전 상태)가 되게 한다.
* `int getState()` : Frame의 현재 상태를 알 수 있다.
* `void setResizable(boolean resizable)` : Frame의 크기를 변경가능(true)/불가능(false) 하게 한다.
 * false일 때는 사용자가 Frame의 크기를 변경할 수 없다.
 
##### Frame 사용하기
```java
import java.awt.*;

public class FrameTest {
    public static void main(String[] args) {
        Frame f = new Frame("Login"); // Frame 객체 생성. 괄호 안은 Frame의 title에 해당.
        f.setSize(300, 200) ; // Frame의 크기를 설정.
        f.setVisible(true); // 설정작업이 모두 끝나면 맨 마지막으로 프레임을 화면에 보이게 한다.
        // Frame객체를 생성했다고 화면에 보이진 않는다. 반드시 이 옵션을 추가해주어야 한다.
    }
}
```

##### Frame을 화면 중앙에 나타나게 하기
```java
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
```

- - -
 
### Button 버튼

* Button : 사용자가 클릭했을 때 어떤 작업이 수행되도록 할 때 사용된다.

##### Button의 메서드
* `Button(String label)` : 지정된 label을 가진 Button을 생성한다.
 * `label` : Button위에 나타날 text를 말한다.
* `String getLabel()` : Button에 나타나 있는 text를 얻는다.
* `void setLabel(String label)` : Button에 나타나 있는 text를 변경한다.

##### Button 사용하기
```java
import java.awt.*;

public class ButtonTest {
    public static void main(String[] args) {
        Frame f = new Frame("Login");
        f.setSize(300,200);

        Button b = new Button("확 인");// "확 인"이라는 글자가 있는 Button 생성
        b.setSize(100,50); // Button의 크기 설정

        f.add(b); // 생성된 Button을 Frame에 포함시킨다.
        f.setVisible(true);
    }
}
```

##### 레이아웃 매니저 Layout Manager (Button 크기 설정)
위 예제에서 버튼 크기를 프레임보다 작게 설정해도 프레임에 꽉 차는 현상이 나타난다.
이는 Frame에 설정되어 있는 Layout Manager(레이아웃 매니저) 때문이다.
* 컨테이너에는 레이아웃매니저를 선택적으로 설정할 수 있다.
* 레이아웃매니저는 컨테이너 크기가 변경될 때 마다, 컨테이너에 포함된 컴포넌트들의 크기와 위치를 자동으로 관리해 준다.
* 장점) 프로그래머가 수동적으로 일일이 컨테이너 내 컴포넌트 배치에 신경쓰지 않아도 된다.
* 다양한 레이아웃 매니저의 종류와 특성이 있다. - 앞으로 배우게 될 것임. 
 * Frame에 기본적으로 설정되어 있는 레이아웃매니저는 BorderLayout이다.
* 지정된 레이아웃매니저 설정을 해제하면 컴포넌트가 자동으로 배치되지 않는다.
 * 프로그래머가 직접 컴포넌트의 크기,위치 등을 설정해 주어야 한다.
  * `setLocation()`, `setSize()` 를 통해 위치와 크기를 설정.
  
아래는 레이아웃매니저를 해제하고 직접 버튼 크기와 위치를 설정하는 예제이다.
```java
import java.awt.*;

public class ButtonTest2 {
    public static void main(String[] args) {
        Frame f = new Frame("Login");
        f.setSize(300, 200);
        f.setLayout(null); // 레이아웃매니저의 설정을 해제한다.

        Button b = new Button("확 인");
        b.setSize(100,50);
        b.setLocation(100,75); // Frame내에서 Button의 위치 설정

        f.add(b);
        f.setVisible(true);
    }
}
```

- - -

### Choice 
* Choice : 여러 item이 있는 목록을 보여주고, 그 중 한 가지를 선택하도록 한다.
 * (콤보박스 combo box / 드랍다운 리스트박스 drop-down listbox)
 
##### Choice의 메서드
* `void add(String item)` : Choice에 item을 추가한다.
* `void remove(String item)` : Choice에서 item을 제거한다.
* `void remove(int index)` : 지정된 인덱스의 item을 제거한다.
 * AWT에서도 index는 0번째부터 시작한다! 첫 번째 item의 인덱스 = 0.
* `void removeAll()` : Choice의 모든 item을 제거한다.
* `void insert(String item, int index)` : 지정된 인덱스에 item을 추가한다.
* `String getItem(int index)` : 지정된 인덱스의 item을 얻는다.
* `int getItemCount()` : 현재 Choice에 추가되어 있는 item이 몇 개인지 알려준다.
* `int getSelectedIndex()` : 현재 선택되어져 있는 item의 index값을 얻는다.
* `String getSelectedItem()` : 현재 선택되어져 있는 item을 얻는다.

##### Choice 사용하기
```java
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
```

- - - 

### List 리스트
* List도 Choice처럼 목록 중 원하는 항목을 선택하게 할 때 사용한다.
* List와 Choice의 다른 점 : 
 * List는 처음부터 모든 item목록을 보여준다
 * List는 item목록 중에서 하나 또는 여러 개를 선택할 수 있다.

##### List의 메서드
* `List(int rows, boolean multipleMode)` 
 * `rows` : 몇 줄 짜리 크기의 List를 만들지 지정.
 * `multipleMode` : 다중선택이 가능하게 지정한다. (true - 다중선택 가능)
* `List(int rows)` 
 * List에 보여줄 item 수만 지정한다. 
 * 위 메서드와 달리 multipleMode값은 false로 자동지정되어 다중선택이 불가능한 선언방법이다.
* `List()` 
 * rows의 값은 기본값인 4로 지정된다.
 * multipleMode의 값은 false로 자동지정되어 다중선택이 불가능한 선언방법.

* `void add(String item)` : item을 List에 추가한다.
* `void add(String item, int index)` : 지정 인덱스에 item을 추가한다.
* `void replaceItem(String newValue, int index)` : 지정 인덱스의 item을 newValue로 바꾼다.

* `void remove(String item)` : List에서 해당 item 제거
* `void remove(int index)` : 지정 인덱스의 item 제거
* `void removeAll()` : List의 모든 item 제거

* `int getRows()` : List에 스크롤 없이 볼 수 있는 아이템의 수를 얻는다.
* `int getItemCount()` : List에 있는 item이 모두 몇 개인지 알려준다.
* `String getItem(int index)` : 지정 인덱스의 item을 얻는다.
* `String[] getItems()` : List의 모든 item을 얻는다.
  
* `void select(int index)` : 지정 인덱스의 item을 선택한다.
* `void deselect(int index)` : 지정 인덱스의 item을 선택해제한다.
* `int getSelectedIndex()` : 현재 선택된 item의 인덱스를 얻는다.
* `int[] getSelectedIndexes()` : 현재 선택된 item들의 인덱스를 모두 얻는다.
 * multipleMode가 true인 경우 사용 가능.
* `String getSelectedItem()` : 현재 선택된 item을 얻는다.
* `String[] getSelectedItems()` : 현재 선택된 item들을 얻는다.
 * multipleMode가 true인 경우 사용 가능. 
* `boolean isIndexSelected(int index)` : 지정 인덱스의 item이 선택되어있는지 알려준다.
* `void setMultipleMode(boolean b)` : List를 multipleMode로 할 것인지 설정.
 * b가 true이면 multipleMode가 된다.

##### List 사용하기
```java
import java.awt.*;

public class ListTest {
    public static void main(String[] args) {
        Frame f = new Frame("List - Select");
        f.setSize(300,200);
        f.setLayout(null);

        List selectOne = new List(6); // 6개 목록을 가진 List 생성
        selectOne.setLocation(20,40);
        selectOne.setSize(100,120);
        selectOne.add("Student");
        selectOne.add("Teacher");
        selectOne.add("Driver");
        selectOne.add("Computer Programmer");
        selectOne.add("Sales Man");
        selectOne.add("Musician");
        selectOne.add("Director");

        // 생성자의 두 번째 인자값이 true이면 multipleMode가 된다.
        List selectMany = new List(6, true);
        selectMany.setLocation(150,40);
        selectMany.setSize(100,120);
        selectMany.add("Student");
        selectMany.add("Teacher");
        selectMany.add("Driver");
        selectMany.add("Computer Programmer");
        selectMany.add("Sales Man");
        selectMany.add("Musician");
        selectMany.add("Director");

        f.add(selectOne);
        f.add(selectMany);
        f.setVisible(true);

    }
}
```

- - - 

### Label 레이블
* Label을 통해 화면에 글자를 표시할 수 있다.
* 설명이나 메시지를 화면에 나타낼 때 주로 사용한다.

##### Label의 주요 메서드
* `Label(String text, int alignment)` 
 * `text` : 화면에 나타낼 글자
 * `alignment` : text의 정렬방식
  * `Label.LEFT` `Label.CENTER` `Label.RIGHT` 중 선택해 지정
* `Label(String text)`
 * `text`를 나타내되 `alignment`기본값인 왼쪽정렬로 설정된다.
 
* `String getText()` : Label의 text를 얻어온다
* `void setText(String text)` : Label의 text를 주어진 값으로 변경
* `void setAlignment(int alignment)` : Label의 text정렬을 지정

##### Label 사용하기
* Frame에 레이아웃매니저가 설정되지 않은 경우, 컴포넌트들의 크기를 지정하지 않으면 화면에 표시되지 않는다.
 * `.setSize()` 또는 `.setBounds()`를 통해 컴포넌트 크기를 지정해야 한다.  
```java
import java.awt.*;

public class LabelTest {
    public static void main(String[] args) {
        Frame f = new Frame("Login");
        f.setSize(300, 200);
        f.setLayout(null);

        // Label을 생성하고, 크기와 위치 지정.
        Label id = new Label("ID :");
        id.setBounds(50,50, 30,10);
        // 50,50 위치에 가로길이 30, 세로길이 10

        Label pwd = new Label("Password : ");
        pwd.setBounds(50,65, 100,10);

        f.add(id);
        f.add(pwd);
        f.setVisible(true);
    }
}
``` 

- - - 

### Checkbox, CheckboxGroup
* Checkbox : boolean처럼 true/false(또는 on/off) 중 하나의 값을 가질 수 있는 컴포넌트이다.
 * CheckboxGroup으로 그룹화하지 않으면 모든 값을 중복선택 가능하다.
* CheckboxGroup : 여러 값들 중 하나를 선택하는 radio button을 만들 수 있다.
 * 같은 그룹 내 Checkbox중에서 한 가지만 선택가능하다.

##### Checkbox의 메서드
* `Checkbox(String text, boolean state)` : Checkbox 객체 생성
 * `text` - Checkbox 와 함께 보여질 text를 지정
 * `state` - true이면 Checkbox가 선택된 상태로, false이면 선택해제된 상태로 생성.
* `Checkbox(String text) ` 
 * Checkbox와 함께 보여질 text를 지정. state는 false(선택해제)로 생성.
* `Checkbox()` 
 * `text` 없이 Checkbox만 나타남. state는 false(선택해제)로 생성.
 
* `Checkbox(String text, CheckboxGroup group, boolean state)`
 * group - CheckboxGroup 객체의 참조. CheckboxGroup을 이용해 radio button을 만든다.

* `String getLabel()` : Checkbox의 label을 얻는다
* `void setLabel(String label)` : Checkbox의 label을 주어진 값으로 변경한다. 
* `boolean getState()` : Checkbox의 상태를 얻는다. true이면 체크된 상태. 
* `void setState(boolean state)` : Checkbox의 상태를 설정. state를 true로 하면 Checkbox가 체크된 상태가 된다.

##### Checkbox 사용하기
```java
import java.awt.*;

public class CheckboxTest {
    public static void main(String[] args) {
        Frame f = new Frame("Questions");
        f.setSize(305,250);
        // Frame의 LayoutManager를 FlowLayout으로 설정.
        // -> 컴포넌트들의 크기, 위치를 따로 정하지 않아도 됨.
        f.setLayout(new FlowLayout());

        Label q1 = new Label("1. 당신의 관심 분야는? (다중선택 가능)");
        Checkbox news = new Checkbox("news", true);
        Checkbox sports = new Checkbox("sports");
        Checkbox movies = new Checkbox("movies");
        Checkbox music = new Checkbox("music");

        f.add(q1); f.add(news); f.add(sports); f.add(movies); f.add(music);

        Label q2 = new Label("2. 얼마나 자주 극장에 가십니까?");
        CheckboxGroup group1 = new CheckboxGroup(); // 그룹화 (하나만 선택가능)
        Checkbox movies1 = new Checkbox("한 달에 두 번", group1, true);
        Checkbox movies2 = new Checkbox("일주일에 한 번", group1, false);
        Checkbox movies3 = new Checkbox("일주일에 두 번", group1, false);

        f.add(q2); f.add(movies1); f.add(movies2); f.add(movies3);

        Label q3 = new Label("3. 하루에 얼마나 컴퓨터를 사용하십니까?");
        CheckboxGroup group2 = new CheckboxGroup(); // 그룹화 (하나만 선택가능)
        Checkbox com1 = new Checkbox("5시간 이하", group2, true);
        Checkbox com2 = new Checkbox("10시간 이하", group2, false);
        Checkbox com3 = new Checkbox("15시간 이상", group2, false);

        f.add(q3); f.add(com1); f.add(com2); f.add(com3);
        f.setVisible(true);
    }
}
``` 

- - - 

### TextField
* TextField : 사용자로부터 값을 입력받는 컴포넌트.
 * 편집이 가능하다.
 * 한 줄만 입력할 수 있어, 비교적 짧은 값을 입력받을 때 사용.(이름, id, 비밀번호)..

##### TextField의 메서드
* `TextField(String text, int col)` : TextField 객체 생성
 * `text` : TextField에 보여질 text 지정
 * `col` : (입력받을 글자의 수) TextField의 크기 지정.
* `void setEchoChar(char c) ` : 지정된 문자를 EchoChar로 한다 (주로 비밀번호 입력에 사용)
 * 입력하는 값에 관계없이 화면에는 지정된 문자`c`가 보이게 된다.
* `int getColumns()` : TextField의 col 수를 얻는다.

TextComponent(TextField의 조상)로부터 상속받은 메서드
* `void setText(String t)` : TextField의 text를 t로 한다.
* `String getText()` : TextField의 text를 얻는다.
* `void select(int selectionStart, int selectionEnd)` : selectionStart~selectionEnd까지의 text를 선택(하이라이트).
* `void selectAll()` : TextField의 모든 text를 선택된 상태로 만든다.
* `String getSelectedText()` : TextField의 text중 선택된 부분을 얻는다.
* `void setEditable(boolean b)` : TextField의 text를 편집가능(true)/불가능(false)하게 설정.


##### TextField 사용하기
```java
import java.awt.*;

public class TextFieldTest {
    public static void main(String[] args) {
        Frame f = new Frame("Login");
        f.setSize(400,65);
        // 레이아웃매니저를 FlowLayout로 한다.
        f.setLayout(new FlowLayout());

        Label lid = new Label("ID : ", Label.RIGHT); // 오른쪽 정렬
        Label lpwd = new Label("Password : ", Label.RIGHT);

        TextField id = new TextField(10); // 10글자를 입력할 수 이는 크기로 생성
        TextField pwd = new TextField(10); // 10글자를 입력할 수 이는 크기로 생성
        pwd.setEchoChar('*'); // 입력한 값 대신 *가 보이게 한다.
        // 한 글자이므로 홑따옴표를 사용해야 한다.

        f.add(lid);
        f.add(id);
        f.add(lpwd);
        f.add(pwd);
        f.setVisible(true);
    }
}
```

- - - 

### TextArea
* TextArea : 여러 줄의 text를 입력하거나 보여줄 수 있는 편집가능한 컴포넌트.
 * 스크롤바를 이용해 화면에 보이는 것 보다 많은 양의 text를 담을 수 있다.
 
##### TextArea의 메서드
(설명 : p.22)
* `TextArea(String text, int row, int col, int scrollbar)` :
 * `text` : 보여질 텍스트  
 * `row` : (필수) TextArea의 줄 수(세로 길이) 
 * `col` : (필수) TextArea의 열 수(가로 길이)
 * `scrollbar` : TextAreadp 사용할 scrollbar의 종류 및 사용여부 지정
  * `TextArea.SCROLLBARS_BOTH`, `TextArea.SCROLLBARS_NONE`, `TextArea.SCROLLBARS_HORIZONTAL_ONLY`, `TextArea.SCROLLBARS_VERTICAL_ONLY` 중 선택
* `int getRows()`, `int getColumns()` : 행, 열 개수 얻기
* `void setRows(int rows)`, `void setColumns(int columns)` : 지정 값으로 행, 열 개수 설정
* `void append(String str)` : text 맨 마지막에 str 덧붙이기
* `void insert(String str, int pos`) : text 의 지정위치 pos에 str을 넣기
* `void replaceRange(String str, int start, int end)` 
* `void setText(String t)`, `String getText()`
* `void select(int selectionStart, int selectionEnd)`, `void selectAll()`
* `String getSelectedText()`
* `void setEditable(boolean b)`

##### TextArea 사용하기
```java
import java.awt.*;

public class TextAreaTest {
    public static void main(String[] args) {
        Frame f = new Frame("Comments");
        f.setSize(400,220);
        f.setLayout(new FlowLayout());

        TextArea comments = new TextArea("하고 싶은 말을 적으세요.", 10, 50);

        f.add(comments);
        comments.selectAll(); // TextArea의 text 전체가 선택되도록 한다.
        f.setVisible(true);
    }
}
```

- - - 

### Scrollbar
* ScrollBar : 사용자가 정해진 범위 내에 있는 값을 쉽게 선택할 수 있도록 해주는 컴포넌트.
* 주로 볼륨 설정, 속도 조절, 색상 선택 등에 사용.

##### Scrollbar의 메서드
(설명 : p.24)
* `Scrollbar()` : 아무 옵션 없이 생성할 수도 있다.
* `Scrollbar(int orientation, int value, int visible, int min, int max)`
 * `orientation` : Scrollbar의 종류. 
  * `Scrollbar.VERTICAL`, `Scrollbar.HORIZONTAL`중 택1
 * `value` : Scrollbar의 초기값
 * `visible` : Scroll버튼(bubble) 의 크기
 * `min` : Scrollbar의 최소값
 * `max` : Scrollbar의 최대값
* `int getValue()`
* `void setValue(int newValue)`

##### Scrollbar 사용하기
```java
import java.awt.*;

public class ScrollbarTest {
    public static void main(String[] args) {
        Frame f = new Frame("Scrollbar");
        f.setSize(300,200);
        f.setLayout(null);

        Scrollbar hor = new Scrollbar(Scrollbar.HORIZONTAL, 0, 50, 0, 100);
        hor.setSize(100, 15);
        hor.setLocation(60,30);

        Scrollbar ver = new Scrollbar(Scrollbar.VERTICAL, 50, 20, 0, 100);
        ver.setSize(15, 100);
        ver.setLocation(30,30);

        f.add(hor);
        f.add(ver);
        f.setVisible(true);
    }
}
```