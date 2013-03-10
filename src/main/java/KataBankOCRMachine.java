public class KataBankOCRMachine {

	private IDataSource<String> dataSource;
	private IAccountNumberValidator accountNumberValidator;

	public KataBankOCRMachine(IDataSource<String> dataSource,
			IAccountNumberValidator accountNumberValidator) {
		super();
		this.dataSource = dataSource;
		this.accountNumberValidator = accountNumberValidator;
	}

	public String scan() {

		StringBuilder sb = new StringBuilder();

		String line1 = null;
		String line2 = null;
		String line3 = null;
		String line4 = null;

		String accountNumber = null;
		do {

			line1 = dataSource.getNext();
			line2 = dataSource.getNext();
			line3 = dataSource.getNext();
			line4 = dataSource.getNext();
			if (line1 != null) {
				accountNumber = KataBankOCR.getNumber(line1, line2, line3);
				sb.append(accountNumber);

				if (!accountNumberValidator.validate(accountNumber)) {
					sb.append(" ERR");
				}
				sb.append("\r");
			}
		} while (line4 != null);

		return sb.toString();
	}
}
