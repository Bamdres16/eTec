import { NgModule, ErrorHandler } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { IonicApp, IonicModule, IonicErrorHandler } from 'ionic-angular';
import { MyApp } from './app.component';

import { AboutPage } from '../pages/about/about';
import { ChatPage } from '../pages/chat/chat';
import { HomePage } from '../pages/home/home';
import { TabsPage } from '../pages/tabs/tabs';
import { LoginPage } from '../pages/login/login';
import { StatusBar } from '@ionic-native/status-bar';
import { SplashScreen } from '@ionic-native/splash-screen';
import {RegistroPage} from '../pages/registro/registro';
import {ServidorPage} from '../pages/servidor/servidor';
import {MensajePage} from '../pages/mensaje/mensajes';
import { HttpProvider } from '../providers/http/http';
import {HttpModule} from '@angular/http';
import { HttpClientModule} from '@angular/common/http';
import { FormsModule } from '@angular/forms';     
import { CustomFormsModule } from 'ng2-validation';
import { UsernamelogProvider } from '../providers/usernamelog/usernamelog';

@NgModule({
  declarations: [
    MyApp,
    AboutPage,
    ChatPage,
    HomePage,
    TabsPage,
    LoginPage,
    RegistroPage,
    ServidorPage,
    MensajePage

  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    HttpModule,
    FormsModule,
    CustomFormsModule,
    IonicModule.forRoot(MyApp)
  ],
  bootstrap: [IonicApp],
  entryComponents: [
    MyApp,
    AboutPage,
    ChatPage,
    HomePage,
    TabsPage,
    LoginPage,
    RegistroPage,
    ServidorPage,
    MensajePage
  ],
  providers: [
    StatusBar,
    SplashScreen,
    {provide: ErrorHandler, useClass: IonicErrorHandler},
    HttpProvider,
    UsernamelogProvider
  ]
})
export class AppModule {}
