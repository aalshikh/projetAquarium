import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FondanimeComponent } from './fondanime.component';

describe('FondanimeComponent', () => {
  let component: FondanimeComponent;
  let fixture: ComponentFixture<FondanimeComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FondanimeComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FondanimeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
