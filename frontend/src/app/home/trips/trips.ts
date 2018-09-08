export interface Trip {
  id: number;
  destination: string;
  client: string;
  kmStart: number;
  kmEnd: number;
  driverID: number;
  busID: number;
  busName: string;
  serialNumber: string;
  capacity: number;
  price_basePrice: number;
  price_taxes: number;
  price_tips: number;
  price_tolls: number;
  price_repairs: number;
  tripDate: Date;
}

export interface Drivers {
  driverID: number;
  driverName: string;
}
