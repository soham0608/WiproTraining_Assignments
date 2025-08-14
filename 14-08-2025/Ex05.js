class Vehicle 
{
    constructor(make, model, year) {
        this.make = make;
        this.model = model;
        this.year = year;
    }

    getInfo() 
    {
        return `${this.make} ${this.model} (${this.year})`;
    }
}

class Car extends Vehicle 
{
    constructor(make, model, year, numDoors) {
        super(make, model, year);
        this.numDoors = numDoors;
    }

    getInfo() 
    {
        return `${super.getInfo()}, Doors: ${this.numDoors}`;
    }
}

const myCar = new Car('BMW', 'X5', 2021, 4);
console.log(myCar.getInfo()); 