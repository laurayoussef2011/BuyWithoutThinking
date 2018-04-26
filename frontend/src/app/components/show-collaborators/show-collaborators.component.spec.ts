import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ShowCollaboratorsComponent } from './show-collaborators.component';

describe('ShowCollaboratorsComponent', () => {
  let component: ShowCollaboratorsComponent;
  let fixture: ComponentFixture<ShowCollaboratorsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ShowCollaboratorsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ShowCollaboratorsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
