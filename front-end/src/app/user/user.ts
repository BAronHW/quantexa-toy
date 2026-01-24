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
  selectedUser = DUMMY_USERS[randomUserIndex]

  get imagePath() {
    return '/' + this.selectedUser.avatar
  }
}
