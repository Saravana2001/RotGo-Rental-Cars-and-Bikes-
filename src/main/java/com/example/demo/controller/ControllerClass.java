package com.example.demo.controller;

import java.util.ArrayList;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.Bike;
import com.example.demo.model.Car;
import com.example.demo.model.Owner;
import com.example.demo.service.BikeService;
import com.example.demo.service.CarService;
import com.example.demo.service.OwnerService;



@Controller
public class ControllerClass {
	@Autowired
	private OwnerService os;
	@Autowired
	private BikeService bs;
	@Autowired
	private CarService cs;
	@Autowired
	//general
	@RequestMapping("www.Rotgo.com")
	public String homePage()
	{
		return "index";
		
	}
	
	@RequestMapping("success/www.Rotgo.com")
	public String homePage2()
	{
		return "index";
	}
	
	@RequestMapping("home")
	public String viewHomePage(Model model) {
		List<Owner> listOwners = os.listAll();
		model.addAttribute("listOwners", listOwners);
		return "index";
	}
		
	//Owner ownerLogin
	@RequestMapping("ownerLogin")
	public String ownerlogin(Model model) {
		Owner owner=new Owner();
		model.addAttribute(owner);
		return "ownerLogin";
	}
	
	
	@RequestMapping(value = "/ownerLogindb")
	public String ownerLogin123(@ModelAttribute("owner") Owner owner, Model model) {
		System.out.println("Entering");
		System.out.println(owner.getId());
		int idd=owner.getId();
		System.out.println("idd"+idd);
		List<Owner> ownerr=os.listAll();
		for(Owner o:ownerr)
		{
			System.out.println("oid"+o.getId());
			if(o.getId()==idd)
			{
				Owner ownerlist=os.get(owner.getId());
				System.out.println("OL"+ownerlist.getId());
				List<Bike> bike=bs.listAll();
				List<Car> car=cs.listAll();
//				if(ownerlist.equals(null))
//						{
//							model.addAttribute("ierror","Invalid ID");
//							return "ownerLogin";
//						}
				
				if(o.getId()==ownerlist.getId() && o.getPassword().equals(owner.getPassword()))
				{
					ArrayList<Bike> bikelist=new ArrayList<Bike>();
					for(Bike bikelist1: bike)
					{
						if(bikelist1.getOwner().getId()==owner.getId())
						{
							bikelist.add(bikelist1);
						}
					}
					ArrayList<Car> carlist=new ArrayList<Car>();
					for(Car carlist1: car)
					{
						if(carlist1.getOwner().getId()==owner.getId())
						{
							carlist.add(carlist1);
						}
					}
					model.addAttribute("idd",idd);
					model.addAttribute("carlist",carlist);
					model.addAttribute("bikelist",bikelist);
					model.addAttribute("ownerlist",ownerlist);
					return "ownerHome";
				}
				else
				{
					model.addAttribute("error","ID and Password Does not Match");
					return "ownerLogin";
				}	
			}	
//			else
//			{
//				model.addAttribute("error","Invalid Credentials");
//				return "ownerLogin";
//			}
			
			}
		model.addAttribute("error","Invalid");
		return "ownerLogin";
		
	}
	
	@RequestMapping("ownerSignup")
	public String ownerSignup(Model model) {
		Owner owner =new Owner();
		model.addAttribute("owner", owner);
		return "ownerSignup";
	}
	
	@RequestMapping(value = "/ownersave", method = RequestMethod.POST)
	public String newOwner(@Valid @ModelAttribute("owner") Owner owner,BindingResult br,Model model,@RequestParam(name="cpass") String pass2) {
		System.out.println(owner.getName());
		System.out.println("password"+owner.getPassword());
		System.out.println("password 2"+pass2);
		System.out.println("pin"+owner.getOaddress().getPincode().length());
		if(br.hasErrors())
		{
			model.addAttribute("message","\n");
			return "ownerSignup"; //which mean, if error it will display in first page
		}
		else
		{
			if(owner.getPassword().equals(pass2) && owner.getOaddress().getPincode().length()==6)
			{
				os.save(owner);
				return "ownerLogin";
			}
			else
			{
				model.addAttribute("pinerror","Invalid Pincode Or Password Mismatch");
				return "ownerSignup";
			}
		}
	}
	@RequestMapping("/owneredit/{id}")
	public ModelAndView showEditOwnerForm(@PathVariable(name = "id") Integer id) {
		ModelAndView mav = new ModelAndView("OwnerProfileEdit");
		
		Owner owner= os.get(id);
		mav.addObject("owner", owner);
		
		return mav;
	}	
	
	@RequestMapping(value = "/ownereditsave/{id}", method = RequestMethod.POST)
	public String saveOwner(@Valid @ModelAttribute("owner") Owner owner,BindingResult br,Model model,@PathVariable("id") Integer id) {
		
		System.out.println("id is "+id);
		if(br.hasErrors())
		{
			model.addAttribute("error","Enter All Fields Correctly.");
			return "ownerProfileEdit";
		}
		else
		{
		owner.setId(id);
		os.save(owner);
		return "redirect:/success/{id}";
		}
	}
	
	@RequestMapping("/newbike/{idd}")
	public String newBike(@PathVariable(name = "idd") Integer id,Model model) {
		System.out.println(id);
		Bike bike = new Bike();
		model.addAttribute("id",id);
		model.addAttribute("bike", bike);
		return "newBike";
	}
	@RequestMapping(value = "bikesave", method =RequestMethod.POST)
	public String newBikeSave(@Valid @ModelAttribute("bike") Bike bike,BindingResult br,Model model,@RequestParam(name="vv") int idd) {
		System.out.println(bike.getBrand());
		System.out.println("iddd"+idd);
		if(br.hasErrors())
		{
			model.addAttribute("id",idd);
			return "newBike"; //which mean, if error it will display in first page
		}
		else
		{
			Owner owner=os.get(idd);
			bike.setOwner(owner);
			bs.save(bike);
//			Owner owner=new Owner();
			model.addAttribute("idd",idd);
			model.addAttribute(owner);
			return "successPage";
		}
	}
	
	@RequestMapping(value = "/success/{idd}")
	public String ownerSuccess(@PathVariable(name = "idd") Integer id,Model model) {
		System.out.println("success "+id);
		int idd=id;
		Owner ownerlist=os.get(idd);
		List<Bike> bike=bs.listAll();
		List<Car> car=cs.listAll();
			ArrayList<Bike> bikelist=new ArrayList<Bike>();
			for(Bike bikelist1: bike)
			{
				if(bikelist1.getOwner().getId()==idd)
				{
					bikelist.add(bikelist1);
				}
			}
			ArrayList<Car> carlist=new ArrayList<Car>();
			for(Car carlist1: car)
			{
				if(carlist1.getOwner().getId()==idd)
				{
					carlist.add(carlist1);
				}
			}
			model.addAttribute("idd",idd);
			model.addAttribute("carlist",carlist);
			model.addAttribute("bikelist",bikelist);
			model.addAttribute("ownerlist",ownerlist);
			return "ownerHome";	
	}
	
	@RequestMapping("/addcar/{idd}")
	public String addCar(@PathVariable(name = "idd") Integer id,Model model) {
		System.out.println(id);
		Car car=new Car();
		model.addAttribute("id",id);
		model.addAttribute("car", car);
		return "newCar";
	}
	@RequestMapping(value = "carsave", method =RequestMethod.POST)
	public String newCarSave(@Valid @ModelAttribute("car") Car car,BindingResult br,Model model,@RequestParam(name="vv") int idd) {
		System.out.println(car.getBrand());
		System.out.println("iddd"+idd);
		if(br.hasErrors())
		{
			model.addAttribute("id",idd);
			return "newCar"; //which mean, if error it will display in first page
		}
		else
		{
			Owner owner=os.get(idd);
			car.setOwner(owner);
			cs.save(car);
//			Owner owner=new Owner();
			model.addAttribute("idd",idd);
			model.addAttribute(car);
			return "successPage";
		}
	}
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveCars(@ModelAttribute("car") Car car,Model model,@RequestParam(name="vv") int idd,@RequestParam(name="vvv") int id) {
		System.out.println("Saved Successfully with idd"+idd);
		System.out.println("Saved"+id);
		Owner owner=os.get(id);
		System.out.println("car with id"+owner.getId());
		car.setOwner(owner);
		car.setId(idd);
		cs.save(car);
		System.out.println("After success id"+idd);
		model.addAttribute("idd",car.getOwner().getId());
		return "successPage";
	}
	
	@RequestMapping("/caredit/{id}")
	public ModelAndView showEditCarForm(@PathVariable(name = "id") Integer id,Model model) {
		ModelAndView mav = new ModelAndView("editCars");
		Car car = cs.get(id);
		model.addAttribute("id",id);
		mav.addObject("car", car);
		
		
		return mav;
	}
	//carEachEditByID
		@RequestMapping(value = "/careachdelete/{id}/{idd}")
		public String carEachDelete(Model model,@PathVariable(name="id") Integer id,@PathVariable(name="idd") Integer idd) {
			System.out.println("Delete Successfully with idd"+idd);
			System.out.println("Delete owner"+id);
			Owner owner=os.get(idd);
			System.out.println("car with owner id"+owner.getId());
			Car car=cs.get(id);
			cs.deleteAll(car);
			System.out.println("After success id"+idd);
			model.addAttribute("idd",idd);
			return "DeletedPage";
		}
		
		
			//bike
			@RequestMapping(value = "/savebike", method = RequestMethod.POST)
			public String saveBikes(@ModelAttribute("bike") Bike bike,Model model,@RequestParam(name="vv") int idd,@RequestParam(name="vvv") int id) {
				System.out.println("Saved Successfully with idd"+idd);
				System.out.println("Saved"+id);
				Owner owner=os.get(id);
				System.out.println("bike with id"+owner.getId());
				bike.setOwner(owner);
				bike.setId(idd);
				bs.save(bike);
				System.out.println("After success id"+idd);
				model.addAttribute("idd",bike.getOwner().getId());
				return "successPage";
			}
			
			@RequestMapping("/bikeedit/{id}")
			public ModelAndView showEditBikeForm(@PathVariable(name = "id") Integer id,Model model) {
				ModelAndView mav = new ModelAndView("editBikes");
				Bike bike= bs.get(id);
				model.addAttribute("id",id);
				mav.addObject("bike", bike);
				return mav;
			}
			//bikeEachEditByID
			@RequestMapping(value = "/bikeeachdelete/{id}/{idd}")
			public String bikeEachDelete(Model model,@PathVariable(name="id") Integer id,@PathVariable(name="idd") Integer idd) {
				System.out.println("Delete Successfully with idd"+idd);
				System.out.println("Delete owner"+id);
				Owner owner=os.get(idd);
				System.out.println("bike with owner id"+owner.getId());
				Bike bike=bs.get(id);
				bs.deleteAll(bike);
				System.out.println("After success id"+idd);
				model.addAttribute("idd",idd);
				return "DeletedPage";
			}
			
//			bikealldelete
			@RequestMapping("/bikealldelete/{idd}")
			public String bikeAllDelete(@PathVariable(name="idd") Integer id)
			{
				System.out.println("bike delete id"+id);
				Owner ownerlist=os.get(id);
				List<Bike> bike=bs.listAll();
					for(Bike bikelist1: bike)
					{
						if(bikelist1.getOwner().getId()==ownerlist.getId())
						{
							System.out.println("bikelist1.getOwner().getId()"+bikelist1.getOwner().getId());
//							if()
//							bs.delete(bikelist1.getId());
							bs.deleteAll(bikelist1);
						}
					}
				return "DeletedPage";
			}
			
			//caralldelete
			@RequestMapping("/caralldelete/{idd}")
			public String carAllDelete(@PathVariable("idd") Integer id)
			{
				System.out.println("car delete id"+id);
				Owner ownerlist=os.get(id);
				List<Car> car=cs.listAll();
					for(Car carlist1: car)
					{
						if(carlist1.getOwner().getId()==ownerlist.getId())
						{
							System.out.println("carlist1.getOwner().getId()"+carlist1.getOwner().getId());
//							if()
//							bs.delete(bikelist1.getId());
							cs.deleteAll(carlist1);
						}
					}
				return "DeletedPage";
			}
	
}