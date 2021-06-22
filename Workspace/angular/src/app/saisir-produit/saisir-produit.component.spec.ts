import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SaisirProduitComponent } from './saisir-produit.component';

describe('SaisirProduitComponent', () => {
  let component: SaisirProduitComponent;
  let fixture: ComponentFixture<SaisirProduitComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SaisirProduitComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(SaisirProduitComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
