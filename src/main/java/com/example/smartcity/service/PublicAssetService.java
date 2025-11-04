package com.example.smartcity.service;

import com.example.smartcity.entity.PublicAsset;
import com.example.smartcity.repository.PublicAssetRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PublicAssetService 
{

    private final PublicAssetRepository repo;

    public PublicAssetService(PublicAssetRepository repo) 
    {
        this.repo = repo;
    }

    public List<PublicAsset> findAll() 
    {
        return repo.findAll();
    }

    public Optional<PublicAsset> findById(Long id) 
    {
        return repo.findById(id);
    }

    public PublicAsset save(PublicAsset asset) 
    {
        return repo.save(asset);
    }

    public void deleteById(Long id)
    {
        repo.deleteById(id);
    }
}
