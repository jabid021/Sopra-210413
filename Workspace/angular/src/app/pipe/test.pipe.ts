import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'test',
})
export class TestPipe implements PipeTransform {
  transform(value: unknown, ...args: unknown[]): unknown {
    if (value > 0) return 'positif';
    else if (value < 0) return 'negatif';
    else return 'neutre';
  }
}
