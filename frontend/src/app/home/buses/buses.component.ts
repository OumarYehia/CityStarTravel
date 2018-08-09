import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-buses',
  templateUrl: './buses.component.html',
  styleUrls: ['./buses.component.scss']
})
export class BusesComponent implements OnInit {

  buses = [
    {
      name: 'أتوبيس الأحلام',
      licencePlate: {
        numbers: 123,
        letters: 'ا ب ت'
      }
    },
    {
      name: 'أتوبيس الإخوة',
      licencePlate: {
        numbers: 123,
        letters: 'ب ك ا'
      }
    },
    {
      name: 'أتوبيس الهنا',
      licencePlate: {
        numbers: 123,
        letters: 'ا ب ت'
      }
    },
    {
      name: 'أتوبيس رايح راجع',
      licencePlate: {
        numbers: 123,
        letters: 'ا ب ت'
      }
    },
    {
      name: 'أتوبيس الهنا 2',
      licencePlate: {
        numbers: 123,
        letters: 'ا ب ت'
      }
    },
    {
      name: 'أتوبيس الإخوة 2',
      licencePlate: {
        numbers: 123,
        letters: 'ا ب ت'
      }
    },
    {
      name: 'أتوبيس الأحلام 3',
      licencePlate: {
        numbers: 123,
        letters: 'ا ب ت'
      }
    }

  ];

  constructor() { }

  ngOnInit() {
  }

}
