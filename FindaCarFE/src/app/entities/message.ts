import { User } from "./user";

export interface Message {
  id:number,
  sender:User,
  reciever:User,
  content:string
}
