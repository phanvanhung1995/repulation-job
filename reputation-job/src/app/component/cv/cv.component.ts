import {Component, OnInit} from '@angular/core';
import {CVService} from "../../service/cv.service";
import {CvDto} from "../../dto/cv-dto";
import {AccountService} from "../../service/account.service";
import {ActivatedRoute, Router} from "@angular/router";
import {Candidate} from "../../dto/candidate";
import {CartService} from "../../service/cart.service";
import {TokenStorageService} from "../../service/tokenStorage.service";
import {CartDto} from "../../dto/cart-dto";
import {ShareService} from "../../service/share.service";
import Swal from "sweetalert2";
import {ViewportScroller} from "@angular/common";

@Component({
  selector: 'app-cv',
  templateUrl: './cv.component.html',
  styleUrls: ['./cv.component.css']
})
export class CvComponent implements OnInit {
  searchName: string;
  currentPage: number;
  cvPage: CvDto[] = [];
  teamPage: any;
  id: number;
  candidate: Candidate;
  itemCount: number;
  cartList: CartDto[];

  constructor(private cvService: CVService,
              private accountService: AccountService,
              private activatedRoute: ActivatedRoute,
              private route: Router,
              private cartService: CartService,
              private tokenStorageService: TokenStorageService,
              private shareService: ShareService,
              private viewportScroller:ViewportScroller) {
    this.shareService.getCount().subscribe(item=>{
      this.itemCount = item;
    })
  }

  ngOnInit(): void {
    this.cartService.getAllCart(this.tokenStorageService.getUser().id
    ).subscribe(item => {
      this.cartList = item;
      this.itemCount = item.length;
    });
    this.searchName = '';
    this.currentPage = 0;
    this.getCV();
    this.activatedRoute.paramMap.subscribe(param => {
      this.id = +param.get('id');
    });
    this.getCandidateById();
    this.viewportScroller.scrollToPosition([0,0])
  }

  getCV() {
    this.cvService.getCV(this.searchName, this.currentPage).subscribe(item => {
      console.log(item)
      this.cvPage = item.content;
      this.teamPage = item;
    })
  }

  changePage(pageNumber: number) {
    this.currentPage = pageNumber;
    this.getCV();
  }

  search(searchName: string) {
    this.searchName = searchName;
    this.currentPage = 0;
    this.cvPage = [];
    this.getCV();
  }

  getCandidateById() {
    this.accountService.findCandidateById(this.id).subscribe(item => {
      this.candidate = item;
    })
  }

  oder(id: number) {
    console.log(id)
    console.log(this.cvPage)
    for (const cv of this.cvPage) {
      if (cv.id == id) {
        if (cv.price == 0) {
          this.route.navigateByUrl('/create/cv/' + id)
          break;
        } else {
          this.cartService.addCart(id, this.tokenStorageService.getUser().id).subscribe(() => {
            this.cartService.getAllCart(this.tokenStorageService.getUser().id).subscribe(item => {
              this.cartList = item;
              this.shareService.setCount(item.length);
              this.route.navigateByUrl('/cart')
            })
          },
            error => {
            if (error.status === 404){
              Swal.fire({
                icon: 'error',
                title: 'Cv has been in cart',
                showConfirmButton: false,
                timer: 1500
              });
            }
            })
        }
      }
    }
  }
}
