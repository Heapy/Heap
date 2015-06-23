var Pinkyfier = require("./Pinkyfier"),
    pinkyfier = new Pinkyfier("text");

pinkyfier.pink();

document.getElementById("fat").onclick = function () {
    require(["./Fattyfier"], function (Fattyfier) {
        var fattyfier = new Fattyfier("text");
        fattyfier.fat();
    });
}
