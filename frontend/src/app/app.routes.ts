import { Routes } from '@angular/router';

export const routes: Routes = [
  {
    path:'products',
    loadChildren:()=>import('./features/products/products.module').then(m=>m.ProductsModule)
  },{
  path:'orders',
    loadChildren:()=>import('./features/orders/orders.module').then(m=>m.OrdersModule)
  },{
  path:'',
    redirectTo:'products',
    pathMatch:'full'
  },{
  path:'**',
    redirectTo:'products',
    pathMatch:'full'
  }
];
