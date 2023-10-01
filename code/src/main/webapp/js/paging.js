var count = 0;
var pages = document.getElementsByClassName("pages")[0];
var buttons = pages.getElementsByClassName("btn-page");

document.getElementsByClassName("prev")[0].addEventListener('click', prevClick);
document.getElementsByClassName("next")[0].addEventListener('click', nextClick);

for (let i = 0; i < buttons.length; i++) {
    buttons[i].addEventListener("click", btnClick)
}

function nextClick() {
    if (count !== buttons.length - 1) {
        count++;
    }
    if (count <= buttons.length - 3) {
        pages.style.left = - (count - 1) * 40 + "px";
    }
}

function prevClick() {
    if (count !== 0) {
        count--;
    }
    if (count < buttons.length - 3) {
        pages.style.left = -(count - 1) * 40 + "px";
    }
}

function btnClick() {
    count = this.innerHTML - 1;
    if (count <= buttons.length - 3) {
        pages.style.left = - (count - 1) * 40 + "px";
    }
}