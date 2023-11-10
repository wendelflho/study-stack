import { Component } from '@angular/core';

@Component({
  selector: 'app-data-biding',
  templateUrl: './data-biding.component.html',
  styleUrl: './data-biding.component.css'
})
export class DataBidingComponent {
  username : String = '';

  onResetUsername() {
    this.username = '';
  }
}
