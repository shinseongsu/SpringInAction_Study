import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TacoCartComponent } from './taco-cart.component';

describe('TacoCartComponent', () => {
  let component: TacoCartComponent;
  let fixture: ComponentFixture<TacoCartComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TacoCartComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TacoCartComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
