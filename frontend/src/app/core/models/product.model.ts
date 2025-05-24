export interface Product {
  id?: string;           // Optional because when creating new products, id may not be set yet
  name: string;
  category: string;
  price: number;
  description: string;
}
