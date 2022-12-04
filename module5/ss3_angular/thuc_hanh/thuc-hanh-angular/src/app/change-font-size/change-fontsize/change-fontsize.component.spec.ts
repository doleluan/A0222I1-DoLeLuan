import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ChangeFontsizeComponent } from './change-fontsize.component';

describe('ChangeFontsizeComponent', () => {
  let component: ChangeFontsizeComponent;
  let fixture: ComponentFixture<ChangeFontsizeComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ChangeFontsizeComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ChangeFontsizeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
