import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

public class AccountNumberValidatorChecksumImplTest {

	private AccountNumberValidatorChecksumImpl underTest;

	@Before
	public void setup() {
		underTest = new AccountNumberValidatorChecksumImpl();
	}

	@Test
	public void test_that_validate_return_false_when_accoutNumber_is_664371495() {

		boolean result = underTest.validate("664371495");

		Assert.assertEquals(false, result);
	}

	@Test
	public void test_that_validate_return_false_when_accoutNumber_is_457508000() {

		boolean result = underTest.validate("457508000");

		Assert.assertEquals(true, result);
	}
}
