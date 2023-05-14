import { Role } from "./role";

export interface User {
  id:number,
  name:string,
  surname:string,
  phoneNumber:string,
  mail:string,
  password:string,
  role:Role,
  
}
