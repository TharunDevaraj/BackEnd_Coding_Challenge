import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { PlayerDTO } from 'src/app/dto/playerDTO';
import { PlayerService } from 'src/app/services/player.service';

@Component({
  selector: 'app-update-player',
  templateUrl: './update-player.component.html',
  styleUrls: ['./update-player.component.css']
})
export class UpdatePlayerComponent implements OnInit{

    player!:PlayerDTO;

   constructor(private playerService:PlayerService,private activatedRoute:ActivatedRoute)
    {
  
    }

  ngOnInit(): void {
    this.activatedRoute.queryParams.subscribe(
      (params)=>{
        const playerId=params['playerId'];
        this.playerService.getById(playerId).subscribe(
          data=>{this.player=data;}
        )
      }
    )
  }
  
    updatePlayer(playerDTO:PlayerDTO)
    {
      this.playerService.updatePlayer(playerDTO).subscribe(
        (playerDTO)=>{
          console.log("Player updated: "+playerDTO);
          alert("Player updated succesfully");
        }
      );
    }

}
