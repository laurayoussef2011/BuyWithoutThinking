import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpModule } from '@angular/http';
import { FormsModule } from '@angular/forms';

import { StoreService } from './service/storeService/store.service';
import { BrandService } from './service/brandService/brand.service';
import { ProductService } from './service/productService/product.service';
import { UserService } from './service/userService/user.service';



import { AppComponent } from './app.component';
import { RegisterComponent } from './components/register/register.component';
import { LoginComponent } from './components/login/login.component';
import { Routes, RouterModule } from '@angular/router';


import { HomePageComponent } from './components/home-page/home-page.component';
import { AdminPageComponent } from './components/admin-page/admin-page.component';
import { StoreOwnerPageComponent } from './components/store-owner-page/store-owner-page.component';
import { NormalUserPageComponent } from './components/normal-user-page/normal-user-page.component';
import { AddProductComponent } from './components/add-product/add-product.component';
import { AddSystemProductComponent } from './components/add-system-product/add-system-product.component';
import { AddBrandComponent } from './components/add-brand/add-brand.component';
import { AutoguardGuard } from './autoguard.guard';
import { AddStoreComponent } from './components/add-store/add-store.component';
import { StoreProductsComponent } from './components/store-products/store-products.component';
import { ProductInfoComponent } from './components/product-info/product-info.component';
import { ShowStatComponent } from './components/show-stat/show-stat.component';
import { CollaboratorComponent } from './components/collaborator/collaborator.component';
import { AddCollaboratorComponent } from './components/add-collaborator/add-collaborator.component';
import { ShowCollaboratorsComponent } from './components/show-collaborators/show-collaborators.component';
import { ShowHistoryComponent } from './components/show-history/show-history.component';
import { BuyProductComponent } from './components/buy-product/buy-product.component';
import { SystemProductService } from './service/system-product-service/system-product.service';
import { AddStatComponent } from './components/add-stat/add-stat.component';


const appRoutes: Routes = [
{ path: 'appTest', component: AppComponent },
  {path:'',component:HomePageComponent},
  {path:'register',component:RegisterComponent},
  {path:'login',component:LoginComponent},
  {path:'adminPage', canActivate: [AutoguardGuard],component:AdminPageComponent},
  {path:'storeOwnerPage', canActivate: [AutoguardGuard],component:StoreOwnerPageComponent},
  {path:'normalUserPage', canActivate: [AutoguardGuard],component:NormalUserPageComponent},
  {path:'collaboratorPage', canActivate: [AutoguardGuard],component:CollaboratorComponent},
  {path:'addProduct', canActivate: [AutoguardGuard],component:AddProductComponent},
  {path:'addSystemProduct', canActivate: [AutoguardGuard],component:AddSystemProductComponent},
  {path:'addBrand', canActivate: [AutoguardGuard],component:AddBrandComponent},
  {path:'addStore', canActivate: [AutoguardGuard],component:AddStoreComponent},
  {path:'storeProducts', canActivate: [AutoguardGuard],component:StoreProductsComponent},
  {path:'productInfo', canActivate: [AutoguardGuard],component:ProductInfoComponent},
  {path:'showStats', canActivate: [AutoguardGuard],component:ShowStatComponent},
  {path:'showCollaborators', canActivate: [AutoguardGuard],component:ShowCollaboratorsComponent},
  {path:'addCollaborator', canActivate: [AutoguardGuard],component:AddCollaboratorComponent},
  {path:'showHistory', canActivate: [AutoguardGuard],component:ShowHistoryComponent},
  {path:'buyProduct', canActivate: [AutoguardGuard],component:BuyProductComponent},
  {path:'addStat', canActivate: [AutoguardGuard],component:AddStatComponent}
  
];



@NgModule({
  declarations: [
    AppComponent,
    HomePageComponent,
    RegisterComponent,
    LoginComponent,
    AdminPageComponent,
    StoreOwnerPageComponent,
    NormalUserPageComponent,
    AddProductComponent,
    AddSystemProductComponent,
    AddBrandComponent,
    AddStoreComponent,
    StoreProductsComponent,
    ProductInfoComponent,
    ShowStatComponent,
    CollaboratorComponent,
    AddCollaboratorComponent,
    ShowCollaboratorsComponent,
    ShowHistoryComponent,
    BuyProductComponent,
    AddStatComponent,
    
  
    
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    RouterModule.forRoot(
      appRoutes,
      { enableTracing: true } // <-- debugging purposes only
    )
    
  ],
  providers: [BrandService,ProductService,StoreService,SystemProductService,UserService, AutoguardGuard],
  bootstrap: [AppComponent]
})
export class AppModule { }
