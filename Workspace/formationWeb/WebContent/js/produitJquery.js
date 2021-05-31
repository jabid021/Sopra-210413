/**
 * 
 */

let numero=0;

function add() {
	let produit = {
		id: '',
		libelle: '',
		description: ''
	}
	showForm(produit);
}

function hideForm() {
	console.log('hide');
	$('#divForm').hide();
	console.log($('#divForm'));
}

function showForm(produit) {
	$('#divForm').show();
	$('#inputId').val(produit.id);
	$('#inputLibelle').val(produit.libelle);
	$('#inputDescription').val(produit.description);
}


function saveProduit() {
	let produit = {
		id: $('#inputId').val(),
		libelle: $('#inputLibelle').val(),
		description: $('#inputDescription').val(),
		photo: 'img1'
	}

	if (!!$('#tr' + produit.id).attr('id')) {
		modifTr(produit);
	} else {
		addTr(produit);
	}
	$('#divForm').hide();
}

function addTr(produit) {
	$('#tbody').append(createTr(produit));
}

function modifTr(produit) {
	$('#tr' + produit.id).replaceWith(createTr(produit));
}



function createTr(p) {
	let tdId = $('<td/>').html(p.id);
	let tdLibelle = $('<td/>').html(p.libelle);
	let tdDescription = $('<td/>').html(function() {
		return p.libelle;
	});
	let image = $('<img/>');
	image.attr({
		src: './images/' + p.photo + '.jpeg',
		width: 50,
		height:50 
		});
	let editer = $('<button>editer</button>').addClass('btn btn-outline-info').click(function(event) {
		showForm(p);
	});
	let tdEditer = $('<td/>').append(editer);
	let supprimer = $('<button/>').html('supprimer').addClass('btn btn-outline-danger').click(function(event) {
		tr = $('#tr' + p.id);
		tr.remove();
	});
	let tdSupprimer = $('<td/>').append(supprimer);
	let tdPhoto = $('<td/>').append(image);
	return $('<tr/>').attr('id', 'tr' + p.id).append(tdId, tdLibelle, tdDescription, tdPhoto, tdEditer, tdSupprimer);

}

$(document).ready(function() {
	let produits = [
		{
			id: 1, libelle: 'tele', description: 'une tele', photo: 'tele'
		},
		{
			id: 2, libelle: 'telephone', description: 'un telephone', photo: 'telephone'
		}
	];

	for (let p of produits) {
		$('#tbody').append(createTr(p));
	}

	$('#buttonCancel').click(function() {
		hideForm();
	});
	$('#buttonAdd').click(function() {
		add();
	});
	$('#buttonSave').click(function() {
		saveProduit();
	})
	hideForm();
}


)