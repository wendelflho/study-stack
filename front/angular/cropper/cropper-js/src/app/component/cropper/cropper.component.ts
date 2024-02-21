import { isPlatformBrowser } from '@angular/common';
import {
  AfterViewInit,
  Component,
  ElementRef,
  EventEmitter,
  Inject,
  Input,
  OnDestroy,
  Output,
  PLATFORM_ID,
  ViewChild,
  ViewEncapsulation
} from '@angular/core';
import Cropper from 'cropperjs';
import { BehaviorSubject } from 'rxjs';

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

@Component({
  selector: 'app-cropper',
  templateUrl: './cropper.component.html',
  styleUrls: ["./cropper.component.scss"],
  encapsulation: ViewEncapsulation.None,
})
export class CropperComponent implements OnDestroy {

  // private id$: BehaviorSubject<string> = new BehaviorSubject<string>(null);

  @ViewChild('image') image!: ElementRef;

  @Input() imageUrl: string = '';
  @Input() settings: ImageCropperSetting = { width: 100, height: 100 };
  @Input() canvasOptions: Cropper.SetCanvasDataOptions = {};
  @Input() viewMode: number = 0;
  @Input() aspectRatio: number = NaN;
  @Input() imageChangedEvent: any = null;

  public cropperOptions: any = {};
  public isLoading: boolean = true;
  public cropper!: Cropper;
  public error: any;

  @Output() export = new EventEmitter<ImageCropperResult>();
  @Output() ready = new EventEmitter();

  constructor(
    private elementRef: ElementRef,
    @Inject(PLATFORM_ID) private platformId: string
  ) { }

  // public ngAfterViewInit(): void {
  //   this.id$.next(`#${this.elementRef.nativeElement.id}`);
  //   this.perform();
  // }

  ngOnDestroy(): void {
    if (this.cropper) {
      this.cropper.destroy();
    }
  }

  // private perform(): void {
  //   if (isPlatformBrowser(this.platformId)) {
  //     import('cropperjs').then(
  //       (module: any) => Optional.ofNullable(module)
  //                         .map(mod => mod?.default)
  //                         .ifPresent(cropper => this.initCropper(cropper))
  //     );
  //   }
  // }

  public initCropper(ev: Event): void {

    this.error = false;

    // const image = this.image.nativeElement as HTMLImageElement;

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

    let aspectRatio = image.width / image.height;
    // if (this.settings) {
    //   const { width, height } = this.settings;
    //   aspectRatio = width / height;
    // };

    let viewMode = this.viewMode || 0;
    let autoCropArea = 1;
    this.cropperOptions = {
      ...{
        aspectRatio,
        viewMode,
        autoCropArea,
        checkCrossOrigin: true,
      },
      ...this.cropperOptions,
    };

    if (this.cropper) {
      this.cropper.destroy();
    }

    this.cropper = new Cropper(image, this.cropperOptions);
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

    //
    // Emit export data when promise is ready
    promise.then((res: any) => {
        this.export.emit({ ...data, ...res });
    });
  }

  imageLoadError(event: any) {
    this.error = true;
    this.isLoading = false;
  }

  public zoomIn() {
    this.cropper.zoom(0.1);
  }

  public zoomOut() {
    this.cropper.zoom(-0.1);
  }

  public rotateLeft() {
    this.cropper.rotate(-45);
  }

  public rotateRight() {
    this.cropper.rotate(45);
  }

  public flipHorizontal() {
    this.cropper.scaleX(-this.cropper.getData().scaleX || -1);
  }

  public flipVertical() {
    this.cropper.scaleY(-this.cropper.getData().scaleY || -1);
  }

  public goRight() {
    this.cropper.move(10, 0);
  }

  public goLeft() {
    this.cropper.move(-10, 0);
  }

  public reset() {
    this.cropper.reset();
  }

}