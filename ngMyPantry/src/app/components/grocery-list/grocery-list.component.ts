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
export class GroceryListComponent implements OnInit, AfterViewInit {

  newGrocery = new Grocery();
  editGrocery = null;
  selected = null;

  // for the table:
  displayedColumns: string[] = ['productName', 'category', 'amount', 'datePurchased', 'expirationDate', 'dateOpened', 'amountUsed', 'delete'];
  groceryList: Grocery[] = [];

  @ViewChild(MatSort) sort: MatSort;

  constructor(
    private grocerySvc: GroceryService
  ) { }

  ngOnInit(): void {
    this.loadGroceryList();

  }

  ngAfterViewInit(){


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
