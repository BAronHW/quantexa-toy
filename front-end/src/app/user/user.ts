import { Component } from '@angular/core';
import { DUMMY_USERS } from '../../dummy-users';

const randomUserIndex = Math.floor(Math.random() * DUMMY_USERS.length);

@Component({
  selector: 'app-user',
  imports: [],
  templateUrl: './user.html',
  styleUrl: './user.scss',
})
export class User {
  userName = DUMMY_USERS[randomUserIndex]
}
