package com.bravi.task.balancedBrackets;

import java.util.ArrayList;
import java.util.List;

public class BalancedBrackets {

	public static final String MSG = "Balanced Brackets is ";

	/**
	 * 
	 * @param args
	 */
	public static void main(String args[]) {
		String[] string_brackets = new String[4];
		string_brackets[0] = "(){}[]";
		string_brackets[1] = "[{()}](){}";
		string_brackets[2] = "[]{()";
		string_brackets[3] = "[{)]";

		BalancedBrackets balancedBrackets = new BalancedBrackets();

		for (String brackets : string_brackets) {
			System.out.println(new StringBuilder(MSG).append(balancedBrackets.isBracketsValid(brackets)));
		}

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
