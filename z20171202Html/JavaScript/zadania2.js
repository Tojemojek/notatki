// Zadanie 1
// nadaj co drugiemu elementowi list o id zadanie1 klase error

var allLiZadanie1= document.querySelectorAll("#zadanie1 li");

for (var i = 0; i < allLiZadanie1.length; i +=2){
    allLiZadanie1[i].setAttribute('class', 'error')
};

// Zadanie 2
// nadaj wszystkim elementom listu o id zadanie2 klase active ( w przypadku jezeli ta klasa juz istnieje zdejmij ta klase)

var allLiZadanie2= document.querySelectorAll("#zadanie2 li");

for (var i = 0; i < allLiZadanie2.length; i ++){

    if (allLiZadanie2[i].getAttribute('class')==="active"){
        allLiZadanie2[i].setAttribute('class', '')
    } else{
    allLiZadanie2[i].setAttribute('class', 'active')
    }
};

// Zadanie 3
// Podmien obrazek tak, aby wyswietlal obraz psa a nie kota

var allLiZadanie3= document.querySelector("img");
allLiZadanie3.setAttribute('src', 'https://upload.wikimedia.org/wikipedia/commons/thumb/d/d9/Collage_of_Nine_Dogs.jpg/1024px-Collage_of_Nine_Dogs.jpg')

// Zadanie 4
// zadanie specjalne na stronie www