function reverseWords(str) {
    let words = str.split(' ');

    let newArray = words.map(word => word.split('').reverse().join(''));

    return newArray.join(' ');
}

let sentence = 'This is an example!';

console.log(reverseWords(sentence));
