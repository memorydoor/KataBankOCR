import junit.framework.Assert;

import org.junit.Test;

public class KataBankOCRTest {

	@Test
	public void test_that_getNumber_return_000000000() {

		// --Arrange
		String line1 = " _  _  _  _  _  _  _  _  _ ";
		String line2 = "| || || || || || || || || |";
		String line3 = "|_||_||_||_||_||_||_||_||_|";

		// --Act
		String result = KataBankOCR.getNumber(line1, line2, line3);

		// --Assert
		Assert.assertEquals("000000000", result);
	}

	@Test
	public void test_that_getNumber_return_111111111() {

		// --Arrange
		String line1 = "                           ";
		String line2 = "  |  |  |  |  |  |  |  |  |";
		String line3 = "  |  |  |  |  |  |  |  |  |";

		// --Act
		String result = KataBankOCR.getNumber(line1, line2, line3);

		// --Assert
		Assert.assertEquals("111111111", result);
	}

	//
	@Test
	public void test_that_getNumber_return_222222222() {

		// --Arrange
		String line1 = " _  _  _  _  _  _  _  _  _ ";
		String line2 = " _| _| _| _| _| _| _| _| _|";
		String line3 = "|_ |_ |_ |_ |_ |_ |_ |_ |_ ";

		// --Act
		String result = KataBankOCR.getNumber(line1, line2, line3);

		// --Assert
		Assert.assertEquals("222222222", result);
	}

	@Test
	public void test_that_getNumber_return_333333333() {

		// --Arrange
		String line1 = " _  _  _  _  _  _  _  _  _ ";
		String line2 = " _| _| _| _| _| _| _| _| _|";
		String line3 = " _| _| _| _| _| _| _| _| _|";

		// --Act
		String result = KataBankOCR.getNumber(line1, line2, line3);

		// --Assert
		Assert.assertEquals("333333333", result);
	}

	@Test
	public void test_that_getNumber_return_444444444() {

		// --Arrange
		String line1 = "                           ";
		String line2 = "|_||_||_||_||_||_||_||_||_|";
		String line3 = "  |  |  |  |  |  |  |  |  |";

		// --Act
		String result = KataBankOCR.getNumber(line1, line2, line3);

		// --Assert
		Assert.assertEquals("444444444", result);
	}

	@Test
	public void test_that_getNumber_return_555555555() {

		// --Arrange
		String line1 = " _  _  _  _  _  _  _  _  _ ";
		String line2 = "|_ |_ |_ |_ |_ |_ |_ |_ |_ ";
		String line3 = " _| _| _| _| _| _| _| _| _|";

		// --Act
		String result = KataBankOCR.getNumber(line1, line2, line3);

		// --Assert
		Assert.assertEquals("555555555", result);
	}

	@Test
	public void test_that_getNumber_return_666666666() {

		// --Arrange
		String line1 = " _  _  _  _  _  _  _  _  _ ";
		String line2 = "|_ |_ |_ |_ |_ |_ |_ |_ |_ ";
		String line3 = "|_||_||_||_||_||_||_||_||_|";

		// --Act
		String result = KataBankOCR.getNumber(line1, line2, line3);

		// --Assert
		Assert.assertEquals("666666666", result);
	}

	@Test
	public void test_that_getNumber_return_777777777() {

		// --Arrange
		String line1 = " _  _  _  _  _  _  _  _  _ ";
		String line2 = "  |  |  |  |  |  |  |  |  |";
		String line3 = "  |  |  |  |  |  |  |  |  |";

		// --Act
		String result = KataBankOCR.getNumber(line1, line2, line3);

		// --Assert
		Assert.assertEquals("777777777", result);
	}

	@Test
	public void test_that_getNumber_return_888888888() {

		// --Arrange
		String line1 = " _  _  _  _  _  _  _  _  _ ";
		String line2 = "|_||_||_||_||_||_||_||_||_|";
		String line3 = "|_||_||_||_||_||_||_||_||_|";

		// --Act
		String result = KataBankOCR.getNumber(line1, line2, line3);

		// --Assert
		Assert.assertEquals("888888888", result);
	}

	@Test
	public void test_that_getNumber_return_999999999() {

		// --Arrange
		String line1 = " _  _  _  _  _  _  _  _  _ ";
		String line2 = "|_||_||_||_||_||_||_||_||_|";
		String line3 = " _| _| _| _| _| _| _| _| _|";

		// --Act
		String result = KataBankOCR.getNumber(line1, line2, line3);

		// --Assert
		Assert.assertEquals("999999999", result);
	}

	@Test
	public void test_that_getNumber_return_123456789() {

		// --Arrange
		String line1 = "    _  _     _  _  _  _  _ ";
		String line2 = "  | _| _||_||_ |_   ||_||_|";
		String line3 = "  ||_  _|  | _||_|  ||_| _|";

		// --Act
		String result = KataBankOCR.getNumber(line1, line2, line3);

		// --Assert
		Assert.assertEquals("123456789", result);
	}
}
