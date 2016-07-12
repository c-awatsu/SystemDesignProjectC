package com.SysC.define;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RowDifine {
	public static enum ROW_TYPE {
		ROW1("ROW1","1"),
		ROW2("ROW2","2"),
		ROW3("ROW3","3"),
		ROW4("ROW4","4"),
		ROW5("ROW5","5"),
		ROW6("ROW6","6"),
		ROW7("ROW7","7"),
		ROW8("ROW8","8"),
		ROW9("ROW9","9"),
		ROW10("ROW10","10"),
		ROW11("ROW11","11"),
		ROW12("ROW12","12"),
		UNKNOWN("unknown","不明");

		String value;
		String label;

		private ROW_TYPE(String value, String label) {
			this.value = value;
			this.label = label;
		}

		public String getValue() {
			return value;
		}

		public String getLabel() {
			return label;
		}

		// 英語でリストが返ってくる
		public static List<ROW_TYPE> getList() {
			List<ROW_TYPE> formatList = new ArrayList<>();
			Arrays.stream(ROW_TYPE.values()).filter(format -> !format.equals(UNKNOWN)).forEach(format -> {
				formatList.add(format);
			});
			return formatList;
		}

		// 英語を日本語にして返す
		public static ROW_TYPE of(String value) {

			return Arrays.stream(ROW_TYPE.values())
					.filter(f -> f.getValue().equals(value))
					.findFirst()
					.orElse(UNKNOWN);
		}
	}
}