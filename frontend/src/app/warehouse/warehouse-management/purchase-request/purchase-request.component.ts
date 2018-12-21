import {AfterViewInit, Component, Input, OnInit, ViewChild} from '@angular/core';
import {ModalDirective} from 'ngx-bootstrap';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {PurchaseItem} from '../warehouse.dto';

@Component({
  selector: 'app-purchase-request',
  templateUrl: './purchase-request.component.html',
  styleUrls: ['./purchase-request.component.scss']
})
export class PurchaseRequestComponent implements OnInit, AfterViewInit {

  @ViewChild('newPurchaseModal') newPurchaseModal: ModalDirective;

  itemForm: FormGroup;
  purchaseForm: FormGroup;

  purchaseItems: PurchaseItem[] = [];
  selectedItem: PurchaseItem;

  isViewInit = false;

  @Input()
  set showModal(show: boolean) {
    if (!this.isViewInit) {
      return;
    }
    this.showPurchaseModal();
  }

  constructor(
    private fb: FormBuilder,
  ) {}

  ngOnInit() {
    this.itemForm = this.fb.group({
      itemCode: ['', Validators.required],
      refCode: ['', Validators.required],
      quantity: ['', Validators.required],
      make: ['', Validators.required],
      unit: ['', Validators.required],
      description: ['', Validators.required]
    });

    this.purchaseForm = this.fb.group({
      date: ['', Validators.required],
      needsRequest: ['', Validators.required],
      supplierCode: ['', Validators.required],
      supplierName: ['', Validators.required]
    });
  }

  ngAfterViewInit() {
    this.isViewInit = true;
  }

  showPurchaseModal(): void {
    this.newPurchaseModal.show();
  }

  hidePurchaseModal(): void {
    this.newPurchaseModal.hide();
  }

  addItem() {
    this.purchaseItems.push(this.itemForm.value);
    this.itemForm.reset();
  }

  addPurchaseRequest() {
  }

  selectItem(item) {
    this.selectedItem = this.selectedItem === item ? null : item;
  }


}
