function past(h, m, s) {
    // let hour = 3600000;
    // let minutes = 60000;
    // let seconds = 1000;
    //
    // return (h*hour) + (m*minutes) + (s*seconds);
    let setTime = new Date().setHours(h, m, s);
    let midNight = new Date().setHours(0, 0, 0);

    return Math.round(setTime - midNight);
}

let hour = 1;

let minutes = 1;

let seconds = 1;

console.log(past(hour, minutes, seconds));