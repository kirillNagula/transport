package view.menu;

import view.actions.*;

import java.util.Map;

public class AdminMenu implements Menu {
    private Map<Integer, Action> actions;

    public AdminMenu(Map<Integer, Action> actions) {
        this.actions = actions;
    }

    @Override
    public Map<Integer, Action> getActions() {
        return this.actions;
    }
}
