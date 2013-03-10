import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;
import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class KataBankOCRMachineTest {

	@InjectMocks
	private KataBankOCRMachine underTest = new KataBankOCRMachine(null, null);

	@Mock
	private IDataSource<String> dataSource;

	@Mock
	private IAccountNumberValidator accountNumberValidator;

	@Before
	public void setup() {
		when(accountNumberValidator.validate(anyString())).thenReturn(true);
	}

	@Test
	public void test_that_scan_return_123456789() {

		// --Arrange
		when(dataSource.getNext()).thenReturn("    _  _     _  _  _  _  _ ")
				.thenReturn("  | _| _||_||_ |_   ||_||_|")
				.thenReturn("  ||_  _|  | _||_|  ||_| _|").thenReturn(null);

		// --Act
		String result = underTest.scan();

		// --Assert
		Assert.assertEquals("123456789\r", result);
	}

	@Test
	public void test_that_scan_return_123456789_and_123456789() {

		// --Arrange
		when(dataSource.getNext()).thenReturn("    _  _     _  _  _  _  _ ")
				.thenReturn("  | _| _||_||_ |_   ||_||_|")
				.thenReturn("  ||_  _|  | _||_|  ||_| _|").thenReturn("")
				.thenReturn("    _  _     _  _  _  _  _ ")
				.thenReturn("  | _| _||_||_ |_   ||_||_|")
				.thenReturn("  ||_  _|  | _||_|  ||_| _|").thenReturn(null);

		// --Act
		String result = underTest.scan();

		// --Assert
		Assert.assertEquals("123456789\r123456789\r", result);
	}

	@Test
	public void test_that_scan_return_123456789ERR_and_123456789ERR_when_accountNumber_are_not_valid() {

		// --Arrange
		when(accountNumberValidator.validate(anyString())).thenReturn(false);
		when(dataSource.getNext()).thenReturn("    _  _     _  _  _  _  _ ")
				.thenReturn("  | _| _||_||_ |_   ||_||_|")
				.thenReturn("  ||_  _|  | _||_|  ||_| _|").thenReturn("")
				.thenReturn("    _  _     _  _  _  _  _ ")
				.thenReturn("  | _| _||_||_ |_   ||_||_|")
				.thenReturn("  ||_  _|  | _||_|  ||_| _|").thenReturn(null);

		// --Act
		String result = underTest.scan();

		// --Assert
		Assert.assertEquals("123456789 ERR\r123456789 ERR\r", result);
	}

}
