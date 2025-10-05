import { Routes } from '@angular/router';
import {Component} from '@angular/core';

export const routes: Routes = [
  {
    path: '',
    pathMatch: "full",
    loadComponent: () => {
      return import('./home/home').then((m) => m.HomeComponent);
    }
  },
  {
    path: 'todos',
    loadComponent: () => {
      return import('./todos/todos').then((m) => m.TodosComponent);
    }
  }
];
