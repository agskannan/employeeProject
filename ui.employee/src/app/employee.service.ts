import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {

  constructor(private http: HttpClient) { }

  getEmployee(id: number){
    return this.http.get("http://localhost:8080/api/v1/employees/"+id);
  }

  createEmployee(employee: Object){
    return this.http.post("http://localhost:8080/api/v1/employees", employee);
  }

  updateEmployee(id: number, value: any){
    return this.http.put("http://localhost:8080/api/v1/employees/"+id, value);
  }

  deleteEmployee(id: number){
    return this.http.delete("http://localhost:8080/api/v1/employees/"+id, { responseType: 'text' });
  }

  getEmployeesList(){
    return this.http.get("http://localhost:8080/api/v1/employees");
  }
}
