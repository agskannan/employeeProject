import { Component, OnInit } from '@angular/core';
import { Employee } from "./../employee";
import { Observable } from "rxjs";
import { EmployeeService } from '../employee.service';

@Component({
  selector: 'app-employee-list',
  templateUrl: './employee-list.component.html',
  styleUrls: ['./employee-list.component.css']
})
export class EmployeeListComponent implements OnInit {
  employees: any;
  constructor(private employeeService: EmployeeService) { }

  ngOnInit() {
    this.reloadData();
  }
  reloadData() {
    this.employeeService.getEmployeesList().subscribe(item=>{
      this.employees=[...item]
    });
    console.log(this.employees);
  }

  deleteEmployee(id: number) {
    this.employeeService.deleteEmployee(id)
      .subscribe(
        data => {
          console.log(data);
          this.reloadData();
        },
        error => console.log(error));
  }

}
