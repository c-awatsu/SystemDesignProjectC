package com.SysC.define;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TermDefine {

	public static enum TERM_TYPE{
		SPRING("spring","春学期"),
		FALL("fall","秋学期"),
		UNKNOWN("unknown", "不明"),
		;

		String value;
		String label;

		private TERM_TYPE(String value,String label){
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
		public static List<TERM_TYPE> getList(){
			List<TERM_TYPE> formatList = new ArrayList<>();
			Arrays.asList(TERM_TYPE.values()).stream()
			.filter(format->!format.equals(UNKNOWN))
			.forEach(format -> {
				formatList.add(format);
			});
			return formatList;
		}

		//英語を日本語にして返す
		public static TERM_TYPE of(String value){

			return Arrays.stream(TERM_TYPE.values())
					.filter(f -> f.getValue().equals(value))
					.findFirst()
					.orElse(UNKNOWN);
		}
	}

}
