import {AfterViewInit, Component, Input, OnInit, ViewChild} from '@angular/core';
import {ModalDirective} from 'ngx-bootstrap';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {PurchaseItem} from '../warehouse.dto';
import {map, startWith} from 'rxjs/operators';
import {Observable} from 'rxjs';
import {SpareType} from '../../warehhouse.dto';

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

  filteredCodes: Observable<SpareType[]>;
  spareTypes: SpareType[] = [];

  isViewInit = false;
  showItemForm = false;

  @Input()
  set showModal(show: boolean) {
    if (!this.isViewInit) {
      return;
    }
    this.showPurchaseModal();
  }

  constructor(
    private fb: FormBuilder,
  ) {
    // let st = new SpareType();
    // st.name = 'واحد';
    // st.id = 0;
    // st.serialNo = 1234;
    // this.spareTypes.push(st);
    //
    // st = new SpareType();
    // st.name = 'ولد';
    // st.id = 0;
    // st.serialNo = 1234;
    // this.spareTypes.push(st);
    //
    // st = new SpareType();
    // st.name = 'آه';
    // st.id = 0;
    // st.serialNo = 1234;
    // this.spareTypes.push(st);
  }

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

    this.filteredCodes = this.itemForm.get('itemCode').valueChanges
      .pipe(
        startWith(''),
        map(st => st ? this._filterSpareTypes(st) : this.spareTypes.slice())
      );
  }

  private _filterSpareTypes(spareType): SpareType[] {
    return this.spareTypes.filter(st => st.name.indexOf(spareType) === 0);
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
