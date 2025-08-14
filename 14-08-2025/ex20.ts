function pair<T, U>(first: T, second: U): [T, U] {
    return [first, second];
}

console.log(pair<number, string>(1, "One"));
console.log(pair<string, boolean>("Hello", true));
console.log(pair<number, number>(10, 20));
