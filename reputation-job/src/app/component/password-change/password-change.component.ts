import { Component, OnInit } from '@angular/core';
import {FormGroup} from "@angular/forms";

@Component({
  selector: 'app-password-change',
  templateUrl: './password-change.component.html',
  styleUrls: ['./password-change.component.css']
})
export class PasswordChangeComponent implements OnInit {
  formChangePassword?: FormGroup;

  constructor() { }

  ngOnInit(): void {
  }

  changePassword() {

  }
}
