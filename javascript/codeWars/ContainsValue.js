function check(a, x) {
    // for (let i = 0; i < a.length; i++) {
    //     if (a[i] === x) {
    //         return true;
    //     }
    // }
    // return false;
    return a.includes(x);
}

console.log(check([66, 101], 66))

/*
(5) Use ES2015 method to see if array contains the value.
    Eliminate more cruft.
*/
// const check = (a,x)=>a.includes(x)




/*
  (4) Eliminate all the overhead setup.
      Use the ES2015 SOME method to see if one or more
      of the array entries matches our target.
      Written in the form of a lambda (arrow function) to make it streamlined

    const check = (a,x)=>a.some(v=>v==x)
*/

/*
(3) Filter the Array
    Reduce it down to matching values or an empty set ... [66]
    Test the length of the array   [66].length > 0

  function check(a,x){
    return (a.filter(v=>v==x)).length > 0
  }
*/