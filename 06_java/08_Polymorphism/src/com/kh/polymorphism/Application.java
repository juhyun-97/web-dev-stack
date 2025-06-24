package com.kh.polymorphism;

import com.kh.polymorphism.controller.EmployeeController;
// FQCN(Full Qualified Class Name)
import com.kh.polymorphism.model.Employee;
import com.kh.polymorphism.model.Engineer;
import com.kh.polymorphism.model.Manager;
import com.kh.polymorphism.model.Secretary;

/*
 * 다형성(Polymorphism)
 * - 하나의 객체변수가 여러가지 모양과 모습을 가지는 능력
 * - 부모 타입으로 자식 객체를 생성하는 것
 * 
 * Liskov Substitution Principle, LSP
 * - 부모 객체는 자식 객체로 교체해도 문제 없다
 * - 다형성이 제대로 설계되었는지 판단하는 기준 중 하나
 * */
public class Application {

	public static void main(String[] args) {

		Employee em = new Employee("문채은", 3000000);
		Employee en = new Engineer("최다인", 3500000, "자바", 300000);
		Employee ma = new Manager("김은진", 4000000, "개발팀");
		Employee se = new Secretary("전영현", 4500000, "문채은");

		System.out.println(em);
		System.out.println(en);
		System.out.println(ma);
		System.out.println(se);

		// 다형성 + 객체 배열
		Employee[] emp = { em, en, ma, se };

		for (Employee employee : emp) {
			System.out.println(employee);
		}
		System.out.println("----------------");
		EmployeeController ec = new EmployeeController();
		// 이름으로 사람 찾기 아무나 -> 이름은 문자열(equals), getName
		Employee findEmployee = ec.findEmployee(emp);
		
		// 찾은 사람의 연봉(getSalary)은 얼마인지
		// 특정 자식 객체 찾는 방법
		System.out.println(ec.getAnnualSalary(findEmployee));

		// 전체 총 월급
		System.out.println(ec.totalSalary(emp));
		System.out.println("----------------");
		
	}
	private static char[] sum(int salary) {
		return null;
	}

}
