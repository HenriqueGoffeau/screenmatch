package br.com.alura.screenmatch.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DataSeasons(@JsonAlias("Season") Integer numSeason,
                          @JsonAlias("Episodes") List<DataEpisode> episodeList) {
}
