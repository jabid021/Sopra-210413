/**
 * 
 */

let produits = [
	{
		id: 1, libelle: 'tele', description: 'une tele',  photo: 'tele'
	},
	{
		id: 2, libelle: 'telephone', description: 'un telephone', photo: 'telephone'
	}
];

function initProduit() {

	for (let p of produits) {
		let tr = document.createElement('tr');
		tr.id = 'tr' + p.id;
		let tdId = document.createElement('td');
		tdId.innerHTML = p.id;
		let tdLibelle = document.createElement('td');
		tdLibelle.innerHTML = p.libelle;
		let tdDescription = document.createElement('td');
		tdDescription.innerHTML = p.description;
		let tdPhoto = document.createElement('td');
		let image = document.createElement('img');
		image.src = './images/' + p.photo + '.jpeg';
		image.width =  50;
		image.height = 50;
		let editer = document.createElement('button');
		editer.innerHTML =  'editer';
		editer.className = 'btn btn-outline-info';
		editer.addEventListener('click', function(event) {
			console.log('click sur le bouton');
			console.log(event.target);
		});
		let tdEditer = document.createElement('td');
		tdEditer.appendChild(editer);
		let supprimer = document.createElement('button');
		supprimer.innerHTML = 'supprimer';
		supprimer.className = 'btn btn-outline-danger';
		let tdSupprimer = document.createElement('td');
		supprimer.addEventListener('click', function(event) {
			document.querySelector('#tbody').removeChild(document.querySelector('#tr' + p.id));
		});
		tdSupprimer.appendChild(supprimer);
		tdPhoto.appendChild(image);
		tr.appendChild(tdId);
		tr.appendChild(tdLibelle);
		tr.appendChild(tdDescription);
		tr.appendChild(tdPhoto);
		tr.appendChild(tdEditer);
		tr.appendChild(tdSupprimer);
		console.log(tr);
		document.querySelector('#tbody').appendChild(tr);
	}

}