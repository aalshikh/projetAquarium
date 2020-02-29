import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AnimalespeceComponent } from './animalespece.component';

describe('AnimalespeceComponent', () => {
  let component: AnimalespeceComponent;
  let fixture: ComponentFixture<AnimalespeceComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AnimalespeceComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AnimalespeceComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
