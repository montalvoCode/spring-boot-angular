import { Injectable } from '@angular/core';
import { Http, Response, Headers, RequestOptions } from '@angular/http';
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';
import 'rxjs/add/observable/throw';
import { Users } from '../users';

@Injectable()
export class UserService {
  private baseUrl: string = 'http://localhost:8080/';
  private headers = new Headers({ 'Content-Type': 'application/json' });
  private options = new RequestOptions({ headers: this.headers });
  private users : Users;

  constructor(public _http: Http) { }

  getUsers() {
    return this._http.get(this.baseUrl + '/users/list-users', this.options).map((response: Response) => response.json()).catch(this.errorHandler);
  }

  getUser(idUsers: Number) {
    return this._http.get(this.baseUrl + '/users/list-id-users' + idUsers, this.options).map((response: Response) => response.json())
      .catch(this.errorHandler);
  }

  deleteUsers(idUsers: Number) {
    return this._http.delete(this.baseUrl + '/users/' + idUsers, this.options).map((response: Response) => response.json())
      .catch(this.errorHandler);
  }

  createUsers(users: Users) {
    return this._http.post(this.baseUrl + '/users/create-users', JSON.stringify(users), this.options).map((response: Response) => response.json())
      .catch(this.errorHandler);
  }

  updateUsers(users: Users) {
    return this._http.put(this.baseUrl + '/users/update-users', JSON.stringify(users), this.options).map((response: Response) => response.json())
      .catch(this.errorHandler);
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
