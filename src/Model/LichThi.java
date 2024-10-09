/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author 
 */
public class LichThi implements Serializable {

    private String tenKyThi;
    private String monThi;
    private String ngayThi;
    private String caThi;
    private String phongThi;
    private String diemThi;
    private List<String> listHS;
    private int soSV = 0;

    public LichThi() {
    }

    public LichThi(String tenKyThi, String monThi, String ngayThi, String caThi, String phongThi, String diemThi, List<String> listHS) {
        this.tenKyThi = tenKyThi;
        this.monThi = monThi;
        this.ngayThi = ngayThi;
        this.caThi = caThi;
        this.phongThi = phongThi;
        this.diemThi = diemThi;
        this.listHS = listHS;
        this.soSV = listHS.size();
    }

    public String getTenKyThi() {
        return tenKyThi;
    }

    public void setTenKyThi(String tenKyThi) {
        this.tenKyThi = tenKyThi;
    }

    public String getMonThi() {
        return monThi;
    }

    public void setMonThi(String monThi) {
        this.monThi = monThi;
    }

    public String getNgayThi() {
        return ngayThi;
    }

    public void setNgayThi(String ngayThi) {
        this.ngayThi = ngayThi;
    }

    public String getCaThi() {
        return caThi;
    }

    public void setCaThi(String caThi) {
        this.caThi = caThi;
    }

    public String getPhongThi() {
        return phongThi;
    }

    public void setPhongThi(String phongThi) {
        this.phongThi = phongThi;
    }

    public String getDiemThi() {
        return diemThi;
    }

    public void setDiemThi(String diemThi) {
        this.diemThi = diemThi;
    }

    public List<String> getListHS() {
        return listHS;
    }

    public void setListHS(List<String> listSV) {
        this.listHS = listSV;
    }

    public int getSoHS() {
        return soSV;
    }

    public void setSoHS(int soSV) {
        this.soSV = soSV;
    }
    public void xoaHS(List<String> needToRemove){
        listHS.removeAll(needToRemove);
    }
    public void themHS(String needToAdd){
        listHS.add(needToAdd);
    }
    @Override
    public String toString() {
        String data;
        data = String.format("%s,%s,%s,%s,%s,%s,%d\n", tenKyThi, monThi, ngayThi, caThi, phongThi, diemThi.toUpperCase(), listHS.size());
        for (int i = 0; i < this.listHS.size(); i++) {
            data += listHS.get(i)+"\n";
        }
        return data;
    }
}
