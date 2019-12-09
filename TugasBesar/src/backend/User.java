/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;

/**
 *
 * @author Gopla
 */
abstract class User {
    protected int id_user;
    protected String nama, username, password, role;
    
    abstract void login(String uname, String pass);
    
    public String getInfo(){
        return "\n\nNama     : " + nama +
               "\n\nRole     : " + role +
               "\n\tUsername : " + username;
    }
}
