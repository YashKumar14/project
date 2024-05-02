package com.example.demo.salesReport;

import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequestMapping("/sales")
public class SalesController {
	@Autowired
	private SaleRepository saleRepository;
	@Autowired
	private SalesReportService salesReportService;

	@GetMapping("/add")
	public String showAddSaleForm(Model model) {
		model.addAttribute("sale", new Sale());
		return "addSale";
	}

	@PostMapping("/add")
	public String addSale(Sale sale) {
		sale.setDate(LocalDate.now());
		salesReportService.addSale(sale);
		return "redirect:/sales/add";
	}

	@GetMapping("/view-reports")
	public String viewReports() {
		return "viewReports";
	}

	@GetMapping("/daily-report")
	public String getDailyReport(Model model) {
		LocalDate date = LocalDate.now();
		List<Sale> dailyReport = salesReportService.generateDailyReport(date);
		double totalSales = calculateTotalSales(dailyReport);
		double totalProfit = calculateTotalProfit(dailyReport);
		model.addAttribute("dailyReport", dailyReport);
		model.addAttribute("totalSales", totalSales);
		model.addAttribute("totalProfit", totalProfit);
		return "viewDailyReport";
	}

	private double calculateTotalSales(List<Sale> sales) {
		return sales.stream().mapToDouble(Sale::getSellingPrice).sum();
	}

	private double calculateTotalProfit(List<Sale> sales) {
		return sales.stream().mapToDouble(sale -> sale.getSellingPrice() - sale.getCostPrice()).sum();
	}

	@GetMapping("/weekly-report")
	public String getWeeklyReport(Model model) {
		List<Sale> weeklyReport = salesReportService.generateWeeklyReport();
		double totalSales = calculateTotalSales(weeklyReport);
		double totalProfit = calculateTotalProfit(weeklyReport);
		model.addAttribute("weeklyReport", weeklyReport);
		model.addAttribute("totalSales", totalSales);
		model.addAttribute("totalProfit", totalProfit);
		return "viewWeeklyReport";
	}

	@GetMapping("/monthly-report")
	public String getMonthlyReport(Model model) {
		LocalDate currentDate = LocalDate.now();
		List<Sale> monthlyReport = salesReportService.generateMonthlyReport(currentDate);
		double totalSales = calculateTotalSales(monthlyReport);
		double totalProfit = calculateTotalProfit(monthlyReport);
		model.addAttribute("monthlyReport", monthlyReport);
		model.addAttribute("totalSales", totalSales);
		model.addAttribute("totalProfit", totalProfit);
		return "viewMonthlyReport";
	}

	@GetMapping("/quarterly-report")
	public String getQuarterlyReport(Model model) {
		List<Sale> quarterlyReport = salesReportService.generateQuarterlyReport();
		double totalSales = calculateTotalSales(quarterlyReport);
		double totalProfit = calculateTotalProfit(quarterlyReport);
		model.addAttribute("quarterlyReport", quarterlyReport);
		model.addAttribute("totalSales", totalSales);
		model.addAttribute("totalProfit", totalProfit);
		return "viewQuarterlyReport";
	}

}
