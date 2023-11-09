function removeEveryOther(arr) {
    return arr.filter((_, index) => index % 2 === 0);
}

let array = ['Keep', 'Remove', 'Keep', 'Remove', 'Keep'];

let result = removeEveryOther(array);

console.log(result);
