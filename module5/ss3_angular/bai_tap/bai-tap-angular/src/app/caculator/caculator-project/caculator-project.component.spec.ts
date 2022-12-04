import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CaculatorProjectComponent } from './caculator-project.component';

describe('CaculatorProjectComponent', () => {
  let component: CaculatorProjectComponent;
  let fixture: ComponentFixture<CaculatorProjectComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CaculatorProjectComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CaculatorProjectComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
