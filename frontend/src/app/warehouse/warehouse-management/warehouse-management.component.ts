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

  @ViewChild('newPurchaseModal') newPurchaseModal: ModalDirective;
  @ViewChild('newStockReceivedModal') newStockReceivedModal: ModalDirective;

  spareTypes: SpareType[];
  spares: Spare[];

  constructor(
    private warehouseService: WarehouseService
  ) {  }

  ngOnInit() {
    this.warehouseService.getSpareTypesList().subscribe(
      res => {
        this.spareTypes = res.content;
      }
    );

    this.warehouseService.getSparesList().subscribe(
      res => {
        console.log(res);
        this.spares = res.content;
      }
    );
  }

  onPurchaseClick() {
    this.showPurchaseModal();
  }

  onStockReceivedClick() {
    this.showStockReceivedModal();
  }

  showPurchaseModal(): void {
    this.newPurchaseModal.show();
  }

  hidePurchaseModal(): void {
    this.newPurchaseModal.hide();
  }

  showStockReceivedModal(): void {
    this.newStockReceivedModal.show();
  }

  hideStockReceivedModal(): void {
    this.newStockReceivedModal.hide();
  }

}
