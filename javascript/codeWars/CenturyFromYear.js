function century(year) {
    return Math.ceil(year/100)
}

let year = 1905;

console.log(century(year));

// falhou nos testes para ano = 89
// falhou nos testes para ano = 714960
