package view;

import exception.ExitException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import view.actions.Action;
import view.menu.Menu;

import java.util.Map;

@Component
public class ConsoleView {
    private Menu menu;

    public ConsoleView(@Qualifier("startMenu") Menu menu) {
        this.menu = menu;
    }

    public void start(){
        System.out.println("Начало");
        run();
        System.out.println("Конец");
    }

    private void run() {

        while (true){
            Action action = getAction(menu);

            try {
                action.action();
            } catch (ExitException e) {
                break;
            }
        }
    }

    private Action getAction(Menu menu) {
        showMenu(menu);
        int num = Input.getInt("Выберите действие");
        Action action = menu.getActions().get(num);
        if (action != null){
            return action;
        }
        System.out.println("Нет такого действия. Повтороите ввод");
        return getAction(menu);
    }

    private void showMenu(Menu menu){
        for (Map.Entry<Integer, Action> actionEntry : menu.getActions().entrySet())
            System.out.println(actionEntry.getKey() + " - " + actionEntry.getValue().getName());
    }
}
