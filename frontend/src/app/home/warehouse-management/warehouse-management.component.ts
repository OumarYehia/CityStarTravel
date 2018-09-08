import { Component, OnInit } from '@angular/core';
import {WarehouseManagementService} from './warehouse-management.service';
import {SparePart, SpareType} from './warehouse-management';
import {ActivatedRoute} from '@angular/router';
import {FormBuilder, FormControl, FormGroup, Validators} from '@angular/forms';
import {Observable} from 'rxjs';
import {map, startWith} from 'rxjs/operators';

@Component({
  selector: 'app-warehouse-management',
  templateUrl: './warehouse-management.component.html',
  styleUrls: ['./warehouse-management.component.scss']
})
export class WarehouseManagementComponent implements OnInit {

  displayedColumns: string[] = ['spareName', 'quantity', 'busName'];

  spareParts: SparePart[];
  spareTypes: SpareType[];

  busID: number;

  newSpareForm: FormGroup;

  addingNewSpare: boolean;

  filteredOptions: Observable<SpareType[]>;


  constructor(
    private warehouseManagementService: WarehouseManagementService,
    private route: ActivatedRoute,
    private fb: FormBuilder
  ) {
    this.busID = undefined;
    this.route.params.subscribe( params => {
      this.busID = params['id'];
      console.log(params);
    } );
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

  ngOnInit() {
    this.addingNewSpare = false;

    this.getSpareParts();

    this.warehouseManagementService.getSpareTypes().subscribe(
      spareTypes => {
        this.spareTypes = spareTypes;
        console.log(this.spareTypes);
      }
    );

    this.newSpareForm = this.fb.group({
      spareName: ['', Validators.required],
      spareTypeID: ['', Validators.required],
      quantity: ['', Validators.required]
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
    console.log(this.newSpareForm.value);
    this.addingNewSpare = false;
    this.warehouseManagementService.addSparePart(this.newSpareForm.value).subscribe(
      data => {
        this.newSpareForm.reset();
        this.getSpareParts();
      }
    );
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

}

