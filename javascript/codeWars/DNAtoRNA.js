function DNAtoRNA(dna) {
    // return dna.split('').map(n => n === 'T' ? 'U' : n).join('')
    // return dna.split("T").join("U");
    return dna.replace(/T/g, 'U')
}

// const

let dna = 'GCAT';

console.log(DNAtoRNA(dna));
