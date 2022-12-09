import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ChooseStarChildComponent } from './choose-star-child.component';

describe('ChooseStarChildComponent', () => {
  let component: ChooseStarChildComponent;
  let fixture: ComponentFixture<ChooseStarChildComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ChooseStarChildComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ChooseStarChildComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
