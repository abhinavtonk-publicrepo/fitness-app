import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomepageComponent } from './homepage/homepage.component';
import { GlobalheaderComponent } from './globalheader/globalheader.component';
import { TrainerComponent } from './trainer/trainer.component';
import { TraineeComponent } from './trainee/trainee.component';
import { PagenotfoundComponent } from './pagenotfound/pagenotfound.component';
import { GlobalfooterComponent } from './globalfooter/globalfooter.component';

@NgModule({
  declarations: [
    AppComponent,
    HomepageComponent,
    GlobalheaderComponent,
    TrainerComponent,
    TraineeComponent,
    PagenotfoundComponent,
    GlobalfooterComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
