import { Component } from '@angular/core';
import { Product } from '../../interface/product';
import { ActivatedRoute, Router } from '@angular/router';
import { ProductService } from '../../service/product.service';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-adminedit',
  imports: [FormsModule, CommonModule],
  templateUrl: './adminedit.component.html',
  styleUrl: './adminedit.component.css',
})
export class AdmineditComponent {
  editingProduct: Product = {
    id: 0,
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

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private productService: ProductService
  ) {}

  ngOnInit(): void {
    const id = Number(this.route.snapshot.paramMap.get('id'));
    if (id) {
      this.productService.getProductById(id).subscribe((data) => {
        this.editingProduct = data;
      });
    }
  }

  updateProduct() {
    if (this.editingProduct?.id) {
      this.productService
        .updateProduct(this.editingProduct.id, this.editingProduct)
        .subscribe(() => {
          this.router.navigate(['/user/menu/0']);
        });
    }
  }

  cancelEdit() {
    this.router.navigate(['/user/menu/0']);
  }
}
