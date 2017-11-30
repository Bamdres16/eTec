import { Component } from '@angular/core';
import { AboutPage } from '../about/about';
import { ChatPage } from '../chat/chat';
import { HomePage } from '../home/home';
import { LoginPage } from '../login/login';
//import {RegistroPage} from '../registro/registro'
import {ServidorPage} from '../servidor/servidor';
//import {ContactosPage} from '../contactos/contactos';



@Component({
  templateUrl: 'tabs.html'
})
export class TabsPage {
  username:string = "";
  tab1Root = HomePage;
  tab2Root = AboutPage;
  tab3Root = ServidorPage;
  tab4Root = ChatPage;
  //tab5Root = MensajePage;
//  //<ion-tab [root]="tab5Root" tabTitle="Login" tabIcon="flower"></ion-tab>
  constructor() {
    
  }
  
}
