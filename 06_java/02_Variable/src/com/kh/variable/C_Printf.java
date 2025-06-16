package com.kh.variable;

import java.nio.file.spi.FileSystemProvider;

public class C_Printf {

	public static void main(String[] args) {
		// print : 출력만 함 (줄바꿈 X)
		System.out.print("hello");
		// println : 출력 후 줄바꿈. ln이 줄바꿈이라는 뜻이라 줄바꿈 포함
		System.out.println("hello"); 
		
		// printf(출력하고자하는형식(포맷), 출력하고자 하는 값, 값, 값, ..)
		int iNum1 = 10;
		int iNum2 = 20;
		
		// 10% 20% 이런식으로 출력해보자
		System.out.println(iNum1 + "% " + iNum2 + "%");
		// 출력하고자 하는 값들이 제시한 형식에 맞춰서 출력만 진행
		System.out.printf("%d%% %d%%", iNum1, iNum2);
		
		/*
		 * 포맷에 쓰이는 키워드
		 * %d : 정수
		 * %f : 실수
		 * %c : 문자
		 * %s : 문자열 (문자도 가능)
		 * */
		System.out.println();
		System.out.printf("%5d\n", iNum1); // 글자마다 나눠서 임의의 칸 생성. 5칸 확보 후 오른쪽 정렬
		System.out.printf("%-5d\n", iNum2); // 왼쪽 정렬
		
		double dNum1 = 1.23456789;
		double dNum2 = 4.53;
		// 무조건 소수점 아래 6번째 자리까지 표시해줌
		System.out.printf("%f \t %f \n" , dNum1, dNum2); 
		System.out.printf("%.3f \t %.1f \n", dNum1, dNum2);
	
		char ch = 'a';
		String str = "Hello";
		System.out.printf("%c \t %s \t %s", ch, str, ch);
		System.out.printf("%C %S", ch, str); // 대문자로 출력
	}

}
