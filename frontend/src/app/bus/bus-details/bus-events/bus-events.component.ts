import {Component, OnInit} from '@angular/core';
import {BusEvent, BusEventType} from '../../bus.dto';
import {BusService} from '../../bus.service';
import {ActivatedRoute} from '@angular/router';

@Component({
  selector: 'app-bus-events',
  templateUrl: './bus-events.component.html',
  styleUrls: ['./bus-events.component.scss'],
  providers: [BusService]
})
export class BusEventsComponent implements OnInit {

  busID: number;
  EVENT_TYPES = BusEventType;
  events: BusEvent[] = [];

  constructor(
    private busService: BusService,
    route: ActivatedRoute
  ) {
    this.busID = route.parent.snapshot.params['id'];
  }

  ngOnInit() {
    this.busService.getBusEvents(this.busID).subscribe(
      events => {
        this.events = events;
      }
    );
  }

}
