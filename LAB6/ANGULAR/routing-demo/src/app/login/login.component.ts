import { Component, OnInit } from '@angular/core';
import {Router} from "@angular/router";
import {UserService} from "../service/user.service.client";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  username: String;
  password: String;

  constructor(private router: Router, private userService: UserService) { }

  ngOnInit(): void {
  }

  login(username, password){
    console.log(username, password);
    const user = this.userService.findUser(username, password);
    if(user != null){
      this.router.navigate(['/profile', user._id]);
    }
  }

}
