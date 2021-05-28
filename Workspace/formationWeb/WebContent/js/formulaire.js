/**
 * 
 */

let status = [false, false, false, false];


function checkName() {
	let input = document.querySelector('#name');
	status[0] = checkInput(input, !!input.value);
	submitStatus();
}

function checkEmail() {
	let exp = /^[a-z][a-z0-9]+(\.?[a-z][a-z0-9]+){0,}@[a-z][a-z0-9]{2,}(\.[a-z]{2,}){1,}$/
	let input = document.querySelector('#email');
	status[1] = checkInput(input, exp.test(input.value.toLowerCase()));
	submitStatus();
}

function checkInput(input, result) {
	if (result) {
		input.className = 'form-control is-valid'
		return true;
	} else {
		input.className = 'form-control is-invalid';
		return false;
	}
}

function checkPassword() {
	let exp = /^(?=.*[a-zA-Z]{1})(?=.*\d{1})([a-zA-Z0-9]{4,})$/
	let input = document.querySelector('#password');
	status[2] = checkInput(input, exp.test(input.value));
	submitStatus();
}

function checkCheckbox() {
	let input = document.querySelector('#checkbox');
	if (input.checked) {
		input.className = 'form-check-input is-valid';
	} else {
		input.className = 'form-check-input is-invalid';
	}
	status[3] = input.checked;
	submitStatus();
}


function submitStatus() {
	let i = 0;
	let unlock = false;
	console.log(status);
	
	for (let e of status) {
		unlock = e;
		if (unlock == false) {
			break;
		}
		i++;
	}
	console.log('unlock:' + unlock);
	document.querySelector('#submit').disabled = !unlock;

}