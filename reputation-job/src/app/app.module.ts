import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {HeaderComponent} from './component/header/header.component';
import {LoginComponent} from "./component/login/login.component";
import {FooterComponent} from './component/footer/footer.component';

import {CvComponent} from './component/cv/cv.component';
import {DetailCvComponent} from './component/detail-cv/detail-cv.component';
import {CartComponent} from './component/cart/cart.component';
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {HttpClientModule} from "@angular/common/http";
import {PasswordChangeComponent} from './component/password-change/password-change.component';
import {CandidateComponent} from './component/candidate/candidate.component';
import {CandidateChangeComponent} from './component/candidate-change/candidate-change.component';
import {CreateCvComponent} from './component/create-cv/create-cv.component';
import {PaypalComponent} from './component/paypal/paypal.component';
import {ErrorPageComponent} from './component/error-page/error-page.component';
import {environment} from "../environments/environment";
import {AngularFireStorageModule} from "@angular/fire/storage";
import {AngularFireModule} from "@angular/fire";
import { HistoryComponent } from './component/history/history.component';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FooterComponent,
    CvComponent,
    DetailCvComponent,
    CartComponent,
    LoginComponent,
    PasswordChangeComponent,
    CandidateComponent,
    CandidateChangeComponent,
    CreateCvComponent,
    PaypalComponent,
    ErrorPageComponent,
    HistoryComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule,
    HttpClientModule,
    FormsModule,
    AngularFireStorageModule,
    AngularFireModule,
    AngularFireModule.initializeApp(environment.firebaseConfig),
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}
