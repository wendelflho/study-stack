function rentalCarCost(d) {
    return d * 40 - (d >= 7 ? 50 : (d >= 3 ? 20 : 0));
}

let days = 5;

console.log(rentalCarCost(days));
