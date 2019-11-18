package id.ac.ukdw.tiketonline;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.beans.Statement;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author User
 */
public class LoginController implements Initializable {
    protected String username;
	protected String password;
	protected String email;
	protected String nama_Lengkap;
	protected String jenis_Kelamin;
	protected String tanggal_Lahir;
	protected String noTelepon;
	protected String asal;
	protected String tujuan;
	protected String kelas;
	protected int userId;
	private Double harga;
	protected String nama_pesawat;
	protected String dari_kota;
	protected String ke_kota;
	protected String tanggal_terbang;
	protected String jam_terbang;
	private int id_pesawat;



	public Connection c;
	public Statement s;
	public ResultSet r;

	public void insertUser(String username, String password, String email, String nama_Lengkap, 
						   String jenis_Kelamin, String tanggal_Lahir,  
						   String noTelepon){
		try{
			c = DriverManager.getConnection("jdbc:mysql://localhost/pbo?serverTimezone=UTC", "root","");
			s = (Statement) c.createStatement();
			s.execute("INSERT INTO user(username,password,email,nama_lengkap,jenis_kelamin,tanggal_lahir,no_telpon)"+ 
								"VALUES ('"+username+"','"+
								password+"','"+email+"','"+nama_Lengkap+"','"+jenis_Kelamin+"','"+tanggal_Lahir+"','"+
								noTelepon+"')");
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}

	public boolean userCek(String username, String password){
		try{
			c = DriverManager.getConnection("jdbc:mysql://localhost/pbo?serverTimezone=UTC", "root", "");
			s = (Statement) c.createStatement();
			r = s.executeQuery("SELECT * FROM user");
			while(r.next()){
				if(r.getString("username").equals(username) && r.getString("password").equals(password)){					 
					this.userId = r.getInt("id");
					this.username = r.getString("username");
					this.password = r.getString("password");
					this.email = r.getString("email");
					this.nama_Lengkap = r.getString("nama_lengkap");
					this.jenis_Kelamin = r.getString("jenis_kelamin");
					this.tanggal_Lahir = r.getString("tanggal_lahir");
					this.noTelepon = r.getString("no_telpon");
					return true;
				}
			}
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		return false;
	}

	
	public void tampilTiket(){
		try{
			String asal, tujuan,tanggal;
			System.out.println("Masukan Kota Asal: ");
			asal = System.console().readLine();
			System.out.println("Masukan Kota Tujuan: ");
			tujuan = System.console().readLine();
			System.out.println("Masukan Tanggal Keberangkatan");
			tanggal = System.console().readLine();

			c = DriverManager.getConnection("jdbc:mysql://localhost/pbo?serverTimezone=UTC", "root", "");
			s = (Statement) c.createStatement();
			r = s.executeQuery("SELECT * FROM jadwal_pesawat WHERE dari_kota = '"
								+asal+"' AND ke_kota = '"+tujuan
								+"' AND tanggal_terbang = '"+tanggal+"'" );
			while(r.next()){
				System.out.print(r.getString("id"));
				System.out.print(". ");
				System.out.println(r.getString("nama_pesawat"));
				System.out.println(r.getString("dari_kota"));
				System.out.println(r.getString("ke_kota"));
				System.out.println(r.getString("tanggal_terbang"));
				System.out.println(r.getString("jam_terbang"));
				System.out.println(r.getString("harga"));
			}
				System.out.println("");
			}catch(Exception e){
				System.out.println(e.getMessage());
			}
		}


		public void insertPenumpang(int userId,int id_pesawat, String kelas, String jenis_penumpang, String title, String namaLengkap, String kewarganegaraan){
		try{
			c = DriverManager.getConnection("jdbc:mysql://localhost/pbo?serverTimezone=UTC", "root","");
			s = (Statement) c.createStatement();
			r = s.executeQuery("SELECT * FROM jadwal_pesawat ");
			while(r.next()){
				if(r.getInt("id") == id_pesawat){
					this.harga = r.getDouble("harga");
				}
			}
			s.execute("INSERT INTO pengguna(id_user, id_pesawat, jenis_kelas, jenis_penumpang,titel,nama_lengkap,kewarganegaraan,total_harga)"+ 
								"VALUES ('"+this.userId+"','"+id_pesawat+"','"+kelas+"','"+jenis_penumpang+"','"+title+"','"+
									namaLengkap+"','"+kewarganegaraan+"','"+this.harga+"')");
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}

	public void bayar(int id_pesawat, String kelas, String jenis_penumpang, String title, String namaLengkap, String kewarganegaraan){
		try{
			c = DriverManager.getConnection("jdbc:mysql://localhost/pbo?serverTimezone=UTC", "root", "");
			s = (Statement) c.createStatement();
			r= s.executeQuery("SELECT * FROM tiket ");
			while (r.next()){
				System.out.println(r.getString("jenis_kelas"));
				System.out.println(r.getString("jenis_penumpang"));
				System.out.print(r.getString("titel"));
				System.out.print(" ");
				System.out.println(r.getString("nama_lengkap"));
				System.out.println(r.getString("kewarganegaraan"));

				System.out.println(r.getString("total_harga"));
			}
			
				System.out.println("");
			}catch(Exception e){
				System.out.println(e.getMessage());
			}
		}

		public void tiket(){
			try{
			c = DriverManager.getConnection("jdbc:mysql://localhost/pbo?serverTimezone=UTC", "root", "");
			s = (Statement) c.createStatement();
			r = s.executeQuery("SELECT * FROM pengguna ");
			while(r.next()){
				this.id_pesawat = r.getInt("ID_Pengguna");
			}
			r=s.executeQuery("SELECT * FROM jadwal_pesawat WHERE id = '"+this.id_pesawat+"' ");
			while(r.next()){
				System.out.print(r.getString("id"));
				System.out.print(". ");
				System.out.println(r.getString("nama_pesawat"));
				System.out.println(r.getString("dari_kota"));
				System.out.println(r.getString("ke_kota"));
				System.out.println(r.getString("tanggal_terbang"));
				System.out.println(r.getString("jam_terbang"));
				System.out.println("");
			}
			
			
			}catch(Exception e){
				System.out.println(e.getMessage());
			}
		}	
	



	public String getUsername(){
		return this.username;
	}

	public String getEmail(){
		return this.email;
	}

	public String getNama_Lengkap(){
		return this.nama_Lengkap;
	}

	public String getNoTelepon(){
		return this.noTelepon;
	}

	public String getJenis_Kelamin(){
		return this.jenis_Kelamin;
	}

	public String getTanggal_Lahir(){
		return this.tanggal_Lahir;
	}

	public String getPassword(){
		return this.password;
	}

	public Integer getUserId(){
		return this.userId;
	}

	public String getNama_Pesawat(){
		return this.nama_pesawat;
	}
	public String getDari_Kota(){
		return this.dari_kota;
	}
	public String getKe_Kota(){
		return this.ke_kota;
	}
	public String getTanggal_Terbang(){
		return this.tanggal_terbang;
	}
	public String getJam_Terbang(){
		return this.jam_terbang;
	}

	public Integer getId_Pesawat(){
		return this.id_pesawat;
	}



	/*public String getTitle(){
		return this.title;
	}

	public String getNamaLengkap(){
		return this.namaLengkap;
	}

	public String getKewarganegaraan(){
		return this.kewarganegaraan;
	}*/
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
