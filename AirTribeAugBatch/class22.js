// // Type of Functions
// //1. Function Declaration

// // function abc(name,a){
// //     console.log("Value of a is ",a)
// //     console.log("HELLO",name);
// // }

// // abc("Riya");
// // abc("Rishit",7);

// // 2. function expression

// // const fn= function(name){
// //     // console.log("Hello ",name)
// //     return "Hello"+name
// // }

// // let op=fn("Richa")
// // console.log(op)

// //3.Arrow Function 

// // fn('Himanshu');
// // var fn=(name)=>{
// //     console.log("Hello ",name)
// // }


// console.log("a")
// // 4. IIFE(Immediately Invoked Functions)

// (function(name){
//     console.log("HELLO",name);
// })("RAHUL");


// console.log("B");


console.log("A");
(function(name){
    console.log("HELLO ",name);
})("RAHUL");
console.log("B");