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
	
	
	/*public static void sePresenter(String tab[][])
	{
		for(int i=0;i<tab.length;i++) 
		{
			System.out.println("Nom : "+tab[i][0]+", prenom : "+tab[i][1]);
		}
		
	}*/
	
	

	public static void sePresenter(Personne tab[])
	{
		for(int i=0;i<tab.length;i++) 
		{
			//System.out.println("Nom : "+tab[i].nom+", prenom : "+tab[i].prenom);
			tab[i].toString();
		}
		
	}
	
	
	public static void main(String[] args) {
		
		Personne p1 = new Personne("Abid","Jordan",27);
		System.out.println(p1);
	
		
		p1.setAge(28);
		System.out.println(p1.getAge());
	
	
		Personne p2 = new Personne("Zohri","Mourad",24);
		
	
		Personne salle[] = {p1,p2};
		
		
		
		
		for(int i=0;i<salle.length;i++) 
		{
			salle[i].toString();
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		/*String salle[][]= 
		{
				{"Abid","Jordan"},
				{"Zohri","Mourad"},
				{"Blosse","Frédéric"},
				{"Florentin","Axelle"}
		};
	
	sePresenter(salle);*/
		
	}

	
	
	
}
