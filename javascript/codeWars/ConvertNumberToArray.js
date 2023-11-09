function digitize(n) {
    let arrayDigits = Array.from(String(n), Number);

    return arrayDigits.reverse()
}

let n = 123456;

console.log(digitize(n));