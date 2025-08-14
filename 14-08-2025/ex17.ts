class Calculator 
{
    add(a: number, b: number): number 
    {
        return a + b;
    }

    subtract(a: number, b: number): number 
    {
        return a - b;
    }
}

const calc = new Calculator();

console.log("Add 5 + 3 =", calc.add(5, 3));
console.log("Subtract 10 - 4 =", calc.subtract(10, 4));
