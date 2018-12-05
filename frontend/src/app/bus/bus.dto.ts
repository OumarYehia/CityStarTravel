export interface Bus {
  busCondition: number;
  createdAt: Date;
  createdBy: string;
  events: string[];
  id: number;
  inOperation: boolean;
  name: string;
  platesLetters: string;
  platesNumbers: string;
  updatedAt: Date;
  updatedBy: string;
}
