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
				System.out.println("M��teri Y�netimi");
				break;
			case 3:
				System.out.println("Sat�� Y�netimi");
				break;
			case 4:
				break;
			default:
				System.out.println("Ge�erli bir se�im yap�n�z");

			}

		} while (secim == 4);
		System.out.println("HO��AKALIN");
	}

}
