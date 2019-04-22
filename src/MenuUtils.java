import java.util.Scanner;

public class MenuUtils {

	static MusteriYonetimi my = new MusteriYonetimi();
	static UrunYonetimi uy = new UrunYonetimi();

	public static void menuSecim() {
		anaMenuYazdir();

		Scanner scan = new Scanner(System.in);

		int secim;

		while (true) {

			secim = scan.nextInt();
			switch (secim) {

			case 1:

				MenuUtils.urunYonetimiWhile();
				menuSecim();

			case 2:
				MenuUtils.musteriYonetimiWhile();
				menuSecim();

			case 3:
				MenuUtils.satisYonetimiWhile();

				menuSecim();
			case 4:
				break;
			default:
				System.out.println("Geçerli bir seçim yapýnýz");
				menuSecim();

			}

		}

	}

	public static void anaMenuYazdir() {
		System.out.println();
		System.out.println("***************************");
		System.out.println("**** Market Otomasyonu ****");
		System.out.println("***************************");
		System.out.println("--------------");
		System.out.println("1.Ürün Yönetimi");
		System.out.println("2.Müþteri Yönetimi");
		System.out.println("3.Satýþ Yönetimi");
		System.out.println("4.Çýkýþ");
		System.out.println("--------------");
		System.out.print("Seçiminiz:");
	}

	public static void urunYonetimi() {
		System.out.println();

		System.out.println("**** Ürün Yönetimi ****");
		System.out.println("--------------");
		System.out.println("1.Listele");
		System.out.println("2.Ekle");
		System.out.println("3.Fiyat Güncelle");
		System.out.println("4.Sil");
		System.out.println("5.Ana Menü");
		System.out.println("--------------");
		System.out.print("Seçiminiz:");

	}

	public static void musteriYonetimi() {

		System.out.println("**** Müþteri Yönetimi ****");
		System.out.println("--------------");
		System.out.println("1.Listele");
		System.out.println("2.Ekle");
		System.out.println("3.Güncelle");
		System.out.println("4.Sil");
		System.out.println("5.Ana Menü");
		System.out.println("--------------");
		System.out.print("Seçiminiz:");

	}

	public static void satisYonetimi() {

		System.out.println("**** Satýþ Yönetimi ****");
		System.out.println("--------------");
		System.out.println("1.Listele");
		System.out.println("2.Ekle");
		System.out.println("3.Güncelle");
		System.out.println("4.Sil");
		System.out.println("5.Ana Menü");
		System.out.println("--------------");
		System.out.print("Seçiminiz:");

	}

	public static void urunYonetimiWhile() {
		try {
			System.out.println();

			UrunYonetimi uy = new UrunYonetimi();
			Scanner scan = new Scanner(System.in);
			int secim;
			while (true) {

				MenuUtils.urunYonetimi();
				secim = scan.nextInt();

				if (secim == 1) {
					uy.listele();
				} else if (secim == 2) {
					uy.urunEkle();

				} else if (secim == 3) {
					uy.listele();
					uy.fiyatGuncelle();

				} else if (secim == 5) {
					break;

				}
			}
		} catch (Exception e) {
			System.out.println(e.toString());
		}

	}

	public static void musteriYonetimiWhile() {
		try {
			System.out.println();

			Scanner scan = new Scanner(System.in);
			int secim;
			while (true) {

				MenuUtils.musteriYonetimi();
				secim = scan.nextInt();

				if (secim == 1) {
					my.listele();
				} else if (secim == 2) {
					System.out.print("Müþteri ismi giriniz:");

					my.setAd(scan.next());
					my.musteriEkle();

				} else if (secim == 3) {
					my.listele();
					System.out.print("Güncelleneck Müþteri id girin:");
					my.setId(scan.nextInt());

					System.out.print("Yeni isim girin:");
					my.setAd(scan.next());
					my.isimGuncelle();

					my.listele();

				} else if (secim == 5) {
					break;

				}
			}
		} catch (Exception e) {
			System.out.println(e.toString());
		}

	}

	public static void satisYonetimiWhile() {
		try {
			System.out.println();

			satisYonetimi sy = new satisYonetimi();

			Scanner scan = new Scanner(System.in);
			int secim;
			while (true) {

				MenuUtils.satisYonetimi();
				secim = scan.nextInt();

				if (secim == 1) {
					sy.listele();
				} else if (secim == 2) {
					my.listele();
					System.out.print("Müþteri ID giriniz:");
					sy.setMusteriId(scan.nextInt());

					uy.listele();
					System.out.print("Ürün ID giriniz:");

					sy.setUrunId(scan.nextInt());
					uy.urunDetay(sy.getUrunId());
					sy.setUrunFiyat(uy.getFiyat());
					System.out.println(uy.getAd());
					sy.setFisNo(2000);

					System.out.println("musteriid=" + my.getId());

					sy.satisEkle();

					// my.setAd(scan.next());
					// my.musteriEkle();

				} else if (secim == 3) {
					sy.listele();
					System.out.print("Güncelleneck Müþteri id girin:");
					// my.setId(scan.nextInt());

					System.out.print("Yeni isim girin:");
					// my.setAd(scan.next());
					// my.isimGuncelle();

					sy.listele();

				} else if (secim == 5) {
					break;

				}
			}
		} catch (Exception e) {
			System.out.println(e.toString());
		}

	}
}
