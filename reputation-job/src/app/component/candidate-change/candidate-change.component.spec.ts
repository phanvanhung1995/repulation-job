import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CandidateChangeComponent } from './candidate-change.component';

describe('CandidateChangeComponent', () => {
  let component: CandidateChangeComponent;
  let fixture: ComponentFixture<CandidateChangeComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CandidateChangeComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CandidateChangeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
