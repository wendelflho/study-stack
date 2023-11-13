import { Component } from '@angular/core';

@Component({
  selector: 'app-collapse',
  templateUrl: './collapse.component.html',
  styleUrls: ['./collapse.component.css']
})
export class CollapseComponent {
  visible = false;

  constructor() {}

  toggleCollapse() {
    this.visible = !this.visible;
  }
}
