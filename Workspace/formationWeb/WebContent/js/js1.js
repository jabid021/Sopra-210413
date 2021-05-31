/**
 * 
 */
//
//console.log('fichier javascript');
//var t=[1,2,3,4,5];
//for(let i of t){
//	document.write(i+'<br>');
//}

//json
var unObjet = {
	prenom: 'olivier',
	nom: 'gozlan',
	age: 222,
	sePresenter: function() {
		console.log(this.prenom+' '+this.nom);
	}
};

console.log(unObjet.sePresenter());
console.log(unObjet);
unObjet.adresse='chez moi';
console.log(unObjet);


function maFonction() {
	console.log('la fonction');
	2 == '2'
	2 === '2'
}

function envoyerValeurDansInput() {
	//let element=document.getElementById('input');
	let element = document.querySelector('#input');
	element.value = 'une valeur du javascript';
	document.querySelector('#img1').src = './images/img1.jpeg';
	document.querySelector('#h4').innerHTML = 'un nouveau contenu';

}

var images = ['carre', 'rectangle', 'triangle', 'trapeze', 'parallelo', 'cercle'];

function loadImg() {
	let select = document.querySelector('#forme');
	document.querySelector('#image').src = './images/' + images[select.value] + '.gif';
	if (select.value == 4) {
		document.querySelector('#titre').innerHTML = 'Aire du parallelogramme';
	} else {
		document.querySelector('#titre').innerHTML = 'Aire du ' + images[select.value];
	}
}

function affichageConsole() {
	console.log('on affiche un truc');
}
var timer;
function timeout() {
	//timer = setInterval(affichageConsole, 2000);
	timer = setTimeout(affichageConsole, 5000);
}

function stop() {
	//clearInterval(timer);
	clearTimeout(timer);
}

var diapo = ['90001', '90003', '90008', '90013'];
var index = 0;

function changeImg() {
	stopLoadImage();
	document.querySelector('#diapo').src = './images/' + diapo[index] + '.jpg';
	startLoadImage();
}

function previous() {
	if (index == 0) {
		index = diapo.length - 1;
	} else {
		index--;
	}
	changeImg();
}

function next() {
	index++;
	if (index == diapo.length) {
		index = 0;
	}
	changeImg();
}

function first() {
	index = 0;
	changeImg();
}

function last() {
	index = diapo.length - 1;
	changeImg();
}

var timerImage;

function startLoadImage() {
	timerImage = setInterval(previous, 3000);
}

function stopLoadImage() {
	clearInterval(timerImage);
}

