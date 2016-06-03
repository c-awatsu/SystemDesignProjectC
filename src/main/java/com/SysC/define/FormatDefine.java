package com.SysC.define;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FormatDefine {

	public static enum FORMAT_TYPE{
		REQUIRED("required","必修"),
		SELECTION("selection","選択"),
		UNKNOWN("unknown", "不明"),
		;

		String label;
		String value;

		private FORMAT_TYPE(String value,String label){
			this.value = value;
			this.label = label;
		}

		public String getValue(){
			return value;
		}

		public String getLabel(){
			return label;
		}

		//英語でリストが返ってくる
		public static List<FORMAT_TYPE> getList(){
			List<FORMAT_TYPE> formatList = new ArrayList<>();
			Arrays.asList(FORMAT_TYPE.values()).stream()
				.filter(format->!format.equals(UNKNOWN))
				.forEach(format -> {
					formatList.add(format);
				});
			return formatList;
		}

		//英語を日本語にして返す
		public static FORMAT_TYPE of(String value){

			return Arrays.stream(FORMAT_TYPE.values())
					.filter(f -> f.getValue().equals(value))
					.findFirst()
					.orElse(UNKNOWN);
		}
	}
}
