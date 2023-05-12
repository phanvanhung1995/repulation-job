import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import {LoginComponent} from "./component/login/login.component";
import {ContentComponent} from "./component/content/content.component";
import {CvComponent} from "./component/cv/cv.component";
import {DetailCvComponent} from "./component/detail-cv/detail-cv.component";
import {CartComponent} from "./component/cart/cart.component";
import {CandidateComponent} from "./component/candidate/candidate.component";
import {CandidateChangeComponent} from "./component/candidate-change/candidate-change.component";
import {CreateCvComponent} from "./component/create-cv/create-cv.component";
import {AuthGuard} from "./guards/auth.guard";
import {ErrorPageComponent} from "./component/error-page/error-page.component";
import {CandidateGuard} from "./guards/candidate.guard";
import {HistoryComponent} from "./component/history/history.component";


const routes: Routes = [
  {
    path: "", component: ContentComponent
  },

  {
    canActivate: [AuthGuard],
    path: 'login',
    component: LoginComponent
  },
  {
    path: "cv", component: CvComponent
  },
  {
    path: "detailCv/:id", component: DetailCvComponent
  },
  {
    canActivate: [CandidateGuard],
    path: "detailCandidate/:id", component: CandidateComponent
  },
  {
    canActivate: [CandidateGuard],
    path: "candidate/change/:id", component: CandidateChangeComponent
  },
  {
    canActivate: [CandidateGuard],
    path: "cart", component: CartComponent
  },
  {
    canActivate: [CandidateGuard],
    path: "create/cv/:id", component: CreateCvComponent
  },
  {
    path: "error", component: ErrorPageComponent
  },
  {
    canActivate: [CandidateGuard],
    path: "history/:id", component: HistoryComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
