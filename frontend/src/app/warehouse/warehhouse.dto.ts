export class SpareType {
  id: number;
  serialNo: number;
  name: string;
  unit: string;
}

export class Spare {
  id: number;
  serialNo: number;
  available: boolean;
  spareType: SpareType;
  quantity: number;
}
