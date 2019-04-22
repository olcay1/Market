import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class UrunYonetimi {

	MysqlConnect mc = new MysqlConnect();

	Scanner scanner = new Scanner(System.in);

	private int id;
	private String ad;
	private float fiyat;

	public int secim(int sec) {
		if (sec == 1) {
			listele();
		} else if (sec == 2) {

			urunEkle();
			urunEkle(ad, fiyat);
		} else if (sec == 3) {

			listele();
			fiyatGuncelle();
		}
		return sec;

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAd() {
		return ad;
	}

	public void setAd(String ad) {
		this.ad = ad;
	}

	public float getFiyat() {
		return fiyat;
	}

	public void setFiyat(float fiyat) {
		this.fiyat = fiyat;
	}

	public void listele() {

		try {
			// Class.forName("com.mysql.cj.jdbc.Driver");

			Statement stmt = mc.baglan().createStatement();
			System.out.println("------------------------------------------");
			System.out.format("|%2s| %10s |%9s |", "ID", "ADI", "FÝYATI");
			System.out.println();
			System.out.println("------------------------------------------");

			ResultSet rs = stmt.executeQuery("select * from urunler");
			while (rs.next()) {
				int urunId = rs.getInt(1);
				String urunAdi = rs.getString(2);
				float urunFiyat = rs.getFloat(3);
				System.out.format("|%2s| %10s |%9s|", urunId, urunAdi, urunFiyat);

				System.out.println();
			}
			System.out.println("------------------------------------------");

		} catch (SQLException e) {
			System.out.println("Hata oluþtu." + e.getMessage());
		} finally {
			try {
				mc.baglan().close();
			} catch (SQLException e) {
				System.out.println("Hata oluþtu." + e.getMessage());
			}
		}
	}

	public void urunDetay(int id) {

		try {
			// Class.forName("com.mysql.cj.jdbc.Driver");

			Statement stmt = mc.baglan().createStatement();

			ResultSet rs = stmt.executeQuery("select * from urunler ");
			while (rs.next()) {

				int urunId = rs.getInt(1);
				if (urunId == id) {
					setAd(rs.getString(2));
					setFiyat(rs.getFloat(3));

				}

			}

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

	public void urunEkle() {
		System.out.print("Ürün adý: ");
		ad = scanner.nextLine();
		System.out.println();
		System.out.print("Ürün fiyatý: ");
		fiyat = scanner.nextFloat();
		urunEkle(ad, fiyat);

	}

	public void fiyatGuncelle() {
		try {
			System.out.print("Ürün Id: ");
			id = scanner.nextInt();

			System.out.print("Yeni Fiyatý: ");
			fiyat = scanner.nextFloat();
			fiyatGuncelle(id, fiyat);

			System.out.println("Fiyat güncellendi");
		} catch (Exception e) {
			System.out.println(e.toString());
		}

	}

	public void urunEkle(String ad, float fiyat) {
		this.setAd(ad);
		this.setFiyat(fiyat);

		try {
			String sorgu = "INSERT INTO urunler (urun_ad,urun_fiyat) VALUES (?,?)";
			PreparedStatement prepareStatement = mc.baglan().prepareStatement(sorgu);

			prepareStatement.setString(1, ad);

			prepareStatement.setFloat(2, fiyat);

			prepareStatement.execute();

			listele();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void fiyatGuncelle(int id, float fiyat) {
		try {

			String sorgu = "UPDATE urunler SET urun_fiyat =? WHERE urun_id =?";
			PreparedStatement prepareStatement = mc.baglan().prepareStatement(sorgu);

			prepareStatement.setInt(2, id);

			prepareStatement.setFloat(1, fiyat);

			prepareStatement.execute();

			listele();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}

}
