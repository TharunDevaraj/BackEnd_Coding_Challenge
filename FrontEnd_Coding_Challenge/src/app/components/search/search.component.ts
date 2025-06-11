import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { PlayerDTO } from 'src/app/dto/playerDTO';
import { PlayerService } from 'src/app/services/player.service';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent implements OnInit{

  playerList:PlayerDTO[]=[];

  searchInput:string='';

  constructor(private playerService:PlayerService,private activateRoute:ActivatedRoute){
    
  }
  ngOnInit(): void {
    this.activateRoute.params.subscribe((params) => {
    this.searchInput = params['input'];

    this.playerService.getByTeam(this.searchInput).subscribe(
      (list) => {
        console.log("Received list from backend:", list);
        this.playerList = list;
      },
      (err) => {
        console.error("Error fetching players:", err);
      }
    );
  });
  }

  

}
