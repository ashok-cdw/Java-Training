public class PrimeNumber {
	public static void main(String[] args) {
		primeNumbers(1, 100);
		checkNumberType(496); // Perfect Number
		checkNumberType(12321); // Palindrome Number
		checkNumberType(1634); // Armstrong Number
		checkNumberType(123); // None of these

	}

	/*
	 * @description - isPrime method checks whether the given number is prime or not
	 * 
	 * @param - number
	 */
	public static boolean isPrime(int number) {
		int count = 0;
		if (number >= 2) {
			for (int i = 2; i <= number / 2 && count <= 1; i++) {
				if ((number % i) == 0) {
					count++;
				}
			}
		}

		if (count == 1) {
			return true;
		} else {
			return false;
		}
	}

	/*
	 * @description - primeNumbers method generates number from start to end value
	 * 
	 * @param - start, end
	 */
	public static void primeNumbers(int start, int end) {
		System.out.println("Prime Numbers Are : ");
		for (int i = start; i <= end; i++) {
			if (isPrime(i)) {
				System.out.print(i + " ");
			}
		}
		System.out.println();
	}

	/*
	 * @description - checkNumberType method checks what kind of number it is
	 * 
	 * @param - number
	 */
	public static void checkNumberType(int number) {
		System.out.println("\n\nNumber is : ");
		char[] temp = Integer.toString(number).toCharArray();

		if (isArmstrongNumber(temp)) {
			System.out.print("Armstrong Number");
		} else if (isPerfectNumber(number)) {
			System.out.print("Perfect Number");
		} else if (isPalindrome(temp)) {
			System.out.print("Palindrome");
		} else {
			System.out.print("None of these");
		}

	}

	/*
	 * @description - isArmstrongNumber checks whether the given number is armstrong number or not
	 * 
	 * @param - temp
	 */
	public static boolean isArmstrongNumber(char[] temp) {
		int sum = 0;
		for (int i = 0; i < temp.length; i++) {
			sum += Math.pow(Character.getNumericValue(temp[i]), temp.length);
		}
		if (Integer.parseInt(new String(temp)) == sum) {
			return true;
		}
		return false;
	}
	/*
	 * @description - isPerfectNumber checks whether the given number is perfect number or not 
	 * 
	 * @param - number
	 */
	public static boolean isPerfectNumber(int number) {
		int sum = 0;
		for (int i = 1; i < number; i++) {
			if (number % i == 0) {
				sum += i;
			}
		}

		if (number == sum) {
			return true;
		}
		return false;
	}

	/*
	 * @description - isPalindrome checks whether the given number is palindrome or not
	 * 
	 * @param - temp
	 */
	public static boolean isPalindrome(char[] temp) {
		String originalString = new String(temp);
		for (int i = 0; i < temp.length / 2; i++) {
			char swap = temp[i];
			temp[i] = temp[temp.length - i - 1];
			temp[temp.length - i - 1] = swap;
		}
		if (new String(temp).equals(originalString)) {
			return true;
		}
		return false;
	}
}
