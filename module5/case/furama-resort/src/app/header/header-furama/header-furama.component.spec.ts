import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { HeaderFuramaComponent } from './header-furama.component';

describe('HeaderFuramaComponent', () => {
  let component: HeaderFuramaComponent;
  let fixture: ComponentFixture<HeaderFuramaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ HeaderFuramaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(HeaderFuramaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
