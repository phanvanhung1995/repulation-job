import {Position} from "./position";
import {Img} from "./img";

export interface CV {
  id?: number;
  name?: string;
  description?: string;
  filePath?: string;
  price?: number;
  position?: Position;
  img?: Img;
}
