public class Application {
	public static void main(String[] args) {

		IDataSource<String> dataSource = new FileRawLineDataSourceImpl(
				Application.class.getResource("./data.txt").getPath());
		KataBankOCRMachine kataBankOCRMachine = new KataBankOCRMachine(
				dataSource, new AccountNumberValidatorChecksumImpl());

		String result = kataBankOCRMachine.scan();

		System.out.println(result);
	}
}
