import java.util.Scanner;



public class Program {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
	

		MenuUtils.anaMenuYazdir();

		int secim=scan.nextInt();

		do {

			switch (secim) {

			case 1:
				MenuUtils.urunYonetimiWhile();

				
			case 2:
				System.out.println("Müþteri Yönetimi");
				break;
			case 3:
				System.out.println("Satýþ Yönetimi");
				break;
			case 4:
				break;
			default:
				System.out.println("Geçerli bir seçim yapýnýz");

			}

		} while (secim == 4);
		System.out.println("HOÞÇAKALIN");
	}

}
