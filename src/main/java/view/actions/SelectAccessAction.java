package view.actions;

import controller.UserController;
import exception.ExitException;
import exception.NoUserException;
import model.User;
import view.Input;
import view.menu.AdminMenu;
import view.menu.Menu;
import view.menu.UserMenu;

public class SelectAccessAction implements Action {
    private UserController controller = new UserController();
    private Menu menu;

    public void action() throws ExitException {
        User user = new User();
        String userName = Input.getString("Введите имя пользователя");
        String password = Input.getString("Введите пароль");
        user.setName(userName);
        user.setPassword(password);
        try {
            String access = controller.getAccess(user);
            if (access.equals("Administrator")){//админ меню
                new AdminMenu();
            }
            if (access.equals("USER")){//юзер меню
                new UserMenu();
            }
        } catch (NoUserException e) {
            System.out.println(e.getMessage());
        }
    }


    public String getName() {
        return "Авторизироваться";
    }
}

