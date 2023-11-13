import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { ServerComponent } from './server/server.component';
import { ServersComponent } from './servers/servers.component';
import { FormsModule } from '@angular/forms';
import { CollapseComponent } from './collapse/collapse.component';
import { ButtonDirective, CardBodyComponent, CardComponent, CollapseModule } from '@coreui/angular';

@NgModule({
  declarations: [
    AppComponent,
    ServerComponent,
    ServersComponent,
    CollapseComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    CollapseModule,
    ButtonDirective,
    CardBodyComponent,
    CardComponent
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}
