import java.util.Scanner;

public class Test {
	public static String saisieString(String msg) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.println(msg);
		return sc.nextLine();
	}
	
	public static int saisieInt(String msg) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.println(msg);
		return sc.nextInt();
	}
	
	public static double saisieDouble(String msg) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.println(msg);
		return sc.nextDouble();
	}
	
	
	public static void tp1_2() 
	{
		
		int min=20;
		int max=10;
		
		int tmp=min;
		
		min=max;
		max=tmp;
		
		System.out.println("min vaut "+min+", max vaut "+max);
		
	}
	
	public static void tp1_3() 
	{
		int min=20;
		int max=10;
		int med=25;
		
		
		int tmp=min;
		
		min=max;
		max=med;
		med=tmp;
		
		System.out.println("min vaut "+min+", max vaut "+max);
	}
	
	public static void tp2_1() {}
	public static void tp2_2() {}
	
	
	public static void main(String[] args)
	{
		tp2_1();
	}
	
	public static void demoFiche() 
	{

		String prenom=saisieString("Saisir prenom");
		
		String nom=saisieString("Saisir nom");
		
		int age=saisieInt("Saisir votre age");
		
		String manga=saisieString("Saisir Manga");
		
	
		System.out.println("Prenom : "+prenom+ ", nom : "+nom+ " age : "+age);
		System.out.println(manga+"> all");
	}
}









