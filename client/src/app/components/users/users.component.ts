import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute, Params } from '@angular/router';
import { Users } from '../../models/users';

@Component({
    selector: 'users',
    templateUrl: './users.component.html'
})

export class UserComponent implements OnInit {

    public title: string;
    public users: Users;
    public status: String;

    constructor(
        private _route: ActivatedRoute,
        private _router: Router,
    ) {
        this.title = '';
        this.users = new Users("", "", "", "", "");
    }

    ngOnInit() {
        console.log('Componente de login cargando...');
    }

    onSubmit() {

    }

}