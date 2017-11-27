import { Component } from '@angular/core';
import { NavController } from 'ionic-angular';
import {HttpProvider} from '../../providers/http/http';

@Component({
  selector: 'page-chat',
  templateUrl: 'chat.html'
})
export class ChatPage {
  usuarios : any[]= [];
  constructor(public navCtrl: NavController,
    public http:HttpProvider, public userService: HttpProvider) {

  }
  cargarUsuarios(){
	  console.log (this.http.getUsers().subscribe())
    this.http.getUsers().subscribe((data) =>{
      this.usuarios = data['results'];
	  
      console.log(this.usuarios)
    },
    (error) =>{
	 
      console.log(error);
    }
  )
 }
}
