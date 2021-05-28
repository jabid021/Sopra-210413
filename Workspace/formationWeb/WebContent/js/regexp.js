/**
 * 
 */

function check(){
	var regexp=new RegExp('^(?=.*[a-z])(?=.*[0-9])(?=.*[A-Z])(?=.*[@$!])([a-zA-Z0-9@$!]{6,})$');
	var input=document.querySelector('#input');
	console.log(regexp.test(input.value));
			
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
(?=.*[a-z])(?=.*[0-9])(?=.*[A-Z])(?=.*[@$!])
*/