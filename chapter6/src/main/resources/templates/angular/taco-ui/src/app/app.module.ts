import { HttpClientModule } from "@angular/common/http";
import { FormsModule } from "@angular/forms";
import { BrowserModule } from "@angular/platform-browser";
import { NgModule } from "@angular/core";
import { RouterModule, Routes } from "@angular/router";

import { AppComponent } from "./app.component";
import { DesignComponent } from "./design/design.component";
import { GroupBoxComponent } from "./group-box/group-box.component";
import { TacoHeaderComponent } from "./taco-header/taco-header.component";
import { TacoCartComponent } from "./taco-cart/taco-cart.component";
import { TacoFooterComponent } from "./taco-footer/taco-footer.component";
import { BigButtonComponent } from "./big-button/big-button.component";

import { ApiService } from "./api/ApiService";
import { CartService } from "./taco-cart/cart-service";

import { routes } from "./app.routes";

@NgModule({
  declarations: [
    AppComponent,
    DesignComponent,
    GroupBoxComponent,
    TacoHeaderComponent,
    TacoCartComponent,
    TacoFooterComponent,
    BigButtonComponent,
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule,
    RouterModule.forRoot(routes),
  ],
  providers: [ApiService, CartService],
  bootstrap: [AppComponent],
})
export class AppModule {}
