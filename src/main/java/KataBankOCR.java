import org.apache.commons.collections.BidiMap;
import org.apache.commons.collections.bidimap.DualHashBidiMap;

public class KataBankOCR {

	private static BidiMap map = new DualHashBidiMap();

	static {
		map.put("0", " _ | ||_|");
		map.put("1", "     |  |");
		map.put("2", " _  _||_ ");
		map.put("3", " _  _| _|");
		map.put("4", "   |_|  |");
		map.put("5", " _ |_  _|");
		map.put("6", " _ |_ |_|");
		map.put("7", " _   |  |");
		map.put("8", " _ |_||_|");
		map.put("9", " _ |_| _|");
	}

	public static String getNumber(String... line1) {

		// --start to process the 9 numbers
		StringBuilder sb = new StringBuilder();
		String content = null;
		for (int i = 0; i < 9; i++) {
			content = new StringBuilder()
					.append(line1[0].substring(i * 3, (i + 1) * 3))
					.append(line1[1].substring(i * 3, (i + 1) * 3))
					.append(line1[2].substring(i * 3, (i + 1) * 3)).toString();
			sb.append((String) map.getKey(content));
		}
		return sb.toString();
	}
}
