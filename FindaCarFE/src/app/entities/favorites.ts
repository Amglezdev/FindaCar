import { User } from "./user";
import { Vehicle } from "./vehicle";

export interface Favorites{
  id:number,
  user:User,
  vehicle:Vehicle,
}
