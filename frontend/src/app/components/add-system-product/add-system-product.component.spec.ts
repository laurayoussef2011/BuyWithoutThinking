import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AddSystemProductComponent } from './add-system-product.component';

describe('AddSystemProductComponent', () => {
  let component: AddSystemProductComponent;
  let fixture: ComponentFixture<AddSystemProductComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AddSystemProductComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AddSystemProductComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
