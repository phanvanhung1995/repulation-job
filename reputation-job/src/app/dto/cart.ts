import {CV} from "../model/cv";
import {Orders} from "../model/orders";

export interface Cart {
  id?: number;
  quantity?: number;
  filePath?:string;
  price?:number;
}
