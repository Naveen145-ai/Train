import java.util.HashMap;

public class UserLoginSystem {
    HashMap<String, String> users = new HashMap<>();
    String current = null;

    public UserLoginSystem() {
        users.put("user1", "pass123");
        users.put("user2", "pass456");
        users.put("admin", "admin123");
    }

    public boolean register(String u, String p) {
        if (users.containsKey(u)) return false;
        users.put(u, p);
        return true;
    }

    public boolean login(String u, String p) {
        if (users.containsKey(u) && users.get(u).equals(p)) {
            current = u;
            return true;
        }
        return false;
    }

    public boolean logout() {
        current = null;
        return true;
    }

    public String getLoggedInUser() {
        return current;
    }

    public boolean isLoggedIn() {
        return current != null;
    }
}
