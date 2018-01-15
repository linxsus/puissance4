package puissance4.modele;

import org.junit.jupiter.api.Test;
import org.mysql.ordinateurBasic.DonneeBase;

class DonneeTestMain {

	@Test
	void test() {
		int temp[][] = { { 0, 0, 0, 1, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0 } };
		DonneeBase test = new DonneeBase(temp, 3, 1);
		test.ajoutPion(4);
		test.ajoutPion(3);
		test.ajoutPion(1);
		test.ajoutPion(2);
		test.ajoutPion(2);
		int[] id = test.getIdBaseDonnee();
		System.out.println(test);
		String str = "[";
		for (int i : id) {
			str += i + " ";
		}
		str += "]";
		System.out.println(str);
		int[] id2 = { 119835, 0, 0 };
		test = test.setDonnee(id);
		System.out.println(test);
		System.out.println(Long.MAX_VALUE);
		long l = (new Double(Math.pow(384, 7))).longValue();
		System.out.println(l);
		l = (new Double(Math.pow(896, 6))).longValue();
		System.out.println(l);
		System.out.println(Double.MAX_VALUE);

	}

}
