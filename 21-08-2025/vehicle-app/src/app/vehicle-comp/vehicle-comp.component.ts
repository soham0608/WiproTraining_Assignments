import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { VehicleService } from '../vehicle.service';
import { Vehicle } from '../vehicle';

@Component({
  selector: 'app-vehicle-comp',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './vehicle-comp.component.html',
  styleUrls: ['./vehicle-comp.component.css']
})
export class VehicleCompComponent implements OnInit {
  vehicles: Vehicle[] = [];
  newVehicle: Vehicle = { make: '', fuelType: '', model: '', price: 0 };
  editMode = false;

  constructor(private vehicleService: VehicleService) {}

  ngOnInit(): void {
    this.loadVehicles();
  }

  loadVehicles(): void {
    this.vehicleService.getVehicles().subscribe(data => {
      this.vehicles = data;
    });
  }

  addVehicle(): void {
    this.vehicleService.addVehicle(this.newVehicle).subscribe(() => {
      this.loadVehicles();
      this.newVehicle = { make: '', fuelType: '', model: '', price: 0 };
    });
  }

  editVehicle(vehicle: Vehicle): void {
    this.editMode = true;
    this.newVehicle = { ...vehicle }; // copy for editing
  }

  updateVehicle(): void {
    if (this.newVehicle.id) {
      this.vehicleService.updateVehicle(this.newVehicle).subscribe(() => {
        this.loadVehicles();
        this.newVehicle = { make: '', fuelType: '', model: '', price: 0 };
        this.editMode = false;
      });
    }
  }

  deleteVehicle(id: number | undefined): void {
    if (id) {
      this.vehicleService.deleteVehicle(id).subscribe(() => {
        this.loadVehicles();
      });
    }
  }
}
