export interface Order {
  orderId: number;
  userId: number;
  productQuantityMap: { [productId: string]: number };
  totalAmount: number;
  orderStatus: string;
  orderDate: string;
}