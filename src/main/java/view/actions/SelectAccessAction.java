package view.actions;

import controller.UserController;
import exception.ExitException;
import exception.NoUserException;
import model.User;
import org.springframework.stereotype.Component;
import view.Input;
import view.menu.Menu;

@Component("select")
public class SelectAccessAction implements Action {
    private UserController controller;
    private Menu menu;

    public SelectAccessAction(UserController controller) {
        this.controller = controller;
    }

    public void action() throws ExitException {
        User user = new User();
        String userName = Input.getString("Введите имя пользователя");
        String password = Input.getString("Введите пароль");
        user.setName(userName);
        user.setPassword(password);
        try {
            String access = controller.getAccess(user);
            if (access.equals("Administrator")){//админ меню
                menu.getActions();
            }
            if (access.equals("USER")){//юзер меню
                menu.getActions();
            }
        } catch (NoUserException e) {
            System.out.println(e.getMessage());
        }
    }


    public String getName() {
        return "Авторизироваться";
    }
}

