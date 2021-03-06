package view.menu;

import view.actions.*;

import java.util.Map;

public class UserMenu implements Menu  {
    private Map<Integer, Action> actions;

    public UserMenu(Map<Integer, Action> actions) {
        this.actions = actions;
    }

    @Override
    public Map<Integer, Action> getActions() {
        return this.actions;
    }
}
