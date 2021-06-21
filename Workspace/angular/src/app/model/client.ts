import { Produit } from './produit';
import { Personne } from './personne';
export class Client extends Personne {
  private _produits: Produit[] = [];

  constructor(prenom?: string, nom?: string, private _ca: number = 0) {
    super(prenom, nom);
  }

  /**
   * Getter $produits
   * @return {Produit[] }
   */
  public get produits(): Produit[] {
    return this._produits;
  }

  public addProduit(produit: Produit) {
    this.produits.push(produit);
  }

  /**
   * Getter $ca
   * @return {number }
   */
  public get ca(): number {
    return this._ca;
  }

  /**
   * Setter $ca
   * @param {number } value
   */
  public set ca(value: number) {
    this._ca = value;
  }
}
