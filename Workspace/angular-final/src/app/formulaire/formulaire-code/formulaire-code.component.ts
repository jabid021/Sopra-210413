import { Modulo10Validator } from './../../validators/modulo10-validator';
import { Component, OnInit } from '@angular/core';
import {
  FormBuilder,
  FormControl,
  FormGroup,
  Validators,
} from '@angular/forms';

@Component({
  selector: 'app-formulaire-code',
  templateUrl: './formulaire-code.component.html',
  styleUrls: ['./formulaire-code.component.css'],
})
export class FormulaireCodeComponent implements OnInit {
  prenomCtrl: FormControl;
  nomCtrl: FormControl;
  prixCtrl: FormControl;
  passwordCtrl: FormControl;
  confirmCtrl: FormControl;
  passwordGroup: FormGroup;
  form: FormGroup;

  constructor(private fb: FormBuilder) {
    this.prenomCtrl = fb.control('', Validators.required);
    this.nomCtrl = fb.control('', [
      Validators.required,
      Validators.minLength(2),
    ]);
    this.prixCtrl = fb.control(0, [
      Validators.required,
      Modulo10Validator.modulo10,
    ]);
    this.passwordCtrl = this.fb.control('', Validators.minLength(3));
    this.confirmCtrl = this.fb.control('');
    this.passwordGroup = this.fb.group(
      {
        password: this.passwordCtrl,
        confirm: this.confirmCtrl,
      },
      {
        validators: this.checkPassword,
      }
    );
    this.form = fb.group({
      prenom: this.prenomCtrl,
      nom: this.nomCtrl,
      passwordGroup: this.passwordGroup,
    });
  }

  submit() {
    console.log(this.form);
    console.log(this.prenomCtrl.value);
  }

  checkPassword(group: FormGroup) {
    const password = group.controls.password;
    const confirm = group.controls.confirm;
    if (password.errors) {
      return null;
    }
    return password.value != confirm.value ? { notMatch: true } : null;
  }

  ngOnInit(): void {}
}
