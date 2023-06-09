import { Role } from "./role";

export interface User {
  id:number,
  name:string,
  surname:string,
  phoneNumber:string,
  mail:string,
  password:string,
  rol:Role,
  security:string,
}
