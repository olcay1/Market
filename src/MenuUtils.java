import java.util.Random;
import java.util.Scanner;

public class MenuUtils {

	static MusteriYonetimi my = new MusteriYonetimi();
	static UrunYonetimi uy = new UrunYonetimi();
	static Random rnd = new Random();

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
				System.out.println("Ge�erli bir se�im yap�n�z");
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
		System.out.println("1.�r�n Y�netimi");
		System.out.println("2.M��teri Y�netimi");
		System.out.println("3.Sat�� Y�netimi");
		System.out.println("4.��k��");
		System.out.println("--------------");
		System.out.print("Se�iminiz:");
	}

	public static void urunYonetimi() {
		System.out.println();

		System.out.println("**** �r�n Y�netimi ****");
		System.out.println("--------------");
		System.out.println("1.Listele");
		System.out.println("2.Ekle");
		System.out.println("3.Fiyat G�ncelle");
		System.out.println("4.Sil");
		System.out.println("5.Ana Men�");
		System.out.println("--------------");
		System.out.print("Se�iminiz:");

	}

	public static void musteriYonetimi() {

		System.out.println("**** M��teri Y�netimi ****");
		System.out.println("--------------");
		System.out.println("1.Listele");
		System.out.println("2.Ekle");
		System.out.println("3.G�ncelle");
		System.out.println("4.Sil");
		System.out.println("5.Ana Men�");
		System.out.println("--------------");
		System.out.print("Se�iminiz:");

	}

	public static void satisYonetimi() {

		System.out.println("**** Sat�� Y�netimi ****");
		System.out.println("--------------");
		System.out.println("1.Listele");
		System.out.println("2.Ekle");
		System.out.println("3.M��teri �r�nleri");
		System.out.println("4.Ana Men�");
		System.out.println("--------------");
		System.out.print("Se�iminiz:");

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
					my.listele(0);
				} else if (secim == 2) {
					System.out.print("M��teri ismi giriniz:");

					my.setAd(scan.next());
					my.musteriEkle();

				} else if (secim == 3) {
					my.listele(0);
					System.out.print("G�ncelleneck M��teri id girin:");
					my.setId(scan.nextInt());

					System.out.print("Yeni isim girin:");
					my.setAd(scan.next());
					my.isimGuncelle();

					my.listele(0);

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

				System.out.println();
				MenuUtils.satisYonetimi();
				secim = scan.nextInt();

				if (secim == 1) {
					sy.listele(0);
				} else if (secim == 3) {

					my.listele(0);
					System.out.println();
					System.out.print("M��teri ID giriniz:");

					sy.musteriUrunListele(scan.nextInt());
					System.out.println();
				} else if (secim == 2) {
					my.listele(0);
					System.out.print("M��teri ID giriniz:");
					sy.setMusteriId(scan.nextInt());

					uy.listele();
					System.out.print("�r�n ID giriniz:");

					sy.setUrunId(scan.nextInt());

					uy.urunDetay(sy.getUrunId());
					sy.setUrunFiyat(uy.getFiyat());
					sy.setFisNo((my.listele(sy.getMusteriId())) * rnd.nextInt(1000));
					System.out.println("Eklediginiz �r�n= " + uy.getAd());
					// System.out.println("musteriid=" + my.getId());

					sy.satisEkle();

					// my.setAd(scan.next());
					// my.musteriEkle();

				} else if (secim == 4) {
					break;

				}
			}
		} catch (Exception e) {
			System.out.println(e.toString());
		}

	}
}
