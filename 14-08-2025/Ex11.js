function separateFirstRest(...args) {
  let [first, ...rest] = args;
  return { first, rest };
}

console.log(separateFirstRest(1, 2, 3, 4));
console.log(separateFirstRest("apple", "banana", "cherry"));