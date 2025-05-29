const id = document.querySelector("#id");
const pw = document.querySelector("#pw");
const repw = document.querySelector("#repw");
const kr = document.querySelector("#kr");
const email = document.querySelector("#email");
const number = document.querySelector("#number");
const 회원가입 = document.querySelector("section button:first-child");
const 취소 = document.querySelector("section button:last-child");
console.log(id);
console.log(pw);
console.log(repw);
console.log(kr);
console.log(email);
console.log(number);
console.log(회원가입);
console.log(취소);
id.addEventListener("input", (e) => {
  let regExp = /^[a-zA-Z][a-zA-Z0-9]{3,11}$/;
  if (regExp.test(e.target.value)) {
    console.log("조건을 충족합니다!");
    result.innerHTML = "조건을 충족합니다!";
    result.style.color = "green";
  } else {
    console.log("다시 입력해주세요!");
    result.innerHTML = "다시 입력해주세요!";
    result.style.color = "red";
  }
});
pw.addEventListener("input", (e) => {
  let b = /^(?=.*[A-Za-z])(?=.*\d)(?=.*[!@#$%^&*])[A-Za-z\d!@#$%^&*]{8,15}$/;
  if (b.test(e.target.value)) {
    console.log("조건을 충족합니다!");
    result2.innerHTML = "조건을 충족합니다!";
    result2.style.color = "green";
  } else {
    console.log("다시 입력해주세요!");
    result2.innerHTML = "다시 입력해주세요!";
    result2.style.color = "red";
  }
});
repw.addEventListener("input", (e) => {
  console.log(pw.value === e.target.value);
  if (pw.value === e.target.value) {
    console.log("비밀번호가 일치합니다!");
    result3.innerHTML = "비밀번호가 일치합니다!";
    result3.style.color = "green";
  } else {
    console.log("비밀번호가 일치하지 않습니다!");
    result3.innerHTML = "비밀번호가 일치하지 않습니다!";
    result3.style.color = "red";
  }
});
kr.addEventListener("input", (e) => {
  let d = /^[가-힣]{2,}$/;
  if (d.test(e.target.value)) {
    console.log("조건을 충족합니다!");
    result4.innerHTML = "조건을 충족합니다!";
    result4.style.color = "green";
  } else {
    console.log("이름을 다시 입력해주세요!");
    result4.innerHTML = "이름을 다시 입력해주세요!";
    result4.style.color = "red";
  }
});
email.addEventListener("input", (e) => {
  let f = /^[\w.-]+@[\w.-]+\.[A-Za-z]{2,}$/;
  if (f.test(e.target.value)) {
    console.log("조건을 충족합니다!");
    result5.innerHTML = "조건을 충족합니다!";
    result5.style.color = "green";
  } else {
    console.log("이메일을 다시 입력해주세요!");
    result5.innerHTML = "이메일을 다시 입력해주세요!";
    result5.style.color = "red";
  }
});
number.addEventListener("input", (e) => {
  let g = /^010-\d{4}-\d{4}$/;
  if (g.test(e.target.value)) {
    console.log("조건을 충족합니다!");
    result6.innerHTML = "조건을 충족합니다!";
    result6.style.color = "green";
  } else {
    console.log("전화번호를 다시 입력하세요!");
    result6.innerHTML = "전화번호를 다시 입력하세요!";
    result6.style.color = "red";
  }
});
const windowConfirm = () => {
  window.confirm("회원가입 하시겠습니까?")
    ? alert("회원가입이 완료되었습니다")
    : alert("감사합니다");
};
