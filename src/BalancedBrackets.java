
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BalancedBrackets {

	public static final String MSG = "Balanced Brackets is ";

	/**
	 * 
	 * @param args
	 */
	public static void main(String args[]) {
		System.out.printf("Enter a balanced brackets: ");
		Scanner scanner = new Scanner(System.in);
		String string_brackets = scanner.next();
		scanner.close();

		BalancedBrackets balancedBrackets = new BalancedBrackets();
		System.out.println(new StringBuilder(MSG).append(balancedBrackets.isBracketsValid(string_brackets)));

	}

	/**
	 * 
	 * @param string_brackets
	 * @return
	 */
	public boolean isBracketsValid(String string_brackets) {

		List<String> lhash = new ArrayList<>();

		for (int i = 0; i < string_brackets.length(); i++) {
			char letter = string_brackets.charAt(i);

			// open brackets
			if (String.valueOf(letter).equals("(") || String.valueOf(letter).equals("{")
					|| String.valueOf(letter).equals("[")) {
				lhash.add(String.valueOf(letter));
			}

			// close brackets
			if (String.valueOf(letter).equals(")") || String.valueOf(letter).equals("}")
					|| String.valueOf(letter).equals("]")) {

				// Retorna falso caso seja a primeira letra seja inválida
				if (i == 0) {
					return false;

					// Compara se as chaves são equivalente e remove da pilha de validação
				} else if (lhash.get(lhash.size() - 1).equals("(") && String.valueOf(letter).equals(")")) {
					lhash.remove(lhash.size() - 1);
					continue;
				} else if (lhash.get(lhash.size() - 1).equals("{") && String.valueOf(letter).equals("}")) {
					lhash.remove(lhash.size() - 1);
					continue;
				} else if (lhash.get(lhash.size() - 1).equals("[") && String.valueOf(letter).equals("]")) {
					lhash.remove(lhash.size() - 1);
					continue;
				} else {
					return false;
				}
			}
		}

		// retorna falso caso exista uma chave sem referência
		if (!lhash.isEmpty()) {
			return false;
		}

		return true;
	}
}
