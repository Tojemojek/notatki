var firstBlood = "to piewszy js";
let firstBlood2 = "to piewszy js";
const firstBlood3 = "to piewszy js";

console.log(firstBlood);

console.log("Tekst1");
console.log("Tekst1", 5, 45, "Java");
console.log("Tekst1", 5, 45, "Java", "Java2");

var pies = {};

pies.name = "Burek";
pies.legs = 4;

var pies2 = {
    name: "Burek2",
    legs: 4
};

var person = {
    name: "Jan testowy",
    age: 33,
    city: "Warszawa"
};

console.log(person);


function suma(a, b) {
    return a + b;
}

console.log(suma(2, 3));
console.log(suma(.25, 3));


typeof 3;

console.log(typeof 3);
console.log(typeof 7.2);
console.log(typeof "7.2");

var test = "Java";
var test2 = test + "Script";
var test3 = `${test}Script`;

console.log(test);
console.log(test2);
console.log(test3);

"JavaScript".length;


console.log(true + 1);
console.log(1 + "JavaString");
console.log(false + "123");
console.log(false - "123");
console.log(false - 123);
console.log(true - 123);


console.log(5 == "5");
console.log(5 === "5");


function ourRange(testedNumber) {
    if ((testedNumber > -100 && testedNumber < 0) || (testedNumber > 10 && testedNumber < 100)){
        console.log(`Liczba ${testedNumber} zawiera się w naszym przedziale`);
    } else {
        console.log(`Liczba ${testedNumber} nie zawiera się w naszym przedziale`);
    }
};

ourRange(-120);
ourRange(-99);
ourRange(1);
ourRange(10);
ourRange(11);
ourRange(99);
ourRange(101);


function everySecondLetter(processedString) {
    var effect = "";
    for (var i = 0; i < processedString.length; i=i+2) {
        effect = effect + processedString[i]
    }
    return effect
};

everySecondLetter("tarantulla");

