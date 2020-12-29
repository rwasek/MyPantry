import { AfterViewInit, Component, OnInit, ViewChild } from '@angular/core';
import { Grocery } from 'src/app/models/grocery';
import { GroceryService } from 'src/app/services/grocery.service';
import {MatSort, Sort} from '@angular/material/sort';
import { MatTableDataSource } from '@angular/material/table';



@Component({
  selector: 'app-grocery-list',
  templateUrl: './grocery-list.component.html',
  styleUrls: ['./grocery-list.component.css']
})
export class GroceryListComponent implements OnInit {

  newGrocery = new Grocery();

  editGrocery = null;
  selected = null;

  // for the table:
  displayedColumns: string[] = ['productName', 'category', 'datePurchased', 'expirationDate', 'delete'];
  groceryList: Grocery[] = [];

  constructor(
    private grocerySvc: GroceryService
  ) {}

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

  displayGrocery(grocery: Grocery){
    this.selected = grocery;
    this.editGrocery = Object.assign({}, this.selected);
  }

  updateGrocery(editGrocery: Grocery){
    this.grocerySvc.update(editGrocery).subscribe(
      data => {
        this.loadGroceryList();
        this.selected = null;
        window.alert('Grocery Updated Successfully');
      },
      err => {
        console.error('error with updateGrocery() in grocery-list component');
      }
    )
  }

  delete(grocId: number){
    this.grocerySvc.delete(grocId).subscribe(
      data => {
        console.log('delete success!');
        this.loadGroceryList();
      },
      err => {
        console.error('problem with delete in the component level')
      }
    )
  }

}
