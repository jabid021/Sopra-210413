import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TestParametreComponent } from './test-parametre.component';

describe('TestParametreComponent', () => {
  let component: TestParametreComponent;
  let fixture: ComponentFixture<TestParametreComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TestParametreComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(TestParametreComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
