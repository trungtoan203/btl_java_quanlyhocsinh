/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Engine;

import java.util.*;
import Model.HocSinh;
import java.io.*;

/**
 *
 * @author HoangCongMinh
 */
public class DBHocSinhEngine {
    public void SaveDataToFile(HashSet<HocSinh> dsSV, boolean check){
        try{
            FileWriter fw = new FileWriter("src/SavedData/DSHocSinh.txt", check);
            BufferedWriter bw = new BufferedWriter(fw);
            for (HocSinh hs : dsSV) {
                bw.write(hs.toString());
                bw.newLine();
            }
            bw.close();
            fw.close();
        } catch(Exception ex){
            ex.printStackTrace();
        }
    }
    public List<HocSinh> ReadDataFromFile(){
        try{
            List<HocSinh> dsHS = new ArrayList<>();
            FileReader fr = new FileReader("src/SavedData/DSHocSinh.txt");
            BufferedReader br = new BufferedReader(fr);
            String line = "";
            while(true){
                line = br.readLine();
                if(line == null){
                    break;
                }
                String[] txt = line.split(",");
                dsHS.add(new HocSinh(txt[0], txt[1] ,txt[2], txt[3], txt[4]));
            }
            return dsHS;
        } catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
    }
       
}
