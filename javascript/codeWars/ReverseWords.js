function reverseWords(str) {
    let x = str.replace(/[^A-Za-z0-9]+/g, ' ');

    let newArray = x.trim().split(' ');

    let teste = '';

    for (let i = newArray.length - 1; i > -1; i--) {
        teste += newArray[i];
    }

    return teste;
}

let sentence = 'This is an example!';

console.log(reverseWords(sentence));