import { Component, OnInit, Injectable } from "@angular/core";
import { CartService } from "./cart-service";
import { HttpClient, HttpHeaders } from "@angular/common/http";

@Component({
  selector: "app-taco-cart",
  templateUrl: "./taco-cart.component.html",
  styleUrls: ["./taco-cart.component.css"],
})
@Injectable()
export class TacoCartComponent implements OnInit {
  model = {
    deliveryName: "",
    deliveryStreet: "",
    deliveryState: "",
    deliveryZip: "",
    ccNumber: "",
    ccExpiration: "",
    ccCVV: "",
    tacos: [],
  };

  constructor(private cart: CartService, private httpClient: HttpClient) {
    this.cart = cart;
  }

  ngOnInit() {}

  get cartItems() {
    return this.cart.getItemsInCart();
  }

  get cartTotal() {
    return this.cart.getCartTotal();
  }

  onSubmit() {
    // this.model.tacos = this.cart.getItemsInCart();
    this.cart.getItemsInCart().forEach((cartItem) => {
      this.model.tacos.push(cartItem.taco);
    });

    this.httpClient
      .post("http://localhost:9090/orders", this.model, {
        headers: new HttpHeaders()
          .set("Content-type", "application/json")
          .set("Accept", "application/json"),
      })
      .subscribe((r) => this.cart.emptyCart());

    // TODO: Do something after this...navigate to a thank you page or something
  }
}
