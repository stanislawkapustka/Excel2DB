package pl.skapustka.controller;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pl.skapustka.entities.SystemContract;
import pl.skapustka.excel.ExcelFile;
import pl.skapustka.excel.ExcelReader;
import pl.skapustka.excel.UploadFileHelper;
import pl.skapustka.service.SystemContractService;

@Controller
public class ExcelController {

	@RequestMapping(value="excel", method = RequestMethod.GET)
	public String index() {
		return "redirect:importexcel.html";
	}

	@RequestMapping(value = "importexcel", method = RequestMethod.GET)
	public String importexcel(ModelMap modelMap) {
		modelMap.put("excelFile", new ExcelFile());
		return "index";
	}

	@RequestMapping(value = "importexcel", method = RequestMethod.POST)
	public String importexcel(@ModelAttribute(value = "excelFile") ExcelFile excelFile, ModelMap modelMap,
			HttpServletRequest request) {
		try {
			File file = UploadFileHelper.simpleUpload(excelFile.getFile(), request, "files");
			ExcelReader er = new ExcelReader();
			modelMap.put("listArkusz1", er.readExcelContract(file.getAbsolutePath()));
			
			} catch (Exception e) {
		}
		return "excelLoaded";
	}

	private SystemContractService systemContractService;

	@Autowired(required = true)
	@Qualifier(value = "systemContractService")
	public void setSystemContractService(SystemContractService scs) {
		this.systemContractService = scs;
	}

	@RequestMapping(value = "/systemContracts", method = RequestMethod.GET)
	public String listSystemContracts(Model model) {
		model.addAttribute("systemContract", new SystemContract());
		model.addAttribute("listSystemContracts", this.systemContractService.listSystemContracts());
		return "systemContract";
	}

	// For add and update systemContract both
	@RequestMapping(value = "systemContract/add", method = RequestMethod.POST)
	public String addSystemContract(@ModelAttribute("systemContract") SystemContract sc) {

		if (sc.getId() == 0) {
			// new SystemContract, add it
			this.systemContractService.addSystemContract(sc);
		} else {
			// existing SystemContract, call update
			this.systemContractService.updateSystemContract(sc);
		}

		return "redirect:systemContracts";

	}

	@RequestMapping("remove/{id}")
	public String removeSystemContract(@PathVariable("id") long id) {

		this.systemContractService.removeSystemContract(id);
		return "redirect:systemContracts";
	}

	@RequestMapping("edit/{id}")
	public String editSystemContract(@PathVariable("id") long id, Model model) {
		model.addAttribute("systemContract", this.systemContractService.getSystemContractById(id));
		model.addAttribute("listSystemContracts", this.systemContractService.listSystemContracts());
		return "systemContract";
	}

}
