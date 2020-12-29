import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { environment } from 'src/environments/environment';
import { Category } from '../models/category';
import { Grocery } from '../models/grocery';
import { AuthService } from './auth.service';


@Injectable({
  providedIn: 'root'
})
export class GroceryService {

  // private baseUrl = 'http://localhost:8093/'
  private url = environment.baseUrl + 'api/groceries';

  constructor(
    private http: HttpClient,
    private auth: AuthService,
    private router: Router

  ) { }

  index() {
    const credentials = this.auth.getCredentials();
    const httpOptions = {
      headers: new HttpHeaders({
        Authorization: `Basic ${credentials}`,
        'X-Requested-With': 'XMLHttpRequest'
      })
    };
    return this.http.get<Grocery[]>(this.url, httpOptions).pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError('error in grocery service index method');
      })
    );
  }

  create(newGrocery: Grocery, catId: number){
    const credentials = this.auth.getCredentials();
    const httpOptions = {
      headers: new HttpHeaders({
        Authorization: `Basic ${credentials}`,
        'X-Requested-With': 'XMLHttpRequest'
      })
    };

    if (this.auth.checkLogin){
      const cat = new Category(catId);
      newGrocery.category = cat;
      return this.http.post<Grocery>(this.url, newGrocery, httpOptions).pipe(
        catchError((err: any) => {
          console.log(err);
          return throwError('error in grocery service create method');
        })
      );
    }
    else {
      this.router.navigateByUrl('/home');
    }
  }

  update(grocery: Grocery) {
    const credentials = this.auth.getCredentials();
    const httpOptions = {
      headers: new HttpHeaders({
        Authorization: `Basic ${credentials}`,
        'X-Requested-With': 'XMLHttpRequest'
      })
    };
   return this.http.put<Grocery>(this.url + '/' + grocery.id, grocery, httpOptions).pipe(
    catchError((err: any) => {
        console.log(err);
        return throwError('error in grocery service update method');
    })
   );
  }

  delete(id: number){
    const credentials = this.auth.getCredentials();
    const httpOptions = {
      headers: new HttpHeaders({
        Authorization: `Basic ${credentials}`,
        'X-Requested-With': 'XMLHttpRequest'
      })
    };
  return this.http.delete<Grocery>(`${this.url}/${id}`, httpOptions).pipe(
      catchError((err: any) => {
      console.log(err);
      return throwError('error in grocery service delete method');
    })
  );
};
}
