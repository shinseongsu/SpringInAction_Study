import { Routes } from "@angular/router";
import { DesignComponent } from "./design/design.component";

export const routes: Routes = [
  {
    path: "design",
    component: DesignComponent,
  },
  {
    path: "**",
    redirectTo: "design",
    pathMatch: "full",
  },
];
