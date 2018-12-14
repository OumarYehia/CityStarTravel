import {Component, OnInit, ViewChild} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {Router} from '@angular/router';
import {BusService} from '../bus.service';
import {Bus} from '../bus.dto';
import {ModalDirective} from 'ngx-bootstrap';

@Component({
  selector: 'app-buses-list',
  templateUrl: './buses-list.component.html',
  styleUrls: ['./buses-list.component.scss']
})
export class BusesListComponent implements OnInit {
  buses: Bus[];
  busForm: FormGroup;

  editableBusID: number;
  deletableBus: Bus;

  @ViewChild('newBusModal') newBusModal: ModalDirective;
  @ViewChild('deleteBusModal') deleteBusModal: ModalDirective;

  constructor(
    private busesService: BusService,
    private router: Router,
    private fb: FormBuilder,
  ) {
  }

  ngOnInit() {
    this.getBuses();

    this.busForm = this.fb.group({
      name: ['', Validators.required],
      km: [''],
      platesLetters: [''],
      platesNumbers: ['', Validators.required]
    });
  }

  getBuses(): void {
    this.busesService.getBusesList().subscribe(res => {
      this.buses = res.content;
    });
  }

  onAddClick() {
    this.editableBusID = null;
    this.busForm.reset();
    this.showFormModal();
  }

  onEditClick(bus: Bus) {
    this.editableBusID = bus.id;
    this.busForm.controls['name'].setValue(bus.name);
    this.busForm.controls['km'].setValue(bus.km);
    this.busForm.controls['platesLetters'].setValue(bus.platesLetters);
    this.busForm.controls['platesNumbers'].setValue(bus.platesNumbers);
    this.showFormModal();
  }

  onDeleteClick(bus: Bus) {
    this.deletableBus = bus;
    this.showDeleteModal();
  }

  deleteBus() {
    this.busesService.deleteBus(this.deletableBus.id).subscribe(
      () => {
        this.deletableBus = null;
        this.getBuses();
      }
    );
    this.hideDeleteModal();
  }

  cancelDelete() {
    this.deletableBus = null;
    this.hideDeleteModal();
  }

  submitBusForm() {
    if (this.editableBusID) {
      this.editBus();
    } else {
      this.addBus();
    }
  }

  editBus() {
    let bus: Bus;
    bus = this.busForm.value;
    bus.id = this.editableBusID;
    this.busesService.editBus(bus).subscribe(
      () => {
        this.busForm.reset();
        this.getBuses();
        this.hideFormModal();
      }
    );
  }

  addBus() {
    this.busesService.createBus(this.busForm.value).subscribe(
      () => {
        this.busForm.reset();
        this.getBuses();
        this.hideFormModal();
      }
    );
  }

  showFormModal(): void {
    this.newBusModal.show();
  }

  hideFormModal(): void {
    this.newBusModal.hide();
  }

  showDeleteModal() {
    this.deleteBusModal.show();
  }

  hideDeleteModal() {
    this.deleteBusModal.hide();
  }
}
