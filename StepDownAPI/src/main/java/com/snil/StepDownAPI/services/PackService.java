package com.snil.StepDownAPI.services;

import com.snil.StepDownAPI.entities.Pack;
import com.snil.StepDownAPI.entities.Song;
import com.snil.StepDownAPI.exceptions.SongException;
import com.snil.StepDownAPI.repositories.PackRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PackService {

    @Autowired
    private PackRepo packRepo;

    public Pack getPack(long packId) throws SongException {
        try {
            return packRepo.findById(packId).orElseThrow(() -> new SongException("Can't find pack with ID " + packId));
        } catch (Exception e) {
            throw new SongException("Can't get pack",e);
        }
    }

    public List<Pack> getAllPacks() throws SongException {
        try {
            return packRepo.findAll();
        } catch (Exception e) {
            throw new SongException("Can't get all packs",e);
        }
    }

    public Pack addPack(Pack pack) throws SongException {
        try {
            return packRepo.save(pack);
        } catch (Exception e) {
            throw new SongException("Can't add pack",e);
        }
    }

    public Pack updatePack(Pack pack) throws SongException {
        try {
            if (packRepo.existsById(pack.getId())) {
                return packRepo.save(pack);
            }
            throw new SongException("Pack does not exist");
        } catch (Exception e) {
            throw new SongException("Can't add pack",e);
        }
    }

    public void deletePack(long packId) throws SongException {
        try {
            if (packRepo.existsById(packId)) {
                packRepo.deleteById(packId);
            }
            throw new SongException("Pack does not exist");
        } catch (Exception e) {
            throw new SongException("Can't delete pack", e);
        }
    }
}
