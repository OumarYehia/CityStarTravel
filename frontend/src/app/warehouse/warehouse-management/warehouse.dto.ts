export class PurchaseItem {
  itemCode: string;
  refCode: string;
  quantity: number;
  make: string;
  unit: string;
  description: string;
}

export class PurchaseRequest {
  date: Date;
  needsRequest: string;
  supplierCode: string;
  supplierName: string;
  purchaseItems: PurchaseItem[];
}

export class StockIssueItem {
  itemCode: string;
  description: string;
  unit: string;
  quantity: number;
  notes: string;
}
