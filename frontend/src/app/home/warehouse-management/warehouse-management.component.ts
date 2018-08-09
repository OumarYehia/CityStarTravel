import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-warehouse-management',
  templateUrl: './warehouse-management.component.html',
  styleUrls: ['./warehouse-management.component.scss']
})
export class WarehouseManagementComponent implements OnInit {

  displayedColumns: string[] = ['name', 'qty', 'bus'];
  dataSource = ELEMENT_DATA;

  constructor() { }

  ngOnInit() {
  }

}

export interface PeriodicElement {
  name: string;
  qty: number;
  bus: string;
}

const ELEMENT_DATA: PeriodicElement[] = [
  {name: 'تيل فرامل', qty: 1, bus: 'أتوبيس الأحلام'},
  {name: 'اطارات', qty: 6, bus: 'أتوبيس الهنا'},
  {name: 'تيل فرامل', qty: 4, bus: 'أتوبيس الإخوة'},
  {name: 'سير موتور', qty: 0, bus: 'أتوبيس رايح راجع'},
  {name: 'فلتر زيت', qty: 12, bus: 'أتوبيس الهنا'},
  {name: 'سير موتور', qty: 0, bus: 'أتوبيس رايح راجع'},
  {name: 'تيل فرامل', qty: 4, bus: 'أتوبيس الإخوة'},
  {name: 'اطارات', qty: 6, bus: 'أتوبيس الهنا'},
];
