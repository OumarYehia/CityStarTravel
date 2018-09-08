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

  form: FormGroup;

  constructor(
    private busesService: BusesService,
    private router: Router,
    private fb: FormBuilder
  ) { }

  ngOnInit() {
    this.busesService.getBuses();
    this.getBuses();

    this.form = this.fb.group({
      name: ['', Validators.required],
      make: ['', Validators.required],
      platesAlpha: [''],
      platesNum: ['', Validators.required]
    });
  }

  getBuses(): void {
    this.busesService.getBuses().subscribe(
      buses => this.buses = buses
    );
  }

  addBus() {
    this.busesService.createBus(this.form.value).subscribe(
      data => {
        this.form.reset();
        this.getBuses();
      }
    );
  }

  navigateToBusSpare(busID) {
    this.router.navigate(['/warehouseManagement/' + busID]);
    console.log('navigating');
  }

}
