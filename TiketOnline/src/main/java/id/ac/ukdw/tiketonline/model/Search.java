
package id.ac.ukdw.tiketonline.model;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Search {
    
   
    public int getId_search() {
        return id_search.get();
    }

  
    public void setId_search(int id_search) {
        this.id_search = new SimpleIntegerProperty(id_search);
    }

  
    public String getAsal1() {
        return asal1.get();
    }


    public void setAsal1(String asal1) {
        this.asal1 =new SimpleStringProperty(asal1);
    }


    public String getTujuan1() {
        return tujuan1.get();
    }


    public void setTujuan1(String tujuan1) {
        this.tujuan1 = new SimpleStringProperty(tujuan1);
    }


    public int getAdult1() {
        return adult1.get();
    }

    public void setAdult1(int adult1) {
        this.adult1 =new SimpleIntegerProperty (adult1);
    }

    public int getInfant1() {
        return infant1.get();
    }


    public void setInfant1(int infant1) {
        this.infant1 =new SimpleIntegerProperty(infant1);
    }

    public int getChild1() {
        return child1.get();
    }

    public void setChild1(int child1) {
        this.child1 =new SimpleIntegerProperty(child1);
    }


    public String getDate1() {
        return date1.get();
    }


    public void setDate1(String date1) {
        this.date1 =new SimpleStringProperty(date1);
        
    }


    public String getKelas1() {
        return kelas1.get();
    }


    public void setKelas1(String kelas1) {
        this.kelas1 = new SimpleStringProperty(kelas1);
    }
    
    private SimpleIntegerProperty id_search;
    private SimpleStringProperty asal1;
    private SimpleStringProperty tujuan1;
    private SimpleIntegerProperty adult1;
    private SimpleIntegerProperty infant1;
    private SimpleIntegerProperty child1;
    private SimpleStringProperty date1;
    private SimpleStringProperty kelas1;
    public Search(){   
    }
    public Search(int id_search, String asal1, String tujuan1, int adult1, int infant1, int child1, String date1, String kelas1){
        this.id_search = new SimpleIntegerProperty(id_search);
        this.asal1 = new SimpleStringProperty(asal1);
        this.tujuan1 = new SimpleStringProperty(tujuan1);
        this.adult1 = new SimpleIntegerProperty(adult1);
        this.infant1 = new SimpleIntegerProperty(infant1);
        this.child1 = new SimpleIntegerProperty(child1);
        this.date1 = new SimpleStringProperty(date1);
        this.kelas1 = new SimpleStringProperty(kelas1);
           
    }

}
