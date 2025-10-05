import {Component, inject, OnInit, signal} from '@angular/core';
import {Todos} from '../services/todos';
import {Todo} from '../models/todo.type';
import {catchError} from 'rxjs';
import {FormsModule, NgForm} from '@angular/forms';

@Component({
  selector: 'app-todos',
  imports: [
    FormsModule
  ],
  templateUrl: './todos.html',
  styleUrl: './todos.scss'
})
export class TodosComponent implements OnInit{
  todoService = inject(Todos);
  todoItems = signal<Array<Todo>>([]);
  firstName: string = "";
  lastName: string = "";
  email: string = "";
  phone: string = "";
  role: string = "";

  ngOnInit(){
    this.todoService.getAllMembers().pipe(
      catchError((err) => {
        console.log(err);
        throw err;
      })
    ).subscribe( (members) => {
        this.todoItems.set(members);
      }
    )

  }
  public getFormData(form: NgForm){
    this.todoService.postMember(form);
    this.ngOnInit();
  }
}
