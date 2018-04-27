import { TestBed, inject } from '@angular/core/testing';

import { SystemProductService } from './system-product.service';

describe('SystemProductService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [SystemProductService]
    });
  });

  it('should be created', inject([SystemProductService], (service: SystemProductService) => {
    expect(service).toBeTruthy();
  }));
});
