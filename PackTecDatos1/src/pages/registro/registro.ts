import { Component} from '@angular/core';
import { NavController, AlertController} from 'ionic-angular';
import { HttpProvider } from '../../providers/http/http';
import { TabsPage} from '../tabs/tabs';
import { UsernamelogProvider} from '../../providers/usernamelog/usernamelog';

@Component({
  selector: 'page-registro',
  templateUrl: 'registro.html'
})

export class RegistroPage {
  respuesta = "";
  constructor(public navCtrl: NavController, public network: HttpProvider, public alertCtrl: AlertController,public userP: UsernamelogProvider){

  }
  ionViewDidLoad(){ }
  
  callPostService(username, name, email, password, passwordconfirm)
  {
    if (password == passwordconfirm && name != null && email != null && password !=null && username != null
    && this.validateEmail(email)) {
      let p = this.network.callPostRegistro(username, name, email, password);
      p.then(data => {
        this.respuesta = data["_body"];
        if(this.respuesta=="Sucess") {
          this.showAlert();
          this.userP.setUsername(username);
       } else if (this.respuesta =="User Exist") {
          this.showAlertExitUser();
       } else if (this.respuesta == "Email Exist"){
          this.showAlertExitEmail();
       }
      })

    }
   
    
  }
  showAlert() {
    let alert = this.alertCtrl.create({
      title: 'Registrado',
      subTitle: 'Bienvenido! Joven Padawan! ',
      buttons: [ {
        text: 'Ok',
        handler: data => {
          this.app();
        }
      }]
    });
    alert.present();
  }

  showAlertExitEmail() {
    let alert = this.alertCtrl.create({
      title: 'NO Registrado',
      subTitle: 'El email ya esta registrado, por favor usar otro',
      buttons: ['OK']
    });
    alert.present();
  }
  showAlertExitUser() {
    let alert = this.alertCtrl.create({
      title: ' NO Registrado',
      subTitle: 'El nombre de usuario ya esta registrado! cambielo prro',
      buttons: ['OK']
    });
    alert.present();
  }

  app(){
    this.navCtrl.push(TabsPage);

  }
  validateEmail(email) {
    var re = /^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
    return re.test(email);
  }


  callGetService(ussername, name, email, password)
  {
    let p = this.network.callGet(ussername, name, email, password);
    p.then(data => {
      console.log(JSON.stringify(data.json().args));
    })
  }
}
