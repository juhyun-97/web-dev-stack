// 1번 문제
const result1 = document.querySelector("#result1");
function printText() {
  //   const div = document.querySelector("#result1");
  //   const p = document.createElement("p");
  //   p.textContent = "안녕하세요";
  //   div.appendChild(p);
  result1.textContent = "안녕하세요"; //textContent or InnerHTML
  //   console.log(result1); //콘솔창에 띄울때 사용. 현문제는 버튼눌렀을때 HTML상에 띄우는것이므로 패스
}
// 2번 문제
// const customer = document.querySelector("#customer");
const result2 = document.querySelector("#result2");
const customer = document.querySelector("#customer");
function printInputValue() {
  // input값(customer)을 가지고 오기
  console.log(customer.value);
  // 가지고 와서 result2에 출력하기
  result2.textContent = customer.value;
  // input값(customer.value)을 비우기
  customer.value = "";
}

// 3번 문제
const divTest = document.querySelector(".div-test");
function changeColor() {
  // 선택한 divTest에 배경색을 변경
  divTest.style.backgroundColor = "yellow";
}
// 4번 문제
const text = document.querySelector("#text");
const result4 = document.querySelector("#result4");
function stringLength() {
  // 입력받은 text에서 글자의 글자수 가지고 오기
  console.log("길이 : ", text.value.length);
  // 글자수를 result4에서 출력
  result4.textContent = text.value.length;
  text.value = "";
}
// 5번 문제  const strToArr = str.split("");
const la = document.querySelector("#la");
const result5 = document.querySelector("#result5");
function stringSplit() {
  // 1. 사과, 바나나, 오렌지, 포도 문자 가지고 오기
  console.log(la.innerHTML);
  const laText = la.innerHTML;
  // 2. 가지고 온 문자열 분리하기 -> 배열로 만들기
  console.log(la.innerHTML.split(","));
  const laArr = laText.split(",");

  // 6. ul 태그 만들기
  const ul = document.createElement("ul");

  // 3. 배열 값 하나씩 가지고 오기 -> 반복문!
  for (let i = 0; i < laArr.length; i++) {
    // 4. li 태그 만들기
    const li = document.createElement("li");
    // 5. li 태그에 값 넣기
    li.innerHTML = laArr[i];
    console.log(li);
    // 7. ul 태그에 만들어놓은 li 태그들 추가하기
    // ul.appendChild(li);
    // ul.innerHTML = "<li>" + laArr[i] + "</li>";
    ul.innerHTML += `<li>${laArr[i]}</li>`;
  }
  console.log(ul);
  // 8. result5에 ul 담기
  result5.appendChild(ul);
}

// 6번 문제
const preview = document.querySelector("#preview");
const remove = document.querySelector("#remove");
const add = document.querySelector("#add");
function arrayTest() {
  //피자 치킨 떡볶에 <- 배열로 만들기

  console.log(preview.textContent.split(" "));
  const previewArr = preview.textContent.split(" ");

  //1. 정 기억이 안나면 일단 반복문으로 시작
  /*
  for (let i = 0; i < previewArr.length; i++) {
    // 이미 가지고 있는 값에서 내가 삭제할 값이 일치하면 배열에서 제거
    // console.log(previewArr[i] === "피자");
    if (previewArr[i] === remove.value) {
      previewArr.splice(i, 1);
    }
  }
    */
  //2. 배열에서 제거 : splice(인덱스, 1);
  const delIdx = previewArr.indexOf(remove.value); // 삭제할 인덱스
  console.log(delIdx);
  // if (delIdx !== -1) previewArr.splice(delIdx, 1);

  // +) 추가
  console.log(previewArr.includes(remove.value));
  if (previewArr.includes(remove.value)) previewArr.splice(delIdx, 1);

  // 추가 -> 배열에 해당 값 추가! push
  previewArr.push(add.value);

  // 배열 -> 문자열로 바꾸기
  console.log(previewArr.join(" "));
  preview.textContent = previewArr.join(" ");
}

// 7번 문제 : prompt로 이름,나이,주소 순으로 입력받아서 출력
const names = document.querySelectorAll(".name");
const ages = document.querySelectorAll(".age");
const addrs = document.querySelectorAll(".addr");
function addStudent() {
  console.log(names);
  for (let i = 0; i < 3; i++) {
    const name = prompt(`${i}번째 학생 이름`);
    const age = prompt(`${i}번째 나이`);
    const addr = prompt(`${i}번째 주소`);
    names[i].textContent = name;
    ages[i].textContent = age;
    addrs[i].textContent = addr;
  }
}

// 8번
const list = document.querySelector("#list");
function addItem() {
  // 1. li 태그를 만들어서 추가하는 방식
  const li = document.createElement("li");
  li.textContent = "테스트";
  list.appendChild(li);

  // 2. innerHTML로 문자로 추가하는 방식
  list.innerHTML += "<li>테스트</li>";
}

function removeItem() {
  // 1. 부모에서 제거
  console.log(list.childNodes);
  //   list.removeChild(list.childNodes[0]);
  // 2. 본인이 제거
  const li = document.querySelector("#list li");
  console.log(li);
  li.remove();
}

// 9번
const result9 = document.querySelector("#result9");
function toggleClass() {
  result9.classList.toggle("active");
}

// 10번
const item = document.querySelector("#item");
const price = document.querySelector("#price");
const cart = document.querySelector("#cart");
const total = document.querySelector("#total span");
let sum = 0;
function addToCart() {
  cart.innerHTML += `<li>${item.value} - ${price.value}</li>`;

  console.log(isNaN(Number(price.value))); // NaN
  if (!isNaN(Number(price.value))) sum += Number(price.value);
  total.innerHTML = sum;
  console.log(sum);

  item.value = "";
  price.value = "";
}
