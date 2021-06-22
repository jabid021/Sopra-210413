import { Component, OnInit, Input, HostListener } from '@angular/core';

@Component({
  selector: 'asc-tooltip,[asc-tooltip]',
  templateUrl: './asc-tooltip.component.html',
  styleUrls: ['./asc-tooltip.component.css'],
})
export class AscTooltipComponent implements OnInit {
  @Input('asc-tooltip-titre')
  titre: string;

  visible: boolean = false;

  constructor() {}

  ngOnInit(): void {}

  @HostListener('mouseover')
  afficher() {
    this.visible = true;
  }

  @HostListener('mouseleave')
  cacher() {
    this.visible = false;
  }
}
