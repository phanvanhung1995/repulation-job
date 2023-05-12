import { Component, OnInit } from '@angular/core';
import {TokenStorageService} from "../../service/tokenStorage.service";
import {ShareService} from "../../service/share.service";
import {AccountService} from "../../service/account.service";

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {
  isLoggedIn: any;
  role?: string;
  username?: string;
   id?: number;

  constructor(private tokenStorageService: TokenStorageService,
              private shareService: ShareService,
              private accountService:AccountService,
            ) {
    this.loadHeader();
  }

  ngOnInit(): void {
    this.shareService.getClickEvent().subscribe(() => {
      this.loadHeader();
    });
  }

  logOut() {
    this.tokenStorageService.signOut();
    this.ngOnInit();
  }

  loadHeader(): void {
    if (this.tokenStorageService.getToken()) {
      this.role = this.tokenStorageService.getUser().roles[0];
      this.username = this.tokenStorageService.getUser().username;
      this.id = this.tokenStorageService.getUser().id;
      console.log(this.id)

    }
    this.isLoggedIn = this.username != null;
  }


}
