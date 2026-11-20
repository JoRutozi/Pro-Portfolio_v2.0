import { ChangeDetectorRef, Component, OnInit } from '@angular/core';
import { ProjectService } from '../../services/project';
import { Project } from '../../models/project';

@Component({
  selector: 'app-projects',
  imports: [],
  templateUrl: './projects.html',
  styleUrl: './projects.scss',
})
export class Projects implements OnInit {
  projects: Project[] = [];

  constructor(
    private projectService: ProjectService,
    private changeDetectorRef: ChangeDetectorRef
  ) {}

  ngOnInit(): void {
    this.projectService.getProjects().subscribe({
      next: (data) => {
        this.projects = data;
        this.changeDetectorRef.markForCheck();
      },
      error: (error) => {
        console.error('Failed to load projects:', error);
      }
    });
  }
}
