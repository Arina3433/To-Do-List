import javax.swing.*;
import java.awt.*;

public class WindowWithTaskList extends JFrame {
    public WindowWithTaskList(String dayOfTheWeek, int numberOfTasks) {
        super ("Список задач");
        setSize(1000, 400);
        setLocation(30, 30);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        Container container = getContentPane();
        container.add(creatingTaskListPanel(dayOfTheWeek, numberOfTasks));
    }

    private JPanel creatingTaskListPanel(String dayOfTheWeek, int numberOfTasks) {
        JPanel gridTaskListPanel = new JPanel(new GridLayout((numberOfTasks + 2), 3, 5, 1));
        gridTaskListPanel.add(new JLabel("Добро пожаловать!"));
        gridTaskListPanel.add(new JLabel(""));
        gridTaskListPanel.add(new JLabel(""));
        gridTaskListPanel.add(new JLabel("Сегодня " + dayOfTheWeek + "! Какие у вас планы?"));
        gridTaskListPanel.add(new JLabel(""));
        gridTaskListPanel.add(new JLabel(""));

        for (int i = 0; i < numberOfTasks; i++) {
            gridTaskListPanel.add(new JLabel("Задача " + (i + 1)));
            gridTaskListPanel.add(new JTextField());
            gridTaskListPanel.add(new JCheckBox("Выполнено", false));
        }

        return gridTaskListPanel;
    }
}
