import { Component, computed, EventEmitter, Input, Output } from '@angular/core';
import { DUMMY_USERS } from '../../dummy-users';

const randomUserIndex = Math.floor(Math.random() * DUMMY_USERS.length);
interface UserInterface {
  id: string;
  avatar: string;
  name: string
}

@Component({
  selector: 'app-user',
  imports: [],
  templateUrl: './user.html',
  styleUrl: './user.scss',
})
export class User {
  @Input({required: true}) user!: UserInterface;
  @Output() select = new EventEmitter<string>();

  get imagePath() {
    return this.user.avatar;
  }

  onSelectUser() {
    this.select.emit(this.user.id);
  }
}