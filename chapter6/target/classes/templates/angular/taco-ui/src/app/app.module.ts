import { HttpClientModule } from "@angular/common/http";
import { FormsModule } from "@angular/forms";
import { BrowserModule } from "@angular/platform-browser";
import { NgModule } from "@angular/core";

import { AppComponent } from "./app.component";
import { DesignComponent } from "./design/design.component";
import { GroupBoxComponent } from "./group-box/group-box.component";
import { TacoHeaderComponent } from "./taco-header/taco-header.component";
import { TacoCartComponent } from "./taco-cart/taco-cart.component";
import { TacoFooterComponent } from "./taco-footer/taco-footer.component";
import { BigButtonComponent } from "./big-button/big-button.component";

import { ApiService } from "./api/ApiService";

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
  imports: [BrowserModule, HttpClientModule, FormsModule],
  providers: [ApiService],
  bootstrap: [AppComponent],
})
export class AppModule {}
