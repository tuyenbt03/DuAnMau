/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Responsitory;

import DomainModel.ChucVu;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public interface InterfaceChucVuResponsitory {
    ArrayList<ChucVu> read();
    ChucVu getChucVuByMa(String Ma);
    int add(ChucVu cv);
    int delete(String Ma);
    int update(ChucVu cv);
}
