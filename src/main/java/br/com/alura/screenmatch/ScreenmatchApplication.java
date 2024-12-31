package br.com.alura.screenmatch;

import br.com.alura.screenmatch.model.DataSeries;
import br.com.alura.screenmatch.service.ConsumoAPI;
import br.com.alura.screenmatch.service.ConvertData;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ScreenmatchApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ScreenmatchApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		var consumoAPI = new ConsumoAPI();

		var json = consumoAPI.getData("http://www.omdbapi.com/?t=gilmore+girls&apikey=bee80494");
		System.out.println(json);
		var converter = new ConvertData();
		DataSeries data = converter.getData(json, DataSeries.class);
		System.out.println(data);
	}
}
