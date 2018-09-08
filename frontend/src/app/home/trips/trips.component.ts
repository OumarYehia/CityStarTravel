import { Component, OnInit } from '@angular/core';
import {ActivatedRoute} from '@angular/router';
import {Trip} from './trips';
import {TripsService} from './trips.service';
import {BusesService} from '../buses/buses.service';
import {Bus} from '../buses/bus';

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

  tripInView: Trip;

  trips: Trip[];
  buses: Bus[];

  constructor(
    private tripsService: TripsService,
    private busesService: BusesService,
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

}
