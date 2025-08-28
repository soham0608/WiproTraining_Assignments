import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ProductService } from '../product.service';
import { Product } from '../product';

@Component({
  selector: 'app-product-edit',
  templateUrl: './product-edit.component.html',
  styleUrls: ['./product-edit.component.css']
})
export class ProductEditComponent implements OnInit {
  product: Product = { id: 0, name: '', category: '', price: 0 };
  id!: number;

  constructor(
    private route: ActivatedRoute,
    private productService: ProductService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.id = +this.route.snapshot.paramMap.get('id')!;
    this.productService.getProductById(this.id).subscribe(data => {
      this.product = data;
    });
  }

  onSubmit(): void {
    this.productService.updateProduct(this.id, this.product).subscribe(() => {
      this.router.navigate(['/products']);
    });
  }
}
