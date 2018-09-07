import { Component, OnInit } from '@angular/core';
import {WarehouseManagementService} from '../warehouse-management/warehouse-management.service';
import {ActivatedRoute} from '@angular/router';
import {Trips} from './trips';
import {TripsService} from './trips.service';

@Component({
  selector: 'app-trips',
  templateUrl: './trips.component.html',
  styleUrls: ['./trips.component.scss']
})
export class TripsComponent implements OnInit {


  displayedColumns: string[] = [
    'destination',
    'quantity',
    'busName'
  ];

  trips: Trips[];

  constructor(
    private tripsService: TripsService,
    private route: ActivatedRoute
  ) { }

  ngOnInit() {

  }

}
