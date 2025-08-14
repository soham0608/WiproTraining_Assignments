function getDate() {
    const today = new Date();
    const dd = String(today.getDate()).padStart(2, '0');
    const mm = String(today.getMonth() + 1).padStart(2, '0');
    const yyyy = today.getFullYear();
    return `${dd}-${mm}-${yyyy}`;
}

function getPIValue() {
    return Math.PI;
}

function convertC2F(celsius) 
{
    return (celsius * 9/5) + 32;
}

function getFibonacci(n) 
{
    if (n <= 0) return [];

    if (n === 1) return [0];

    const fib = [0, 1];
    for (let i = 2; i < n; i++) {
        fib.push(fib[i - 1] + fib[i - 2]);
    }
    return fib;
}

console.log(getDate());
console.log(getPIValue());
console.log(convertC2F(0));
console.log(getFibonacci(10));