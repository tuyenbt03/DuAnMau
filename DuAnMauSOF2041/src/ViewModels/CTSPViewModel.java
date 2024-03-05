/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ViewModels;

/**
 *
 * @author Admin
 */
public class CTSPViewModel {
    private int Stt;
    private String id;
    private String MasanPham;
    private String TensanPham;
    private String mauSac;
    private int NamBH;
    private String moTa;
    private int slTon;
    private float giaNhap;
    private float giaBan;

    public CTSPViewModel() {
    }

    public CTSPViewModel(int Stt, String id, String MasanPham, String TensanPham, String mauSac, int NamBH, String moTa, int slTon, float giaNhap, float giaBan) {
        this.Stt = Stt;
        this.id = id;
        this.MasanPham = MasanPham;
        this.TensanPham = TensanPham;
        this.mauSac = mauSac;
        this.NamBH = NamBH;
        this.moTa = moTa;
        this.slTon = slTon;
        this.giaNhap = giaNhap;
        this.giaBan = giaBan;
    }

    public int getStt() {
        return Stt;
    }

    public void setStt(int Stt) {
        this.Stt = Stt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMasanPham() {
        return MasanPham;
    }

    public void setMasanPham(String MasanPham) {
        this.MasanPham = MasanPham;
    }

    public String getTensanPham() {
        return TensanPham;
    }

    public void setTensanPham(String TensanPham) {
        this.TensanPham = TensanPham;
    }

    public String getMauSac() {
        return mauSac;
    }

    public void setMauSac(String mauSac) {
        this.mauSac = mauSac;
    }

    public int getNamBH() {
        return NamBH;
    }

    public void setNamBH(int NamBH) {
        this.NamBH = NamBH;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public int getSlTon() {
        return slTon;
    }

    public void setSlTon(int slTon) {
        this.slTon = slTon;
    }

    public float getGiaNhap() {
        return giaNhap;
    }

    public void setGiaNhap(float giaNhap) {
        this.giaNhap = giaNhap;
    }

    public float getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(float giaBan) {
        this.giaBan = giaBan;
    }
    
    
}
