// src/app/core/models/order.model.ts
export interface Order {
  id?: string;
  customerName: string;
  productIds: string[];
  quantity: number;
  status: string;
  orderDate?: string; // ISO string date
}
