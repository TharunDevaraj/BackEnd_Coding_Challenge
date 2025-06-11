import { Component } from '@angular/core';
import { PlayerDTO } from 'src/app/dto/playerDTO';
import { PlayerService } from 'src/app/services/player.service';

@Component({
  selector: 'app-add-player',
  templateUrl: './add-player.component.html',
  styleUrls: ['./add-player.component.css']
})
export class AddPlayerComponent {

  constructor(private playerService:PlayerService)
  {

  }

  addPlayer(playerDTO:PlayerDTO)
  {
    this.playerService.addPlayer(playerDTO).subscribe(
      (playerDTO)=>{
        console.log("Player added: "+playerDTO);
        alert("Player added succesfully");
      }
    );
  }

}
