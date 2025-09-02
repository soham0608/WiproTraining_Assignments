import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { Product } from '../../interface/product';
import { ProductService } from '../../service/product.service';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-adminadd',
  imports: [CommonModule, FormsModule],
  templateUrl: './adminadd.component.html',
  styleUrl: './adminadd.component.css',
})
export class AdminaddComponent {
  newProduct: Product = {
    prodName: '',
    prodDesc: '',
    prodCat: '',
    make: '',
    availableQty: 0,
    price: 0,
    uom: '',
    prodRating: 0,
    imageURL: '',
    dateOfManufactureName: new Date(),
  };

  constructor(private productService: ProductService, private router: Router) {}

  addProduct() {
    this.productService.addProduct(this.newProduct).subscribe(() => {
      this.router.navigate(['/user/menu/0']); 
    });
  }

  cancelAdd() {
    this.router.navigate(['/user/menu/0']);
  }
}
