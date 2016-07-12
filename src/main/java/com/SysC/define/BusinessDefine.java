package com.SysC.define;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BusinessDefine {
	public static enum BUSINESS_TYPE{
		KADAI1("KADAI1","課題ができた"),
		KADAI2("KADAI2","課題がわからない"),
		PC("PC","PCが不調"),
		OTHER("other","その他"),
		UNKNOWN("unknown","不明");
		
		String value;
		String label;

		private BUSINESS_TYPE(String value,String label){
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
		public static List<BUSINESS_TYPE> getList(){
			List<BUSINESS_TYPE> formatList = new ArrayList<>();
			Arrays.stream(BUSINESS_TYPE.values())
			.filter(format->!format.equals(UNKNOWN))
			.forEach(format -> {
				formatList.add(format);
			});
			return formatList;
		}

		//英語を日本語にして返す
		public static BUSINESS_TYPE of(String value){

			return Arrays.stream(BUSINESS_TYPE.values())
					.filter(f -> f.getValue().equals(value))
					.findFirst()
					.orElse(UNKNOWN);
		}
	}
}