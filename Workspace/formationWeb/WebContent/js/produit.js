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
		document.querySelector('#tbody').appendChild(createTr(p));
	}

}

function add() {
	let produit = {
		id: '',
		libelle: '',
		description: ''
	}
	showForm(produit);
}

function hideForm() {
	document.querySelector('#divForm').className = 'd-none';
}

function showForm(produit) {
	document.querySelector('#divForm').className = 'd-block';
	document.querySelector('#inputId').value = produit.id;
	document.querySelector('#inputLibelle').value = produit.libelle;
	document.querySelector('#inputDescription').value = produit.description;
}


function saveProduit() {
	let produit = {
		id: document.querySelector('#inputId').value,
		libelle: document.querySelector('#inputLibelle').value,
		description: document.querySelector('#inputDescription').value,
		photo: 'img1'
	}
	if (!!document.querySelector('#tr' + produit.id)) {
		modifTr(produit);
	} else {
		addTr(produit);
	}
	document.querySelector('#divForm').className = 'd-none';
}

function addTr(produit) {
	document.querySelector('#tbody').appendChild(createTr(produit));
}

function modifTr(produit) {
	document.querySelector('#tbody').replaceChild(createTr(produit), document.querySelector('#tr' + produit.id));
}

function createTr(p) {
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
	image.width = 50;
	image.height = 50;
	let editer = document.createElement('button');
	editer.innerHTML = 'editer';
	editer.className = 'btn btn-outline-info';
	editer.addEventListener('click', function(event) {
		showForm(p);
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
	return tr;
}