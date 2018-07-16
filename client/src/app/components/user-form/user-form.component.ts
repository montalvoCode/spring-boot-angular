import { Component, OnInit } from '@angular/core';
import { Users } from '../../users';
import { Router }  from '@angular/router';
import { UserService } from '../../shared_service/user.service';

@Component({
  selector: 'app-user-form',
  templateUrl: './user-form.component.html',
  styleUrls: ['./user-form.component.css']
})
export class UserFormComponent implements OnInit {
  private users: Users;

  constructor(private _userService:UserService,private _router:Router) { }

  ngOnInit() {
    this.users = this._userService.getter();    
  }

  processForm(){
    if(this.users.idUsers == undefined || this.users.idUsers == ""){
       this._userService.createUsers(this.users).subscribe((users)=>{
         console.log(users);
         this._router.navigate(['/']);
       },(error)=>{
         console.log(error);
       });
    }else{
       this._userService.updateUsers(this.users).subscribe((users)=>{
         console.log(users);
         this._router.navigate(['/']);
       },(error)=>{
         console.log(error);
       });
    }
  }
  
}
