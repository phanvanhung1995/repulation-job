import {CV} from "./cv";
import {Orders} from "./orders";

export interface Cart {
  id?: number;
  quantity?: number;
  cv?: CV;
  orders?:Orders;
}
