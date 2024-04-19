package sof2formativeassessment;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class T9Pad {

	/**
	 * keep the mapping between numeric key and alphabet characters. The keys of the
	 * map are integer comprised between 0..9 included, the values are set of lower
	 * case alphabet characters.
	 */
	HashMap<Integer, Set<Character>> pad;

	/**
	 * Construct an empty keypad. Numeric key and mapped characters must be added
	 * via the method addKey(Integer, String).
	 */
	public T9Pad() {
		pad = new HashMap<Integer, Set<Character>>();
	}

	/**
	 * Adds to the pad the mapping between key and every characters in the String
	 * letters.
	 * 
	 * For example, addKey(2, "abc") should add the mappings (2, 'a'), (2, 'b'), and
	 * (2, 'c') to the pad.
	 * 
	 * @param key
	 * @param letters
	 * @throws IllegalArgumentException
	 *             if any of the arguments is null, or if the key is not comprised
	 *             between 0 and 9 included.
	 */
	public void addKey(Integer key, String letters) {
		// Sanity check of all parameters
		if (letters == null || key == null || key < 0 || key > 9) {
			throw new IllegalArgumentException();
		}

		Set<Character> currentLetters = pad.get(key);
		if (currentLetters == null) {
			currentLetters = new HashSet<>();
		}
		for (int i = 0; i < letters.length(); i++) {
			currentLetters.add(letters.charAt(i));
		}
		pad.put(key, currentLetters);
	}

	@Override
	public String toString() {
		String output = "<T9Pad:\n";
		for (Integer key : pad.keySet()) {
			output += key + ":";
			for (Character letter : pad.get(key)) {
				output += letter;
			}
			output += "\n";
		}
		output += ">";
		return output;
	}

	/**
	 * Returns the set of keys used in the keypad, that is all the digits that are
	 * paired with at least one character
	 * 
	 * @return the set of keys used on the keypad
	 */
	public Set<Integer> keySet() {
		return pad.keySet();
	}

	public Integer getKeyCode(Character letter) throws IllegalArgumentException {
		List<Integer> intKeys = new ArrayList<>(pad.keySet());

        List<Set<Character>> valueList = new ArrayList<>(pad.values());
		int keySetIndex = 0;
		for (Set<Character> set : valueList) {
			for (Character value : set) {
				if (value == letter) return intKeys.get(keySetIndex);
			}
			keySetIndex++;
		}
		throw new IllegalArgumentException("There are no mappings for the character: " + letter);
	}

	public List<Character> getPadLetters() {
		List<Character> allChars = new ArrayList<>();
		
        List<Set<Character>> valueList = new ArrayList<>(pad.values());
		for (Set<Character> set : valueList) {
			for (Character value : set) {
				if (!allChars.contains(value)) allChars.add(value);
			}
		}
		return allChars;
	}

	public boolean isTextonym(String word1, String word2) {
		String word1Keys = "";
		String word2Keys = "";

		for (Character character : word1.toCharArray()) 
			word1Keys += getKeyCode(character);
		for (Character character : word2.toCharArray()) 
			word2Keys += getKeyCode(character);

		return word1Keys.equals(word2Keys);
	}

	public static void main(String[] args) {
		T9Pad pad = new T9Pad();
		pad.addKey(2, "abc");
		pad.addKey(3, "def");
		pad.addKey(4, "ghi");
		pad.addKey(5, "jkl");
		pad.addKey(6, "mno");
		pad.addKey(7, "pqrs");
		pad.addKey(8, "tuv");
		pad.addKey(9, "wxyz");
		System.err.println(pad.getKeyCode('a'));
		System.err.println(pad.getKeyCode('f'));

		System.err.println(pad.getPadLetters());

		System.err.println(pad.isTextonym("good", "home"));
		System.err.println(pad.isTextonym("gone", "home"));
		System.err.println(pad.isTextonym("good", "gone"));
	}
}
