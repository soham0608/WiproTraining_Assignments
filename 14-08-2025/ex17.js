var Calculator = /** @class */ (function () {
    function Calculator() {
    }
    Calculator.prototype.add = function (a, b) {
        return a + b;
    };
    Calculator.prototype.subtract = function (a, b) {
        return a - b;
    };
    return Calculator;
}());
var calc = new Calculator();
console.log("Add 5 + 3 =", calc.add(5, 3));
console.log("Subtract 10 - 4 =", calc.subtract(10, 4));
