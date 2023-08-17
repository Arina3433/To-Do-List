import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;

public class ButtonEventManager implements ActionListener {

    ButtonGroup dayOfTheWeekGroup;
    JTextField numberOfTasksField;

    public ButtonEventManager(ButtonGroup dayOfTheWeekGroup, JTextField numberOfTasksField) {
        this.dayOfTheWeekGroup = dayOfTheWeekGroup;
        this.numberOfTasksField = numberOfTasksField;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        for(Enumeration<AbstractButton> radioButtons = dayOfTheWeekGroup.getElements(); radioButtons.hasMoreElements();)
        /* КакБудтоМассив<КакБудтоТипДанных> названиеМассива = передаемВМассивЭлементыИзГруппыКнопок(); прописываем чтобы
        перебирать элементы в массиве (показать что они там дальше есть и до конца массива) */
        {
            AbstractButton abstractButton = radioButtons.nextElement();
            /*На основе класса AbstractButton, который включает в себя какие-то типы кнопок, и в частности например
            RadioButton, создаем объект, в который передаем первый (и далее) элемент массива */
            if (abstractButton.isSelected()) {
                String chosenDayOfTheWeek = abstractButton.getText();
                new WindowWithTaskList(chosenDayOfTheWeek, Integer.parseInt(numberOfTasksField.getText())).setVisible(true);
                break;
            }
        }
    }
}