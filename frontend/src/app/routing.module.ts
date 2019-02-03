import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { StartCheckinComponent } from './components/start-checkin/start-checkin.component';
import { CheckinComponent } from './components/checkin/checkin.component';
import { ConfirmCheckinComponent } from './components/confirm-checkin/confirm-checkin.component';

const routes: Routes = [
    {
        path: '',
        redirectTo: '',
        pathMatch: 'full'
    },
    {
        path: 'checkin',
        component: StartCheckinComponent
    }, {
        path: 'checkin/:id',
        component: CheckinComponent
    }, {
        path: 'confirm',
        component: ConfirmCheckinComponent
    }

];

@NgModule({
    declarations: [],
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule],
    providers: [],
})

export class AppRouterModule { }