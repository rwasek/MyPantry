import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { Grocery } from '../models/grocery';
import { AuthService } from './auth.service';

@Injectable({
  providedIn: 'root'
})
export class GroceryService {

  private baseUrl = 'http://localhost:8093/'
  private url = this.baseUrl + 'api/groceries';

  constructor(
    private http: HttpClient,
    private auth: AuthService,

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
}
