import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import view.actions.Action;
import view.menu.AdminMenu;
import view.menu.Menu;
import view.menu.StartMenu;
import view.menu.UserMenu;

import java.util.HashMap;
import java.util.Map;

@Configuration
@ComponentScan (basePackages = {"controller", "dao", "service", "view"})
public class RootConfiguration {

    @Bean
    public Menu adminMenu(Action addCountry, Action addTransport, Action editCountry, Action editTransport, Action exit, Action report, Action removeCountry, Action removeTransport,  Action showCountry, Action showTransport, Action transportService){
        Map<Integer, Action> actions = new HashMap<>();
        actions.put(1, addCountry);
        actions.put(2, showCountry);
        actions.put(3, removeCountry);
        actions.put(4, editCountry);
        actions.put(5, addTransport);
        actions.put(6, showTransport);
        actions.put(7, removeTransport);
        actions.put(8, editTransport);
        actions.put(9, report);
        actions.put(10, transportService);
        actions.put(0, exit);
        return new AdminMenu(actions);
    }

    @Bean
    public Menu userMenu(Action exit, Action showCountry, Action showTransport, Action transportService){
        Map<Integer, Action> actions = new HashMap<>();
        actions.put(1, showCountry);
        actions.put(2, showTransport);
        actions.put(3, transportService);
        actions.put(0, exit);
        return new UserMenu(actions);
    }

    @Bean
    public Menu startMenu(Action exit, Action select){
        Map<Integer, Action> actions = new HashMap<>();
        actions.put(1, select);
        actions.put(0, exit);
        return new StartMenu(actions);
    }
}
