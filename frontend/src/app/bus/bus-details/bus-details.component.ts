import {Component, OnInit} from '@angular/core';
import {BusService} from '../bus.service';
import {Bus} from '../bus.dto';

@Component({
  selector: 'app-bus-details',
  templateUrl: './bus-details.component.html',
  styleUrls: ['./bus-details.component.scss'],
  providers: [BusService]
})
export class BusDetailsComponent implements OnInit {

  bus: Bus;

  constructor(
    private busService: BusService
  ) { }

  ngOnInit() {
    this.busService.getBus(1).subscribe(
      bus => {
        this.bus = bus;
        console.log(bus);
      }
    );

  }

}
