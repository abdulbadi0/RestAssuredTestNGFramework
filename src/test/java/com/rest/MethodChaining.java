package com.rest;

public class MethodChaining {
	
	public static void main(String[] args) {
		
		//MethodChaining mchain= new MethodChaining();
		a1()
		.a2()
		.a3();
	}
	
	public static MethodChaining a1() {
		System.out.println("This is a1 method!");
		return new MethodChaining();	
	}
	public MethodChaining a2() {
		System.out.println("This is a2 method!");
		return this;	
	}
	public MethodChaining a3() {
		System.out.println("This is a3 method!");
		return this;	
	}

}
