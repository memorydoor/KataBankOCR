public class AccountNumberValidatorChecksumImpl implements
		IAccountNumberValidator {

	public boolean validate(String accountNumber) {

		// d9 d8 d7 d6 d5 d4 d3 d2 d1
		// checksum calculation:
		// (d1+2*d2+3*d3 +..+9*d9) mod 11 = 0

		int sum = 0;
		for (int i = 0; i < 9; i++) {
			sum = sum + Integer.valueOf(accountNumber.charAt(i) + "") * (9 - i);
		}
		return sum % 11 == 0;
	}

}
