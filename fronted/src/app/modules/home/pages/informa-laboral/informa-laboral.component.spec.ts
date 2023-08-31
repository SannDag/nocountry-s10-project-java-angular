import { ComponentFixture, TestBed } from '@angular/core/testing';

import { InformaLaboralComponent } from './informa-laboral.component';

describe('InformaLaboralComponent', () => {
  let component: InformaLaboralComponent;
  let fixture: ComponentFixture<InformaLaboralComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [InformaLaboralComponent]
    });
    fixture = TestBed.createComponent(InformaLaboralComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
