package com.SysC.define;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



public class ColDifine {
	public static enum COL_TYPE {
		COL1("COL1","A"),
		COL2("COL2","B"),
		COL3("COL3","C"),
		COL4("COL4","D"),
		COL5("COL5","E"),
		COL6("COL6","F"),
		COL7("COL7","G"),
		COL8("COL8","H"),
		COL9("COL9","I"),
		COL10("COL10","J"),
		UNKNOWN("unknown","不明");

		String value;
		String label;

		private COL_TYPE(String value, String label) {
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
		public static List<COL_TYPE> getList() {
			List<COL_TYPE> formatList = new ArrayList<>();
			Arrays.stream(COL_TYPE.values()).filter(format -> !format.equals(UNKNOWN)).forEach(format -> {
				formatList.add(format);
			});
			return formatList;
		}

		// 英語を日本語にして返す
		public static COL_TYPE of(String value) {

			return Arrays.stream(COL_TYPE.values())
					.filter(f -> f.getValue().equals(value))
					.findFirst()
					.orElse(UNKNOWN);
		}
	}

}
