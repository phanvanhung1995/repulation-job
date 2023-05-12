import {Component, OnInit} from '@angular/core';
import {CartService} from "../../service/cart.service";
import {TokenStorageService} from "../../service/tokenStorage.service";
import {CartDto} from "../../dto/cart-dto";
import {render} from "creditcardpayments/creditCardPayments";
import Swal from "sweetalert2";
import {Router} from "@angular/router";



@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent implements OnInit {
  cartList: CartDto[];
  totalMoney: number;
  id: number;


  constructor(private cartService: CartService,
              private tokenStorageService: TokenStorageService,
              private route: Router,
  ) {
  }

  ngOnInit(): void {
    this.totalMoney = 0;
    this.getCart();
  }

  getCart() {
    this.id = this.tokenStorageService.getUser().id
    this.cartService.getAllCart(this.id).subscribe(item => {
      this.cartList = item;
      for (let i = 0; i < this.cartList.length; i++) {
        this.totalMoney += +(this.cartList[i].quantity * this.cartList[i].price);
      }
      console.log( this.totalMoney)
      render(
        {
          id: "#myPaypalButtons",
          currency: "VND",
          value: this.totalMoney.toPrecision(),
          onApprove: (details) => {
            this.totalMoney = 0;
            this.cartList = [];
            console.log(this.tokenStorageService.getUser().id)
            this.cartService.deleteCartAll(this.tokenStorageService.getUser().id).subscribe(() => {
              this.route.navigateByUrl('/cart')
            })
            Swal.fire({
              icon: 'success',
              title: 'thanh toán thành công',
              showConfirmButton: false,
              timer: 1500
            });
          }
        }
      )
    })
  }

  delete(id: number) {
    this.cartService.deleteCartById(id).subscribe(() => {
      this.totalMoney = 0;
      this.cartService.getAllCart(this.id).subscribe(item => {
        this.cartList = item;
        for (let i = 0; i < this.cartList.length; i++) {
          this.totalMoney += +(this.cartList[i].quantity * this.cartList[i].price);
        }
      })
    })
  }

}
