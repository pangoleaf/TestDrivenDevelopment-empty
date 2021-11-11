package com.qa.testdrivendevelopment;

import java.util.Arrays;

public class Questions {

	/**
	 * EXAMPLE: THIS ONE HAS BEEN DONE FOR YOU <br>
	 * 
	 * Given a name, return "Hi" plus the name <br>
	 * <br>
	 * For Example:<br>
	 * greetingExample("John") → "Hi John" <br>
	 * greetingExample("Matt") → "Hi Matt" <br>
	 * greetingExample("Angelica") → "Hi Angelica"
	 * 
	 */
	public String greetingExample(String name) {
		return "Hi " + name;
	}

	/**
	 * Given a string, return a string where for every char in the original string,
	 * there are three chars.<br>
	 * <br>
	 * 
	 * For Example:<br>
	 * multChar("The") → "TTThhheee"<br>
	 * multChar("AAbb") → "AAAAAAbbbbbb"<br>
	 * multChar("Hi-There") → "HHHiii---TTThhheeerrreee"
	 */
	
	// NEW & IMPROVED, OLD IS BELOW
	public String multiChar(String input) {
		return Arrays.stream(input.split("")).map(s -> s.repeat(3)).reduce("", String::concat);
	}

//	// OLD
//	public String multiCharOld(String input) {
//		String output = "";
//		for (int i = 0; i < input.length(); i++) {
//			char c = input.charAt(i);
//			for (int j = 0; j < 3; j++) {
//				output += c;
//			}
//		}
//		return output;
//	}

	/**
	 * Return the string (backwards) that is between the first and last appearance
	 * of "bread" in the given string, or return the empty string "" if there is not
	 * 2 occurances of "bread". Ignore Case<br>
	 * <br>
	 * For Example: sandwichFilling("breadclivebread") → "evilc"<br>
	 * sandwichFilling("xxbreadfridgebreadyy") → "egdirf"<br>
	 * sandwichFilling("xxBreadfridgeBReAdyy") → "egdirf"<br>
	 * sandwichFilling("xxbreadyy") → "" sandwichFilling("xxbreADyy") → ""<br>
	 * <br>
	 * HINT: "a" == "a" if false HINT: "a".equals("a") is true
	 */

	// NEW & IMPROVED, OLD IS BELOW
	public String sandwichFilling(String sandwich) {
		return sandwich
				.toLowerCase().replaceAll("^.*bread(.*)bread.*$|^.*bread.*$","$1").chars()
				.mapToObj(Character::toString).reduce("", (a,b) -> b+a);
	}
	
//	// OLD
//	public String sandwichFillingOld(String sandwich) {
//		String sandLower = sandwich.toLowerCase();                                // breadclivebread
//		String afterFirst = sandLower.substring(sandLower.indexOf("bread") + 5);  // clivebread
//		if (afterFirst.indexOf("bread") == -1)
//			return "";                                                            // kick out if only one bread
//		String filling = afterFirst.substring(0, afterFirst.indexOf("bread"));    // clive
//
//		String gnillif = "";
//		for (int i = filling.length() - 1; i >= 0; i--) {
//			gnillif += filling.charAt(i);
//		}
//		return gnillif;
//	}

	/**
	 * Given three ints, a b c, one of them is small, one is medium and one is
	 * large. Return true if the three values are evenly spaced, so the difference
	 * between small and medium is the same as the difference between medium and
	 * large. Do not assume the ints will come to you in a reasonable order.<br>
	 * <br>
	 * For Example:<br>
	 * evenlySpaced(2, 4, 6) → true<br>
	 * evenlySpaced(4, 6, 2) → true<br>
	 * evenlySpaced(4, 6, 3) → false<br>
	 * evenlySpaced(4, 60, 9) → false
	 */
	public boolean evenlySpaced(int a, int b, int c) {
		int[] arr = { a, b, c };
		Arrays.sort(arr);
		return arr[2] - arr[1] == arr[1] - arr[0];
	}

	/**
	 * Given a string and an int n, return a string that removes n letters from
	 * the'middle' of the string. The string length will be at least n. The input
	 * string will have an odd number of letters. n will always be an odd
	 * number.<br>
	 * <br>
	 * For Example:<br>
	 * nMid("Hello", 3) → "Ho"<br>
	 * nMid("Chocolate", 3) → "Choate"<br>
	 * nMid("Chocolate", 1) → "Choclate"<br>
	 */
	
	
	public String nMid(String input, int n) {
		int chunkLength = (input.length() - n) / 2;
		return input.substring(0, chunkLength) + input.substring(chunkLength + n);
	}

	/**
	 * Given a string, return the boolean True if it ends in "java" and False if
	 * does not end in "java". Ignore Case.<br>
	 * <br>
	 * For Example: <br>
	 * endsJava("ilovejava") → true <br>
	 * endsJava("iloveJaVa") → true <br>
	 * endsJava("welovejava") → true <br>
	 * endsJava("welovejavamoreeveryday") → false <br>
	 * endsJava("javaiscool") → false <br>
	 * endsJava("pythoniscool") → false <br>
	 */

	public boolean endsJava(String input) {
		return input.toLowerCase().substring(input.length() - 4).equals("java");
	}

	/**
	 * Given a string, return the length of the largest "block" in the string. A
	 * block is a run of adjacent chars that are the same, do not ignore case.<br>
	 * <br>
	 * For Example: superBlock("hooopplla") → 3 <br>
	 * superBlock("abbCCCddDDDDeeEEE") → 4 <br>
	 * superBlock("abbCCCCC")) → 5 <br>
	 * superBlock("") → 0 <br>
	 * <br>
	 * HINT: "a" == "a" if false HINT: "a".equals("a") is true
	 */
	
	// NEW & IMPROVED, OLD IS BELOW
	public int superBlock(String input) {
		return Arrays.stream(input.replaceAll("(.)(?!\\1)", "$1`").split("`"))
				.mapToInt(s -> s.length()).max().getAsInt();
	}
	
//	// OLD
//	public int superBlockOld(String input) {
//		String inPad = input + " ";
//		char prevChar = '\u0000';
//		int blockSize = 0;
//		int maxBlockSize = 0;
//
//		for (int i = 0; i < inPad.length(); i++) {
//			if (inPad.charAt(i) != prevChar || i == inPad.length() - 1) {
//				maxBlockSize = blockSize > maxBlockSize ? blockSize : maxBlockSize;
//				blockSize = 1;
//			} else {
//				blockSize++;
//			}
//			prevChar = inPad.charAt(i);
//		}
//		return maxBlockSize;
//	}

	/**
	 * Given a string - return the number of times "am" appears in the String
	 * ignoring case - BUT ONLY WHEN the word "am" appears without being followed or
	 * preceded by other letters <br>
	 * <br>
	 * For Example: <br>
	 * amISearch("Am I in Amsterdam") → 1 <br>
	 * amISearch("I am in Amsterdam am I?") → 2 <br>
	 * amISearch("I have been in Amsterdam") → 0 <br>
	 * <br>
	 * HINT: String.toLowerCase
	 */
	
	public int amISearch(String sentence) {
		return (" " + sentence.toLowerCase() + " ").split(" am ").length - 1;
	}

	/**
	 * Given a number if this number is divisible by 3 return "fizz" if this number
	 * is divisible by 5 return "buzz" if this number is divisible by both 3 and 5
	 * return "fizzbuzz" if this number is not divisible by 3 or 5 return null<br>
	 * <br>
	 * For Example: <br>
	 * fizzBuzz(3) → "fizz" <br>
	 * fizzBuzz(10) → "buzz" <br>
	 * fizzBuzz(15) → "fizzbuzz" <br>
	 * fizzBuzz(8) → null
	 */
	
	public String fizzBuzz(int number) {
		String output = "";
		output += number % 3 == 0 ? "fizz" : "";
		output += number % 5 == 0 ? "buzz" : "";
		return output.isEmpty() ? null : output;
	}

	/**
	 * Given a string, split the string into the individual numbers present then add
	 * each digit of each number to get a final value for each number <br>
	 * <br>
	 * String example = "55 72 86"<br>
	 * <br>
	 * "55" will = the integer 10 <br>
	 * "72" will = the integer 9 <br>
	 * "86" will = the integer 14 <br>
	 * <br>
	 * You then need to return the highest vale <br>
	 * <br>
	 * For Example: <br>
	 * largest("55 72 86") → 14 <br>
	 * largest("15 72 80 164") → 11 <br>
	 * largest("555 72 86 45 10") → 15 <br>
	 * <br>
	 * HINT: Integer.parseInt
	 */

	// NEW & IMPROVED, OLD IS BELOW
	public int largest(String input) {
		return Arrays.stream(input.split(" "))
				.mapToInt(digits -> digits.chars().map(Character::getNumericValue).sum())
				.max().getAsInt();
	}

//	// OLD
//	public int largestOld(String input) {
//		return Arrays.stream(input.split(" "))
//				.map(digitList -> Arrays.stream(digitList.split(""))
//						.collect(Collectors.summingInt(i -> Integer.parseInt(i))))
//				.reduce(0, (a, b) -> a > b ? a : b);
//	}
	
	/**
	 * Given a string, int and a char, return a boolean value if the 'nth'
	 * (represented by the int provided) char of the String supplied is the same as
	 * the char supplied. The int provided will NOT always be less than than the
	 * length of the String. Ignore case and Whitespace. <br>
	 * <br>
	 * For Example: <br>
	 * compares("The",2,'h') → true <br>
	 * compares("AAbb",1,'b') → false <br>
	 * compares("Hi-There",10,'e') → false <br>
	 * <br>
	 * HINT: String.charAt
	 */
	
	public boolean compares(String word, int index, char letter) {
		return index <= word.length() && word.toLowerCase().charAt(index - 1) == letter;
	}
}
