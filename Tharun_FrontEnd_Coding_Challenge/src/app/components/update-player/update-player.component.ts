import { Component } from '@angular/core';
import { PlayerDTO } from 'src/app/dto/playerDTO';
import { PlayerService } from 'src/app/services/player.service';

@Component({
  selector: 'app-update-player',
  templateUrl: './update-player.component.html',
  styleUrls: ['./update-player.component.css']
})
export class UpdatePlayerComponent {

   constructor(private playerService:PlayerService)
    {
  
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
