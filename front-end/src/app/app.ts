import { Component, signal } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { User } from './user/user';
import { Header } from './header/header';
import { DUMMY_USERS } from '../dummy-users';
import { Task } from './task/task';

@Component({
  selector: 'app-root',
  imports: [User, Header, Task],
  templateUrl: './app.html',
  styleUrl: './app.scss'
})
export class App {
  users = DUMMY_USERS;
  selectedUser = signal<string>('');

  onSelectUser(id: string) {
    const userName = this.getUserNameById(id);
    this.selectedUser.set(userName);
  }

  getUserNameById(id: string): string {
    return DUMMY_USERS.find(user => user.id === id)!.name;
  }
}
