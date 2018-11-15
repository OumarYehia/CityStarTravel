import { Component, OnInit } from '@angular/core';
import {BusesService} from './buses.service';
import {Bus} from './bus';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {Router} from '@angular/router';

@Component({
  selector: 'app-buses',
  templateUrl: './buses.component.html',
  styleUrls: ['./buses.component.scss']
})
export class BusesComponent implements OnInit {

  buses: Bus[];

  editableBus: number;
  addingBus: boolean;

  newBusForm: FormGroup;
  editBusForm: FormGroup;

  constructor(
    private busesService: BusesService,
    private router: Router,
    private fb: FormBuilder
  ) { }

  ngOnInit() {
    this.getBuses();
    this.editableBus = -1;
    this.addingBus = false;

    this.newBusForm = this.fb.group({
      name: ['', Validators.required],
      make: ['', Validators.required],
      platesAlpha: [''],
      platesNum: ['', Validators.required]
    });

    this.editBusForm = this.fb.group({
      id: '',
      name: '',
      make: '',
      platesAlpha: '',
      platesNum: ''
    });
  }

  startAddingBus() {
    this.addingBus = true;
  }

  getBuses(): void {
    this.busesService.getBuses().subscribe(buses => {
      this.buses = buses.filter(bus => bus.id != -1);
    });
  }

  addBus() {
    this.addingBus = false;
    this.busesService.createBus(this.newBusForm.value).subscribe(
      data => {
        this.newBusForm.reset();
        this.getBuses();
      }
    );
  }

  navigateToBusSpare(busID: number) {
    this.router.navigate(['/warehouseManagement/' + busID]);
  }

  editBus(bus: Bus) {
    this.editBusForm.controls['id'].setValue(bus.id);

    if (!this.editBusForm.dirty) {
      console.log('no changes');
      return;
    }

    if (this.editBusForm.controls['name'].value === '') {
      this.editBusForm.controls['name'].setValue(bus.name);
    }

    if (this.editBusForm.controls['make'].value === '') {
      this.editBusForm.controls['make'].setValue(bus.make);
    }

    if (this.editBusForm.controls['platesAlpha'].value === '') {
      this.editBusForm.controls['platesAlpha'].setValue(bus.platesAlpha);
    }

    if (this.editBusForm.controls['platesNum'].value === '') {
      this.editBusForm.controls['platesNum'].setValue(bus.platesNum);
    }

    this.busesService.updateBus(this.editBusForm.value).subscribe(
      data => {
        this.editableBus = -1;
        this.getBuses();
      }
    );
  }

  deleteBus(busID: number) {
    console.log('Deleting bus' + busID);
    this.busesService.deleteBus(busID).subscribe(
      data => {
        console.log('delete response');
        console.log(data);
      }
    );
  }

}
