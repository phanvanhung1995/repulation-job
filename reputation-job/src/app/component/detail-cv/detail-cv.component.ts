import {Component, OnInit} from '@angular/core';
import {CVService, Page} from "../../service/cv.service";
import {CvDto} from "../../dto/cv-dto";
import {ActivatedRoute, Router} from "@angular/router";
import Swal from "sweetalert2";
import {CartService} from "../../service/cart.service";
import {TokenStorageService} from "../../service/tokenStorage.service";
import {CartDto} from "../../dto/cart-dto";
import {ShareService} from "../../service/share.service";
import {ViewportScroller} from "@angular/common";

@Component({
  selector: 'app-detail-cv',
  templateUrl: './detail-cv.component.html',
  styleUrls: ['./detail-cv.component.css']
})
export class DetailCvComponent implements OnInit {
  CV: CvDto;
  id: number;
  cartList: CartDto[];

  constructor(private cvService: CVService,
              private activatedRoute:ActivatedRoute,
              private route:Router,
              private cartService :CartService,
              private tokenStorageService:TokenStorageService,
              private shareService: ShareService,
              private viewportScroller:ViewportScroller) {
  }

  ngOnInit(): void {
    this.viewportScroller.scrollToPosition([0,0])
    this.activatedRoute.paramMap.subscribe(param => {
      console.log(+param.get('id'))
      this.id = +param.get('id');
    });
    this.getCVById();
  }

   getCVById() {
    this.cvService.findCVById(this.id).subscribe(item => {
      this.CV = item;
    })
  }

  oder(id: number) {
      if (this.CV.id == id) {
        if (this.CV.price == 0) {
          this.route.navigateByUrl('/create/cv/' + id)
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
