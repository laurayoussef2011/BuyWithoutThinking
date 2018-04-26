import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ShowStatComponent } from './show-stat.component';

describe('ShowStatComponent', () => {
  let component: ShowStatComponent;
  let fixture: ComponentFixture<ShowStatComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ShowStatComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ShowStatComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
