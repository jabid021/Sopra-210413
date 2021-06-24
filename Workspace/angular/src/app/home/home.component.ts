import { FakeDemoService } from './../services/fake-demo.service';
import { DemoService } from '../services/demo.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css'],
  providers: [{ provide: DemoService, useClass: DemoService }],
})
export class HomeComponent implements OnInit {
  message: string;

  constructor(private monService: DemoService) {}

  ngOnInit(): void {
    this.message = this.monService.hello();
  }
}
