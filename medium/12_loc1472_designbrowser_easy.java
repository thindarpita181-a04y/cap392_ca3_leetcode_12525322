import java.util.ArrayList;
import java.util.List;

class BrowserHistory {
    private List<String> history;
    private int curr; // Index of the current page
    private int last; // Index of the furthest valid forward page

    public BrowserHistory(String homepage) {
        history = new ArrayList<>();
        history.add(homepage);
        curr = 0;
        last = 0;
    }
    
    public void visit(String url) {
        curr++;
        // Overwrite existing forward history if available, otherwise append
        if (curr < history.size()) {
            history.set(curr, url);
        } else {
            history.add(url);
        }
        // Visiting a new page clears all forward history beyond 'curr'
        last = curr;
    }
    
    public String back(int steps) {
        // Move back at most to index 0
        curr = Math.max(0, curr - steps);
        return history.get(curr);
    }
    
    public String forward(int steps) {
        // Move forward at most to 'last'
        curr = Math.min(last, curr + steps);
        return history.get(curr);
    }
}
