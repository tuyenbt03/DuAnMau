/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ViewModels;

import DomainModel.ChiTietSP;
import DomainModel.HoaDon;

/**
 *
 * @author baphuoc
 */
public class GioHang_QLHoaDon {
    private int STT;
    private String MaSP;
    private String Mau;
    private int SL;
    private float donGia;
    private float ThanhTien;

    public GioHang_QLHoaDon() {
    }

    public GioHang_QLHoaDon(int STT, String MaSP, String Mau, int SL, float donGia, float ThanhTien) {
        this.STT = STT;
        this.MaSP = MaSP;
        this.Mau = Mau;
        this.SL = SL;
        this.donGia = donGia;
        this.ThanhTien = ThanhTien;
    }

    public int getSTT() {
        return STT;
    }

    public void setSTT(int STT) {
        this.STT = STT;
    }

    public String getMaSP() {
        return MaSP;
    }

    public void setMaSP(String MaSP) {
        this.MaSP = MaSP;
    }

    public String getMau() {
        return Mau;
    }

    public void setMau(String Mau) {
        this.Mau = Mau;
    }

    public int getSL() {
        return SL;
    }

    public void setSL(int SL) {
        this.SL = SL;
    }

    public float getDonGia() {
        return donGia;
    }

    public void setDonGia(float donGia) {
        this.donGia = donGia;
    }

    public float getThanhTien() {
        return ThanhTien;
    }

    public void setThanhTien(float ThanhTien) {
        this.ThanhTien = ThanhTien;
    }
    
}
