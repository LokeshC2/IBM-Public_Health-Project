import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AboutComponent } from './about/about.component';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { UserComponent } from './user/user.component';
import { SignupComponent } from './signup/signup.component';

const routes: Routes = [
  {path: 'home',component: HomeComponent},
  {path: '', redirectTo: 'home', pathMatch: 'full'},
  {path:'about',component: AboutComponent},
  {path: 'login',component: LoginComponent},
  {path: 'user',component: UserComponent},
  {path: 'signup',component: SignupComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
