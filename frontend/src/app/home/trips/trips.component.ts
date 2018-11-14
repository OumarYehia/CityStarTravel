import { Component, OnInit } from '@angular/core';
import {ActivatedRoute} from '@angular/router';
import {Trip} from './trips';
import {TripsService} from './trips.service';
import {BusesService} from '../buses/buses.service';
import {Bus} from '../buses/bus';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';

@Component({
  selector: 'app-trips',
  templateUrl: './trips.component.html',
  styleUrls: ['./trips.component.scss']
})
export class TripsComponent implements OnInit {


  displayedColumns: string[] = [
    'destination',
    'bus',
    'date',
    'client'
  ];

  newTripForm: FormGroup;
  editTripForm: FormGroup;
  addingNewTrip: boolean;
  editableTrip: number;

  tripInView: Trip;

  trips: Trip[];
  buses: Bus[];

  constructor(
    private tripsService: TripsService,
    private busesService: BusesService,
    private fb: FormBuilder,
    private route: ActivatedRoute,
  ) { }

  getBusNameFromID(busID: number) {
    if (!this.buses) { return; }

    for (const bus of this.buses) {
      if ( bus.id.toString() === busID.toString() ) {
        return bus.name;
      }
    }
  }

  ngOnInit() {
    this.tripInView = null;
    this.addingNewTrip = false;

    this.newTripForm = this.fb.group({
      destination: ['', Validators.required],
      client: ['', Validators.required],
      kmStart: ['', Validators.required],
      kmEnd: ['', Validators.required],
      driverID: ['', Validators.required],
      busID: ['', Validators.required],
      serialNumber: ['', Validators.required],
      capacity: ['', Validators.required],
      tripDate: ['', Validators.required],
      price_basePrice: ['', Validators.required],
      price_taxes: ['', Validators.required],
      price_tips: ['', Validators.required],
      price_tolls: ['', Validators.required],
      price_repairs: ['', Validators.required],
    });

    this.editTripForm = this.fb.group({
      id: '',
      destination: ['', Validators.required],
      client: ['', Validators.required],
      kmStart: ['', Validators.required],
      kmEnd: ['', Validators.required],
      driverID: ['', Validators.required],
      busID: ['', Validators.required],
      serialNumber: ['', Validators.required],
      capacity: ['', Validators.required],
      tripDate: ['', Validators.required],
      price_basePrice: ['', Validators.required],
      price_taxes: ['', Validators.required],
      price_tips: ['', Validators.required],
      price_tolls: ['', Validators.required],
      price_repairs: ['', Validators.required],
    });

    this.busesService.getBuses().subscribe(
      buses => {
        this.buses = buses;
        this.tripsService.getTrips().subscribe(
          trips => {
            this.trips = trips;

            for (const trip of trips) {
              trip.busName = this.getBusNameFromID(trip.busID);
            }

          }
        );
      }
    );



  }

  viewTrip(trip) {
    this.tripInView = trip;
  }

  addNewTrip() {
    if (!this.newTripForm.valid) { return; }

    this.tripsService.addTrip(this.newTripForm.value).subscribe(res => {
      this.tripsService.getTrips().subscribe(
        trips => {
          this.trips = trips;

          for (const trip of trips) {
            trip.busName = this.getBusNameFromID(trip.busID);
          }

        }
      );
    });

  }

  editTrip(trip: Trip) {
    this.editableTrip = trip.id;
    this.editTripForm.controls['id'].setValue(trip.id);
    this.editTripForm.controls['destination'].setValue(trip.destination);
    this.editTripForm.controls['client'].setValue(trip.client);
    this.editTripForm.controls['kmStart'].setValue(trip.kmStart);
    this.editTripForm.controls['kmEnd'].setValue(trip.kmEnd);
    this.editTripForm.controls['driverID'].setValue(trip.driverID);
    this.editTripForm.controls['busID'].setValue(trip.busID);
    this.editTripForm.controls['serialNumber'].setValue(trip.serialNumber);
    this.editTripForm.controls['capacity'].setValue(trip.capacity);
    this.editTripForm.controls['tripDate'].setValue(trip.tripDate);
    this.editTripForm.controls['price_basePrice'].setValue(trip.price_basePrice);
    this.editTripForm.controls['price_taxes'].setValue(trip.price_taxes);
    this.editTripForm.controls['price_tips'].setValue(trip.price_tips);
    this.editTripForm.controls['price_tolls'].setValue(trip.price_tolls);
    this.editTripForm.controls['price_repairs'].setValue(trip.price_repairs);

    console.log(trip.busID);
    console.log( this.editTripForm.controls['busID'].value);
  }

  cancelEdit() {
    this.editableTrip = -1;
  }

  updateTrip() {
    if (!this.editTripForm.valid) { return; }

    this.tripsService.updateTrip(this.editTripForm.value).subscribe(res => {
      this.tripsService.getTrips().subscribe(
        trips => {
          this.trips = trips;

          for (const trip of trips) {
            trip.busName = this.getBusNameFromID(trip.busID);
          }

        }
      );
    });

    this.tripInView = null;
    this.cancelEdit();
  }
}
