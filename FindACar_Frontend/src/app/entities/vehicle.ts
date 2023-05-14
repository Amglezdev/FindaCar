import { User } from "./user";

export interface Vehicle {
  id:number,
  brand:string,
  model:string,
  power:number,
  mileage:number,
  type:string,
  age:Date,
  owner:User,
  price:number
}
