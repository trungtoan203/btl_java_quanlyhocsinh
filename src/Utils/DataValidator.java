/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Utils;

import java.awt.Color;
import javax.swing.*;

/**
 *
 * @author HoangCongMinh
 */
public class DataValidator {
    public static void ValidateIsEmpty(JTextField txtF, StringBuilder sb, String errorMess){
        if(txtF.getText().equals("")){
            sb.append(errorMess);
            txtF.setBackground(Color.red);
        }
        else{
            txtF.setBackground(Color.white);
        }
    }
    public static void ValidateIsSelected(ButtonGroup btnGr, StringBuilder sb, String errorMess){
        ButtonModel tmpBtn = btnGr.getSelection();
        if(tmpBtn == null){
            sb.append(errorMess);
        }
        else {
            sb.append("");
        }
    }
    public static void ValidateIsComboBoxSelected(JComboBox comboBox, StringBuilder sb, String errorMess){
        int tmp = comboBox.getSelectedIndex();
        if(tmp < 1){
            sb.append(errorMess);
        }
        else {
            sb.append("");
        }
    }
}
