function removeEveryOther(arr) {
    let newArray = [];

    for (let i = 0; i < arr.length; i++) {
        console.log(arr[i]);
        newArray = arr.splice(i % 2 !== 0, 1);
    }

    console.log(newArray);

    return newArray;
}

let array = ['Keep', 'Remove', 'Keep', 'Remove', 'Keep'];

let result = removeEveryOther(array);

console.log(result);
