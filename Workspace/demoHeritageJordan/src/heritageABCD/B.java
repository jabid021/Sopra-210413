package heritageABCD;

public class B extends A {

	
	public B(int nb) 
	{
		//new A(nb);
		super(nb);
	}
	
	public void m1() 
	{
		System.out.println("Je suis m1 de B");
	}
	
	public void m2() 
	{
		System.out.println(nb);
	}
	
}
