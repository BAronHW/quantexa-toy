import { Component, signal } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { User } from './user/user';
import { Header } from './header/header';
import { DUMMY_USERS } from '../dummy-users';

@Component({
  selector: 'app-root',
  imports: [User, Header],
  templateUrl: './app.html',
  styleUrl: './app.scss'
})
export class App {
  users = DUMMY_USERS;
}
