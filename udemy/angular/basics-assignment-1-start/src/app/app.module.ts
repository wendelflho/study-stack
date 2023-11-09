import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';


import { AppComponent } from './app.component';
import { SuccessAlertsComponent } from './success-alerts/success-alerts.component';
import { WarningAlertsComponent } from './warning-alerts/warning-alerts.component';

@NgModule({
  declarations: [
    AppComponent,
    SuccessAlertsComponent,
    WarningAlertsComponent,
  ],
  imports: [
    BrowserModule,
    FormsModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
