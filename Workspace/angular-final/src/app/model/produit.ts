export class Produit {
  constructor(
    private _id: number | any = null,
    private _nom: string = '',
    private _prix: number = 0
  ) {}

  /**
   * Getter id
   * @return {number }
   */
  public get id(): number | any {
    return this._id;
  }

  /**
   * Setter id
   * @param {number } value
   */
  public set id(value: number | any) {
    this._id = value;
  }

  /**
   * Getter nom
   * @return {string }
   */
  public get nom(): string {
    return this._nom;
  }

  /**
   * Getter prix
   * @return {number }
   */
  public get prix(): number {
    return this._prix;
  }

  /**
   * Setter nom
   * @param {string } value
   */
  public set nom(value: string) {
    this._nom = value;
  }

  /**
   * Setter prix
   * @param {number } value
   */
  public set prix(value: number) {
    this._prix = value;
  }
}
