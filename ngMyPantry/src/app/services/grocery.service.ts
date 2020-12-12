import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { Grocery } from '../models/grocery';

@Injectable({
  providedIn: 'root'
})
export class GroceryService {

  private baseUrl = 'http://localhost:8093/'
  private url = this.baseUrl + 'api/groceries';

  constructor(
    private http: HttpClient
  ) { }

  index() {
    return this.http.get<Grocery[]>(this.url).pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError('error in grocery service index method');
      })
    );
  }
}
