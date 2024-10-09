/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/*
 *
 * @author Pham Xuan Trung
 *
 */

package Engine;

import Model.LichThi;
import Model.HocSinh;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DBLichThiEngine {

    public static void writeFile(String fileName, List list) throws Exception {
        try (BufferedWriter write = new BufferedWriter(new FileWriter(fileName))) {
            for (Object obj : list) {
                write.write(obj.toString());
                write.newLine();
            }
        } catch (IOException ex) {
            System.out.println(ex.toString());
        }
    }

    public static List<LichThi> lichThiFromFile(String fileName) throws Exception {
        List<LichThi> list = new ArrayList<>();

        try (BufferedReader read = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = read.readLine()) != null) {
                LichThi lichthi = new LichThi();
                String[] data = line.split(",");
                lichthi.setTenKyThi(data[0].trim());
                lichthi.setMonThi(data[1].trim());
                lichthi.setNgayThi(data[2].trim());
                lichthi.setCaThi(data[3].trim());
                lichthi.setPhongThi(data[4].trim());
                lichthi.setDiemThi(data[5].trim());
                lichthi.setSoHS(Integer.parseInt(data[6].trim()));
                List<String> listHS = new ArrayList<>();
                for (int i = 0; i < lichthi.getSoHS(); i++) {
                    String dataHS = read.readLine();
                    listHS.add(dataHS);
                }
                lichthi.setListHS(listHS);
                list.add(lichthi);
                read.readLine();
            }
        } catch (IOException ex) {
            System.out.println(ex.toString());
        }
        return list;
    }

    public static List<HocSinh> SVFromFile(String fileName) throws Exception {
        List<HocSinh> listSV = new ArrayList<>();
        try (BufferedReader read = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = read.readLine()) != null) {
                HocSinh sv = new HocSinh();
                String[] data = line.split(",");
                sv.setMaHS(data[0]);
                sv.setHoTen(data[1]);
                sv.setLop(data[2]);
                sv.setCongTacDoan(data[3]);
                sv.setGioiTinh(data[4]);
                listSV.add(sv);
            }
        } catch (IOException ex) {
            System.out.println(ex.toString());
        }
        return listSV;
    }

    public static HocSinh getListSVById(List<HocSinh> list, String maHS) {
        for (HocSinh sv : list) {
            if (sv.getMaHS().equalsIgnoreCase(maHS)) {
                return sv;
            }
        }
        return null;
    }
}
