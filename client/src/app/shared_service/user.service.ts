import { Injectable } from '@angular/core';
import { Http, Response, Headers, RequestOptions } from '@angular/http';
import { Observable, throwError } from 'rxjs';
import { map, catchError } from 'rxjs/operators';
import { Users } from '../users';

@Injectable()
export class UserService {
  private baseUrl: string = 'http://localhost:8080/';
  private headers = new Headers({ 'Content-Type': 'application/json' });
  private options = new RequestOptions({ headers: this.headers });
  private users: Users;

  constructor(public _http: Http) { }

  getUsers() {
    return this._http.get(this.baseUrl + '/users/list-users', this.options).pipe(map((response: Response) => response.json().catchError(this.errorHandler)));
  }

  getUser(idUsers: Number) {
    return this._http.get(this.baseUrl + '/users/list-id-users' + idUsers, this.options).pipe(map((response: Response) => response.json().catchError(this.errorHandler)));
  }

  deleteUsers(idUsers: Number) {
    return this._http.delete(this.baseUrl + '/users/' + idUsers, this.options).pipe(map((response: Response) => response.json().catchError(this.errorHandler)));
  }

  createUsers(users: Users) {
    return this._http.post(this.baseUrl + '/users/create-users', JSON.stringify(users), this.options).pipe(map((response: Response) => response.json().catchError(this.errorHandler)));
  }

  updateUsers(users: Users) {
    return this._http.put(this.baseUrl + '/users/update-users', JSON.stringify(users), this.options).pipe(map((response: Response) => response.json().catchError(this.errorHandler)));
  }

  errorHandler(error: Response) {
    return Observable.throw(error || "SERVER ERROR");
  }

  setter(users: Users) {
    this.users = users;
  }

  getter() {
    return this.users;
  }

}
