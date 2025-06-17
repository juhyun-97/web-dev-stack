package com.kh.operator;

import java.util.Scanner;

public class D_Comparison {

	/*
	 * 비교 연산자
	 * a < b : a가 b보다 작은가?
	 * a > b : a가 b보다 큰가?
	 * a <= b : a가 b보다 작거나 같은가?
	 * a >= b : a가 b보다 크거나 같은가?
	 * a == b : a와 b가 같은가?
	 * a != b : a와 b가 같지 않은가?
	 * 
	 * - 비교 연산의 조건을 만족하면 true, 만족하지 않으면 false
	 * */
	
	public static void main(String[] args) {
		D_Comparison d = new D_Comparison();
		//d.method1();
		d.method2();
	}

	public void method1() {
		int a = 10;
		int b = 25;
		
		System.out.println(a == b); // a랑 b가 같은가? 10이 25랑 같은가? false
		System.out.println(a <= b); // 10이 25 보다 작거나 같은가? true
		
		boolean result = a > b; // boolean을 써야 결과값 도출 가능
		System.out.println(result); // false
		
		System.out.println((a * 2) > (b / 5)); // true
		
		// 짝수, 홀수
		// 2로 나눠서 나머지가 0이면 == 짝수
		//                 1이면 == 홀수 == 나머지가 0이 아닌 경우
		System.out.println("a가 짝수인가? : " + (a % 2 == 0)); // a를 2로 나눴을때 나머지가 0인가?
		System.out.println("b가 홀수인가? : " + (b % 2 == 1)); // true
		System.out.println("b가 홀수인가? : " + (b % 2 != 0));
		System.out.println("b가 홀수인가? : " + !(b % 2 == 0));
	}
	
	public void method2() {
		Scanner sc = new Scanner(System.in);
		
		System.out.printf("첫번째 정수 입력 : ");
		int num1 = sc.nextInt();
		System.out.printf("두번째 정수 입력 : ");
		int num2 = sc.nextInt();
		
		// 첫번째 수가 두번째 수보다 큽니까?
		System.out.println(num1 > num2);
		// 첫번째 수가 짝수입니까?
		System.out.println(num1 % 2 == 0);
		// 두번째 수가 'A'보다 큽니까?
		System.out.println(num2 > 'A'); // A=65(아스키코드)
		System.out.println((int)'A'); // A ~ Z : 65 ~ 90, a ~ z : 97 ~ 122
	}
	
}

