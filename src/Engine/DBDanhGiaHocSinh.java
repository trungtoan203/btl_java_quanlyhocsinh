package Engine;

import Model.DanhGiaHocSinh;
import Model.HocSinh;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;


public class DBDanhGiaHocSinh {
    public List<DanhGiaHocSinh> list;
    public void ghifile(List<DanhGiaHocSinh> list){
    try {
                        FileWriter fw = new FileWriter("src/SavedData/DSDanhGiaHocSinh.txt");
                        BufferedWriter bw = new BufferedWriter(fw);
                        for(DanhGiaHocSinh hs:list){
                            bw.write(hs.toString());
                            bw.newLine();
                        }
                        bw.close();
                        fw.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
}
    public List<HocSinh> docfile(){
            try {
            List<HocSinh> list=new ArrayList<>();
            FileReader fr=new FileReader("src/SavedData/DSHocSinh.txt");
            BufferedReader br=new BufferedReader(fr);
            String line="";
            while(true){
                line=br.readLine();
                if(line==null){
                    break;
                }
                String txt[]=line.split(",");
                list.add(new HocSinh(txt[0],txt[1],txt[2],txt[3],txt[4]));
            }
                
            return list;
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public List<DanhGiaHocSinh> docfiledg(){
            try {
            List<DanhGiaHocSinh> list = new ArrayList<>();
            FileReader fr=new FileReader("src/SavedData/DSDanhGiaHocSinh.txt");
            BufferedReader br=new BufferedReader(fr);
            String line="";
            while(true){
                line=br.readLine();
                if(line==null){
                    break;
                }
                String txt[]=line.split(",");System.out.println(txt[3]);
                list.add(new DanhGiaHocSinh(txt[0],txt[1] , Integer.parseInt(txt[2]), txt[3]));
            }
            return list;
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
