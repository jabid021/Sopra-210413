import { Directive, ElementRef, Renderer2, OnInit, Input } from '@angular/core';

@Directive({
  selector: '[appRouge]',
})
export class RougeDirective implements OnInit {
  @Input()
  couleur: string = 'red';
  constructor(private el: ElementRef, private renderer: Renderer2) {}

  ngOnInit(): void {
    console.log(this.el.nativeElement);
    this.renderer.setStyle(this.el.nativeElement, 'color', this.couleur);
  }
}
