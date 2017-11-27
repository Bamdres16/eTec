import { Component} from '@angular/core';
import { NavController, AlertController} from 'ionic-angular';
import { HttpProvider } from '../../providers/http/http';


@Component({
  selector: 'page-registro',
  templateUrl: 'registro.html'
})

export class RegistroPage {
  myModel: any;
  constructor(public navCtrl: NavController, public network: HttpProvider, public alertCtrl: AlertController){
    this.myModel = {};

  }
  ionViewDidLoad(){ }
  
  callPostService(ussername, name, email, password)
  {
    let p = this.network.callPost(ussername, name, email, password);
    p.then(data => {
      console.log(data.json().data);
    })
  }

  callGetService(ussername, name, email, password)
  {
    let p = this.network.callGet(ussername, name, email, password);
    p.then(data => {
      console.log(JSON.stringify(data.json().args));
    })
  }
}
