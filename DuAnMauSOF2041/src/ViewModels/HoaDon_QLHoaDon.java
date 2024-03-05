/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ViewModels;

import java.util.Date;

/**
 *
 * @author baphuoc
 */
public class HoaDon_QLHoaDon {
    private int sTT;
    private String Ma;
    private Date ngayTao;
    private String tenNV;
    private int TinhTrang;

    public HoaDon_QLHoaDon() {
    }

    public HoaDon_QLHoaDon(int sTT, String Ma, Date ngayTao, String tenNV, int TinhTrang) {
        this.sTT = sTT;
        this.Ma = Ma;
        this.ngayTao = ngayTao;
        this.tenNV = tenNV;
        this.TinhTrang = TinhTrang;
    }

    public int getsTT() {
        return sTT;
    }

    public void setsTT(int sTT) {
        this.sTT = sTT;
    }

    public String getMa() {
        return Ma;
    }

    public void setMa(String Ma) {
        this.Ma = Ma;
    }

    public Date getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }

    public String getTenNV() {
        return tenNV;
    }

    public void setTenNV(String tenNV) {
        this.tenNV = tenNV;
    }

    public int getTinhTrang() {
        return TinhTrang;
    }

    public void setTinhTrang(int TinhTrang) {
        this.TinhTrang = TinhTrang;
    }
    
}
