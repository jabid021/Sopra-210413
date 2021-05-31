/**
 * 
 */

let numeroAuto = 10;

$().ready(function() {
	let add = function() {
		let personne = {
			id: '', titre: 'M', prenom: '', nom: '', age: 0
		}
		showForm(personne);
	}

	let save = function() {
		console.log('save');
		let personne = {
			id: $('#id').val(), titre: $('#titre').val(), prenom: $('#prenom').val(), nom: $('#nom').val(), age: $('#age').val()
		}
		let erreur = false;
		let checkCaractere = /^[a-zA-Z]{2,}(-[a-zA-Z]{2,}){0,}$/;
		console.log(checkCaractere.test(personne.prenom));
		if (personne.prenom === '' || !checkCaractere.test(personne.prenom)) {
			console.log('test');
			$('#prenom').addClass('is-invalid')
			$('#erreurPrenom').show();
			erreur = true;
		} else {
			$('#prenom').removeClass().addClass('form-control');
			$('#erreurPrenom').hide();
		}

		if (personne.nom == '' || !checkCaractere.test(personne.nom)) {
			$('#erreurNom').show();
			$('#nom').addClass('is-invalid')
			erreur = true;
		} else {
			$('#nom').removeClass().addClass('form-control');
			$('#erreurNom').hide();
		}

		if ($('#age').val() > 0 && $('#age').val()  < 150) {
			$('#age').removeClass().addClass('form-control');
			$('#erreurAge').hide();
		} else {
			$('#erreurAge').show();
			$('#age').addClass('is-invalid')
			erreur = true;
		}

		if (!erreur) {

			if (!!$('#tr' + personne.id).attr('id')) {
				$('#tr' + personne.id).replaceWith(createTr(personne));
			} else {
				personne.id = numeroAuto;
				numeroAuto++;
				$('#tbody').append(createTr(personne));
			}
			hideForm();
		}

	}

	let showForm = function(personne) {
		$('#id').val(personne.id);
		$('#titre').val(personne.titre);
		$('#prenom').val(personne.prenom);
		$('#nom').val(personne.nom);
		$('#age').val(personne.age);
		$('#form').show();
	}

	let hideForm = function() {
		$('#nom').removeClass().addClass('form-control');
		$('#prenom').removeClass().addClass('form-control');
		$('#age').removeClass().addClass('form-control');
		$('#erreurNom').hide();
		$('#erreurPrenom').hide();
		$('#erreurAge').hide()
		$('#form').hide();
	}

	let createTr = function(personne) {
		let $tdId = $('<td>').html(personne.id);
		let $tdTitre = $('<td>').html(personne.titre);
		let $tdPrenom = $('<td>').html(personne.prenom);
		let $tdNom = $('<td>').html(personne.nom);
		let $tdAge = $('<td>').html(personne.age);
		let $tdButtonEditer = $('<td>').append($('<button>').html('editer').addClass('btn btn-outline-primary').click(function() {
			showForm(personne);
		}));
		let $tdButtonSupprimer = $('<td>').append($('<button>').html('supprimer').addClass('btn btn-outline-danger').click(function() {
			$('#tr' + personne.id).remove();
		}));
		return $('<tr>').attr('id', 'tr' + personne.id).append($tdId, $tdTitre, $tdPrenom, $tdNom, $tdAge, $tdButtonEditer, $tdButtonSupprimer);
	};

	let init = function() {

		hideForm();
		$('#cancel').click(function() {
			hideForm();
		})
		$('#add').click(function() {
			add();
		});

		$('#save').click(function() {
			save();
		})

		$('#erreurPrenom').hide();
		$('#erreurNom').hide();
		$('#erreurAge').hide();

	}

	init();

})