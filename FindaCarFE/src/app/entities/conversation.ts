import { User } from "./user";

export interface Conversation {
  id:number,
  sender:User,
  reciever:User
}
