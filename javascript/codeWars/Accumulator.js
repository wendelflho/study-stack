// "ZpglnRxqenU" -> "Z-Pp-Ggg-Llll-Nnnnn-Rrrrrr-Xxxxxxx-Qqqqqqqq-Eeeeeeeee-Nnnnnnnnnn-Uuuuuuuuuuu");

function accum(s) {
    let newString = s.split('')
    let teste = s.charAt(0);
    
    newString.forEach((element, index) => {
        teste += element.repeat(index);
    });

    return teste;
}

console.log(accum('ZpglnRxqenU'));