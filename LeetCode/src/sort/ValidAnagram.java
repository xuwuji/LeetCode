package sort;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map.Entry;

public class ValidAnagram {

	public static boolean isAnagram(String s, String t) {
		// check the length of them
		if (s.length() != t.length()) {
			return false;
		}

		// recorde the apperances of every letter of the first string
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		for (int i = 0; i < s.length(); i++) {
			String a = s.substring(i, i + 1);
			if (map.containsKey(a)) {
				map.put(a, map.get(a) + 1);
			} else {
				map.put(a, 1);
			}
		}
		// check if the apperances of every letter of the second string match
		// the first string
		for (int j = 0; j < t.length(); j++) {
			String b = t.substring(j, j + 1);
			if (map.containsKey(b)) {
				map.put(b, map.get(b) - 1);
			} else {
				return false;
			}
		}
		for (Entry<String, Integer> entry : map.entrySet()) {
			if (entry.getValue() != 0) {
				return false;
			}
		}
		return true;
	}

	public static boolean isAnagram2(String s, String t) {
		// check the length of them
		if (s.length() != t.length()) {
			return false;
		}

		// sort each string
		String[] array_s = new String[s.length()];
		String[] array_t = new String[t.length()];
		for (int i = 0; i < s.length(); i++) {
			array_s[i] = s.substring(i, i + 1);
			array_t[i] = t.substring(i, i + 1);
		}
		sort(array_s, 0, array_s.length - 1);
		sort(array_t, 0, array_t.length - 1);
		for (int i = 0; i < s.length(); i++) {
			if (!array_s[i].equals(array_t[i])) {
				return false;
			}
		}
		return true;
	}

	private static void merge(String[] data, int low, int middle, int high) {
		int i = low;
		int j = middle + 1;
		String[] temp = Arrays.copyOf(data, data.length);
		for (int index = 0; index < data.length; index++) {
			if (i > middle) {
				temp[index] = data[j];
				j++;
			} else if (j > high) {
				temp[index] = data[i];
				i++;
			} else if (data[i].compareTo(data[j]) < 0) {
				temp[index] = data[i];
				i++;
			} else {
				temp[index] = data[j];
				j++;
			}
		}
	}

	private static void sort(String[] data, int low, int high) {
		while (low >= high) {
			return;
		}
		int middle = (low + high) / 2;
		sort(data, 0, middle);
		sort(data, middle + 1, high);
		merge(data, 0, middle, high);

	}

	public static boolean isAnagram3(String s, String t) {
		if (s.length() != t.length())
			return false;
		char ss[] = s.toCharArray();
		char tt[] = t.toCharArray();
		Arrays.sort(ss);
		Arrays.sort(tt);
		return new String(ss).equals(new String(tt));
	}

	
	public static boolean isAnagram4(String s, String t) {
		if (s.length() != t.length())
			return false;
		int[] alphabet = new int[26];
		for (int i = 0; i < 26; i++) {
			alphabet[i] = 0;
		}
		for (int i = 0; i < s.length(); i++) {
			alphabet[s.charAt(i) - 'a']++;
		}
		for (int i = 0; i < t.length(); i++) {
			alphabet[t.charAt(i) - 'a']--;
			if (alphabet[t.charAt(i) - 'a'] < 0)
				return false;
		}
		return true;

	}

	public static void main(String[] args) {
		int result = 0;
		for (int i = 0; i < 10000; i++) {
			long start = System.nanoTime();
			System.out.println(ValidAnagram.isAnagram2("nagaram", "anagram"));
			long elapsedTime = System.nanoTime() - start;
			result += elapsedTime;
		}

		System.out.println(result / 10000);
	}
}
