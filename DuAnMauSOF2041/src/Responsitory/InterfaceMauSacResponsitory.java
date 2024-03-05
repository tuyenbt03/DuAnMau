/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Responsitory;

import DomainModel.MauSac;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public interface InterfaceMauSacResponsitory {
    ArrayList<MauSac> read();
    MauSac getChucVuByMa(String Ma);
    int add(MauSac ms);
    int delete(String Ma);
    int update(MauSac ms);
}
