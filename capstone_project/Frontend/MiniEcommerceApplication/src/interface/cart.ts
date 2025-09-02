export interface Cart {
  id: number;
  userId: number;
  prodDetails: { [productId: string]: number }; 
  totalQty: number;
  totalPrice: number;
}
