
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { StartCheckinComponent } from './components/start-checkin/start-checkin.component';
import { CheckinComponent } from './components/checkin/checkin.component';
import { ConfirmCheckinComponent } from './components/confirm-checkin/confirm-checkin.component';
import { HttpModule } from '@angular/http';
import { FormsModule } from '@angular/forms';
import { DataService } from './services/data.service';

@NgModule({
  declarations: [
    AppComponent,
    StartCheckinComponent,
    CheckinComponent,
    ConfirmCheckinComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpModule,
    FormsModule
  ],
  providers: [DataService],
  bootstrap: [AppComponent]
})
export class AppModule { }
