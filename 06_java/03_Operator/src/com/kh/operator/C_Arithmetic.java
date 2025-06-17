package com.kh.operator;

public class C_Arithmetic {

	/*
	 * 산술 연산자
	 * + : 더하기
	 * - : 빼기
	 * * : 곱하기
	 * / : 나누기
	 * % : 나머지 
	 * */
	
	public static void main(String[] args) {
		C_Arithmetic c = new C_Arithmetic();
		c.method2();
	}
	
	public void method1() {
		int num1 = 10;
		int num2 = 3;
		
		System.out.println("+ : " + (num1 + num2)); // 13
		System.out.println("- : " + (num1 - num2)); // 7
		System.out.println("* : " + (num1 * num2)); // 30
		System.out.println("/ : " + (num1 / num2)); // 3 - 나누기 몫만 출력함. 정수끼리 연산하면 정수만 인지함.
		System.out.println("% : " + (num1 % num2)); // 1
	}
	
	public void method2() {
		int a = 5;
		int b = 10;
		int c = (++a) + b++; // a=6 + b=10  c=16  b = 11
		int d = c / a; // c=16 / a=6 =  d=2
		int e = c % a; // c=16 % a=6 = e=4
		int f = e++; // 5   f=4
		int g = (--b) + (d--); // b=10 + d=1  g= 12   
		int h = c-- * b; // c=15 * b=10 = 16*10= h=160
		int i = (a++) + b / (--c / f) * (g-- - d) % (++e + h); // 6 + 10 / (15/5) * (11-1) % (5+160) 
		
		System.out.println(i);
	}
 
}
