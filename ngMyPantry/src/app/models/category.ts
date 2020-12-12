export class Category {
  id: number;
  categoryName: string;
  stockPicture: string;
  // groceries: Grocery[];

  constructor(id?: number, categoryName?: string, stockPicture?: string){
    this.id = id;
    this.categoryName = categoryName;
    this.stockPicture = stockPicture;
  }
}
