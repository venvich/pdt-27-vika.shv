package com.example.tests;

public class Sample {

	public static void main(String[] args) {
		//String a = new String("tttest");
		//String b = new String("test            test xxx");
		String b = "    +7 (812) 123-45-67     ";
		b= b.trim();
		System.out.println(b);
		b = b.replaceAll("[ ()\\-]", "");
		
		//String[] list = b.split("\\s+");
		
		
		//System.out.println(a == b);
		//System.out.println(a.equals(b));
//		System.out.println(b.contains(a));
//		System.out.println(b.indexOf(a));
//		System.out.println(list.length);
//		System.out.println(list[0]);
//		System.out.println(list[1]);
//		System.out.println(list[2]);
		//System.out.println(b.matches("\\+\\d+\\s*\\(\\d+\\)\\s*[\\d\\-]+"));
		System.out.println(b);
		System.out.println(b.matches("\\+\\d+"));
	}

}
