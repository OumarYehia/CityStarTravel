import {Component, OnInit} from '@angular/core';
import {WarehouseManagementService} from './warehouse-management.service';
import {Order, SparePart, SpareType, SparePartsLegendItem} from './warehouse-management';
import {ActivatedRoute, Router} from '@angular/router';
import {FormBuilder, FormControl, FormGroup, Validators} from '@angular/forms';
import {Observable} from 'rxjs';
import {map, startWith} from 'rxjs/operators';
import {Bus} from '../buses/bus';
import {BusesService} from '../buses/buses.service';


@Component({
  selector: 'app-warehouse-management',
  templateUrl: './warehouse-management.component.html',
  styleUrls: ['./warehouse-management.component.scss']
})
export class WarehouseManagementComponent implements OnInit {

  displayedColumns: string[] = [
    'spareName',
    'busName',
    'actions'
  ];
  spareTypesDisplayedColumns: string[] = ['spareTypeName', 'quantityAllocated', 'quantityAvailable'];
  spareParts: SparePart[];
  spareTypes: SpareType[];
  orders: Order[];
  sparePartsLegendItems: SparePartsLegendItem[];

  legendDataReady: boolean;

  buses: Bus[];

  busID: number;

  newSpareForm: FormGroup;
  newSpareTypeForm: FormGroup;

  addingNewSpare: boolean;
  addingNewSpareType: boolean;
  newSpareType: string;

  editableSpare: SparePart;
  editableSpareBusID: number;

  // filteredOptions: Observable<SpareType[]>;

  constructor(
    private warehouseManagementService: WarehouseManagementService,
    private busesService: BusesService,
    private route: ActivatedRoute,
    private router: Router,
    private fb: FormBuilder
  ) {
    this.busID = undefined;
    this.editableSpare = null;
    this.route.params.subscribe(params => {
      this.busID = params['id'];
      console.log(params['id']);
      // if (this.busID === undefined) { this.displayedColumns.push('actions'); }
    });
  }

  getSpareParts() {
    if (this.busID == undefined) {
      console.log('getting all');
      this.warehouseManagementService.getAllSpares().subscribe(
        spares => {
          this.spareParts = spares;
          console.log(this.spareParts);
        });
    } else {
      this.warehouseManagementService.getSpareByID(this.busID).subscribe(
        spares => {
          this.spareParts = spares;
        }
      );
    }
  }

  getLegendData() {
    this.warehouseManagementService.getAllSparePartsLegend().subscribe(
      legend => {
        this.sparePartsLegendItems = legend;
        this.legendDataReady = true;
      }
    );
  }

  getBuses() {
    this.busesService.getBuses().subscribe(buses => {
      this.buses = buses;
    });
  }

  ngOnInit() {
    this.legendDataReady = false;
    this.addingNewSpare = false;
    this.addingNewSpareType = false;

    this.getSpareParts();
    this.getLegendData();
    this.getBuses();

    this.warehouseManagementService.getSpareTypes().subscribe(
      spareTypes => {
        this.spareTypes = spareTypes;
        console.log(this.spareTypes);
      }
    );

    this.warehouseManagementService.getOrders().subscribe(
      orders => {
        this.orders = orders;
        console.log(this.orders);
      }
    );

    this.newSpareTypeForm = this.fb.group({
      name: ['', Validators.required]
    });

    this.newSpareForm = this.fb.group({
      spareName: ['', Validators.required],
      spareTypeID: ['', Validators.required],
      orderID: ['', Validators.required],
      busID: ''
    });

    // this.filteredOptions = this.newSpareForm.valueChanges
    //   .pipe(
    //     startWith<string | SpareType>(''),
    //     map(value => typeof value === 'string' ? value : value.name),
    //     map(name => name ? this._filter(name) : this.spareTypes.slice())
    //   );

  }

  addSparePart() {
    console.log('adding');
    this.newSpareForm.controls['busID'].setValue('-1');
    console.log(this.newSpareForm.value);
    this.addingNewSpare = false;
    this.warehouseManagementService.addSparePart(this.newSpareForm.value).subscribe(
      data => {
        this.newSpareForm.reset();
        this.getSpareParts();
      }
    );
  }

  addSpareType() {
    if (!this.newSpareTypeForm.valid) {
      return;
    }

    this.warehouseManagementService.addSpareType(this.newSpareTypeForm.value).subscribe(res => {
      this.warehouseManagementService.getSpareTypes().subscribe(
        spareTypes => {
          this.spareTypes = spareTypes;
        }
      );
    });
  }

  // displayFn(spareType?: SpareType): string | undefined {
  //   return spareType ? spareType.name : undefined;
  // }
  //
  //
  // private _filter(name: string): SpareType[] {
  //   const filterValue = name;
  //
  //   console.log('filter');
  //   console.log(name);
  //   // console.log(this.spareTypes.filter(option => option.name.indexOf(filterValue) === 0));
  //
  //   return this.spareTypes.filter(option => option.name.indexOf(filterValue) === 0);
  // }

  assign(spare: SparePart) {
    this.editableSpare = spare;
  }

  editSpare() {
    this.warehouseManagementService.editSparePart(this.editableSpare).subscribe(res => {
        this.getSpareParts();
        this.getLegendData();
        this.editableSpare = null;
      }
    );
  }

  sendToWarehouse(spare: SparePart) {
    spare.busID = -1;
    this.warehouseManagementService.editSparePart(spare).subscribe(res => {
        this.getSpareParts();
        this.getLegendData();
      }
    );
  }

  navigateToBusSpare(busID: number) {
    console.log('clicked');
    if (this.busID === undefined) {
      console.log('undefined');
      this.router.navigate(['', busID]);
    }
  }

}


