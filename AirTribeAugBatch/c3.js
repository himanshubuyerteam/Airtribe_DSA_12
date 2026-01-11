// setTimeout(function(){
//     console.log("HELLO")
// },2000);



// 5
// 10
// 15
// 20
// 25
// 30
// 35
// 40


// let multiplier=1;
let def = setInterval(function(){
    console.log(multiplier*5);
    multiplier++
    if(multiplier>10)
        clearInterval(def)
},500);

// for (let i = 1; i <= 10; i++) {
//     setTimeout(() => {
//       console.log(i * 5);
//     }, i * 1000);
// }


let multiplier = 1;
let abc = setInterval(() => {
    console.log("inerval = " , multiplier*5);
    multiplier++;
    if(multiplier>10) 
        clearInterval(abc);
}, 1000);


for (let index = 0; index < 10; index++) 
{
    setTimeout(() => {
    console.log("for => " + (index+1)*5);
    }, 1000);
}