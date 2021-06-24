import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class FakeDemoService {
  constructor() {}

  public hello(): string {
    return 'hello du FakeService';
  }
}
