let name ={
    fn:"Himanshu",
    ln:"Mittal",
    printFullName: function(){
        console.log(this.fn+" "+this.ln);
    }
}


name.printFullName();


let name2 ={
    fn:"Richa",
    ln:"Tayal",
}

let printFullName = function(){
    console.log(this.fn+" "+this.ln);
}

printFullName.call(name2);