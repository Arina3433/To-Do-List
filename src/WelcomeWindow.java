import javax.swing.*;
import java.awt.*;
import java.util.Enumeration;

public class WelcomeWindow extends JFrame {
    JTextField numberOfTasksField;
    JRadioButton mon, tue, wed, thu, fri, sat, sun;
    JButton setContinueButton;

    public WelcomeWindow() {
        super("Hello");
        setSize(1000, 400);
        setLocation(5, 5);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        ButtonGroup buttonDayOfTheWeekGroup = creatingDayOfTheWeekButtonGroup();

        JPanel numberOfTasksPanel = creatingNumberOfTasksPanel();
        JPanel continueButtonPanel = creatingContinueButtonPanel();
        numberOfTasksPanel.add(continueButtonPanel);
        /* Эти две панели пришлось отдельно создавать и объединять чисто для нормального отображения, а то они скачут
        если в контейнер добавить больше 3 объектов (на 28 строке)
        Ты вроде разрешил не заморачиваться с интерфейсом поэтому так)) */

        Container container = getContentPane();
        container.add(creatingWelcomeTextPanel(), BorderLayout.NORTH);
        container.add(creatingDayOfTheWeekButtonPanel(buttonDayOfTheWeekGroup), BorderLayout.CENTER);
        container.add(numberOfTasksPanel, BorderLayout.AFTER_LAST_LINE);

        setContinueButton.addActionListener(new ButtonEventManager(buttonDayOfTheWeekGroup, numberOfTasksField));
    }

    private JPanel creatingWelcomeTextPanel() {
        JPanel gridWelcomeTextPanel = new JPanel(new GridLayout(2, 1, 1, 0));
        gridWelcomeTextPanel.add(new JLabel("Здравствуйте!"));
        gridWelcomeTextPanel.add(new JLabel("Чтобы составить список задач на день, пожалуйста выберите " +
                "день недели и количество запланированных дел :)"));

        return gridWelcomeTextPanel;
    }

    private ButtonGroup creatingDayOfTheWeekButtonGroup() {
        ButtonGroup buttonDayOfTheWeekGroup = new ButtonGroup();
        buttonDayOfTheWeekGroup.add(mon = new JRadioButton("Понедельник"));
        buttonDayOfTheWeekGroup.add(tue = new JRadioButton("Вторник"));
        buttonDayOfTheWeekGroup.add(wed = new JRadioButton("Среда"));
        buttonDayOfTheWeekGroup.add(thu = new JRadioButton("Четверг"));
        buttonDayOfTheWeekGroup.add(fri = new JRadioButton("Пятница"));
        buttonDayOfTheWeekGroup.add(sat = new JRadioButton("Суббота"));
        buttonDayOfTheWeekGroup.add(sun = new JRadioButton("Воскресенье"));

        mon.setSelected(true);

        return buttonDayOfTheWeekGroup;
    }

    private JPanel creatingDayOfTheWeekButtonPanel(ButtonGroup buttonDayOfTheWeekGroup) {
        JPanel gridDayOfTheWeekButtonPanel = new JPanel(new GridLayout(5, 2, 2, 5));
        gridDayOfTheWeekButtonPanel.add(new JLabel("Выберете день недели:"));
        gridDayOfTheWeekButtonPanel.add(new JLabel(""));

        for (Enumeration<AbstractButton> dayOfTheWeekGroupElements = buttonDayOfTheWeekGroup.getElements();
             dayOfTheWeekGroupElements.hasMoreElements(); ) {
            AbstractButton abstractButton = dayOfTheWeekGroupElements.nextElement();
            gridDayOfTheWeekButtonPanel.add(abstractButton);
        }

        return gridDayOfTheWeekButtonPanel;
    }

    private JPanel creatingNumberOfTasksPanel() {
        JPanel gridNumberOfTasksPanel = new JPanel(new GridLayout(2, 2, 2, 5));
        gridNumberOfTasksPanel.add(new JLabel("Введите количество задач: "));
        gridNumberOfTasksPanel.add(numberOfTasksField = new JTextField());

        return gridNumberOfTasksPanel;
    }

    private JPanel creatingContinueButtonPanel() {
        JPanel flowContinueButtonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        flowContinueButtonPanel.add(setContinueButton = new JButton("Продолжить"));
        setContinueButton.setPreferredSize(new Dimension(110, 40));

        return flowContinueButtonPanel;
    }
}

    /*private JPanel creatingDayOfTheWeekButtonPanel() {
        JPanel gridDayOfTheWeekButton = new JPanel(new GridLayout(5, 2, 2, 5));
        gridDayOfTheWeekButton.add(new JLabel("Выберете день недели:"));
        gridDayOfTheWeekButton.add(new JLabel(""));
        gridDayOfTheWeekButton.add(mon = new JRadioButton("Понедельник"));
        gridDayOfTheWeekButton.add(tue = new JRadioButton("Вторник"));
        gridDayOfTheWeekButton.add(wed = new JRadioButton("Среда"));
        gridDayOfTheWeekButton.add(thu = new JRadioButton("Четверг"));
        gridDayOfTheWeekButton.add(fri = new JRadioButton("Пятница"));
        gridDayOfTheWeekButton.add(sat = new JRadioButton("Суббота"));
        gridDayOfTheWeekButton.add(sun = new JRadioButton("Воскресенье"));

        mon.setSelected(true);

        ButtonGroup buttonDayOfTheWeekGroup = new ButtonGroup();
        buttonDayOfTheWeekGroup.add(mon);
        buttonDayOfTheWeekGroup.add(tue);
        buttonDayOfTheWeekGroup.add(wed);
        buttonDayOfTheWeekGroup.add(thu);
        buttonDayOfTheWeekGroup.add(fri);
        buttonDayOfTheWeekGroup.add(sat);
        buttonDayOfTheWeekGroup.add(sun);

        return gridDayOfTheWeekButton;
    } */

    /*private ButtonGroup creatingButtonDayOfTheWeekGroup(JPanel gridDayOfTheWeekButton) {
        for(Enumeration<> )
        ButtonGroup buttonDayOfTheWeekGroup = new ButtonGroup();
        buttonDayOfTheWeekGroup.add(mon);
        buttonDayOfTheWeekGroup.add(tue);
        buttonDayOfTheWeekGroup.add(wed);
        buttonDayOfTheWeekGroup.add(thu);
        buttonDayOfTheWeekGroup.add(fri);
        buttonDayOfTheWeekGroup.add(sat);
        buttonDayOfTheWeekGroup.add(sun);

        return buttonDayOfTheWeekGroup;
    }

    private void userDataInputHandler() {
        numberOfTasks = Integer.parseInt(numberOfTasksField.getText());
        if (mon.isSelected())
            dayOfTheWeek = "понедельник";
        else if (tue.isSelected())
            dayOfTheWeek = "вторник";
        else if (wed.isSelected())
            dayOfTheWeek = "среда";
        else if (thu.isSelected())
            dayOfTheWeek = "четверг";
        else if (fri.isSelected())
            dayOfTheWeek = "пятница";
        else if (sat.isSelected())
            dayOfTheWeek = "суббота";
        else
            dayOfTheWeek = "воскресенье";
    }

    public int getNumberOfTasks() {
        return numberOfTasks;
    }

    public String getDayOfTheWeek() {
        return dayOfTheWeek;
    }

     */