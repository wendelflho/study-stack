/*function findAverage(array) {
    if (array.length === 0) {
        return 0;
    } else {
        let soma = 0;

        for (let i = 0; i < array.length; i++) {
            soma += array[i];
        }

        return soma / array.length;
    }
}*/

function findAverage(array) {
    return array.length > 0 ? array.reduce((a, b) => a + b) / array.length : 0;
}

let array = [];

let result = findAverage(array);

console.log(result);