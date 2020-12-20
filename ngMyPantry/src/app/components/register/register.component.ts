import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { User } from 'src/app/models/user';
import { AuthService } from 'src/app/services/auth.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  newUser = new User();

  constructor(
    private auth: AuthService,
    private router: Router
    ) { }

  ngOnInit(): void {

  }

  register(newUser: User){

    this.auth.register(newUser).subscribe(
      data => {
        console.log('RegisterComponent.register(): user registered.');
        console.log(newUser);
        this.auth.login(newUser.username, newUser.password).subscribe(
          next => {
            console.log('RegisterComponent.register(): user logged in, routing to /groceryList.');
            this.router.navigateByUrl('/groceryList');
          },
          error => {
            console.error('RegisterComponent.register(): error logging in.');
          }
        );
      },
      err => {
        console.error('RegisterComponent.register(): error registering.');
        console.error(err);
      }
    );
  }
}
