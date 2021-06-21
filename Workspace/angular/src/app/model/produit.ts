import { Client } from './client';
import { Fournisseur } from './fournisseur';
export class Produit {
  private _clients: Array<Client> = new Array<Client>();

  constructor(
    private _nom: string = '',
    private _prix: number = 0,
    private _fournisseur: Fournisseur = null
  ) {}

  /**
   * Getter prix
   * @return {number}
   */
  public get prix(): number {
    return this._prix;
  }

  /**
   * Getter fournisseur
   * @return {Fournisseur}
   */
  public get fournisseur(): Fournisseur {
    return this._fournisseur;
  }

  /**
   * Setter prix
   * @param {number} value
   */
  public set prix(value: number) {
    this._prix = value;
  }

  /**
   * Setter fournisseur
   * @param {Fournisseur} value
   */
  public set fournisseur(value: Fournisseur) {
    this._fournisseur = value;
  }

  /**
   * Getter clients
   * @return {Array<Client>}
   */
  public get clients(): Array<Client> {
    return this._clients;
  }

  /**
   * Getter nom
   * @return {string}
   */
  public get nom(): string {
    return this._nom;
  }

  /**
   * Setter clients
   * @param {Array<Client>} value
   */
  public set clients(value: Array<Client>) {
    this._clients = value;
  }

  /**
   * Setter nom
   * @param {string} value
   */
  public set nom(value: string) {
    this._nom = value;
  }
}
