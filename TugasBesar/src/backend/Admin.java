/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;

import frontend.AdminMain;
import java.sql.ResultSet;
import java.util.ArrayList;


/**
 *
 * @author Gopla
 */
public class Admin extends User{

    public Admin(String nama, String username, String password, String role) {
        super.nama = nama;
        super.username = username;
        super.password = password;
        super.role = role;
    }

    public Admin() {
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
    
    public Admin getById(int key){
        Admin admin = new Admin();
        ResultSet rs = DBHelper.selectQuery("SELECT * FROM user " +
                                            "WHERE id_user = '"+ key +"'");
        try {
            while (rs.next()) {
                admin = new Admin();
                admin.setId_user(rs.getInt("id_user"));
                admin.setNama(rs.getString("nama"));
                admin.setUsername(rs.getString("usernmae"));
                admin.setPassword(rs.getString("password"));
                admin.setRole(rs.getString("role"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return admin;
    }
    
    public ArrayList<Admin> getAll(){
        ArrayList<Admin> listAdmin = new ArrayList();
        ResultSet rs = DBHelper.selectQuery("SELECT * FROM user");
        try {
            while (rs.next()) {
                Admin admin = new Admin();
                admin.setId_user(rs.getInt("id_user"));
                admin.setNama(rs.getString("nama"));
                admin.setUsername(rs.getString("usernmae"));
                admin.setPassword(rs.getString("password"));
                admin.setRole(rs.getString("role"));
                listAdmin.add(admin);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listAdmin;
    }
    
    public ArrayList<Admin> search(String key){
        ArrayList<Admin> listAdmin = new ArrayList();
        ResultSet rs = DBHelper.selectQuery("SELECT * FROM user WHERE " +
                                            "nama like '%"+ key +"%' OR " +
                                            "username like '%"+ key +"%'");
        try {
            while (rs.next()) {
                Admin admin = new Admin();
                admin.setId_user(rs.getInt("id_user"));
                admin.setNama(rs.getString("nama"));
                admin.setUsername(rs.getString("usernmae"));
                admin.setPassword(rs.getString("password"));
                admin.setRole(rs.getString("role"));
                listAdmin.add(admin);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listAdmin;
    }
    
    public void save(){
        if (getById(id_user).getId_user() == 0) {
            String SQL = "INSERT INTO user (nama, username, password, role) VALUES ("
                        + " '"+this.nama+"', "
                        + " '"+this.username+"', "
                        + " '"+this.password+"', "
                        + " '"+this.role+"' "
                        + " )";
            this.id_user = DBHelper.insertQueryGetId(SQL);
        }else{
            String SQL = "UPDATE user SET "
                        + " nama = '"+this.nama+"', "   
                        + " username = '"+this.username+"', "
                        + " password = '"+this.password+"', "
                        + " role = '"+this.role+"', "
                        + " WHERE id_user = '"+this.id_user+"' ";
            DBHelper.executeQuery(SQL);
        }
    }
    
    public void delete() {
        String SQL = "DELETE FROM user WHERE id_user = '"+this.id_user+"'";
        DBHelper.executeQuery(SQL);
    }
   

    @Override
    public void login(String uname, String pass) {
        String SQL = "SELECT * FROM user WHERE username = '"+ uname +"'" +
                     " AND password = '"+ pass +"'";
        ResultSet rs = DBHelper.selectQuery(SQL);
        try {
            while (rs.next()) { 
                setId_user(rs.getInt("id_user"));
                setRole(rs.getString("role"));
                if (rs.getString("role").equals("admin")) {
                    new AdminMain(getId_user(), getRole()).setVisible(true);
                }else{
                    System.out.println("halo");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public String getInfo(){
        return "Info Kasir : " + super.getInfo();
    }
    
}
