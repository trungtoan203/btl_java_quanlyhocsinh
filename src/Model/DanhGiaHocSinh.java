package Model;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author 
 */
public class DanhGiaHocSinh extends HocSinh{
    private int score;
    private String xeploai;

    public DanhGiaHocSinh() {
    }

    public DanhGiaHocSinh(String maHS, String hoTen,int score, String xeploai) {
        super(maHS,hoTen);
        this.score = score;
        this.xeploai = xeploai.isEmpty()?"":xeploai;
    }

    public int getScore() {
        return score;
    }

    public String getMaHS() {
        return maHS;
    }

    public void setMaHS(String maHS) {
        this.maHS = maHS;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }
    
    public void setScore(int score) {
        this.score = score;
    }

    public String getXeploai() {
        return xeploai;
    }

    public void setXeploai(String xeploai) {
        this.xeploai = xeploai;
    }
    

    @Override
    public String toString() {
        return  super.getMaHS()+","+ super.getHoTen()+ "," + score +","+ xeploai ;
    }
    
    
    
}
