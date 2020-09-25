package view.menu;

import view.actions.Action;

import java.util.Map;

public class StartMenu implements Menu {
    private Map<Integer, Action> actions;

    public StartMenu(Map<Integer, Action> actions) {
        this.actions = actions;
    }

    @Override
    public Map<Integer, Action> getActions() {
        return this.actions;
    }
}
