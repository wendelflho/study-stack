function disemvowel(str) {
    const vowels = 'aeiou';
    return str.split('').filter(letter => !vowels.includes(letter.toLowerCase())).join('')
    // return str.replace(/[aeiou]/gi, "");
}

console.log(disemvowel('Freio'));