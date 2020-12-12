import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class GroceryService {

  private baseUrl = 'http://localhost:8093'
  private url = this.baseUrl + 'api/groceries';

  constructor(
    private http: HttpClient
  ) { }

  index() {
    return
  }
}
