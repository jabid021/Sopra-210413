package heritageABCD;

import java.util.ArrayList;
import java.util.List;

public class Test {

	public static void faireQlqChose(A var) {
		 var.m1();
	}
	
	
	public static void main(String[] args) {
		A a = new A(40);
		B b = new B(50);
		C c =new C(20);
		D d = new D(18);
		
		a.m1();
		b.m1();
		c.m1();
		d.m1();
		
		List<A> maListe=new ArrayList();
		
		maListe.add(a);
		maListe.add(b);
		maListe.add(c);
		maListe.add(d);
		
		
		List<B> listeDobjetB = new ArrayList();
		listeDobjetB.add(b);
		listeDobjetB.add(d);
		
		faireQlqChose(b);
	}

}
