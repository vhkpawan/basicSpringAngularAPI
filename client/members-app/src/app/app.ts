import { Component, signal } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import {HomeComponent} from './home/home';
import {HeaderComponent} from './components/header/header';

@Component({
  selector: 'app-root',
  imports: [HeaderComponent, RouterOutlet],
  template: `
    <app-header></app-header>
    <main>
      <router-outlet></router-outlet>
    </main>
    `,
  styles: [`
    main{
      padding: 16px;
      font-size: 30px;
    }
  `],
})
export class App {
  protected readonly title = signal('members-app');
}
