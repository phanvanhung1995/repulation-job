import { Component, OnInit } from '@angular/core';
import {AccountService} from "../../service/account.service";
import {ActivatedRoute} from "@angular/router";
import {Candidate} from "../../dto/candidate";

@Component({
  selector: 'app-candidate',
  templateUrl: './candidate.component.html',
  styleUrls: ['./candidate.component.css']
})
export class CandidateComponent implements OnInit {
   id: number;
   candidate: Candidate;

  constructor(private accountService:AccountService,
              private activatedRoute:ActivatedRoute) { }

  ngOnInit(): void {
    this.activatedRoute.paramMap.subscribe(param => {
      this.id = +param.get('id');
    });
    this.getCandidateById();
  }

   getCandidateById() {
    this.accountService.findCandidateById(this.id).subscribe(item => {
      this.candidate = item;
    })
  }
}
