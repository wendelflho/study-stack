import { Component } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { CropperComponent } from './component/cropper/cropper.component';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrl: './app.component.scss'
})
export class AppComponent {
  title = 'cropper-js';
  public cropper!: Cropper;

  constructor(public dialog: MatDialog) {}

  openDialog() {
    const dialogRef = this.dialog.open(CropperComponent, {
      // width: '600px',
      data: {
        imageUrl: 'assets/minions.jpg',
        aspectRatio: 16 / 9,
        viewMode: 1,
        settings: { width: 300, height: 200 },
        canvasOptions: {}
      }
    });

    dialogRef.afterClosed().subscribe(result => {
      this.cropper = result;
      console.log(result);
    });
  }
}
