import java.util.Scanner;

public class MenuUtils {
	 

	public static void anaMenuYazdir() {
		System.out.println("**** Market Otomasyonu ****");
		System.out.println("--------------");
		System.out.println("1.�r�n Y�netimi");
		System.out.println("2.M��teri Y�netimi");
		System.out.println("3.Sat�� Y�netimi");
		System.out.println("4.��k��");
		System.out.println("--------------");
		System.out.print("Se�iminiz:");
	}

	public static void urunYonetimi() {

		System.out.println("**** �r�n Y�netimi ****");
		System.out.println("--------------");
		System.out.println("1.Listele");
		System.out.println("2.Ekle");
		System.out.println("3.Fiyat G�ncelle");
		System.out.println("4.Sil");
		System.out.println("5.��k��");
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
		System.out.println("3.G�ncelle");
		System.out.println("4.Sil");
		System.out.println("5.Ana Men�");
		System.out.println("--------------");
		System.out.print("Se�iminiz:");

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
