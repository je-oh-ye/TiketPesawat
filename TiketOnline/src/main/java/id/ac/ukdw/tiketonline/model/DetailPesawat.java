
package id.ac.ukdw.tiketonline.model;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;


public class DetailPesawat {
    public int getId_detail() {
        return id_detail.get();
    }


    public void setId_detail(int id_detail) {
        this.id_detail = new SimpleIntegerProperty(id_detail);
    }


    public String getMaskapai() {
        return maskapai.get();
    }


    public void setMaskapai(String maskapai) {
        this.maskapai = new SimpleStringProperty(maskapai);
    }


    public String getAsal() {
        return asal.get();
    }


    public void setAsal(String asal) {
        this.asal =new SimpleStringProperty(asal);
    }


    public String getTujuan() {
        return tujuan.get();
    }

  
    public void setTujuan(String tujuan) {
        this.tujuan = new SimpleStringProperty(tujuan);
    }





    public String getKelas() {
        return kelas.get();
    }


    public void setKelas(String kelas) {
        this.kelas = new SimpleStringProperty(kelas);
    }


    public String getJam_berangkat() {
        return jam_berangkat.get();
    }

     
    public void setJam_berangkat(String jam_berangkat) {
        this.jam_berangkat = new SimpleStringProperty(jam_berangkat);
    }


    public int getHarga() {
        return harga.get();
    }

 
    public void setHarga(int harga) {
        this.harga = new SimpleIntegerProperty(harga);
    }
    
    private SimpleIntegerProperty id_detail;
    private SimpleStringProperty maskapai;
    private SimpleStringProperty asal;
    private SimpleStringProperty tujuan;
    private SimpleStringProperty kelas;
    private SimpleStringProperty jam_berangkat;
    private SimpleIntegerProperty harga;
    
    public DetailPesawat(){
        
    }
    public DetailPesawat(int id_detail, String maskapai, String asal, String tujuan, String kelas, String jam_berangkat, int harga){
        this.id_detail = new SimpleIntegerProperty(id_detail);
        this.maskapai = new SimpleStringProperty(maskapai);
        this.asal = new SimpleStringProperty(asal);
        this.tujuan = new SimpleStringProperty(tujuan);
        this.kelas = new SimpleStringProperty(kelas);
        this.jam_berangkat = new SimpleStringProperty(jam_berangkat);
        this.harga = new SimpleIntegerProperty(harga);
    }   


    
}
