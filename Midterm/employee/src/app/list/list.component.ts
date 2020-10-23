import { Component, OnInit } from '@angular/core';
import {EmployeeService} from '../../service/EmployeeService';

@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.css']
})
export class ListComponent implements OnInit {
  public employees: any;
  constructor(private employeeService: EmployeeService) { }

  ngOnInit(): void {
    this.employeeService.findAllEmployees().then(employees => this.employees = employees);
  }

}
