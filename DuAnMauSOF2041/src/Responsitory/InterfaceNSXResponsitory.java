/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Responsitory;

import DomainModel.NSX;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public interface InterfaceNSXResponsitory {
    ArrayList<NSX> read();
    NSX getNSXByMa(String Ma);
    int add(NSX nsx);
    int delete(String Ma);
    int update(NSX nsx);
}
