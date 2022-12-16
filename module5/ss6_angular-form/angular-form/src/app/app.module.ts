import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { TodoComponent } from './app-todo/todo/todo.component';
import { StudentCreateComponent } from './student-create/student-create/student-create.component';
import { StudentListComponent } from './student-list/student-list/student-list.component';
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import { LoginComponent } from './loginComponent/login/login.component';
import { RegistorComponent } from './registorComponent/registor/registor.component';


@NgModule({
  declarations: [
    AppComponent,
    TodoComponent,
    StudentCreateComponent,
    StudentListComponent,
    LoginComponent,
    RegistorComponent,
  ],
  imports: [
    BrowserModule,
    FormsModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
