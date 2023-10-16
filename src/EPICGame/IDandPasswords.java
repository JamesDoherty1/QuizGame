package EPICGame;

import java.util.HashMap;

public class IDandPasswords {
    HashMap<String, String> logininfo = new HashMap();

    IDandPasswords() {
        this.logininfo.put("james", "doherty");
        this.logininfo.put("user", "password");
        this.logininfo.put("123", "abc");
    }

    public HashMap getLoginInfo() {
        return this.logininfo;
    }
}