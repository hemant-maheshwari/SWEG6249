import { Component, OnInit } from '@angular/core';
import {CourseService} from "../../servies/CourseService";

@Component({
  selector: 'app-course-navigator',
  templateUrl: './course-navigator.component.html',
  styleUrls: ['./course-navigator.component.css']
})
export class CourseNavigatorComponent implements OnInit {
  courses: any;

  constructor(private courseService: CourseService) { }

  ngOnInit(): void {
    this.courseService.findAllCourses().then(courses => this.courses = courses);
  }

}
