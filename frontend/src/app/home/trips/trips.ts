export interface Trips {
  tripID: number;
  destination: string;
  kmStart: number;
  kmEnd: number;
  driverID: number;
  busID: number;
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
