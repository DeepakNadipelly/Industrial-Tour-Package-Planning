import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FpadminComponent } from './fpadmin.component';

describe('FpadminComponent', () => {
  let component: FpadminComponent;
  let fixture: ComponentFixture<FpadminComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FpadminComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FpadminComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
