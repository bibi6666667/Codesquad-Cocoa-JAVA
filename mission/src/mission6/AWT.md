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

#### Frame의 메서드
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
 
#### Frame 사용하기
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

#### Frame을 화면 중앙에 나타나게 하기
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

#### Button의 메서드
* `Button(String label)` : 지정된 label을 가진 Button을 생성한다.
  * `label` : Button위에 나타날 text를 말한다.
* `String getLabel()` : Button에 나타나 있는 text를 얻는다.
* `void setLabel(String label)` : Button에 나타나 있는 text를 변경한다.

#### Button 사용하기
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

#### 레이아웃 매니저 Layout Manager (Button 크기 설정)
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
 
#### Choice의 메서드
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

#### Choice 사용하기
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

#### List의 메서드
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

#### List 사용하기
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

#### Label의 주요 메서드
* `Label(String text, int alignment)` 
  * `text` : 화면에 나타낼 글자
  * `alignment` : text의 정렬방식
    * `Label.LEFT` `Label.CENTER` `Label.RIGHT` 중 선택해 지정
* `Label(String text)`
  * `text`를 나타내되 `alignment`기본값인 왼쪽정렬로 설정된다.
 
* `String getText()` : Label의 text를 얻어온다
* `void setText(String text)` : Label의 text를 주어진 값으로 변경
* `void setAlignment(int alignment)` : Label의 text정렬을 지정

#### Label 사용하기
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

#### Checkbox의 메서드
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

#### Checkbox 사용하기
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

#### TextField의 메서드
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


#### TextField 사용하기
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
 
#### TextArea의 메서드
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

#### TextArea 사용하기
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

#### Scrollbar의 메서드
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

#### Scrollbar 사용하기
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

- - - 

### Canvas
* Canvas : 빈 평면 공간을 제공하는 컴포넌트. 그림을 그리거나 글자를 적을 수 있다.
* 주로 그림을 그리거나 이미지를 넣는 공간으로 사용.
* 사용자정의 컴포넌트를 만들 때도 사용 가능.

#### Canvas 사용하기
```java
import java.awt.*;

public class CanvasTest {
    public static void main(String[] args) {
        Frame f = new Frame("CanvasTest");
        f.setSize(300, 200);
        f.setLayout(null); // Frame의 LayoutManager 설정 해제

        Canvas c = new Canvas();
        c.setBackground(Color.pink); // 캔버스 배경 = 분홍색
        c.setBounds(50, 50, 150, 100); // 위치(x축/y축), 너비, 높이

        f.add(c);
        f.setVisible(true);
    }
}
```

- - - 

### Panel
* Panel : Frame과 같이 다른 컴포넌트를 자기 영역 내에 포함시킬 수 있는  **컨테이너**.
* Panel 자신이 다른 컨테이너에 포함되거나, Panel 안에 Panel이 포함되는 것도 가능.
* Frame과의 차이점 
  * titlebar나 버튼이 전혀 없고, 비어있는 평면공간만 있다.
  * Panel은 컨테이너이므로 자신만의 레이아웃을 유지 가능 - Panel을 통해 컴포넌트 배치를 다양화할수 있다.

#### Panel 사용하기
```java
import java.awt.*;

public class PanelTest {
    public static void main(String[] args) {
        Frame f = new Frame("Panel");
        f.setSize(300,200);
        f.setLayout(null); // Frame이 LayoutManager를 사용하지 않게 한다.

        Panel p = new Panel(); // Panel은 LayoutManager를 사용 - Panel안의 버튼 위치,크기는 자동배치.
        p.setBackground(Color.green);
        p.setSize(100, 100);
        p.setLocation(50, 50);

        Button ok = new Button("OK");

        p.add(ok); // Button은 Panel에 포함시킨다.
        f.add(p); // Panel은 Frame에 포함시킨다.
        f.setVisible(true);

    }
}
```
  
- - -

### ScrollPane
* ScrollPane : **컨테이너**이나, 다른 컴포넌트를 **단 하나**만 포함할 수 있다.
* 제한된 공간에서 크기가 큰 컴포넌트를 화면에 보여줄 때 사용.
* 포함된 컴포넌트보다 자기자신보다 큰 경우 자동으로 스크롤바가 나타난다.

#### ScrollPane 메서드
* `ScrollPane(int scrollbarDisplayPolicy)`
  * `scrollbarDisplayPolicy` - 아래 값 중 하나를 지정 (스크롤바 표시 여부)
    * `SCROLLBARS_ALWAYS`, `SCROLLBARS_AS_NEEDED`, `SCROLLBARS,NEVER`
* `ScrollPane()` 처럼 아무 설정 없이 객체를 생성할 수도 있다.

#### ScrollPane 사용하기
```java
import java.awt.*;

public class ScrollPaneTest {
    public static void main(String[] args) {
        Frame f = new Frame("ScrollPaneTest");
        f.setSize(300, 200);

        ScrollPane sp = new ScrollPane();
        Panel p = new Panel();
        p.setBackground(Color.green);
        p.add(new Button("첫번째")); // Button들을 Panel에 포함시킨다.
        p.add(new Button("두번째"));
        p.add(new Button("세번째"));
        p.add(new Button("네번쨰"));

        sp.add(p); // Panel을 ScrollPane에 포함시킨다
        f.add(sp); // ScrollPane을 Frame에 포함시킨다
        f.setVisible(true);
    }
}
```

- - -

### Dialog
* Dialog : 주로 화면에 메시지창을 보여줄 때 사용.
  * 에러 발생을 알릴 때, 파일 삭제 전 사용자에게 확인을 받을 때 .. 등
* Dialog도 다른 컴포넌트들을 포함할 수 있는 **컨테이너** 이다.
* Frame과 유사한 모양을 하고 있다.

#### Dialog의 메서드
* `Dialog(Frame parent, String title, boolean modal)` (생성자)
  * `parent` : (필수) 어떤 Frame에 속한 것인지 지정.
    * Dialog를 사용하기 위해서는 하나의 Frame이 Dialog의 parent로 지정되어야 함.
    * 상속의 부모-자식 관계는 아니지만, Dialog가 어느 Frame과 관련있는지 지정하기 위함임.
  * `title` : (필수) Dialog의 titlebar에 나타날 text 지정.
  * `modal` : Dialog를 modal(필수응답)로 할 것인지 지정. 지정하지 않으면 false가 된다.
    * ※`modal`은 사용자 입력을 독점한다는 의미. 반대말은 modeless.
  * true인 경우, 부모 Frame은 Dialog가 사라지기 전까지는 사용할 수 없게 된다.
    * 주로 사용자에게 중요 확인을 받아야 할 경우 사용.
  * false인 경우, Dialog가 열려있어도 부모 Frame을 사용할 수 있다.
* `void show()`, `void hide()` -> `void setVisible(boolean b)`: Dialog 보이기/숨기기
* `void dispose()` : Dialog 삭제(화면에 안 보이게 한 후, 메모리에서 제거)
* `String getTitle()`
* `void setModal(boolean b)`
* `void setResizable(boolean resizable)` : Dialog크기를 변경가능/불가능하게 함
  * 기본적으로 Dialog는 크기변경이 불가능. 

#### Dialog 사용하기
```java
import java.awt.*;

public class DialogTest {
    public static void main(String[] args) {
        Frame f = new Frame("Parent");
        f.setSize(300, 200);

        // parent Frame을 f, modal을 true(필수응답 Dialog)
        Dialog info = new Dialog(f, "Information", true);
        info.setSize(140, 90);
        info.setLocation(50,50); // parent Frame이 아닌, 화면이 위치기준이 됨.
        info.setLayout(new FlowLayout());
        // Dialog의 기본 레아이웃 매니저는 BorderLayout이기 떄문에 FlowLayout로 변경.

        Label msg = new Label("This is modal Dialog", Label.CENTER);
        Button ok = new Button("ok");
// 아직 안 배운 내용(이벤트 처리) - ok버튼 누르면 Dialog 창 없애기.
        ok.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //ok버튼을 누르면 수행될 메서드 : Dialog 없애기.
                info.setVisible(false); // Dialog를 안 보이게 한다.(숨김)
                info.dispose(); // Dialog를 메모리에서 없앤다.(삭제)
                // 둘 중 어느 방법을 사용해도 Dialog는 보이지 않게 되며, 부모Frame은 사용가능해진다.
            }
        });

        info.add(msg);
        info.add(ok);

        f.setVisible(true); // Frame을 보이게 한 다음,
        info.setVisible(true); // Dialog를 보이게 한다.
    }
}
```

- - -

### FileDialog
* FileDialog : 파일을 열거나 저장할 때 사용되는 Dialog.
* 대부분의 기능이 이미 구현되어 있어, 따로 코드를 추가하지 않아도 된다.

#### FileDialog 메서드
* `FileDialog(Frame parent, String title, int mode)` (생성자)
  * `parent` : (필수) 어떤 Frame에 속한 것인지 지정
  * `title` : (필수) FileDialog의 titlebar에 나타날 text 지정
  * `mode` : `FileDialog.LOAD`(열기), `FileDialog.SAVE`(저장) 중 하나 선택
* `String getFile()` : FileDialog에 의해 선택된 파일의 이름을 얻는다. 
* `String getDirectory()` : FileDialog에 의해 선택된 파일의 경로(path)를 얻는다. 
* `void setFile(String file)`, `void setDirectory(String dir)` 
  * FileDialog에 지정된 파일/디렉토리 설정.
 
#### FileDialog 사용하기
```java
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
```

- - -

### Font
* Font : Font의 인스턴스를 생성한 뒤 컴포넌트의 글씨체를 지정할 수 있다.
* `setFont(Font f)` : 컴포넌트에 사용되는 text의 글씨체를 지정할 수 있다.  

#### Font 생성자
* `Font(String name, int style, int size)`
  * `name` : 사용할 폰트의 이름.
    * 기본 제공 폰트 :  `Serif`, `SansSerif`, `Dialog`, `DialogInput`, `Monospaced`
    * 다른 폰트 사용을 위해서는 그 폰트가 컴퓨터에 설치되어 있어야 한다.
    * 현재 설치된 Font리스트 얻기 : `GraphicsEnvironment` 클래스의 메서드들을 이용한다.
  * `style` : 폰트의 스타일 지정.
    * `Font.PLAIN`, `Font.BOLD`, `Font.ITALIC`, `Font.BOLD+Font.ITALIC` 중 선택.
  * `size` : 폰트의 크기 지정.

#### Font 조회하기
```java
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
```  

#### Font 사용하기
```java
import java.awt.*;

public class FontTest {
    public static void main(String[] args) {
        Frame f = new Frame("Font Test");
        String abc = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        Label abc1 = new Label(abc);
        Label abc2 = new Label(abc);
        Label abc3 = new Label(abc);
        Label abc4 = new Label(abc);
        Label abc5 = new Label(abc);

        // Font를 설정
        Font f1 = new Font("Serif", Font.PLAIN, 20); // 보통체
        Font f2 = new Font("Serif", Font.ITALIC, 20); // 기울임체
        Font f3 = new Font("Serif", Font.BOLD, 20); // 굵은체
        Font f4 = new Font("Serif", Font.BOLD+Font.ITALIC, 20); // 굵은 기울임체

        // 설정한 Font를 Label에 적용
        abc1.setFont(f1);
        abc2.setFont(f2);
        abc3.setFont(f3);
        abc4.setFont(f4);

        f.setLayout(new FlowLayout());
        f.add(abc1);
        f.add(abc2);
        f.add(abc3);
        f.add(abc4);
        f.add(abc5); // 폰트를 지정해 주지 않으면, 자신이 포함된 컨테이너의 기본설정을 따른다.

        f.setSize(400, 200);
        f.setVisible(true);
    }
}
```

### Color
* Color : 색을 표현하는 클래스. 원하는 RGB값을 가지고 그 색깔의 객체를 생성, 사용할 수 있다.
  * 자주 쓰이는 색은 static으로 정의되어 있어 RGB값을 몰라도 사용 가능.
* 주로 컴포넌트의 배경색/전경색 설정하는 메서드 - `setForeground(Color c)`, `setBackground(Color c)`의 매개변수로 사용됨.

#### Color의 생성자 / 메서드
* `Color(int r, int g, int b, int a)` 또는 `Color(float r, float g, float b, float a)`
  * `r` - red, `g` - green, `b` - blue.
    * `r`, `g`, `b`는 모두 0~255의 정수값 또는 0.0~1.0의 실수값을 갖는다.
  * `a` - (선택) 색의 불투명도를 지정하는 alpha값으로. 값이 클수록 불투명하다.
    * 0~255의 정수값 또는 0.0~1.0의 실수값을 갖는다.

#### Color 사용하기
```java
import java.awt.*;

public class ColorTest {
    public static void main(String[] args) {
        Frame f = new Frame("Color Test");
        f.setLayout(new GridLayout(14, 2)); // 가로 14줄, 세로 2줄의 표? 생성
        Panel p1 = new Panel(); p1.setBackground(Color.black);
        Panel p2 = new Panel(); p2.setBackground(Color.blue);
        Panel p3 = new Panel(); p3.setBackground(Color.cyan);
        Panel p4 = new Panel(); p4.setBackground(Color.darkGray);
        Panel p5 = new Panel(); p5.setBackground(Color.gray);
        Panel p6 = new Panel(); p6.setBackground(Color.green);
        Panel p7 = new Panel(); p7.setBackground(Color.lightGray);
        Panel p8 = new Panel(); p8.setBackground(Color.magenta);
        Panel p9 = new Panel(); p9.setBackground(Color.orange);
        Panel p10 = new Panel(); p10.setBackground(Color.pink);
        Panel p11 = new Panel(); p11.setBackground(Color.red);
        Panel p12 = new Panel(); p12.setBackground(Color.white);
        Panel p13 = new Panel(); p13.setBackground(Color.yellow);
        Panel p14 = new Panel(); p14.setBackground(new Color(50,100,100));
        // 새 Color객체 선언해 RGB값을 설정할 수도 있다.

        f.add(new Label("Color.black")); f.add(p1); // 색 이름과 색 Panel 추가.
        f.add(new Label("Color.blue")); f.add(p2);
        f.add(new Label("Color.cyan")); f.add(p3);
        f.add(new Label("Color.darkGray")); f.add(p4);
        f.add(new Label("Color.gray")); f.add(p5);
        f.add(new Label("Color.green")); f.add(p6);
        f.add(new Label("Color.lightGray")); f.add(p7);
        f.add(new Label("Color.magenta")); f.add(p8);
        f.add(new Label("Color.orange")); f.add(p9);
        f.add(new Label("Color.pink")); f.add(p10);
        f.add(new Label("Color.red")); f.add(p11);
        f.add(new Label("Color.white")); f.add(p12);
        f.add(new Label("Color.yellow")); f.add(p13);
        f.add(new Label("Color(50, 100, 100)")); f.add(p14);
        f.setSize(250, 300);
        f.setVisible(true);
    }
}
```
- - -
- - -

# 메뉴 만들기

## 메뉴를 구성하는 컴포넌트
* Frame에 메뉴를 구성하기 위해서는 MenuComponent 클래스의 `MenuBar`, `Menu`, `MenuItem`과 같은 컴포넌트들을 사용한다.
* 모든 AWT컴포넌트의 조상이 Component클래스인 것처럼, 메뉴를 구성하는 컴포넌트들의 조상은 MenuComponent이다.
  * MenuComponent클래스는 `MenuBar`와 `MenuItem`을 자식으로 갖고,
  * `MenuItem`은 `Menu`/`PopupMenu`, `CheckboxMenuItem`을 자식으로 갖는다.

* 계층형 메뉴 : 폴더처럼 Menu에 Menu를 담아 계층형을 메뉴를 구성할 수 있다.
* 최상위 메뉴 : 항상 화면에 나타나는 최상위메뉴를 MenuBar에 담고, MenuBar는 다시 Frame에 추가함으로써 메뉴 작성이 끝난다.

* `Menu` : Menu와 MenuItem이 포함될 수 있다.
  * 계층형 메뉴 : Menu에 Menu를 포함시킨다.
* `MenuBar` : Menu만 포함될 수 있다. MenuItem은 포함시킬 수 없다.
* `MenuItem` : Menu에 포함된다.

* `PopupMenu` : 마우스 오른쪽 버튼을 누르면 나타나는, 위치가 고정되어 있지 않은 메뉴.
  * Frame내의 어디서나 실행 가능. (= 오른쪽 클릭)  


이벤트핸들러, 캔버스 위주로 공부하기.

#### 메뉴 컴포넌트의 메서드, 생성자
* `setHelpMenu(Menu menu)` 
  * OS마다 Help메뉴가 다르게 취급된다. - 윈도우에서는 특별히 다르게 다뤄지지는 않음.
* `addSeparator()`
* `CheckboxMenuItem(String name, boolean status)`
* `CheckboxMenuItem(String name)`

#### 메뉴 컴포넌트들과 PopupMenu 사용하기
##### 메뉴 컴포넌트
```java
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
```

##### PopupMenu
```java
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
```

- - -
- - -

# 레이아웃 매니저 Layout Manager
* 레이아웃 매니저 : 컨테이너 내의 컴포넌트 배치를 자동으로 관리한다.
  * 새로운 컴포넌트 추가 / 컨테이너 크기 변경 .. 등 컴포넌트의 배치, 재배치를 자동 처리.
  
### 레이아웃 매니저의 종류 (5가지)
* 컨테이너 당 하나의 레이아웃매니저를 설정할 수 있다.
  * `BorderLayout` 
  * `FlowLayout` 
  * `GridLayout` 
  * `CardLayout` 
  * `GridbagLayout`
  
* 한 Frame에 여러 레이아웃매니저를 사용해 컴포넌트들을 배치할 수도 있다.
  * Frame에 여러 컨테이너를 넣고, 각 컨테이너별로 레이아웃을 설정하면 된다.
  * (p.48 계산기 예제 참고) 

### 컨테이너별 기본 레이아웃 매니저
* 모든 컨테이너는 기본적으로 레이아웃 매니저가 지정되어 있다.
  * `FlowLayout` - Panel, Applet
  * `BorderLayout` - Window, Dialog, Frame
  
- - -
 
### BorderLayout
* BorderLayout : 
  * 컨테이너를 North, South, East, West, Center(동,서,남,북,중앙) 의 5영역으로 나눈다.
  * 각 영역에 하나의 컴포넌트만을 배치한다. 
    * 한 영역에 여러 컴포넌트 배치하면, 마지막으로 추가한 컴포넌트만 보인다
    * 한 영역에 여러 컴포넌트 넣으려면 Panel에 넣고 그 Panel을 영역에 넣어야 한다.
  * Window, Frame, Dialog의 기본 layout이다.

* Frame의 크기를 상하로 늘렸을 때
  * West, Center, East 영역의 길이만 상하로 늘어나고, North South 영역에는 아무런 변화가 없다.
* Frame의 크기를 좌우로 늘렸을 때
  * North, Center, South영역의 길이만 좌우로 늘어나고, West East 영역에는 아무런 변화가 없다.


#### BorderLayout의 메서드
* `BorderLayout()` 또는 `BorderLayout(int hgap, int vgap)` (생성자)
  * `hgap` : (선택) 좌우 간격
  * `vgap` : (선택) 상하 간격
* `add(String name, Component c)` 또는 `add(Component c, String name)`
  * 각 영역에 컴포넌트 추가하는 메서드. 
  * 5영역을 모두 채워야 하는 것은 아니고, 필요한 영역만 추가한다.

#### BorderLayout 사용하기
```java
import java.awt.*;

public class BorderLayoutTest {
    public static void main(String[] args) {
        Frame f = new Frame("BorderLayoutTest");
        f.setSize(200, 200);
        // Frame 은 기본적으로 BorderLayout로 설정되어 있으므로, 따로 설정하지 않아도 됨

        f.setLayout(new BorderLayout());
        Button north = new Button("North");
        Button south = new Button("South");
        Button east = new Button("East");
        Button west = new Button("West");
        Button center = new Button("Center");

        // Frame의 5개의 각 영역에 Button을 하나씩 추가한다
        f.add(north, "North"); // f.add("North",north); . 와 같이 쓸 수도 있다
        f.add(south, "South"); // South의 대소문자 정확히
        f.add(east, "East"); // East대신 , BorderLayout.EAST  사용가능
        f.add(west, "West");
        f.add(center, "Center");

        f.setVisible(true);
    }
}
```

- - -

### FlowLayout
* FlowLayout 
  * 컴포넌트들이 추가되는 순서에 따라 왼쪽-오른쪽으로 배치된다.
  * 공간이 부족하면 아랫줄에 추가된다. (줄바꿈)
    * 마치 워드프로세스에서 글자를 입력하는 것과 비슷한 방식.
  * 컴포넌트 정렬이 가능 : 왼쪽/오른쪽/가운데 정렬이 가능하다.
  * 화면을 늘리거나 줄이면..
    * 배치는 바뀌되, 같은 배치방식을 따른다.
    * 컴포넌트 크기는 그대로 유지된다.
  
#### FlowLayout의 메서드, 생성자
* `FlowLayout()` 또는 `FlowLayout(int align, int hgap, int vgap)` (생성자)
  * 아무것도 지정하지 않으면 가운데정렬, 상하좌우여백 5px으로 생성된다. 
  * `align` : 컴포넌트의 정렬 지정.
    * `FlowLayout.LEFT`, `FlowLayout.CENTER`, `FlowLayout.RIGHT` 중 택1
  * `hgap` : 컴포넌트 간 좌우 간격 지정.
  * `vgap` : 컴포넌트 간 상하 간격 지정.
  
#### FlowLayout 사용하기
```java
import java.awt.*;

public class FlowLayoutTest {
    public static void main(String[] args) {
        Frame f = new Frame("FlowLayoutTest");
        f.setSize(250, 100);
        f.setLayout(new FlowLayout(FlowLayout.LEFT)); // 왼쪽정렬의  FlowLayout 생성

        f.add(new Button("첫번째"));
        f.add(new Button("두번째"));
        f.add(new Button("세번째"));
        f.add(new Button("네번째"));
        f.add(new Button("다섯번째"));
        f.setVisible(true);
    }
}
```

- - -

### GridLayout
* GridLayout
  * 컨테이너를 테이블(표)처럼 행(row),열(col)로 나누어 컴포넌트를 배치한다.
  * 컴포넌트들은 모두 같은 크기로 나누어진다.
  * 컴포넌트들은 컨테이너의 첫 번째 행의 열들 - 두 번째 행의 열들 - .. 의 순서로 채워진다.
  * 컨테이너의 크기를 변경하면..
    * 각 영역이 모두 같은 비율로 커지거나 작아진다.
    
* GridbagLayout
  * GridbagLayout은 GridLayout과 같이 컨테이너를 열과 행으로 나누어 컴포넌트들을 배치할 수 있다. 
  * 각 영역은 서로 다른 크기로 지정될 수 있으며 인접한 열 또는 행으로의 확장이 가능하다. 
  * (HTML문서에서의 Table레이아웃을 설정하는 것과 비슷하다.)

    
#### GridLayout의 생성자, 메서드
* `GridLayout(int row, int col)` 또는 `GridLayout(int row, int col, int hgap, int vgap)` (생성자)
  * `row`, `col` : (필수) 컨테이너를 몇 개의 행/열로 나눌지 지정.
  * `hgap`, `vgap` : 각 영역 간 좌우/상하 간격을 지정.
  
#### GridLayout 사용하기
```java
import java.awt.*;

public class GridLayoutTest {
    public static void main(String[] args) {
        Frame f = new Frame("GridLayoutTest");
        f.setSize(150, 150);
        f.setLayout(new GridLayout(3, 2));
        // 3행 2열의 테이블을 만든다

        f.add(new Button("1")); // 추가되는 순서대로 Button에 번호를 붙였다
        f.add(new Button("2"));
        f.add(new Button("3"));
        f.add(new Button("4"));
        f.add(new Button("5"));
        f.add(new Button("6"));

        f.setVisible(true);
    }
}
```
  
- - -

### CardLayout
* CardLayout
  * 여러 화면을 슬라이드처럼 바꿔가며 보여줄 수 있는 레이아웃이다.
  * 여러 개의 컨테이너를 CardLayout에 추가한 다음, 
  * 순서대로/임의로 컨네이너를 선택해 보여줄 수 있다.
  * (예시) 설치마법사 처럼 단계별로 화면을 이동하는 경우.
  
#### CardLayout의 생성자, 메서드
* `CardLayout()` 또는 `CardLayout(int hgap, int vgap)` (생성자)
  * `hgap`, `vgap` : 컨테이너-CardLayout간의 수평/수직 간격 지정.
* `add(Container parent, String name)`, `show(Container parent, String name)`
  * `name` : 컨테이너의 이름 
  * `parent` : 추가될/보여질 컨테이너
* `first(Container parent)`, `last(Container parent)`
* `previous(Container parent)`, `next(Container parent)`

#### CardLayout 사용하기
```java
import java.awt.*;
import java.awt.event.*;

public class CardLayoutTest {
    public static void main(String[] args) {
        final Frame f = new Frame("CardLayoutTest");
        final CardLayout card = new CardLayout(10, 10);
        f.setLayout(card); // CardLayout로 설정

        Panel card1 = new Panel();
        card1.setBackground(Color.lightGray);
        card1.add(new Label("Card 1"));
        Panel card2 = new Panel();
        card2.add(new Label("Card 2"));
        card2.setBackground(Color.orange);
        Panel card3 = new Panel();
        card3.add(new Label("Card 3"));
        card3.setBackground(Color.cyan);

        f.add(card1, "1"); // Frame에 card1을 "1"이라고 이름 붙여 추가한다
        f.add(card2, "2");
        f.add(card3, "3");

        class Handler extends MouseAdapter {
            public void mouseClicked(MouseEvent e) {
                // 마우스 오른쪽 버튼을 눌렀을 때
                if (e.getModifiers() == e.BUTTON3_MASK) {
                    card.previous(f); // CardLayout의 이전 Panel을 보여준다
                } else {
                    card.next(f); // CardLayout의 다음 Panel을 보여준다
                }
            }
        } // class Handler

        card1.addMouseListener(new Handler());
        card2.addMouseListener(new Handler());
        card3.addMouseListener(new Handler());

        f.setSize(200, 200);
        f.setLocation(200, 200);
        f.setVisible(true);

        card.show(f, "1"); // Frame에 추가된 Component들 중 이름이 "1"인 것을 보여준다.
    }
}
```

- - - 
- - - 

# 이벤트 처리 event handling
