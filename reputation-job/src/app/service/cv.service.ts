import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {CvDto} from "../dto/cv-dto";

@Injectable({
  providedIn: 'root'
})
export class CVService {

  constructor(private httpClient: HttpClient) {
  }


  getCV(name: string, page: number): Observable<Page<CvDto>> {
    return this.httpClient.get<Page<CvDto>>('http://localhost:8080/api/candidate/cv/list?name=' + name + '&page=' + page);
  }

  findCVById(id: number): Observable<CvDto> {
    return this.httpClient.get<CvDto>('http://localhost:8080/api/candidate/cv/list/' + id);
  }
}


export interface Page<T> {
  content: T[];
  pageable: {
    sort: {
      sorted: boolean;
      unsorted: boolean;
    };
    pageNumber: number;
    pageSize: number;
    offset: number;
    unpaged: boolean;
  };
  totalPages: number;
  totalElements: number;
  last: boolean;
  size: number;
  number: number;
  sort: {
    sorted: boolean;
    unsorted: boolean;
  };
  numberOfElements: number;
  first: boolean;
  empty: boolean;
}
