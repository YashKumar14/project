package com.example.demo.salesReport;

import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SalesReportService {
	@Autowired
	private SaleRepository saleRepository;
	double totalSales = 0.0;
	double totalProfit = 0.0;

	public void addSale(Sale sale) {
		saleRepository.save(sale);
	}

	public List<Sale> generateDailyReport(LocalDate date) {
		List<Sale> sales = saleRepository.findByDate(date);
		resetTotals();
		for (Sale sale : sales) {
			double profit = sale.getSellingPrice() - sale.getCostPrice();
			totalSales += sale.getSellingPrice();
			totalProfit += profit;
		}
		return sales;
	}

	public List<Sale> generateWeeklyReport() {
		LocalDate endDate = LocalDate.now();
		LocalDate startDate = endDate.minusWeeks(1);
		List<Sale> sales = saleRepository.findByDateBetween(startDate, endDate);
		resetTotals();
		for (Sale sale : sales) {
			double profit = sale.getSellingPrice() - sale.getCostPrice();
			totalSales += sale.getSellingPrice();
			totalProfit += profit;
		}
		return sales;
	}

	public List<Sale> generateMonthlyReport(LocalDate date) {
		LocalDate startDate = date.withDayOfMonth(1);
		LocalDate endDate = date.withDayOfMonth(date.lengthOfMonth());
		List<Sale> sales = saleRepository.findByDateBetween(startDate, endDate);
		resetTotals();
		for (Sale sale : sales) {
			double profit = sale.getSellingPrice() - sale.getCostPrice();
			totalSales += sale.getSellingPrice();
			totalProfit += profit;
		}
		return sales;
	}

	public List<Sale> generateQuarterlyReport() {
		LocalDate endDate = LocalDate.now();
		LocalDate startDate = getStartOfQuarter(endDate);
		List<Sale> sales = saleRepository.findByDateBetween(startDate, endDate);
		resetTotals();
		for (Sale sale : sales) {
			double profit = sale.getSellingPrice() - sale.getCostPrice();
			totalSales += sale.getSellingPrice();
			totalProfit += profit;
		}
		return sales;
	}

	private LocalDate getStartOfQuarter(LocalDate date) {
		int month = date.getMonthValue();
		int startMonth = (month - 1) / 3 * 3 + 1;
		return LocalDate.of(date.getYear(), startMonth, 1);
	}

	private void resetTotals() {
		totalSales = 0.0;
		totalProfit = 0.0;
	}

}
