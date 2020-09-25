package view.menu;

import view.actions.Action;
import view.actions.ExitAction;
import view.actions.SelectAccessAction;

import java.util.HashMap;
import java.util.Map;

public interface Menu {
    Map<Integer, Action> getActions();
}
