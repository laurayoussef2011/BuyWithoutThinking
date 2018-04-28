import { Component, OnInit } from '@angular/core';
import { Brand } from '../../entities/brand';
import { BrandService } from '../../service/brandService/brand.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-add-brand',
  templateUrl: './add-brand.component.html',
  styleUrls: ['././../home-page/home-page.component.css']
})
export class AddBrandComponent implements OnInit {
  private brand : Brand;

  constructor(private _brandService:BrandService ,private _router:Router) { }

  ngOnInit() {
    this.brand = new Brand();
  }

  addBrand(){
    this._brandService.createBrand(this.brand).subscribe((flag)=>{
      console.log(flag); 
      if(flag == true)
      {
        window.alert("Brand has been added successfully !");
      }
      else
      {
        window.alert("Brand allready exists !");
      }
    },(error)=>{
      console.log(error);
    })
  }

}
