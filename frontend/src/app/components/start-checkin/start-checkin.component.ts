import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-start-checkin',
  templateUrl: './start-checkin.component.html',
  styleUrls: ['./start-checkin.component.css']
})
export class StartCheckinComponent implements OnInit {

  constructor(private router: Router) { }

  ngOnInit() {
  }

  onSelect(id: Number) {
    this.router.navigate(['/checkIn', id]);
  }

}
