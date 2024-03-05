/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Responsitory;

import DomainModel.DongSP;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public interface InterfaceDongSPResponsitory {
    ArrayList<DongSP> read();
    DongSP getDongSPByMa(String Ma);
    int add(DongSP dsp);
    int delete(String Ma);
    int update(DongSP dsp);
}
