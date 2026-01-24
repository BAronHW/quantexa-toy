import { Component, computed, Input, input, signal } from '@angular/core';
import { DUMMY_USERS } from '../../dummy-users';

const randomUserIndex = Math.floor(Math.random() * DUMMY_USERS.length);

@Component({
  selector: 'app-user',
  imports: [],
  templateUrl: './user.html',
  styleUrl: './user.scss',
})
export class User {
  @Input({ required: true }) avatar!: string;
  @Input({required: true}) name!: string;

  get imagePath() {
    return this.avatar;
  }

  onSelectUser() {

  }
}
