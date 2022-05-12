package learn.solar.domain;

import learn.solar.models.Panel;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PanelResult {

    private ArrayList<String> messages = new ArrayList<>();

    private Panel panel;
    public boolean isSuccess() {
        return messages.size() == 0;
    }

    public List<String> getMessages() {
        return new ArrayList<>(messages);
    }

    public Panel getPanel() {
        return panel;
    }

    public void setPanel(Panel panel) {
        this.panel = panel;
    }

    public void addMessages(String message) {
        messages.add(message);
    }
}
