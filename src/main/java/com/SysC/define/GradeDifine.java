package com.SysC.define;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GradeDifine {
	public static enum GRADE{
		ONE("grade1","1年"),
		TWO("grade2","2年"),
		THREE("grade3", "3年"),
		FOUR("grade4","4年"),
		UNKNOWN("unknown","-1"),
		;

		String label;
		String value;

		private GRADE(String value,String label){
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
		public static List<GRADE> getList(){
			List<GRADE> formatList = new ArrayList<>();
			Arrays.stream(GRADE.values())
			.filter(format->!format.equals(UNKNOWN))
			.forEach(format -> {
				formatList.add(format);
			});
			return formatList;
		}

		//英語を日本語にして返す
		public static GRADE of(String value){

			return Arrays.stream(GRADE.values())
					.filter(f -> f.getValue().equals(value))
					.findFirst()
					.orElse(UNKNOWN);
		}
	}
}
