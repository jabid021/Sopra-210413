import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AfficherProduitTableauComponent } from './afficher-produit-tableau.component';

describe('AfficherProduitTableauComponent', () => {
  let component: AfficherProduitTableauComponent;
  let fixture: ComponentFixture<AfficherProduitTableauComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AfficherProduitTableauComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AfficherProduitTableauComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
