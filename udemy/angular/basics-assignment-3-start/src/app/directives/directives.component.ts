import {Component} from '@angular/core';

@Component({
  selector: 'app-directives',
  templateUrl: './directives.component.html',
  styleUrls: ['./directives.component.css']
})
export class DirectivesComponent {
  isCollapsed: boolean = false;
  log: any = [];

  constructor() {
  }

  toggleCollapse() {
    this.isCollapsed = !this.isCollapsed;
    this.log.push(new Date());
  }
}
