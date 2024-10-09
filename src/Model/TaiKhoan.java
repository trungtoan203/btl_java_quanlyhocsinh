/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Model;

/**
 *
 * @author HoangCongMinh
 */
public class TaiKhoan {
    private String userName;
    private String password;
    private String nameAccount;

    public TaiKhoan(String userName, String password, String nameAccount) {
        this.userName = userName;
        this.password = password;
        this.nameAccount = nameAccount;
    }
    
    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }
    
    public String getNameAccount(){
        return nameAccount;
    }
}
