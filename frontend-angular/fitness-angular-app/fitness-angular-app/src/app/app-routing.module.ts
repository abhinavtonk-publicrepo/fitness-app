import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomepageComponent } from './homepage/homepage.component';
import { PagenotfoundComponent } from './pagenotfound/pagenotfound.component';
import { TraineeComponent } from './trainee/trainee.component';
import { TrainerComponent } from './trainer/trainer.component';

const routes: Routes = [
  {
    component: TrainerComponent,
    path: 'trainers'
  },
  {
    component: TraineeComponent,
    path: 'trainees'
  },
  {
    component: HomepageComponent,
    path: ''
  },
  {
    component: HomepageComponent,
    path: 'homepage'
  },
  {
    component: PagenotfoundComponent,
    path: '**'
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
