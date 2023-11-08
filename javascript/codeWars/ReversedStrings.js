function solution(str) {
    // Solução 1
    return str.split('').reverse().join('');

    // Solução 2
    // let newString = '';
    //
    // for (let i = str.length - 1; i > -1; i--) {
    //     newString += str[i];
    // }
    //
    // return newString;

}

let string = 'world';

console.log(solution(string));