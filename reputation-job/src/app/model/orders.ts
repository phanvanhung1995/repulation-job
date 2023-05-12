import {Candidate} from "./candidate";

export interface Orders {
  id?: number;
  date?: string;
  isPaid?:string;
  orderCoder?:string;
  candidate?:Candidate
}
