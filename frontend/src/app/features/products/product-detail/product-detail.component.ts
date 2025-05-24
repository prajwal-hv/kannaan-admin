import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, ReactiveFormsModule, Validators} from "@angular/forms";
import {ProductService} from "../../../core/services/product.service";
import {ActivatedRoute, Router, RouterLink} from "@angular/router";
import {Product} from "../../../core/models/product.model";

@Component({
  selector: 'app-product-detail',
  standalone: true,
  imports: [
    ReactiveFormsModule,
    RouterLink
  ],
  templateUrl: './product-detail.component.html',
  styleUrl: './product-detail.component.scss'
})
export class ProductDetailComponent implements OnInit {
  productForm!: FormGroup;
  productId?: string;
  isEditMode=false;

  constructor(private fb: FormBuilder,
              private route: ActivatedRoute,
              private router: Router,
              private productService: ProductService) {
  }


  ngOnInit(): void {
    this.productForm = this.fb.group({
      name: ['', [Validators.required, Validators.minLength(3)]],
      category: ['', [Validators.required, Validators.minLength(3)]],
      price: [0, [Validators.required]],
      description: ['', [Validators.required, Validators.minLength(15)]],
    });

    this.productId = this.route.snapshot.paramMap.get("id") ?? undefined;
    this.isEditMode = !!this.productId;

    if(this.isEditMode && this.productId){
      this.productService.getProductById(this.productId).subscribe({
        next: (product: Product) => this.productForm.patchValue(product),
        error: (error: any) => console.error("Error loading product"+error)
      })
    }
  }

  onSubmit():void{
    if(this.productForm.invalid) return;

    const formValue= this.productForm.value;
    if(this.isEditMode && this.productId){
      this.productService.updateProduct(this.productId, this.productForm.value).subscribe({
        next: (product: Product) => this.router.navigate(['/products']),
        error: (error: any) => console.error("Error while updating product"+error)
      });

    } else  {
      this.productService.createProduct(formValue).subscribe({
        next: (product: Product) => this.router.navigate(['/products']),
        error: (error: any) => console.error("Error while creating product"+error)
      })
    }
  }


}
