function fakeBin(x) {
    // Solução 1
    // return x.split('').map(n => n < 5 ? 0 : 1).join('');

    // Solução 2
    // let newString = '';
    // for (let i = 0; i < x.length; i++) {
    //
    //     if (x[i] < 5) {
    //         newString += '0';
    //     } else {
    //         newString += '1';
    //     }
    //
    // }
    //
    // return newString;

    // Solução 3
    // let newString = x.split('');
    //
    // let string = '';
    //
    // for (let i of newString) {
    //     if (i < 5) {
    //         newString.concat('0');
    //     } else {
    //         newString.concat('1');
    //     }
    // }
    //
    // newString = x.join('');
    //
    // return newString;
}

let teste = '45385593107843568';

let result = fakeBin(teste);

console.log(result);