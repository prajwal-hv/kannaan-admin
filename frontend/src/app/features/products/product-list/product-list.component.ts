import {Component, OnInit} from '@angular/core';
import {Product} from "../../../core/models/product.model";
import {ProductService} from "../../../core/services/product.service";
import {RouterLink} from "@angular/router";
import {NgForOf} from "@angular/common";
import {InfiniteScrollModule} from "ngx-infinite-scroll";

declare var bootstrap: any;
@Component({
  selector: 'app-product-list',
  standalone: true,
  imports: [RouterLink, NgForOf, InfiniteScrollModule],
  templateUrl: './product-list.component.html',
  styleUrl: './product-list.component.scss'
})
export class ProductListComponent implements OnInit {
  products: Product[] = [];
  productIdToDelete: string | null | undefined = null;
  modal: any;
  page = 0;
  pageSize = 16;
  loading = false;

  constructor(private productService: ProductService) {
  }

  ngOnInit(): void {
    this.loadProducts()
    const modalElement = document.getElementById('confirmDeleteModal');
    this.modal = new bootstrap.Modal(modalElement);
  }

  loadProducts(): void {
    if(this.loading) return
    this.loading = true;
    this.productService.getProducts(this.page,this.pageSize).subscribe(products => {
      this.products = [...this.products, ...products];
      this.page++;
      this.loading = false;
    });
  }

  deleteProduct(): void {
    if (this.productIdToDelete) {
      this.productService.deleteProduct(this.productIdToDelete).subscribe(() => {
// Move focus to a safe element before hiding modal
        (document.activeElement as HTMLElement)?.blur();
        this.modal.hide();
        this.page=0
        this.products = [];
        this.loadProducts();
      });
    }
  }

  openDeleteModal(productId: string | undefined) {
    this.productIdToDelete = productId;
    this.modal.show();
  }

  onScroll(){
    this.loadProducts();
  }


  protected readonly onscroll = onscroll;
}
