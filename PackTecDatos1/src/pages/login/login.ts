import { Component } from '@angular/core';
import { NavController, AlertController} from 'ionic-angular';
import {RegistroPage} from '../registro/registro';
import { HttpProvider } from '../../providers/http/http';
import { TabsPage} from '../tabs/tabs';
<<<<<<< HEAD

=======
>>>>>>> 1b68d42672a83a95babd4d9960f38203ec0e8a83

@Component({
  selector: 'page-login',
  templateUrl: 'login.html'
})
export class LoginPage {
  respuesta = "";
  constructor(public navCtrl: NavController, public network: HttpProvider, public alertCtrl: AlertController) {

  }

  registro(){
    this.navCtrl.push(RegistroPage)
  }
  callPostService(username, password)
   {
     let p = this.network.callPostLogin(username, password);
     p.then(data => {
       this.respuesta = data["_body"];
       if(this.respuesta=="Login Correct") {
         this.showAlert();
      } else if (this.respuesta=="User not exist") {
         this.showAlertExitUser();
      } else if(this.respuesta=="Password Incorrect"){
        this.showAlertExitPassword();
      }
     })

   }

   showAlert() {
     let alert = this.alertCtrl.create({
       title: 'Logueado exitoso',
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

   showAlertExitPassword() {
     let alert = this.alertCtrl.create({
       title: 'NO Logueado',
       subTitle: 'Contraseña incorrecta',
       buttons: ['OK']
     });
     alert.present();
   }
   showAlertExitUser() {
     let alert = this.alertCtrl.create({
       title: ' NO Logueado',
       subTitle: 'Usuario incorrecto',
       buttons: ['OK']
     });
     alert.present();
   }

   app(){
     this.navCtrl.push(TabsPage);

<<<<<<< HEAD
  callPostService(username, password)
  {
    let p = this.network.callPostLogin(username, password);
    p.then(data => {
      this.respuesta = data["_body"];
      if(this.respuesta=="Login Correct") {
        this.showAlert();
     } else if (this.respuesta=="User not exist") {
        this.showAlertExitUser();
     } else if(this.respuesta=="Password Incorrect"){
       this.showAlertExitPassword();
     }
    })
   
  }

  showAlert() {
    let alert = this.alertCtrl.create({
      title: 'Logueado exitoso',
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

  showAlertExitPassword() {
    let alert = this.alertCtrl.create({
      title: 'NO Logueado',
      subTitle: 'Contraseña incorrecta',
      buttons: ['OK']
    });
    alert.present();
  }
  showAlertExitUser() {
    let alert = this.alertCtrl.create({
      title: ' NO Logueado',
      subTitle: 'Usuario incorrecto',
      buttons: ['OK']
    });
    alert.present();
  }

  app(){
    this.navCtrl.push(TabsPage);

  }
=======
 }
>>>>>>> 1b68d42672a83a95babd4d9960f38203ec0e8a83
}
