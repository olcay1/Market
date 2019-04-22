import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class satisYonetimi {

	MysqlConnect mc = new MysqlConnect();

	Scanner scanner = new Scanner(System.in);

	private int urunId;
	private int musteriId;
	private int musteriUrunId;
	private float urunFiyat;
	private int fisNo;

	public int getUrunId() {
		return urunId;
	}

	public void setUrunId(int urunId) {
		this.urunId = urunId;
	}

	public int getMusteriId() {
		return musteriId;
	}

	public void setMusteriId(int musteriId) {
		this.musteriId = musteriId;
	}

	public int getMusteriUrunId() {
		return musteriUrunId;
	}

	public void setMusteriUrunId(int musteriUrunId) {
		this.musteriUrunId = musteriUrunId;
	}

	public float getUrunFiyat() {
		return urunFiyat;
	}

	public void setUrunFiyat(float urunFiyat) {
		this.urunFiyat = urunFiyat;
	}

	public int getFisNo() {
		return fisNo;
	}

	public void setFisNo(int fisNo) {
		this.fisNo = fisNo;
	}

	public void listele(int tek) {

		try {
			// Class.forName("com.mysql.cj.jdbc.Driver");

			Statement stmt = mc.baglan().createStatement();
			System.out.println("-----------------------------------------------");
			System.out.format("|%2s| %10s | %10s| %3s | %2s |", "ID", "MÜÞTERÝ", "ÜRÜN", "FÝYAT", "FÝÞ NO");
			System.out.println();
			System.out.println("-----------------------------------------------");
			ResultSet rs = null;
			if (tek == 1) {

				rs = stmt.executeQuery("SELECT musteri_urun_id,m.isim,u.urun_ad,mu.urun_fiyat,mu.fis_no "
						+ "FROM musteri_urun mu inner join musteriler m inner join urunler  u "
						+ "on mu.musteri_id=m.musteri_id and mu.urun_id= u.urun_id "
						+ " order by mu.musteri_urun_id desc limit 1");
			} else {
				rs = stmt.executeQuery("SELECT musteri_urun_id,m.isim,u.urun_ad,mu.urun_fiyat,mu.fis_no "
						+ "FROM musteri_urun mu inner join musteriler m inner join urunler  u "
						+ "on mu.musteri_id=m.musteri_id and mu.urun_id= u.urun_id "
						+ " order by mu.musteri_urun_id desc");

			}

			while (rs.next()) {
				int musteri_urun_id = rs.getInt(1);
				String musteriAdi = rs.getString(2);
				String urunAdi = rs.getString(3);
				float urunFiyat = rs.getFloat(4);
				int fisNo = rs.getInt(5);

				System.out.format("|%2s| %10s | %10s| %5s | %2s |", musteri_urun_id, musteriAdi, urunAdi, urunFiyat,
						fisNo);

				System.out.println();
			}
			System.out.println("-----------------------------------------------");

		} catch (SQLException e) {
			System.out.println(e);
		} finally {
			try {
				mc.baglan().close();
			} catch (SQLException e) {
				System.out.println("Hata oluþtu." + e.getMessage());
			}
		}
	}

	public void musteriUrunListele(int idver) {

		try {
			// Class.forName("com.mysql.cj.jdbc.Driver");

			Statement stmt = mc.baglan().createStatement();
			System.out.println("-----------------------------------------------");
			System.out.format("|%2s| %10s | %10s| %3s | %2s |", "ID", "MÜÞTERÝ", "ÜRÜN", "FÝYAT", "FÝÞ NO");
			System.out.println();
			System.out.println("-----------------------------------------------");
			ResultSet rs = null;

			rs = stmt.executeQuery("SELECT musteri_urun_id,m.isim,u.urun_ad,mu.urun_fiyat,mu.fis_no "
					+ "FROM musteri_urun mu inner join musteriler m inner join urunler  u "
					+ "on mu.musteri_id=m.musteri_id and mu.urun_id= u.urun_id " + "where m.musteri_id =" + idver + ""
					+ " order by mu.musteri_urun_id desc");

			while (rs.next()) {
				int musteri_urun_id = rs.getInt(1);
				String musteriAdi = rs.getString(2);
				String urunAdi = rs.getString(3);
				float urunFiyat = rs.getFloat(4);
				int fisNo = rs.getInt(5);

				System.out.format("|%2s| %10s | %10s| %5s | %2s |", musteri_urun_id, musteriAdi, urunAdi, urunFiyat,
						fisNo);

				System.out.println();
			}
			System.out.println("-----------------------------------------------");

		} catch (SQLException e) {
			System.out.println(e);
		} finally {
			try {
				mc.baglan().close();
			} catch (SQLException e) {
				System.out.println("Hata oluþtu." + e.getMessage());
			}
		}
	}

	public void satisEkle() {

		this.setFisNo(fisNo);
		this.setMusteriId(musteriId);
		this.setUrunId(urunId);
		this.setUrunFiyat(urunFiyat);

		try {

			String sorgu = "INSERT INTO musteri_urun (musteri_id,urun_id,urun_fiyat,fis_no) VALUES (?,?,?,?)";

			PreparedStatement prepareStatement = mc.baglan().prepareStatement(sorgu);

			prepareStatement.setInt(1, musteriId);
			prepareStatement.setInt(2, urunId);
			prepareStatement.setFloat(3, urunFiyat);
			prepareStatement.setInt(4, fisNo);

			prepareStatement.execute();

			listele(1);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.toString());
		}
	}
}
