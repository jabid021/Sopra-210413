/**
 * 
 */

function check() {
	var regexp = new RegExp('^(?=.*[a-z])(?=.*[0-9])(?=.*[A-Z])(?=.*[$!])([a-zA-Z0-9$!]{6,})$');
	var input = document.querySelector('#telephone');
	console.log(regexp.test(input.value));

}

function aa() {
	var regexp = /^((0[1-9])|(\+33\s?[1-9]))\s?([0-9]{2}\s?){4}$/;
	var input = document.querySelector('#telephone');
	console.log('check')
	if (regexp.test(input.value)) {
		console.log('ok');
		input.className = 'default';
		document.querySelector('#submit').disabled = false;
	} else {
		console.log('error');
		input.className = 'error';
		document.querySelector('#submit').disabled = true;
	}
}

function telephone() {
	//var regexp = new RegExp('^(0[1-9])|(\\+33\\s?[1-9])\\s?([0-9]{2}\\s?){4}$');
	var regexp = /^(0[1-9])|(\+33\s?[1-9])\s?([0-9]{2}\s?){4}$/;
	var input = document.querySelector('#telephone');
	if (regexp.test(input.value)) {
		input.className = 'default';
		document.querySelector('#submit').disabled = false;
	} else {
		input.className = 'error';
		document.querySelector('#submit').disabled = true;
	}
}
/*
 ^:debut de ligne
 $:fin de ligne
 [azer]:1 caractere dans la liste
 [a-eA-E]:1 caractere dans l'intervale a=>e'
 .:1 caractere
 {n}:repetion n fois de ce qui il a avant
 {n,m}:repetiton minimum n fois max m fois
 *:{0,} repetition 0 à n fois
 +<=>{1,}:repetition au moins une fois
 ():groupe
 |:ou
 \d:nombre
 \:echappement
 \s:espace
 (?=)
*/