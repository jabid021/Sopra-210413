import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-formulaire-template',
  templateUrl: './formulaire-template.component.html',
  styleUrls: ['./formulaire-template.component.css'],
})
export class FormulaireTemplateComponent implements OnInit {
  prenom: string = '';
  nom: string = '';

  constructor() {}

  ngOnInit(): void {}

  submit(monForm: any) {
    console.log(monForm);
  }
}
