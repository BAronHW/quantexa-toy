import { Component, Input, signal } from '@angular/core';
@Component({
  selector: 'app-task',
  imports: [],
  templateUrl: './task.html',
  styleUrl: './task.scss',
})
export class Task {
  @Input({required: true}) selectedUserName!: string;
  isVisible = signal<boolean>(true);

  toggle() {
    this.isVisible.update((oldVal: boolean) => !oldVal);
  }
}
