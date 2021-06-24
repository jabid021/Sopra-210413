import { TestBed } from '@angular/core/testing';

import { ProduitLocalService } from './produit-local.service';

describe('ProduitLocalService', () => {
  let service: ProduitLocalService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ProduitLocalService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
