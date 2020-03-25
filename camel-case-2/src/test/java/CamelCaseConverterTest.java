import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class CamelCaseConverterTest {

	private CamelCaseConverter camelCase; 
	
	@Before
	public void setup() {
		camelCase = new CamelCaseConverter();	
	}
	
	@Test
	public void aplicarCamelCaseEmNomeUnico() throws Exception{
		assertEquals("Lionel", camelCase.converter("lionel"));
	}

	@Test
	public void deveConverterNomeSimplesMisturadoMaiusculoEMinusculo() throws Exception{
		assertEquals("Lionel", camelCase.converter("liOnel"));
	}
	
	@Test
	public void deveConverterMaisDeUmNomeParaMaisculo() throws Exception{
		assertEquals("Lionel Messi", camelCase.converterVariosNomes("lionel messi"));
	}
	
	
}


 