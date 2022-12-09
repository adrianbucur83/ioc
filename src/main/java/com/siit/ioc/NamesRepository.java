package com.siit.ioc;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class NamesRepository {

    public List<String> getNames = List.of("John, Marry, Ellis");

    public List<String> getLastNames = List.of("Smith, Ann, Dogton");

}
