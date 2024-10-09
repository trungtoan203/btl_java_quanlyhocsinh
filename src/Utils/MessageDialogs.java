/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Utils;

import java.awt.Component;
import javax.swing.JOptionPane;

/**
 *
 * @author HoangCongMinh
 */
public class MessageDialogs {
    public static void ShowErrorMessage(Component c, String content, String typeMess){
        JOptionPane.showMessageDialog(c, content, typeMess, JOptionPane.ERROR_MESSAGE);
    }
    public static void ShowMessage(Component c, String content, String typeMess){
        JOptionPane.showMessageDialog(c, content, typeMess, JOptionPane.INFORMATION_MESSAGE);
    }
    public static int ShowConfirmMessage(Component c, String content, String typeMess){
        int choose= JOptionPane.showConfirmDialog(c, content, typeMess, JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
       return choose;
    }
}
