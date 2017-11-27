import { Component } from '@angular/core';
import { NavController } from 'ionic-angular';
import {RegistroPage} from '../registro/registro';

@Component({
  selector: 'page-login',
  templateUrl: 'login.html'
})
export class LoginPage {

  constructor(public navCtrl: NavController) {

  }

  registro(){
    this.navCtrl.push(RegistroPage)
  }

}
