import java.util.Arrays;
import java.util.Random;
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

	public static double carre(double nb) 
	{
		return nb*nb;
	}

	public static void tp2_1() 
	{
		double nombre=saisieDouble("Saisir votre nombre");
		//double carre = nombre*nombre;
		//double carre=carre(nombre);

		System.out.println("Le carre de "+nombre+" est "+carre(nombre));
	}

	public static void tp2_2() 
	{

		double HT = saisieDouble("Saisir prix HT");
		int qte = saisieInt("Saisir la qte");
		double TVA = saisieDouble("Saisir le taux de tva (0,2 pour 20%)");

		double TTC = HT * qte * (1+TVA);

		System.out.println("Le montant TTC est de "+TTC+"€");


	}

	public static void tp3_1() 
	{
		double nb =saisieDouble("Saisir un nombre pour savoir s'il est positif ou négatif");

		if(nb>0) 
		{
			System.out.println(nb+" est positif");
		}
		else 
		{
			System.out.println(nb+" est négatif");
		}
	}
	public static void tp3_2() 
	{
		double nb1=saisieDouble("Saisir nb1");
		double nb2=saisieDouble("Saisir nb2");

		if(    (nb1>0 && nb2>0) ||   (nb1<0 && nb2<0)     ) 
		{
			System.out.println("Le produit de "+nb1+" et "+nb2+" est positif");
		}

		else 
		{
			System.out.println("Le produit de "+nb1+" et "+nb2+" est négatif");
		}


	}

	public static void tp3_3() 
	{
		double nb =saisieDouble("Saisir un nombre pour savoir s'il est positif ou négatif");

		if(nb>0) 
		{
			System.out.println(nb+" est positif");
		}
		else if(nb==0) 
		{
			System.out.println(nb+" est nul");
		}
		else 
		{
			System.out.println(nb+" est négatif");
		}
	}
	public static void tp3_4() 
	{
		double nb1=saisieDouble("Saisir nb1");
		double nb2=saisieDouble("Saisir nb2");

		if(   (nb1>0 && nb2>0) ||   (nb1<0 && nb2<0)     ) 
		{
			System.out.println("Le produit de "+nb1+" et "+nb2+" est positif");
		}

		else if(nb1==0 || nb2==0) 
		{
			System.out.println("Le produit de "+nb1+" et "+nb2+" est nul");
		}
		else 
		{
			System.out.println("Le produit de "+nb1+" et "+nb2+" est négatif");
		}
	}
	public static void tp3_5()
	{
		int age=saisieInt("Saisir l'age de votre enfant");

		if(age>=6 && age<=16) 
		{
			if(age<=7 ) {System.out.println("Categorie Poussin");}
			else if(age>=8 && age<=9) {System.out.println("Categorie Pupille");}
			else if(age>=10 && age<=11) {System.out.println("Categorie Minime");}
			else if(age>=12) {System.out.println("Categorie Cadet");}
		}
		else 
		{
			if(age<6)
			{
				System.out.println("Trop jeune");
			}
			else 
			{
				System.out.println("Trop vieux");
			}
		}
	}

	public static void tp4_1() 
	{

		int heure=saisieInt("Saisir heure");
		int minute=saisieInt("Saisir minute");

		String heureAffiche="";
		String minuteAffiche="";

		minute++;
		if(minute==60) 
		{
			minute=0;
			heure++;
			if(heure==24) 
			{
				heure=0;
			}
		}


		heureAffiche=(heure<10)?"0"+heure : ""+heure;
		minuteAffiche=(minute<10)?"0"+minute : ""+minute;


		System.out.println("Dans une minute il sera : "+heureAffiche+":"+minuteAffiche);
	}

	public static void tp4_2() 
	{

		int heure=saisieInt("Saisir heure");
		int minute=saisieInt("Saisir minute");
		int seconde=saisieInt("Saisir seconde");


		String heureAffiche="";
		String minuteAffiche="";
		String secondeAffiche="";



		seconde++;
		if(seconde==60)
		{	seconde=0;
		minute++;
		if(minute==60) 
		{
			minute=0;
			heure++;
			if(heure==24) 
			{
				heure=0;
			}
		}

		}
		heureAffiche=(heure<10)?"0"+heure : ""+heure;
		minuteAffiche=(minute<10)?"0"+minute : ""+minute;
		secondeAffiche=(seconde<10)?"0"+seconde : ""+seconde;


		System.out.println("Dans une minute il sera : "+heureAffiche+"h"+minuteAffiche+":"+secondeAffiche);
	}

	public static void tp4_3() 
	{
		int age=saisieInt("Saisir votre age");
		String civ=saisieString("Saisir civ ? (h/f)");

		if((civ.equals("f") && age>=18 && age<=35) || (civ.equals("h") && age>=20)) 
		{
			System.out.println("Imposable");
		}
		else 
		{
			System.out.println("Pas imposable");
		}

	}

	public static void tp4_4() 
	{
		double score1=saisieDouble("Saisir score candidat 1");
		double score2=saisieDouble("Saisir score candidat 2");
		double score3=saisieDouble("Saisir score candidat 3");
		double score4=saisieDouble("Saisir score candidat 4");

		if(score1>50 || score2>50 || score3>50 || score4>50) 
		{
			if(score1>50) {System.out.println("Candidat 1 Win");}
			else {System.out.println("Candidat 1 Loose");}
		}
		else if(score1>12.5) 
		{
			if(score1>=score2 && score1>=score3 && score1>score4) 
			{
				System.out.println("Candidat 1 passe le 2nd tour, ballotage fav");
			}
			else 
			{
				System.out.println("Candidat 1 passe le 2nd tour, ballotage défav");
			}
		}
		else {System.out.println("Candidat 1 Loose");}

	}

	public static void tp4_5() 
	{

		int age=saisieInt("Saisir votre age");
		int permis=saisieInt("Saisir permis");
		int acc=saisieInt("Saisir accidents");
		int fid=saisieInt("Saisir fid");

		int score=1;

		if(age>=25) {score++;}
		if(permis>=2) {score++;}
		score=score-acc;
		if(fid>=5 && score>0) {score++;}

		switch(score) 
		{
		case 1 : System.out.println("Rouge");break;
		case 2 : System.out.println("Orange");break;
		case 3 : System.out.println("Vert");break;
		case 4 : System.out.println("Bleu");break;
		default : System.out.println("Refusé");break;
		}
	}

	public static void tp4_6() 
	{

		int jour=saisieInt("Saisir le jour");
		int mois=saisieInt("Saisir le mois");
		int annee=saisieInt("Saisir année");

		boolean dateValide=false;

		if(jour>=1 && jour<=31 && mois>=1 && mois<=12) 
		{
			if((mois==4 || mois==6 || mois==9 || mois==11) && jour<=30 ) 
			{
				dateValide=true;
			}
			else if(mois==2) 
			{
				if((annee%4==0 && annee%100!=0) || annee%400==0 ) 
				{
					if(jour<=29) {dateValide=true;}
				}
				else 
				{
					if(jour<=28) {dateValide=true;}
				}
			}
		}
		if(dateValide==true) {System.out.println("La date est valide");}
		else {System.out.println("La date n'est pas valide");}
	}

	public static void tp5_1() 
	{
		double nb = saisieDouble("Saisir un nombre entre [1 et 3]");
		while(nb<1 || nb>3) 
		{
			nb=saisieDouble("ENTRE 1 ET 3 le nombre ! ");
		}
		System.out.println("BRAVO");
	}
	
	public static void tp5_2() 
	{
		int nb =saisieInt("Saisir un nombre pour afficher les 10 suivants :");
		int nbPlusDix = nb+10;
		
		while(nb<=nbPlusDix) 
		{
			System.out.println(++nb);
		}
		
	}
	
	public static void tp5_2bis() 
	{
		int nb =saisieInt("Saisir un nombre pour afficher les 10 suivants :");
		int compteur=1;
		
		while(compteur<=10) 
		{
			
			System.out.println(nb+compteur);;
			compteur++;
		}
		
		
	}
	
	public static void tp5_3() 
	{
		int nb =saisieInt("Saisir un nombre pour afficher les 10 suivants :");
		
		for(int i=1;i<=10;i++) 
		{
			System.out.println(nb+i);;
		}
		
	}
	
	public static void tp5_4() 
	{
		int nb=saisieInt("Table de ? :");
		
		System.out.println("Table de "+nb+" :");
		
		for(int i=1;i<=10;i++) {
			System.out.println(nb+" x "+i+" = "+i*nb);
		}
	}
	
	public static void tp5_5() 
	{
		double max=0;
		int pos=1;
		for(int i=1;i<=3;i++) 
		{
			double note=saisieDouble("Saisir la note numero : "+i);
			if(note>=max || i==1) 
			{
				max=note;
				pos=i;
			}
			
			
		}
		System.out.println("La note max etait : "+max +" à la position "+pos);
	}
	
	public static double fact(int nb) 
	{
		double result=1;
		for(int i=1;i<=nb;i++) 
		{
			result=result*i;
			//result*=i;
		}
		return result;
	}
	
	
	public static void tp5_6() 
	{
		
		int n=saisieInt("Nombre de chevaux partants ");
		int p=saisieInt("Nombre de chevaux joués");
		
		double X = fact(n)  / fact(n - p);
		double Y = fact(n) / (fact(p)  * fact(n - p) );

		
		System.out.println("Dans l’ordre : une chance sur "+X+" de gagner");
		System.out.println("Dans le désordre : une chance sur "+Y+" de gagner");
		
	}
	
	public static void tp6_1() 
	{
		int notes[]= {0,0,0,0,0,0};
		 //int notes[]=new int[6];
		 
		// for(int i=0;i<6;i++){notes[i]=0;}
		 
		 System.out.println(Arrays.toString(notes));	
	}
	
	public static void tp6_2() 
	{
	
		 double notes[]=new double[5];
		
		 for(int i=0;i<notes.length;i++)
		 {
			 notes[i]=saisieDouble("Saisir note "+(i+1));
		}
		 
		 System.out.println(Arrays.toString(notes));	
	}
	
	public static void tp6_3() 
	{
		double notes[]= {15.5,12.5,13,18,2.75,0};
		double somme=0;
		
		/*for(int i=0;i<notes.length;i++) 
		{
			double noteEnCours=notes[i];
			somme+=noteEnCours;
		}*/
		
		//for(Type de données | varTmp : monTableau) {}
		
		for(double noteTmp : notes) 
		{
			somme+=noteTmp;
		}
		System.out.println("Somme du tableau : "+somme);
		
		
	}
	
	public static void tp6_4() 
	{
		int tab1[]= {4	,8	,7	,9	,1	,5	,4	,6};
		int tab2[]= {7	,6	,5	,2	,1	,3	,7	,4};
		int tab3[]=new int[tab1.length];
		
		for(int i=0;i<tab1.length;i++)
		{
			tab3[i]=tab2[i]+tab1[i];
		}		
		
		System.out.println(Arrays.toString(tab3));
		
	}
	
	public static void exemplesIF() 
	{
		int age=saisieInt("Saisir votre age");
		int test=10;

		if(age!=18 )
		{
			System.out.println("Vous n'avez pas 18ans");
		}
		else 
		{
			System.out.println("[0,18[U[19,inf]");
		}

		//And
		if(age>=17 && age<=20) 
		{
			System.out.println("Vous avez entre 17 et 20 ans");
		}

		//OR
		if(age==17 ||  age==32)
		{System.out.println("Tu as 17 ou 32ans !");}	

		//NOR
		if(age!=17 && age!=32) {}

		//XOR (Soit 20, soit 10, jamais les 2 ! 
		if((age==20 || test==10) && !(age==20 && test==10)) 
		{

		}


		if(age==20 && age==10 || test==10)


			if(age==20 && (age==10 || test==10))




				/*10/3 => 3*3 + 1 

		10%3 => 1


		x%2 => 0 Pair
		x%2 => 1 impair*/

				//test : 10-> 11
				test=test+1;

		//test : 11-> 12
		test++;

		//test : 12-> 11
		test=test-1;

		//test : 11-> 10
		test--;



		test=test+4;
		test+=4;


		test=test*12;
		test*=12;

		System.out.println("Fin des if");

	}


	public static void tabMultiDim() 
	{
		int sudoku[][]=new int[9][9];
		sudoku[0][0]=2;
		sudoku[8][8]=3;


		for(int i=0;i<9;i++) 
		{
			for(int j=0;j<9;j++) 
			{
				System.out.println(sudoku[i][j]);
			}
		}


		for(int i=0;i<9;i++) 
		{
			System.out.println(Arrays.toString(sudoku[i]));
		}
	}


	public static void exempleTableau() 
	{
		//int[] notes=new int[20]; 
		//int nb=saisieInt("Combien de case ? ");

		int notes[]=new int[6];
		notes[0]=10;
		notes[1]=20;
		notes[2]=3;
		notes[3]=7;
		notes[4]=2;


		//IMPOSSIBLE  => notes[5]=2;


		//Saisir les notes du tableau une à une
		for(int i=0;i<notes.length;i++) 
		{
			notes[i]=saisieInt("Saisir la note");

		}

		//Afficher les notes du tableau une à une
		for(int i=0;i<5;i++) 
		{
			System.out.println(notes[i]);
		}

		//Init un tableau avec des valeurs
		int notes2[]= {8,260,7,89,27};
		String listePrenom[] = {"toto","titi"};


		//Afficher directement un tableau !
		System.out.println(Arrays.toString(notes2));
	}


	public static void main(String[] args)
	{
		tp6_4() ;
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









