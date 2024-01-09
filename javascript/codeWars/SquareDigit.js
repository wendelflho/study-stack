function squareDigits(num) {
    return parseInt(
        num.toString()
        .split('')
        .map(valor => valor * valor)
        .join('')
    );
    
    // let splitNumber = num.toString().split('');
    // let multiplica = 1;
    // let numberString = '';
    //
    // console.log(splitNumber);
    //
    // for (let i = 0; i < splitNumber.length; i++) {
    //     multiplica = Math.pow(parseInt(splitNumber[i]), 2);
    //     numberString += multiplica;
    // }
    //
    // return parseInt(numberString);
}

console.log(squareDigits(3212));