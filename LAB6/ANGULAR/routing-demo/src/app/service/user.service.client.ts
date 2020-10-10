import {Injectable} from "@angular/core";

@Injectable()
export class UserService{
  users = [
    {_id:1, username: 'hemant', password: '123'},
    {_id:2, username: 'jack', password: '456'}
  ]

  findUser(username: String, password: String){
    for(let i=0; i<this.users.length; i++){
      const user = this.users[i];
      if(username === user.username && password === user.password){
        return user;
      }
    }
    return null;
  }

  findUserById(id: String){
    for(let i=0; i<this.users.length; i++){
      const user = this.users[i];
      if(id === user._id.toString()){
        return user;
      }
    }
    return null;
  }

}
