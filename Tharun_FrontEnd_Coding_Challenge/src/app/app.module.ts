import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { DashboardComponent } from './components/dashboard/dashboard.component';
import { PlayerService } from './services/player.service';
import { AddPlayerComponent } from './components/add-player/add-player.component';
import { UpdatePlayerComponent } from './components/update-player/update-player.component';
import { ViewPlayerComponent } from './components/view-player/view-player.component';
import { SearchComponent } from './components/search/search.component';


@NgModule({
  declarations: [
    AppComponent,
    DashboardComponent,
    AddPlayerComponent,
    UpdatePlayerComponent,
    ViewPlayerComponent,
    SearchComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [PlayerService],
  bootstrap: [AppComponent]
})
export class AppModule { }
