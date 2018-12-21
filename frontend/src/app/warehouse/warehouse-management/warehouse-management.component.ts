import {Component, OnInit, ViewChild} from '@angular/core';
import {ModalDirective} from 'ngx-bootstrap';
import {WarehouseService} from '../warehouse.service';
import {Spare, SpareType} from '../warehhouse.dto';

@Component({
  selector: 'app-warehouse-management',
  templateUrl: './warehouse-management.component.html',
  styleUrls: ['./warehouse-management.component.scss']
})
export class WarehouseManagementComponent implements OnInit {


  spareTypes: SpareType[];
  spares: Spare[];
  showPurchase: boolean;
  showStock: boolean;

  constructor(
    private warehouseService: WarehouseService
  ) {  }

  ngOnInit() {
    this.showPurchase = false;
    this.showStock = false;
    this.warehouseService.getSpareTypesList().subscribe(
      res => {
        this.spareTypes = res.content;
      }
    );

    this.warehouseService.getSparesList().subscribe(
      res => {
        this.spares = res.content;
      }
    );
  }

  onPurchaseClick() {
    this.showPurchase = !this.showPurchase;
  }

  onStockReceivedClick() {
    this.showStock = !this.showStock;
  }



}
