package com.SysC.define;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DepartmentDifine {

	public static enum DEPARTMENT_TYPE{
		BIOMATERIAL("bioMaterial","バイオマテリアル学科"),
		OPTOELECTORONICSYSTEM("optoElectoronic","光システム学科"),
		GSD("gsd","グローバルシステムデザイン学科"),
		UNKNOWN("unknown","不明");


		String value;
		String label;

		private DEPARTMENT_TYPE(String value,String label){
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
		public static List<DEPARTMENT_TYPE> getList(){
			List<DEPARTMENT_TYPE> formatList = new ArrayList<>();
			Arrays.asList(DEPARTMENT_TYPE.values()).stream()
			.filter(format->!format.equals(UNKNOWN))
			.forEach(format -> {
				formatList.add(format);
			});
			return formatList;
		}

		//英語を日本語にして返す
		public static DEPARTMENT_TYPE of(String value){

			return Arrays.stream(DEPARTMENT_TYPE.values())
					.filter(f -> f.getValue().equals(value))
					.findFirst()
					.orElse(UNKNOWN);
		}


	}
}
