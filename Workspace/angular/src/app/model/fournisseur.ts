import { Personne } from './personne';
export class Fournisseur extends Personne {
  constructor(private _societe: string = '', prenom?: string, nom?: string) {
    super(prenom, nom);
  }

  /**
   * Getter societe
   * @return {string }
   */
  public get societe(): string {
    return this._societe;
  }

  /**
   * Setter societe
   * @param {string } value
   */
  public set societe(value: string) {
    this._societe = value;
  }
}
