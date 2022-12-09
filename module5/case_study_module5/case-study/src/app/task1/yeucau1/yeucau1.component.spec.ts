import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { Yeucau1Component } from './yeucau1.component';

describe('Yeucau1Component', () => {
  let component: Yeucau1Component;
  let fixture: ComponentFixture<Yeucau1Component>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ Yeucau1Component ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(Yeucau1Component);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
