// Zadanie 0 - znajdz pierwszy paragraf na stronie
var firstP = document.querySelector("p");
console.log(firstP);

// Zadanie 1 - znajdz wszystkie paragrafy na stronie
var allParagraphs= document.querySelectorAll("p");
console.log(allParagraphs);

// Zadanie 2 - znajdz div'a o klasie inner2
var allDivInner= document.querySelector("div.inner");
console.log(allDivInner);

// Zadanie 3 - znajdz wszystkie paragrafy o klasie inner
var allPInner= document.querySelector("p.inner");
console.log(allPInner);

// Zadanie 3a - znajdz wszystko w klasie inner
var allPInner= document.getElementsByClassName("inner");
console.log(allPInner);

// Zadanie 4 - znajdz wszystkie elementy li o klasie error
var allLIError= document.querySelectorAll("li.error");
console.log(allLIError);




// Zadanie 1 - Znajdz wszystkie div'y na stronie - wypisz ich nazwy klas
var allDiv= document.querySelectorAll("div");

for (var i = 0; i < allDiv.length; i++){
    console.log(allDiv[i].className);
};

// Zadanie 2 - Znajdz wszystkie element li o klasie 'ok' i zmien im kolor tla na zielony

var allLiOK= document.querySelectorAll("li.ok");

for (var i = 0; i < allDivInner.length; i++){
    allLiOK[i].style.background="green"
};


// Zadanie 3 - pobierz tekst który znajduję sie w paragrafie, zapisz go do zmiennej oraz wyświetl a następnie podmień go na "Hello World"

var paragraphText= document.querySelector("p");
console.log(paragraphText.innerHTML);
paragraphText.innerHTML="Hello World";

// Zadanie 4 - wypisz zawartość wszystkich elementów li na stronie

var liContent= document.querySelectorAll("li");
for (var i = 0; i < liContent.length; i++){
    liContent[i].innerHTML
};



// przykłady  innych

var allDivs = document.getElementsByTagName("div");
var allImagesInParagraphs= document.querySelectorAll("p img");
var header = document.getElementById("header");
var allTooltips = document.getElementsByClassName("tooltip");
var firstH2 = foo.querySelector("h2");