package com.wipro.vehiclelog.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "vehicle")
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int vehId;
    private double lat;
    private double longitude;

    public int getVehId() {
        return vehId;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

	public Vehicle(int vehId, double lat, double longitude) {
		super();
		this.vehId = vehId;
		this.lat = lat;
		this.longitude = longitude;
	}

	public Vehicle() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Vehicle [vehId=" + vehId + ", lat=" + lat + ", longitude=" + longitude + "]";
	}
    
    
}
