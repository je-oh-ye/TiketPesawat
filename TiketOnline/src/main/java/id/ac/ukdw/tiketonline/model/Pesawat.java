/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.ukdw.tiketonline.model;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author asus
 */
public class Pesawat {
    /**
     * @return the id_pesawat
     */
    public int getId_pesawat() {
        return id_pesawat.get();
    }

    /**
     * @param id_pesawat the id_pesawat to set
     */
    public void setId_pesawat(int id_pesawat) {
        this.id_pesawat = new SimpleIntegerProperty(id_pesawat);
    }

    /**
     * @return the maskapai
     */
    public String getMaskapai() {
        return maskapai.get();
    }

    /**
     * @param maskapai the maskapai to set
     */
    public void setMaskapai(String maskapai) {
        this.maskapai = new SimpleStringProperty(maskapai);
    }

    /**
     * @return the asal
     */
    public String getAsal() {
        return kota_asal.get();
    }

    /**
     * @param asal the asal to set
     */
    public void setAsal(String kota_asal) {
        this.kota_asal =new SimpleStringProperty(kota_asal);
    }

    /**
     * @return the tujuan
     */
    public String getTujuan() {
        return kota_tujuan.get();
    }

    /**
     * @param tujuan the tujuan to set
     */
    public void setTujuan(String kota_tujuan) {
        this.kota_tujuan = new SimpleStringProperty(kota_tujuan);
    }

    /**
     * @return the jumlah
     */
    public int getJumlah() {
        return jumlah_kursi.get();
    }

    /**
     * @param jumlah the jumlah to set
     */
    public void setJumlah(int jumlah_kursi) {
        this.jumlah_kursi = new SimpleIntegerProperty(jumlah_kursi);
    }

    /**
     * @return the kelas
     */
    public String getKelas() {
        return kelas.get();
    }

    /**
     * @param kelas the kelas to set
     */
    public void setKelas(String kelas) {
        this.kelas = new SimpleStringProperty(kelas);
    }

    /**
     * @return the jam
     */
    public int getJam() {
        return jam_berangkat.get();
    }

    /**
     * @param jam the jam to set
     */
    public void setJam(int jam_berangkat) {
        this.jam_berangkat = new SimpleIntegerProperty(jam_berangkat);
    }

    /**
     * @return the harga
     */
    public int getHarga() {
        return harga.get();
    }

    /**
     * @param harga the harga to set
     */
    public void setHarga(int harga) {
        this.harga = new SimpleIntegerProperty(harga);
    }
    
    private SimpleIntegerProperty id_pesawat;
    private SimpleStringProperty maskapai;
    private SimpleStringProperty kota_asal;
    private SimpleStringProperty kota_tujuan;
    private SimpleIntegerProperty jumlah_kursi;
    private SimpleStringProperty kelas;
    private SimpleIntegerProperty jam_berangkat;
    private SimpleIntegerProperty harga;
    
    public Pesawat(){
        
    }
    public Pesawat(int id_pesawat, String maskapai, String kota_asal, String kota_tujuan, int jumlah_kursi, String kelas, int jam_berangkat, int harga){
        this.id_pesawat = new SimpleIntegerProperty(id_pesawat);
        this.maskapai = new SimpleStringProperty(maskapai);
        this.kota_asal = new SimpleStringProperty(kota_asal);
        this.kota_tujuan = new SimpleStringProperty(kota_tujuan);
        this.jumlah_kursi = new SimpleIntegerProperty(jumlah_kursi);
        this.kelas = new SimpleStringProperty(kelas);
        this.jam_berangkat = new SimpleIntegerProperty(jam_berangkat);
        this.harga = new SimpleIntegerProperty(harga);
    }   

    
}
