function solution(str, ending) {
    return str.endsWith(ending)
}

let string = 'abc';

let stringEnd = 'bc';

console.log(solution(string, stringEnd));