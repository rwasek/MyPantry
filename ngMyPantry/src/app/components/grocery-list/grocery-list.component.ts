import { AfterViewInit, Component, OnInit, ViewChild } from '@angular/core';
import { Grocery } from 'src/app/models/grocery';
import { GroceryService } from 'src/app/services/grocery.service';
import {MatSort} from '@angular/material/sort';
import { MatTableDataSource } from '@angular/material/table';


@Component({
  selector: 'app-grocery-list',
  templateUrl: './grocery-list.component.html',
  styleUrls: ['./grocery-list.component.css']
})
export class GroceryListComponent implements OnInit {

  groceryList: Grocery[] = [];

  // for the table:
  displayedColumns: string[] = ['category', 'productName'];
  @ViewChild(MatSort) sort: MatSort;

  constructor(
    private grocerySvc: GroceryService
  ) { }

  ngOnInit(): void {
    this.loadGroceryList();

  }

  // ngAfterViewInit(){
  //   this.dataSource.sort = this.sort;
  // }

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
