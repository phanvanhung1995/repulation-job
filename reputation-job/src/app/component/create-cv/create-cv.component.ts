import {Component, OnInit} from '@angular/core';
import {CVService} from "../../service/cv.service";
import {CvDto} from "../../dto/cv-dto";
import {ActivatedRoute} from "@angular/router";
import {AccountService} from "../../service/account.service";
import {TokenStorageService} from "../../service/tokenStorage.service";
import {Candidate} from "../../dto/candidate";
import {HttpHeaders} from "@angular/common/http";
import {ViewportScroller} from "@angular/common";

@Component({
  selector: 'app-create-cv',
  templateUrl: './create-cv.component.html',
  styleUrls: ['./create-cv.component.css']
})
export class CreateCvComponent implements OnInit {
  id: number;
  CV: CvDto;
  account: Candidate;
  lang: string;

  constructor(private cvService: CVService,
              private activatedRoute: ActivatedRoute,
              private accountService: AccountService,
              private tokenStorageService: TokenStorageService,
              private viewportScroller: ViewportScroller) {
  }

  ngOnInit(): void {
    this.viewportScroller.scrollToPosition([0,0]);
    this.lang = localStorage.getItem('lang') || 'vi';

    const header = new HttpHeaders({
      'Accept-Language': this.lang
    });

    this.activatedRoute.paramMap.subscribe(param => {
      console.log(+param.get('id'))
      this.id = +param.get('id');
    });
    this.getCVById();
    this.getAccountByUser();
  }


   getCVById() {
    this.cvService.findCVById(this.id).subscribe(item => {
      this.CV = item;
    })
  }

  getAccountByUser() {
    this.id = this.tokenStorageService.getUser().id;
    this.accountService.findCandidateById(this.id).subscribe(item => {
      this.account = item;
    })
  }

  changeLang(lang: any) {
    console.log(lang)
    localStorage.setItem('lang', lang);
    window.location.reload();
  }
}
