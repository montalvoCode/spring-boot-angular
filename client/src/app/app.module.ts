import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HttpModule } from '@angular/http';
import { FormsModule }   from '@angular/forms';

import { AppComponent } from './app.component';
import { ListUsersComponent } from './components/list-users/list-users.component';
import { UserFormComponent } from './components/user-form/user-form.component';
import { UserService } from './shared_service/user.service';

const appRoutes: Routes = [
  { path: '', component: ListUsersComponent },
  { path: 'op', component: UserFormComponent }
];

@NgModule({
  declarations: [
    AppComponent,
    ListUsersComponent,
    UserFormComponent
  ],
  imports: [
    BrowserModule,
    HttpModule,
    FormsModule,    
    RouterModule.forRoot(appRoutes)
  ],
  providers: [
    UserService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
