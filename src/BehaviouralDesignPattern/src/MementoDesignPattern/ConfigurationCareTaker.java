package MementoDesignPattern;

import java.util.ArrayList;
import java.util.List;

public class ConfigurationCareTaker {
    List<ConfigurationMemento> history = new ArrayList<ConfigurationMemento>();

    public void addMemnento(ConfigurationMemento memnento) {
        history.add(memnento);
    }

    public ConfigurationMemento undo(){
        if(!history.isEmpty()){
            int lastMemnentoIndex = history.size() - 1;
            ConfigurationMemento memnento = history.get(lastMemnentoIndex);
            history.remove(lastMemnentoIndex);
            return memnento;
        }
        return null;
    }
}
