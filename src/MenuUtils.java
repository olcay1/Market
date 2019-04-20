import java.util.Scanner;

public class MenuUtils {
	 

	public static void anaMenuYazdir() {
		System.out.println("**** Market Otomasyonu ****");
		System.out.println("--------------");
		System.out.println("1.Ürün Yönetimi");
		System.out.println("2.Müþteri Yönetimi");
		System.out.println("3.Satýþ Yönetimi");
		System.out.println("4.Çýkýþ");
		System.out.println("--------------");
		System.out.print("Seçiminiz:");
	}

	public static void urunYonetimi() {

		System.out.println("**** Ürün Yönetimi ****");
		System.out.println("--------------");
		System.out.println("1.Listele");
		System.out.println("2.Ekle");
		System.out.println("3.Fiyat Güncelle");
		System.out.println("4.Sil");
		System.out.println("5.Çýkýþ");
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
		UrunYonetimi uy = new UrunYonetimi();
		Scanner scan = new Scanner(System.in);
		int secim = scan.nextInt();
		while (true) {
			System.out.println();
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
		
	}

}
