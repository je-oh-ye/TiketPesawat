
package id.ac.ukdw.tiketonline.model;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;


public class Pesawat {
    public int getId_pesawat() {
        return id_pesawat.get();
    }


    public void setId_pesawat(int id_pesawat) {
        this.id_pesawat = new SimpleIntegerProperty(id_pesawat);
    }


    public String getMaskapai() {
        return maskapai.get();
    }


    public void setMaskapai(String maskapai) {
        this.maskapai = new SimpleStringProperty(maskapai);
    }


    public String getKota_asal() {
        return kota_asal.get();
    }


    public void setKota_asal(String kota_asal) {
        this.kota_asal =new SimpleStringProperty(kota_asal);
    }


    public String getKota_tujuan() {
        return kota_tujuan.get();
    }

  
    public void setKota_tujuan(String kota_tujuan) {
        this.kota_tujuan = new SimpleStringProperty(kota_tujuan);
    }

    public int getJumlah_kursi() {
        return jumlah_kursi.get();
    }

  
    public void setJumlah_kursi(int jumlah_kursi) {
        this.jumlah_kursi = new SimpleIntegerProperty(jumlah_kursi);
    }


    public String getTanggal() {
        return tanggal.get();
    }


    public void setTanggal(String tanggal) {
        this.tanggal = new SimpleStringProperty(tanggal);
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
        public String getJam_tiba() {
        return jam_tiba.get();
    }

     
    public void setJam_tiba(String jam_tiba) {
        this.jam_tiba = new SimpleStringProperty(jam_tiba);
    }


    public int getHarga() {
        return harga.get();
    }

 
    public void setHarga(int harga) {
        this.harga = new SimpleIntegerProperty(harga);
    }
    
    private SimpleIntegerProperty id_pesawat;
    private SimpleStringProperty maskapai;
    private SimpleStringProperty kota_asal;
    private SimpleStringProperty kota_tujuan;
    private SimpleIntegerProperty jumlah_kursi;
    private SimpleStringProperty tanggal;
    private SimpleStringProperty kelas;
    private SimpleStringProperty jam_berangkat;
    private SimpleStringProperty jam_tiba;
    private SimpleIntegerProperty harga;
    
    public Pesawat(){
        
    }
    public Pesawat(int id_pesawat, String maskapai, String kota_asal, String kota_tujuan, int jumlah_kursi, String tanggal, String kelas, String jam_berangkat, String jam_tiba, int harga){
        this.id_pesawat = new SimpleIntegerProperty(id_pesawat);
        this.maskapai = new SimpleStringProperty(maskapai);
        this.kota_asal = new SimpleStringProperty(kota_asal);
        this.kota_tujuan = new SimpleStringProperty(kota_tujuan);
        this.jumlah_kursi = new SimpleIntegerProperty(jumlah_kursi);
        this.tanggal = new SimpleStringProperty(tanggal);
        this.kelas = new SimpleStringProperty(kelas);
        this.jam_berangkat = new SimpleStringProperty(jam_berangkat);
        this.jam_tiba = new SimpleStringProperty(jam_tiba);
        this.harga = new SimpleIntegerProperty(harga);
    }   
}
