import { Component, OnInit } from '@angular/core';
import { UserService } from '../../service/userService/user.service';
import { Router } from '@angular/router';
import { Statistics } from '../../entities/statistics';

@Component({
  selector: 'app-add-stat',
  templateUrl: './add-stat.component.html',
  styleUrls: ['././../home-page/home-page.component.css']
})
export class AddStatComponent implements OnInit {
  private stat : Statistics;
  constructor(private _userService:UserService ,private _router:Router) { }

  ngOnInit() {
    this.stat = new Statistics();
  }

  addStat()
  {
    this._userService.addStat(this.stat.method).subscribe((flag)=>{
      console.log(flag); 
      if(flag == true)
      {
        window.alert("Statistics method has been added successfully !");
      }
      else
      {
        window.alert("Statistics method allready exists !");
      }
    },(error)=>{
      console.log(error);
    })
  }

}
