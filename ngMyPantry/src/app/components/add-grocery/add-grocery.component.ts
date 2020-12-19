import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Category } from 'src/app/models/category';
import { Grocery } from 'src/app/models/grocery';
import { GroceryService } from 'src/app/services/grocery.service';

@Component({
  selector: 'app-add-grocery',
  templateUrl: './add-grocery.component.html',
  styleUrls: ['./add-grocery.component.css']
})
export class AddGroceryComponent implements OnInit {

  newGrocery = new Grocery();
  newGroceryCategory = new Category();

  constructor(
    private grocerySvc: GroceryService,
    private router: Router
  ) { }

  ngOnInit(): void {
  }

  // create new grocery
  createNewGrocery(catId: number){

    this.grocerySvc.create(this.newGrocery, catId).subscribe(
      grocery => {
        console.log('creation success!');
        // call index method on service
        window.alert('Grocery Created Successfully!');
        this.router.navigateByUrl('groceryList');

      },
      err => {
        console.error('problem with createNewGrocery() in add-grocery component');
      }
    );
  }

}
