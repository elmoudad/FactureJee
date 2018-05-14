package madwols.controller;

import java.util.List;

import javax.validation.Valid;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;





import madwols.dao.FactureRepository;
import madwols.entities.Facture;

@Controller
public class FactureController {
	@Autowired
	FactureRepository factureRepository;
	
	@RequestMapping(name="/index")
	public String index(Model model ,@RequestParam(name="size" ,defaultValue="5") int size ,@RequestParam(name="pase",defaultValue="0" ) int page ,@RequestParam(name="motCle" , defaultValue="") String motCle) {
		Page<Facture> PageFactures = factureRepository.findBySocName("%"+motCle+"%",new PageRequest(page, size));
		model.addAttribute("listeFactures",PageFactures.getContent());
		int[] pages= new int[PageFactures.getTotalPages()];
		model.addAttribute("pages",pages);
		model.addAttribute("size",size);
		model.addAttribute("pageCourante",page);
		model.addAttribute("motCle",motCle);
		return "factures";
	}
	@RequestMapping(value="/delete", method=RequestMethod.GET)
	public String delete(Integer numero,String motCle,int page,int size) {
		factureRepository.deleteById(numero);
		return "redirect:/index?page="+page+"&size="+size+"&motCle="+motCle;
	}
	
	@RequestMapping(value="/form",method=RequestMethod.GET)
	public String formFacture(Model model) {
		model.addAttribute("facture",new Facture());
		return "FormFacture";
	}
	
	
	@RequestMapping(value="/edit",method=RequestMethod.GET)
	public String formFacture(Model model,Integer numero) {
		List<Facture> lp = factureRepository.getFactureByID(numero);
		model.addAttribute("facture",lp.get(0));
		
		return "editFacture";
	}
	
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public String save(Model model,@Valid Facture facture ,BindingResult bindingResult) {
		if(bindingResult.hasErrors())
			return "FormFacture";
		factureRepository.save(facture);
		return "Confirmation";
	}
	

}
