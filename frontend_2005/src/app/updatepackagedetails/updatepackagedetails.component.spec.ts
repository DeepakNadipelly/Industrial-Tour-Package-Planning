import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdatepackagedetailsComponent } from './updatepackagedetails.component';

describe('UpdatepackagedetailsComponent', () => {
  let component: UpdatepackagedetailsComponent;
  let fixture: ComponentFixture<UpdatepackagedetailsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UpdatepackagedetailsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UpdatepackagedetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
