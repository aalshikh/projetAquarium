import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { BandebiodiversiteComponent } from './bandebiodiversite.component';

describe('BandebiodiversiteComponent', () => {
  let component: BandebiodiversiteComponent;
  let fixture: ComponentFixture<BandebiodiversiteComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ BandebiodiversiteComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(BandebiodiversiteComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
