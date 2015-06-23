function Pinkyfier(id) {
    this.element = document.getElementById(id);
}

Pinkyfier.prototype.pink = function () {
    this.element.style.backgroundColor = "mistyrose";
    this.element.style.color = "hotpink";
}

module.exports = Pinkyfier;

