import {Component, OnInit} from '@angular/core';
import {AccountService} from "../../service/account.service";
import {ActivatedRoute, Router} from "@angular/router";
import {Candidate} from "../../dto/candidate";
import {FormControl, FormGroup, Validators} from "@angular/forms";
import Swal from "sweetalert2";

@Component({
  selector: 'app-candidate-change',
  templateUrl: './candidate-change.component.html',
  styleUrls: ['./candidate-change.component.css']
})
export class CandidateChangeComponent implements OnInit {
  id: number;
  formUpdateCandidate: FormGroup;
  candidate?: Candidate;


  constructor(private accountService: AccountService,
              private activatedRoute: ActivatedRoute,
              private route: Router) {
    this.formUpdateCandidate = new FormGroup({
      id: new FormControl('', [Validators.required]),
      name: new FormControl('', [Validators.required]),
      dateOfBirth: new FormControl('', [Validators.required]),
      address: new FormControl('', [Validators.required]),
      gender: new FormControl('', [Validators.required]),
      phoneNumber: new FormControl('', [Validators.required]),
      email: new FormControl('', [Validators.required]),
      idCard: new FormControl('', [Validators.required]),
    });
  }

  ngOnInit(): void {
    this.getCandidate();
    this.updateCandidate();
  }

  getCandidate() {
    this.activatedRoute.paramMap.subscribe(next => {
      this.id = parseInt(next.get('id'));
      this.accountService.findCandidateById(this.id).subscribe(data => {
        this.formUpdateCandidate.patchValue(data);
        let candidate: Candidate = this.formUpdateCandidate.value;
        console.log(this.formUpdateCandidate.value);
        candidate.id = this.id;
        console.log(candidate);
      });
    });
  }

  updateCandidate() {
    if (this.formUpdateCandidate.valid) {
      this.candidate = this.formUpdateCandidate.value;
      this.accountService.updateCandidate(this.candidate).subscribe(() => {
        Swal.fire({
          icon: 'success',
          title: 'Sửa thành công',
          showConfirmButton: false,
          timer: 1500
        });
        this.route.navigateByUrl("");
      });
    }
  }
}
