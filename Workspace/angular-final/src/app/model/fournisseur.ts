import { Adresse } from './adresse';
import { Civilite } from './civilite';
export class Fournisseur {
  constructor(
    private _id: number | any = null,
    private _prenom: string = '',
    private _nom: string = '',
    private _commentaire: string = '',
    private _civilite: Civilite = Civilite.M,
    private _contact: string = '',
    private _adresse: Adresse = new Adresse(),
    private _dateNaissance: Date = new Date()
  ) {}

  public get dateNaissance(): Date {
    return this._dateNaissance;
  }

  public set dateNaissance(value: Date) {
    this._dateNaissance = value;
  }

  /**
   * Getter id
   * @return {number }
   */
  public get id(): number {
    return this._id;
  }

  /**
   * Getter prenom
   * @return {string }
   */
  public get prenom(): string {
    return this._prenom;
  }

  /**
   * Getter nom
   * @return {string }
   */
  public get nom(): string {
    return this._nom;
  }

  /**
   * Getter commentaire
   * @return {string }
   */
  public get commentaire(): string {
    return this._commentaire;
  }

  /**
   * Getter civilite
   * @return {Civilite }
   */
  public get civilite(): Civilite {
    return this._civilite;
  }

  /**
   * Getter contact
   * @return {string }
   */
  public get contact(): string {
    return this._contact;
  }

  /**
   * Getter adresse
   * @return {Adresse }
   */
  public get adresse(): Adresse {
    return this._adresse;
  }

  /**
   * Setter id
   * @param {number } value
   */
  public set id(value: number) {
    this._id = value;
  }

  /**
   * Setter prenom
   * @param {string } value
   */
  public set prenom(value: string) {
    this._prenom = value;
  }

  /**
   * Setter nom
   * @param {string } value
   */
  public set nom(value: string) {
    this._nom = value;
  }

  /**
   * Setter commentaire
   * @param {string } value
   */
  public set commentaire(value: string) {
    this._commentaire = value;
  }

  /**
   * Setter civilite
   * @param {Civilite } value
   */
  public set civilite(value: Civilite) {
    this._civilite = value;
  }

  /**
   * Setter contact
   * @param {string } value
   */
  public set contact(value: string) {
    this._contact = value;
  }

  /**
   * Setter adresse
   * @param {Adresse } value
   */
  public set adresse(value: Adresse) {
    this._adresse = value;
  }
}
