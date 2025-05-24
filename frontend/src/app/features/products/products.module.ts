import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ProductsRoutingModule } from './products-routing.module';
import {InfiniteScrollModule} from "ngx-infinite-scroll";


@NgModule({
  declarations: [],
  imports: [
    CommonModule,
    ProductsRoutingModule,
    InfiniteScrollModule
  ]
})
export class ProductsModule { }
