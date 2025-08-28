import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { ProductService } from '../product.service';
import { Product } from '../product';

@Component({
  selector: 'app-product-add',
  templateUrl: './product-add.component.html',
  styleUrls: ['./product-add.component.css']
})
export class ProductAddComponent {
  product: Product = { name: '', category: '', price: 0 };

  constructor(private productService: ProductService, private router: Router) {}

  onSubmit(): void {
    this.productService.addProduct(this.product).subscribe(() => {
      this.router.navigate(['/products']);
    });
  }
}
