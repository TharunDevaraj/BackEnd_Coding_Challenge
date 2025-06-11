import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { PlayerDTO } from '../dto/playerDTO';

@Injectable({
  providedIn: 'root'
})
export class PlayerService {

  baseURL:string = 'http://localhost:8080/api/players/';

  constructor(private http : HttpClient) { }

  getAllPlayers():Observable<PlayerDTO[]>
  {
    console.log("In service: getAll method called")
    return this.http.get<PlayerDTO[]>(this.baseURL);
  }

  getByTeam(teamName:string):Observable<PlayerDTO[]>
  {
    console.log("In service: getByTeam method called")
    return this.http.get<PlayerDTO[]>(this.baseURL+"team/"+teamName);
  }

  getById(playerId:number):Observable<PlayerDTO>
  {
    console.log("In service: getById method called")
    return this.http.get<PlayerDTO>(this.baseURL+playerId);
  }

  addPlayer(player:PlayerDTO):Observable<PlayerDTO>
  {
    console.log("In service: addPlayer method called")
    return this.http.post<PlayerDTO>(this.baseURL,player);
  }

  updatePlayer(player:PlayerDTO):Observable<PlayerDTO>
  {
    console.log("In service: updatePlayer method called")
    return this.http.put<PlayerDTO>(this.baseURL+player.playerId,player);
  }

  deletePlayer(playerId:number):Observable<string>
  {
    console.log("In service: deletePlayer method called")
    return this.http.delete<string>(this.baseURL+playerId);
  }
}
