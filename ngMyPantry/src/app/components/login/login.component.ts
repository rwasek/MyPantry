import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { ModalDismissReasons, NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { AuthService } from 'src/app/services/auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  // modal field:
  closeResult = '';
  constructor(
    private auth: AuthService,
    private router: Router,
    private modalService: NgbModal
  ) { }

  ngOnInit(): void {
    window.scroll(0, 0);
  }

  // modal function:
  open(content) {
    this.modalService.open(content, {ariaLabelledBy: 'modal-basic-title', size: 'sm'}).result.then((result) => {
      this.closeResult = `Closed with: ${result}`;
    }, (reason) => {
      this.closeResult = `Dismissed ${this.getDismissReason(reason)}`;
    });
  }
  // modal function:
  private getDismissReason(reason: any): string {
    if (reason === ModalDismissReasons.ESC) {
      return 'by pressing ESC';
    } else if (reason === ModalDismissReasons.BACKDROP_CLICK) {
      return 'by clicking on a backdrop';
    } else {
      return `with: ${reason}`;
    }
  }

  login(form: NgForm){
    const user = form.value.username;
    const pw = form.value.password;
    this.auth.login(user, pw).subscribe(
      data => {
        console.log('LoginComponent.login(): user logged in.');
        this.router.navigateByUrl('/groceryList');
        },
          error => {
            console.error('login() component: error logging in.');
            window.alert('Account has been deactivated, please email admin@mypantry.com to reactivate it if desired!');
          }
        );
      }

}
