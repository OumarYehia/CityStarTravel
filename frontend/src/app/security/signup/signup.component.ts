import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {AuthService} from '../../auth/auth.service';
import {NewUser} from '../../auth/user';
import {Router} from '@angular/router';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.scss']
})
export class SignupComponent implements OnInit {
  form: FormGroup;
  user: NewUser;

  constructor(
    private router: Router,
    private fb: FormBuilder,
    private authService: AuthService
  ) {}

  ngOnInit() {
    this.form = this.fb.group({
      userName: ['', Validators.required],
      password: ['', Validators.required],
      confirmPassword: ['', Validators.required],
      fullName: ['', Validators.required],
      email: ['', Validators.required],
      mobileNumber: ['', Validators.required]
    });
  }

  isFieldInvalid(field: string) {
    return (
      !this.form.get(field).valid && this.form.get(field).touched
    );
  }

  onSubmit() {
    this.authService.signup(this.form.value).subscribe(
      data =>  {
        console.log('successful signup');
        this.router.navigate(['/login']);
      },
      error => {
        console.log('failed in signup');
        console.log(error);
      }
    );
  }
}
