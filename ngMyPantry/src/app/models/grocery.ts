import { Category } from './category';

export class Grocery {
  id: number;
  category: Category;
  productName: string;
  amount: number;
  datePurchased: Date;
  expirationDate: Date;
  dateOpened: Date;
  amountUsed: number;

  constructor(id?: number, category?: Category, productName?: string, amount?: number,
    datePurchased?: Date, expirationDate?: Date, dateOpened?: Date, amountUsed?: number){
      this.id = id;
      this.category = category;
      this.productName = productName;
      this.amount = amount;
      this.datePurchased = datePurchased;
      this.expirationDate = expirationDate;
      this.dateOpened = dateOpened;
      this.amountUsed = amountUsed;
  }

}
