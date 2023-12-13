function findNextSquare(sq) {
    let x = Math.sqrt(sq);

    let nextSqrt = Math.pow(x + 1, 2);

    if (!Number.isInteger(x)) {
        return -1;
    }

    return nextSqrt;
}

console.log(findNextSquare(121));