import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

const routes: Routes = [
  {path:'home', loadChildren: () => import('./home/home.module').then(module => module.HomeModule)},
  {path: 'security', loadChildren:() => import('./security/security.module').then(module => module.SecurityModule)},
  {path:'cart', loadChildren:() => import('./cart/cart.module').then(module => module.CartModule)}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
