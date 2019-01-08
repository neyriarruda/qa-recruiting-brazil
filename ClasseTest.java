import org.junit.Test;

public class ClasseTest {

	@Test
	public void test() {
		Classe classe = new Classe();

		// Regras
		classe.adicionarPrecos("A", 50, 130, 3);
		classe.adicionarPrecos("B", 30, 45, 2);
		classe.adicionarPrecos("C", 20, 0, 0);
		classe.adicionarPrecos("D", 15, 0, 0);

		// Teste
		assertEquals(0, classe.ler(""));
		assertEquals(50, classe.ler("A"));
		assertEquals(80, classe.ler("AB"));
		assertEquals(115, classe.ler("CDBA"));

		assertEquals(100, classe.ler("AA"));
		assertEquals(130, classe.ler("AAA"));
		assertEquals(180, classe.ler("AAAA"));
		assertEquals(230, classe.ler("AAAAA"));
		assertEquals(260, classe.ler("AAAAAA"));

		assertEquals(160, classe.ler("AAAB"));
		assertEquals(175, classe.ler("AAABB"));
		assertEquals(190, classe.ler("AAABBD"));
		assertEquals(190, classe.ler("DABABA"));

		assertEquals(130, classe.ler("BBCAD"));
		assertEquals(305, classe.ler("AAAABBBCDD"));

		assertEquals(160, classe.ler("AAAB"));
		assertEquals(175, classe.ler("AAABB"));
		assertEquals(190, classe.ler("AAABBD"));
		assertEquals(130, classe.ler("BBCAD"));
		assertEquals(305, classe.ler("AAAABBBCDD"));
		assertEquals(130, classe.ler("BCADD"));
		assertEquals(120, classe.ler("BBBBB"));
		assertEquals(135, classe.ler("BBDDDDDD"));
		assertEquals(135, classe.ler("ABCCD"));

	}

}
