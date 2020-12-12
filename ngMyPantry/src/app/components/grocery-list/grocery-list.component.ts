import { Component, OnInit } from '@angular/core';
import { Grocery } from 'src/app/models/grocery';
import { GroceryService } from 'src/app/services/grocery.service';

@Component({
  selector: 'app-grocery-list',
  templateUrl: './grocery-list.component.html',
  styleUrls: ['./grocery-list.component.css']
})
export class GroceryListComponent implements OnInit {

  groceryList: Grocery[] = [];

  constructor(
    private grocerySvc: GroceryService
  ) { }

  ngOnInit(): void {
    this.loadGroceryList();
  }

  // functions:

  loadGroceryList(){
    this.grocerySvc.index().subscribe(
      groceries => {
        this.groceryList = groceries;
      },
      onfail => {
        console.log(this.groceryList);
        console.error('Observer got an error: ' + onfail);
      }
    )
  }

}
