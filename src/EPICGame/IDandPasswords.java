package EPICGame;

import java.util.HashMap;

public class IDandPasswords {
    HashMap<String, String> logininfo = new HashMap();
    //HashMap for storing Info

    IDandPasswords() {
        this.logininfo.put("james", "doherty");
        this.logininfo.put("user", "password");
        this.logininfo.put("123", "abc");
        //Stores a key and a value
    }

    public HashMap getLoginInfo() {
        return this.logininfo;
    }
}