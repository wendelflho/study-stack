import {Component} from '@angular/core';

@Component({
  selector: 'app-directives',
  templateUrl: './directives.component.html',
  styleUrls: ['./directives.component.css']
})
export class DirectivesComponent {
  isCollapsed: boolean = false;
  log : any = [];
  counter = 1;

  constructor() {}

  toggleCollapse() {
    this.isCollapsed = !this.isCollapsed;
    this.log.push(this.counter++);
  }

  getBackgroundColor() {
    return this.counter > 4 ? 'blue' : 'transparent';
  }

  getTextColor() {
    return this.counter > 4 ? 'white' : 'black';
  }
}
