/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

/**
 *
 * @author Admin
 */
public class AllService {
    public static InterfaceChucVuService getChucVuService(){
        return new ChucVuService();
    }
    
    public static InterfaceDongSPService getDongSPService(){
        return new DongSPService();
    }
    
    public static InterfaceMauSacService getMauSacService(){
        return new MauSacService();
    }
    
    public static InterfaceNSXService getNSXService(){
        return new NSXService();
    }
    
    public static InterfaceSanPhamService getSanPhamService(){
        return new SanPhamService();
    }
    
    public static InterfaceCuaHangService getCuaHangService(){
        return new CuaHangService();
    }
    
    public static InterfaceKhachHangService getKhachHangService(){
        return new KhachHangService();
    }
    
    public static InterfaceNhanVienService getNhanVienService(){
        return new NhanVienService();
    }
    
    public static InterfaceChiTietSPService getChiTietSPService(){
        return new ChiTietSPService();
    }
    
    public static InterfaceHoaDonService getHoaDonService(){
        return new HoaDonService();
    }
    
    public static InterfaceHDChiTietService getHDChiTietService(){
        return new HDChiTietService();
    }
}
