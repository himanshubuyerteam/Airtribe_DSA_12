// console.log(a);
// var a=10;
// console.log(a);
// console.log(b)
// console.log(b)

// console.log(a);
// const a=10;
// console.log(a);

// function example1() 
// {
//     if (true) 
//     {
//         var aa = 1;
//         let bb = 2;
//     }
//     console.log(aa); 
//     console.log(bb); 
// }
// example1();
// console.log(cc)
// var cc=20;
// function abc()
// {
//     if(true)
//     {
//         var cc=1;
//     }
//     console.log(cc);
// }
// abc();
// console.log(cc);


// console.log(cc)
// var cc=20;
// function abc()
// {
//     if(true)
//     {
//         cc=1;
//     }
//     console.log(cc);
// }
// abc();
// console.log(cc);

// var a=100;
// function p1()
// {
//     function c1()
//     {
//         console.log(a);
//     }
//     console.log("Line no 57")
//     c1();
//     console.log("Line no 59");
// }
// p1()


// var a=10;
// function p1()
// {
//     function c1()
//     {
//         function c2()
//         {
            
//             console.log(a);   
//         }
//         c2();
//     }
//     c1();
// }
// p1();


// function p1(){
//     var a=20;
//     function c1()
//     {
//         console.log(a);
//         function c2()
//         {
//             console.log(a);
//         }
//         // var a=10;
//         c2();
//     }
//     c1();
//     console.log(a);
// }
// p1();


function p1()
{
    var a=20
    function c1()
    {
        c2();
        console.log("Line no 104",a)
        var a=10
        
        console.log("Line no 106",a);
        function c2()
        {
            console.log("Line no 109",a);
            a=30;
        }
        // c2();
        console.log("Line no 113",a);
    }
    c1();
    console.log("Line no 116",a);
}
p1();

