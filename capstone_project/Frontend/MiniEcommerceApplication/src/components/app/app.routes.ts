import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from '../login/login.component';
import { ProductComponent } from '../product/product.component';
import { RegisterComponent } from '../register/register.component';
import { AdminComponent } from '../admin/admin.component';
import { CartComponent } from '../cart/cart.component';
import { CheckoutComponent } from '../checkout/checkout.component';
import { OrderhistoryComponent } from '../orderhistory/orderhistory.component';
import { AdminaddComponent } from '../adminadd/adminadd.component';
import { AdmineditComponent } from '../adminedit/adminedit.component';
import { ProfileComponent } from '../profile/profile.component';

export const routes: Routes = [
  { path: '', component: LoginComponent },
  { path: 'login', component: LoginComponent },
  { path: 'register', component: RegisterComponent },
  { path: 'user/menu/0', component: AdminComponent },
  { path: 'admin/add', component: AdminaddComponent },
  { path: 'admin/edit/:id', component: AdmineditComponent },
  { path: 'user/menu/1', component: ProductComponent },
  { path: 'cart', component: CartComponent },
  { path: 'products', component: ProductComponent },
  { path: 'checkout', component: CheckoutComponent },
  { path: 'orders', component: OrderhistoryComponent },
  { path: 'profile', component: ProfileComponent },
];
RouterModule.forRoot(routes, { enableTracing: true });
