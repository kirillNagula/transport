package view.menu;

import view.actions.Action;
import view.actions.ExitAction;
import view.actions.SelectAccessAction;

import java.util.HashMap;
import java.util.Map;

public abstract class Menu {
     public static Map<Integer, Action> map = new HashMap<>();

     static {
         map.put(1, new SelectAccessAction());
         map.put(0, new ExitAction());
     }
}
