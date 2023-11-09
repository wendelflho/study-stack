class SmallestIntegerFinder {
    // Solução 1
    findSmallestInt = args => Math.min(...args);

    // Solução 2
    // findSmallestInt(args) {
    //     return args.reduce((a, v) => Math.min(a, v));
    // }

}

let finder = new SmallestIntegerFinder();

let numbers = [56, 10, 7, 17, 28, 15];

let result = finder.findSmallestInt(numbers);

console.log(result);
