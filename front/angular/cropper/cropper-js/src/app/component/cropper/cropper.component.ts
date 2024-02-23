import {
  AfterViewInit,
  Component,
  ElementRef,
  EventEmitter,
  Inject,
  Injector,
  OnDestroy,
  OnInit,
  Output,
  PLATFORM_ID,
  ViewChild,
  ViewEncapsulation
} from '@angular/core';
import { BehaviorSubject } from 'rxjs';
import Cropper from 'cropperjs';
import { MAT_DIALOG_DATA, MatDialogRef } from '@angular/material/dialog';

export interface ImageCropperSetting {
  width: number;
  height: number;
}

export interface ImageCropperResult {
  imageData: Cropper.ImageData;
  cropData: Cropper.CropBoxData;
  blob?: Blob;
  dataUrl?: string;
}

export interface DialogData {
  imageUrl: string;
  aspectRatio: number;
  viewMode: number;
  settings: ImageCropperSetting;
  canvasOptions: Cropper.SetCanvasDataOptions;
}

export interface CroppedEvent {
  base64?: string;
  file?: File;
}

@Component({
  selector: 'app-cropper',
  templateUrl: './cropper.component.html',
  styleUrls: ["./cropper.component.scss"],
  encapsulation: ViewEncapsulation.None,
})
export class CropperComponent implements OnInit, OnDestroy {

  private id$: BehaviorSubject<string> = new BehaviorSubject<string>('');

  @ViewChild('image')
  image!: ElementRef<HTMLImageElement>;

  public imageUrl!: string;
  public settings: ImageCropperSetting = { width: 0, height: 0 };
  public canvasOptions: Cropper.SetCanvasDataOptions = {};
  public viewMode: number = 0;
  public aspectRatio: number = NaN;
  // @Input() imageChangedEvent: any;

  public cropperOptions: any = {};
  public isLoading: boolean = true;
  public cropper!: Cropper;
  public error: any;

  @Output() export = new EventEmitter<ImageCropperResult>();
  @Output() ready = new EventEmitter();

  constructor(
    private elementRef: ElementRef,
    public dialogRef: MatDialogRef<CropperComponent>,
    @Inject(PLATFORM_ID) private platformId: string,
    @Inject(MAT_DIALOG_DATA) public data: DialogData,    
  ) {
  }

  ngOnInit(): void {
    this.imageUrl = this.data.imageUrl;
    this.aspectRatio = this.data.aspectRatio;
    this.viewMode = this.data.viewMode;
    this.settings = this.data.settings;
    this.canvasOptions = this.data.canvasOptions;
  }

  public ngOnDestroy(): void {
    if (this.cropper) {
      this.cropper.destroy();
    }
  }

  // private perform(): void {
  //   this.platformService.ifBrowserThen(() => {
  //     import('cropperjs').then();
  //   });
  // }

  // private perform(): void {
  //   this.platformService.ifBrowserThen(() => {
  //     import('cropperjs').then(
  //       (module: any) => Optional.ofNullable(module)
  //                                 .map(mod => mod?.default)
  //                                 .ifPresent(cropper => this.initCropper(cropper))
  //     );
  //   });
  // }

  public initCropper(ev: any): void {
    console.log(ev);

    this.error = false;

    const image = ev.target as HTMLImageElement;

    if (this.cropperOptions.checkCrossOrigin) {
      image.crossOrigin = 'anonymous';
    }

    image.addEventListener('ready', () => {
      this.ready.emit(true);
      this.isLoading = false;
      if (this.canvasOptions) {
        this.cropper.setCropBoxData(this.canvasOptions);
      }
    });

    let aspectRatio = this.aspectRatio || NaN;
    if (this.settings) {
      const { width, height } = this.settings;
      aspectRatio = width / height;
    };

    let viewMode = this.viewMode || 0;
    let autoCropArea = 1;
    this.cropperOptions = {
      aspectRatio: aspectRatio,
      viewMode: viewMode,
      autoCropArea: autoCropArea,
      checkCrossOrigin: true,
    };

    if (this.cropper) {
      this.cropper.destroy();
    }

    this.cropper = new Cropper(image, this.cropperOptions);

    console.log(this.cropper);
  }

  public exportCanvas(base64?: any) {
    //
    // Get and set image, crop and canvas data
    const imageData = this.cropper.getImageData();
    const cropData = this.cropper.getCropBoxData();
    const canvas = this.cropper.getCroppedCanvas();
    const data = { imageData, cropData };

    //
    // Create promise to resolve canvas data
    const promise = new Promise((resolve) => {
        //
        // Validate base64
        if (base64) {
            //
            // Resolve promise with dataUrl
            return resolve({
                dataUrl: canvas.toDataURL("image/png"),
            });
        }
        canvas.toBlob((blob) => resolve({ blob }));
    });

    console.log(data);

    //
    // Emit export data when promise is ready
    promise.then((res: any) => {
        this.export.emit({ ...data, ...res });
    });

    this.dialogRef.close(this.cropper);
  }

  imageLoadError(event: any) {
    this.error = true;
    this.isLoading = false;
    console.log(event);
  }

  public zoomIn(): void {
    this.cropper.zoom(0.1);
  }

  public zoomOut(): void {
    this.cropper.zoom(-0.1);
  }

  public rotateLeft(): void {
    this.cropper.rotate(-45);
  }

  public rotateRight(): void {
    this.cropper.rotate(45);
  }

  public flipHorizontal(): void {
    this.cropper.scaleX(-this.cropper.getData().scaleX || -1);
  }

  public flipVertical(): void {
    this.cropper.scaleY(-this.cropper.getData().scaleY || -1);
  }

  public goLeft(): void {
    this.cropper.move(10, 0);
  }

  public goRight(): void {
    this.cropper.move(-10, 0);
  }

  public reset(): void {
    this.cropper.reset();
  }

  public cancel(): void {
    this.dialogRef.close();
  }

}
