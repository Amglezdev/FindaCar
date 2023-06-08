import { User } from "./user";
import { VehicleType } from "./vehicle-type";

export interface Vehicle {
  id:number,
  brand:string,
  model:string,
  power:number,
  mileage:number,
  type:VehicleType,
  age:Date,
  owner:User,
  price:number
}
