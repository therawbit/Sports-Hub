package io.github.sudru.SportsHub.service;

import io.github.sudru.SportsHub.dto.TournamentDto;
import io.github.sudru.SportsHub.dto.TournamentRegisterDto;
import io.github.sudru.SportsHub.model.Tournament;
import io.github.sudru.SportsHub.repository.TournamentRepository;
import io.github.sudru.SportsHub.utils.SportsHubUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class TournamentService {
    private final TournamentRepository tournamentRepository;

    private final  ModelMapper modelMapper;

    private final SportsHubUtil sportsHubUtil;

    public List<TournamentDto> getUsersTournaments(){
        return tournamentRepository.findAllByUser(sportsHubUtil.getAuthenticatedUser()).stream().map(a->modelMapper.map(a,TournamentDto.class)).collect(Collectors.toList());
    }
    public void createTournament(TournamentRegisterDto dto){
        Tournament tournament = modelMapper.map(dto,Tournament.class);
        tournament.setUser(sportsHubUtil.getAuthenticatedUser());
        tournamentRepository.save(tournament);
        log.info(tournament.toString());
    }

    public TournamentDto tournamentDetails(String id) {
        Tournament tournament = tournamentRepository.findById(id).orElseThrow();
        return modelMapper.map(tournament,TournamentDto.class);
    }
}
