import { FormControl } from '@angular/forms';
export class Modulo10Validator {
  public static modulo10(control: FormControl) {
    if (control.value % 10 == 0) {
      return { modulo10: true };
    }
    return null;
  }
}
