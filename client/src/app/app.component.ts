import { Component, OnInit, DoCheck } from '@angular/core';
import { Router, ActivatedRoute, Params} from '@angular/router';
import { GLOBAL } from './services/global';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit, DoCheck{

  public title: String;
  public url: String;

  constructor(
    private _route: ActivatedRoute,
    private _router: Router
  ){
    this.title = 'Vehicle';
    this.url = GLOBAL.url;    
  }

  ngOnInit(){

  }

  ngDoCheck(){

  }

  logout(){
    this._router.navigate(['/']);
  }
}
