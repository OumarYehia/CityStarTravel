import {Component, OnInit} from '@angular/core';
import {BusService} from '../bus.service';
import {Bus} from '../bus.dto';
import {ActivatedRoute} from '@angular/router';

@Component({
  selector: 'app-bus-details',
  templateUrl: './bus-details.component.html',
  styleUrls: ['./bus-details.component.scss'],
  providers: [BusService]
})
export class BusDetailsComponent implements OnInit {

  busID: number;
  bus: Bus;

  constructor(
    private busService: BusService,
    route: ActivatedRoute
  ) {
    this.busID = route.snapshot.params['id'];
  }

  ngOnInit() {
    this.busService.getBus(this.busID).subscribe(
      bus => {
        this.bus = bus;
      }
    );

  }

}
