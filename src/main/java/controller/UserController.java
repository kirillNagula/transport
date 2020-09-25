package controller;

import dao.DbUserDao;
import exception.NoUserException;
import model.User;
import org.springframework.stereotype.Component;

@Component
public class UserController {
    private DbUserDao dbUserDao;

    public UserController(DbUserDao dbUserDao) {
        this.dbUserDao = dbUserDao;
    }

    public String getAccess(User user) throws NoUserException {
        if (dbUserDao.getAccess(user) == null)
            throw new NoUserException();
        else return dbUserDao.getAccess(user);

    }
}
