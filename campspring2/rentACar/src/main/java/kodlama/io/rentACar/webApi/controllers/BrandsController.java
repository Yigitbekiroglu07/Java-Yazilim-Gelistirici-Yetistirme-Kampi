package kodlama.io.rentACar.webApi.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.rentACar.business.abstracts.BrandService;
import kodlama.io.rentACar.business.request.CreateBrandRequest;
import kodlama.io.rentACar.business.responses.GetAllBrandsResponse;
import kodlama.io.rentACar.entities.concretes.Brand;

@RestController //annotation >> bilgilendirme
@RequestMapping("api/brands")
public class BrandsController {
		private BrandService brandService;

		public BrandsController(BrandService brandService) {
			this.brandService = brandService;
		}
		@GetMapping("/getAll")
		public List<GetAllBrandsResponse> getAll(){ // Business, Data Access'i çağırdı. Api ise Business'ı çağıracak.
			return brandService.getAll();
		}
		@PostMapping("/add")
		public void add(@RequestBody CreateBrandRequest createBrandRequest) {
			this.brandService.add(createBrandRequest);
		}
	
}