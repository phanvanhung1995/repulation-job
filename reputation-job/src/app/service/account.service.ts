import { Injectable } from '@angular/core';
import {Observable} from 'rxjs';
import {HttpClient} from '@angular/common/http';
import {Candidate} from "../dto/candidate";

@Injectable({
  providedIn: 'root'
})
export class AccountService {

  constructor(private httpClient: HttpClient) { }
  getAllAccount(): Observable<any> {
    return this.httpClient.get<Account[]>('http://localhost:8080/api/public/admin/account');
  }

  findCandidateById(id: number): Observable<Candidate> {
    return this.httpClient.get<Candidate>('http://localhost:8080/api/candidate/list/' + id);
  }


  updateCandidate(candidate: Candidate): Observable<Candidate> {
    return this.httpClient.patch('http://localhost:8080/api/candidate/update/' ,candidate);
  }

}
