import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Project } from '../models/project';
import { environment } from '../../environments/environment';

@Injectable({
  providedIn: 'root',
})
export class ProjectService {

  private readonly apiUrl = `${environment.apiBaseUrl}/projects`;

  constructor(private http: HttpClient) {}

  getProjects(): Observable<Project[]> {
    return this.http.get<Project[]>(this.apiUrl);
  }
}
