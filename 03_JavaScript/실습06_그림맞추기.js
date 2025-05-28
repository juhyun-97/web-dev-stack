window.addEventListener("DOMContentLoaded", () => {
  const click = document.querySelector("#click");
  const restart = document.querySelector("#restart");
  click.addEventListener("click", () => {
    click.style.background = "yellow";
    console.log(Math.floor(Math.random() * 3) + 1);
    console.log(picture);
  });
  const picture = document.querySelectorAll("#picture");
  for (let i = 0; i < picture.length; i++) {
    img[i].addEventListener("click", (e) => {});
  }
});
