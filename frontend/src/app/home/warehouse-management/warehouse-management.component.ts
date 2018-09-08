import { Component, OnInit } from '@angular/core';
import {WarehouseManagementService} from './warehouse-management.service';
import {SparePart} from './warehouse-management';
import {ActivatedRoute} from '@angular/router';

@Component({
  selector: 'app-warehouse-management',
  templateUrl: './warehouse-management.component.html',
  styleUrls: ['./warehouse-management.component.scss']
})
export class WarehouseManagementComponent implements OnInit {

  displayedColumns: string[] = ['spareName', 'quantity', 'busName'];

  spareParts: SparePart[];

  busID: number;

  constructor(
    private warehouseManagementService: WarehouseManagementService,
    private route: ActivatedRoute
  ) {
    this.busID = undefined;
    this.route.params.subscribe( params => {
      this.busID = params['id'];
      console.log(params);
    } );
  }

  ngOnInit() {
    console.log(this.busID);

    if (this.busID == undefined) {
      console.log("getting all");
      this.warehouseManagementService.getAllSpares().subscribe(
        spares => {
          this.spareParts = spares;
        });
    } else {
      this.warehouseManagementService.getSpareByID(this.busID).subscribe(
        spares => {
          this.spareParts = spares;
        }
      );
    }
  }
}

