import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { PlayerDTO } from 'src/app/dto/playerDTO';
import { PlayerService } from 'src/app/services/player.service';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent {

  searchData!:string;

  

  constructor(private playerService:PlayerService,private router:Router)
  {

  }

  find(formData:any)
  {
    this.router.navigate(['/search/'+formData.form.value.searchData]);

    console.log(formData.form.value.searchData);
  }

  

}
