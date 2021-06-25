export class Adresse {
  constructor(
    private _numero: number = 0,
    private _rue: string = '',
    private _codePostal: string = '',
    private _ville: string = ''
  ) {}

  /**
   * Getter numero
   * @return {number }
   */
  public get numero(): number {
    return this._numero;
  }

  /**
   * Getter rue
   * @return {string }
   */
  public get rue(): string {
    return this._rue;
  }

  /**
   * Getter codePostal
   * @return {string }
   */
  public get codePostal(): string {
    return this._codePostal;
  }

  /**
   * Getter ville
   * @return {string }
   */
  public get ville(): string {
    return this._ville;
  }

  /**
   * Setter numero
   * @param {number } value
   */
  public set numero(value: number) {
    this._numero = value;
  }

  /**
   * Setter rue
   * @param {string } value
   */
  public set rue(value: string) {
    this._rue = value;
  }

  /**
   * Setter codePostal
   * @param {string } value
   */
  public set codePostal(value: string) {
    this._codePostal = value;
  }

  /**
   * Setter ville
   * @param {string } value
   */
  public set ville(value: string) {
    this._ville = value;
  }
}
