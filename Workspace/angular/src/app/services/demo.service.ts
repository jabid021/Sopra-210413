import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class DemoService {
  private _n: number = 0;

  constructor() {
    console.log('creation du service');
  }

  public hello(): string {
    return 'hello du service';
  }

  /**
   * Getter $n
   * @return {number}
   */
  public get n(): number {
    return this._n;
  }
}
