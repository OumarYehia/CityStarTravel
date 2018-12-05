import { ReactiveFormsModule, ValidationErrors} from '@angular/forms';
import { AbstractControl } from '@angular/forms';

export class registerValidator {
  static validOldPassword ( control: AbstractControl) {
    return new Promise ((resolve) => {
      if (control.value !== '1234') {
        resolve ({ notValidOldPassword : true});
      } else {
        resolve(null);
      }
    });
  }

  static PasswordMatch ( control: AbstractControl) {
    console.log('validating');
    const password = control.get('password');
    const confirmPassword = control.get('confirmPassword');

    if (password.value !== confirmPassword.value) {
      return { passwordMatch : true};
    } else {
      return null;
    }
  }
}
