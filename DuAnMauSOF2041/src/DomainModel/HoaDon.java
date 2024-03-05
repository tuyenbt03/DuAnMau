/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DomainModel;

import java.util.Date;

/**
 *
 * @author baphuoc
 */
public class HoaDon {

    private String id;
    private String ma;
    private Date ngayTao;
    private int TrangThai;

    public HoaDon() {
    }

    public HoaDon(String ma, Date ngayTao, int TrangThai) {
        this.ma = ma;
        this.ngayTao = ngayTao;
        this.TrangThai = TrangThai;
    }

    public HoaDon(String id, String ma, Date ngayTao, int TrangThai) {
        this.id = id;
        this.ma = ma;
        this.ngayTao = ngayTao;
        this.TrangThai = TrangThai;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public Date getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }

    public int getTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(int TrangThai) {
        this.TrangThai = TrangThai;
    }
    

}
