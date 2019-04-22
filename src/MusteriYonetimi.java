import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class MusteriYonetimi {

	MysqlConnect mc = new MysqlConnect();
	Scanner scanner = new Scanner(System.in);

	public int secim(int sec) {
		if (sec == 1) {
			listele(0);
		} else if (sec == 2) {

			musteriEkle();

		} else if (sec == 3) {

			listele(0);
			isimGuncelle();

		}
		return sec;

	}

	private int id;
	private String ad;

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

	public int listele(int idbul) {

		try {
			// Class.forName("com.mysql.cj.jdbc.Driver");

			Statement stmt = mc.baglan().createStatement();
			System.out.println("------------------------------------------");
			System.out.format("|%2s| %10s |", "ID", "ADI");
			System.out.println();
			System.out.println("------------------------------------------");

			ResultSet rs = stmt.executeQuery("select * from musteriler");
			while (rs.next()) {
				int musteriId = rs.getInt(1);
				if (musteriId == idbul) {
					return musteriId;
				}
				String musteriAdi = rs.getString(2);

				System.out.format("|%2s| %10s |", musteriId, musteriAdi);

				System.out.println();
			}
			System.out.println("------------------------------------------");

		} catch (SQLException e) {
			System.out.println(e);
		} finally {
			try {
				mc.baglan().close();
			} catch (SQLException e) {
				System.out.println("Hata olu�tu." + e.getMessage());
			}
		}
		return 1;
	}

	public void musteriEkle() {
		this.setAd(ad);

		try {
			String sorgu = "INSERT INTO musteriler (isim) VALUES (?)";
			PreparedStatement prepareStatement = mc.baglan().prepareStatement(sorgu);

			prepareStatement.setString(1, ad);

			prepareStatement.execute();

			listele(0);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void isimGuncelle() {
		this.setAd(ad);
		this.setId(id);
		try {

			String sorgu = "UPDATE musteriler SET isim =? WHERE musteri_id =?";
			PreparedStatement prepareStatement = mc.baglan().prepareStatement(sorgu);

			prepareStatement.setInt(2, id);

			prepareStatement.setString(1, ad);

			prepareStatement.execute();

			listele(0);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}//
