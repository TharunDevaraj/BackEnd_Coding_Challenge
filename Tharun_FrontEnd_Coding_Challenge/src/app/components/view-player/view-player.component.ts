import { Component, OnInit } from '@angular/core';
import { PlayerDTO } from 'src/app/dto/playerDTO';
import { PlayerService } from 'src/app/services/player.service';

@Component({
  selector: 'app-view-player',
  templateUrl: './view-player.component.html',
  styleUrls: ['./view-player.component.css']
})
export class ViewPlayerComponent implements OnInit{

  playerList:PlayerDTO[]=[];

  constructor(private playerService:PlayerService)
  {

  }
  ngOnInit(): void {
    this.getAllPlayers();
  }

  getAllPlayers()
  {
    this.playerService.getAllPlayers().subscribe(
      (list)=>{
        this.playerList=list;
        console.log("All players list:"+this.playerList)
      }
    )
  }

  deleteById(playerId:number)
  {
    this.playerService.deletePlayer(playerId).subscribe(
      (msg)=>{
        alert("Player deleted successfully");
        console.log("Player deleted:"+msg);
        this.getAllPlayers();
      },
      (err) => {
        console.error("Error deleting player", err);
        alert("Failed to delete player");
    }
    )
  }

}
