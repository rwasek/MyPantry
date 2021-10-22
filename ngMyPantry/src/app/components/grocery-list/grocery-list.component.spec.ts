import { HttpClient, HttpHandler } from '@angular/common/http';
import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing';
import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { RouterTestingModule } from '@angular/router/testing';

import { GroceryListComponent } from './grocery-list.component';

fdescribe('GroceryListComponent', () => {
  let component: GroceryListComponent;
  let fixture: ComponentFixture<GroceryListComponent>;
  let httpTestingController: HttpTestingController;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ GroceryListComponent ],
      imports: [RouterTestingModule],
      providers: [HttpTestingController, HttpClientTestingModule, HttpClient, HttpHandler]
    })
    .compileComponents();


  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(GroceryListComponent);
    component = fixture.componentInstance;
    httpTestingController = TestBed.inject(HttpTestingController);

    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  describe('#ngOnInit', () => {
    it('should call loadGroceryList', () => {
      spyOn(component, 'loadGroceryList');
      component.ngOnInit();

      expect(component.loadGroceryList).toHaveBeenCalled();
    });
  });
});
