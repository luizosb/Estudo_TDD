
public class CamelCaseConverter {

	String nome = "";
	String posicao = "";
	String mais = "";
	String tudo = "";
	String maiuscula2 = "";

	public String converter(String nome) {
		return nome.substring(0,1).toUpperCase() + nome.substring(1).toLowerCase();

	}
	
	public String converterVariosNomes(String nome) {
		posicao = "" + nome.charAt(0);
		String pos = posicao.toUpperCase();
		for (int i = 1; i < nome.length(); i++) {
			mais = mais + nome.charAt(i);
			if (nome.charAt(i) == ' ') {
				String maiuscula = "" + nome.charAt(i+1); 
				maiuscula2 = maiuscula.toUpperCase();
				mais = mais+maiuscula2;
				i=i+1;
			}
		}
		return tudo = pos + mais;

	}

}
