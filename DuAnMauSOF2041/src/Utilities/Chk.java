/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utilities;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Admin
 */
public class Chk {
    public static boolean chknull(String mess, JTextField txt) {
        if (txt.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, mess, "Lỗi", JOptionPane.ERROR_MESSAGE);
            txt.requestFocus();
            return true;
        } else {
            return false;
        }
    }
    
    public static boolean chkInt(String mess1, String mess2, JTextField txt) {
        if (txt.getText().length() > 0) {
            try {
                int a = Integer.parseInt(txt.getText());
                if (a < 0) {
                    JOptionPane.showMessageDialog(null, mess2, "Lỗi", JOptionPane.ERROR_MESSAGE);
                    txt.requestFocus();
                    return true;
                } else {
                    return false;
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, mess1, "Lỗi", JOptionPane.ERROR_MESSAGE);
                txt.requestFocus();
                return true;
            }
        } else {
            return false;
        }
    }

    public static boolean chkFloat(String mess1, String mess2, JTextField txt) {
        if (txt.getText().length() > 0) {
            try {
                float a = Float.parseFloat(txt.getText());
                if (a < 0) {
                    JOptionPane.showMessageDialog(null, mess2, "Lỗi", JOptionPane.ERROR_MESSAGE);
                    txt.requestFocus();
                    return true;
                } else {
                    return false;
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, mess1, "Lỗi", JOptionPane.ERROR_MESSAGE);
                txt.requestFocus();
                return true;
            }
        } else {
            return false;
        }
    }
    
    public static boolean chkDate(String mess,JTextField txt){
        SimpleDateFormat datefm = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date date = datefm.parse(txt.getText());
            return false;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, mess, "Lỗi", JOptionPane.ERROR_MESSAGE);
            txt.requestFocus();
            return true;
        }
    }
}
