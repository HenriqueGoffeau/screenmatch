package br.com.alura.screenmatch.main;

import br.com.alura.screenmatch.model.DataEpisode;
import br.com.alura.screenmatch.model.DataSeasons;
import br.com.alura.screenmatch.model.DataSeries;
import br.com.alura.screenmatch.service.ConsumeAPI;
import br.com.alura.screenmatch.service.ConvertData;

import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private final Scanner scanner = new Scanner(System.in);
    private final ConsumeAPI consume = new ConsumeAPI();
    private final ConvertData converter = new ConvertData();

    private final String ADDRESS = "http://www.omdbapi.com/?t=";
    private final String API_KEY = "&apikey=bee80494";

    public void showMenu() {
        System.out.println("Digite o nome da série");
        var nameSeries = scanner.nextLine();
        var json = consume.getData(ADDRESS + nameSeries.replace(" ", "+") + API_KEY);
        DataSeries dataSeries = converter.getData(json, DataSeries.class);
        System.out.println(dataSeries);
        List<DataSeasons> seasons = new ArrayList<>();

        for (int i = 1; i <= dataSeries.totalSeasons(); i++) {
            json = consume.getData(ADDRESS + nameSeries.replace(" ", "+") + "&season=" + i + API_KEY);
            DataSeasons dataSeasons = converter.getData(json, DataSeasons.class);
            seasons.add(dataSeasons);
        }
        seasons.forEach(System.out::println);

        seasons.forEach(t -> t.episodeList().forEach(e -> System.out.println(e.title())));
    }
}
