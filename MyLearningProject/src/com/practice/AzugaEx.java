package com.practice;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AzugaEx {
		
	public static void main(String[] args) {
		String s = "name=Megha&company=Azuga Telematics Pvt Ltd.&phone=9566&city=Blr";
		String[] stringArr = s.split("&");
		
		Map<String, String> map =
		Stream.of(stringArr).collect(Collectors.toMap(spl->spl.split("=")[0], spl->spl.split("=")[1]));
		
		System.out.println(map);
		
		
	}
}
