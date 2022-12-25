import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FooterFuramaComponent } from './footer-furama.component';

describe('FooterFuramaComponent', () => {
  let component: FooterFuramaComponent;
  let fixture: ComponentFixture<FooterFuramaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FooterFuramaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FooterFuramaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
