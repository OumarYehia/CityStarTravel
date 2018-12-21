import {AfterViewInit, Component, Input, OnInit, ViewChild} from '@angular/core';
import {ModalDirective} from 'ngx-bootstrap';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';

@Component({
  selector: 'app-stock-received',
  templateUrl: './stock-received.component.html',
  styleUrls: ['./stock-received.component.scss']
})
export class StockReceivedComponent implements OnInit, AfterViewInit {

  @ViewChild('newStockReceivedModal') newStockReceivedModal: ModalDirective;

  stockForm: FormGroup;

  showItemForm = false;
  isViewInit = false;
  @Input()
  set showModal(show: boolean) {
    if (!this.isViewInit) { return; }
    this.showStockReceivedModal();
  }

  constructor(
    private fb: FormBuilder
  ) { }

  ngOnInit() {
    this.stockForm = this.fb.group({
    });
  }

  ngAfterViewInit() {
    this.isViewInit = true;
  }

  showStockReceivedModal(): void {
    this.newStockReceivedModal.show();
  }

  hideStockReceivedModal(): void {
    this.newStockReceivedModal.hide();
  }


}
