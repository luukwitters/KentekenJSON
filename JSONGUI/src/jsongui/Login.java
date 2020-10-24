/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsongui;

/**
 *
 * @author luukw
 */
class Login {

    static void add(Login log) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    private final String username;
    private final String password;
    
    public Login(String sUsername, String sPassword){
        this.password = sPassword;
        this.username = sUsername;
        
        
        
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
