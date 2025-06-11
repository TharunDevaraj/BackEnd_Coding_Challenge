import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddPlayerComponent } from './components/add-player/add-player.component';
import { UpdatePlayerComponent } from './components/update-player/update-player.component';
import { ViewPlayerComponent } from './components/view-player/view-player.component';
import { SearchComponent } from './components/search/search.component';

const routes: Routes = [
  {path:'addPlayer',component:AddPlayerComponent},
  {path:'updatePlayer',component:UpdatePlayerComponent },
  {path:'viewAll',component:ViewPlayerComponent},
  {path:'search/:input',component:SearchComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
