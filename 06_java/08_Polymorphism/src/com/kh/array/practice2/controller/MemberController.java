package com.kh.array.practice2.controller;

import com.kh.array.practice2.model.Member;

public class MemberController {

	private Member[] members = new Member[3];
	public int count = 0;
	
	// members - getter
	public Member[] getMembers() {
		return members;
	}
	
	// 추가 로직!
	public void addInfo(Member m) {
		members[count++] = m;
	}

	public int idCheck(String id) {

		for (int i = 0; i < members.length; i++) {
			if (members[i] != null && members[i].getId().equals(id)) {
				// 기존 배열에서 아이디가 있는 경우
				return i;
			}
		}

		// 아이디가 없는 경우!
		return -1;
	}

	public void updateInfo(String id, String name, String email, String pwd) {
		int index = idCheck(id);
		members[index].setName(name);
		members[index].setEmail(email);
		members[index].setPwd(pwd);
	}
}