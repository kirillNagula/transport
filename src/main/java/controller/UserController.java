package controller;

import dao.DbUserDao;
import exception.NoUserException;
import model.User;

public class UserController {
    private DbUserDao dbUserDao = new DbUserDao();

    public String getAccess(User user) throws NoUserException {
        if (dbUserDao.getAccess(user) == null)
            throw new NoUserException();
        else return dbUserDao.getAccess(user);

    }
}
