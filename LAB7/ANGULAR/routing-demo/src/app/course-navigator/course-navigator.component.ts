import { Component, OnInit } from '@angular/core';
import {CourseService} from "../../servies/CourseService";

@Component({
  selector: 'app-course-navigator',
  templateUrl: './course-navigator.component.html',
  styleUrls: ['./course-navigator.component.css']
})
export class CourseNavigatorComponent implements OnInit {
  courses: any;
  selectedCourse = {
    id: String,
    modules: []
  };
  selectedModule = {
    id: String,
    lessons: []
  };
  selectedLesson = {
    id: String
  };

  constructor(private courseService: CourseService) { }

  ngOnInit(): void {
    this.courseService.findAllCourses().then(courses => this.courses = courses);
  }

  selectCourse(course: never){
    this.selectedCourse = course;
  }

  selectModule(module: never){
    this.selectedModule = module;
  }

  selectLesson(lesson: never){
    this.selectedLesson = lesson;
  }

}
