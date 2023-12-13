function swap(a, b) {
    return [b, a];
}

function getSum(a, b) {
    let sum = 0;

    if (b < a) {
        [a, b] = swap(a, b);
    }

    for (let i = a; i <= b; i++) {
        sum += i;
    }

    return sum;
}

console.log(getSum(2, 2));
