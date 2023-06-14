import { Conversation } from "./conversation";
import { User } from "./user";

export interface Message {
  id:number,
  conversation:Conversation,
  content:string
}
