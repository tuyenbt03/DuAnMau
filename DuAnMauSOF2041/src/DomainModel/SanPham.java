/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DomainModel;

/**
 *
 * @author Admin
 */
public class SanPham {
    private String Id;
    private String Ma;
    private String Ten;

    public SanPham() {
    }

    public SanPham(String Id, String Ma, String Ten) {
        this.Id = Id;
        this.Ma = Ma;
        this.Ten = Ten;
    }

    public SanPham(String Ma, String Ten) {
        this.Ma = Ma;
        this.Ten = Ten;
    }
    
    @Override
    public String toString() {
        return "SanPham_Model{" + "id=" + Id + ", ma=" + Ma + ", ten=" + Ten + '}';
    }

    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    public String getMa() {
        return Ma;
    }

    public void setMa(String Ma) {
        this.Ma = Ma;
    }

    public String getTen() {
        return Ten;
    }

    public void setTen(String Ten) {
        this.Ten = Ten;
    }
    
    
}
