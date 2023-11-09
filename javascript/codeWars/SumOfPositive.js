function positiveSum(arr) {
    // Solução 1
    // let sum = 0;
    //
    // const positiveArray = arr.filter(num => num > -1);
    //
    // for (let i = 0; i < positiveArray.length; i++) {
    //     sum += positiveArray[i]
    // }
    //
    // return sum;

    // Solução 2
    return arr.filter(num => num > -1).reduce((a, b) => a + b, 0);
}

let numbers = [1,-4,7,12];

console.log(positiveSum(numbers));