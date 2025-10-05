import {inject, Injectable} from '@angular/core';
import {Todo} from '../models/todo.type';
import {HttpClient} from '@angular/common/http';
import {NgForm} from '@angular/forms';

@Injectable({
  providedIn: 'root'
})
export class Todos {
  http = inject(HttpClient);
  members: Array<Todo> = [];
  constructor() {}

  public getAllMembers(){
    const url = `http://localhost:8080/member-api/getAllMembers`;
    return this.http.get<Array<Todo>>(url);
  }

  public postMember(form: NgForm){
    const url = `/member-api/addMember`;
    return this.http.post(url,form.value).subscribe({
      next: (res) => console.log("success"),
      error: (res) => console.log("error")
      }
    )
  }

}
