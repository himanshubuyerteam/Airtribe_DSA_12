// // let mm=42;
// // let pm=40;
// // const myPromise= new Promise(function(resolve,reject){
// //     if(mm>pm)
// //     {
// //         resolve("PASS")
// //     }
// //     else
// //     {
// //         reject("FAIL IN EXAM")
// //     }
// // })
// // myPromise.then(function(result){
// //     console.log(result)
// // }).catch(function(error){
// //     console.log(error)
// // })



// console.log("A")
// setTimeout(function(){
//     console.log("B")
// },1000);
// setTimeout(function(){
//     console.log("C")
// })
// Promise.resolve().then(()=>{
//     console.log("D")
// })
// console.log("E");


// let mm=42;
// let pm=40;
// const myPromise= new Promise(function(resolve,reject){
//     if(mm>pm)
//     {
//         resolve("PASS")
//     }
//     else
//     {
//         reject("FAIL IN EXAM")
//     }
// })
// myPromise.then(function(result){
//     console.log(result)
// }).catch(function(error){
//     console.log(error)
// })



console.log("A")
setTimeout(function(){
    console.log("B")
},1000);
setTimeout(function(){
    console.log("C")
})
Promise.reject().catch(()=>{
    setTimeout(function(){
        console.log("D")
    },500)
})
console.log("E");



