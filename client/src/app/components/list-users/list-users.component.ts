import { Component, OnInit } from '@angular/core';
import { UserService } from '../../shared_service/user.service';
import { Users } from '../../users';
import { Router } from '@angular/router';

@Component({
  selector: 'app-list-users',
  templateUrl: './list-users.component.html',
  styleUrls: ['./list-users.component.css']
})
export class ListUsersComponent implements OnInit {
  public users: Users[];
  constructor(private _userService: UserService, private _router: Router) { }

  ngOnInit() {
      this._userService.getUsers().subscribe((users) => {
      console.log(users);
      this.users = users;
    }, (error) => {
      console.log(error);
    })
  }

  deleteUsers(users) {
    this._userService.deleteUsers(users.idUsers).subscribe((data) => {
      this.users.splice(this.users.indexOf(users), 1);
    }, (error) => {
      console.log(error);
    });
  }

  updateUsers(users) {
    this._userService.setter(users);
    this._router.navigate(['/op']);
  }

  newUsers() {
    let user = new Users("","","","");
    this._userService.setter(user);
    this._router.navigate(['/op']);
  }
}
