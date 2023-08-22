import { RolResponse } from "./rol-response";

export interface LoginResponse {

  email:string;
  token:string;
  rol:RolResponse;
}
